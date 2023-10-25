package com.hvlv.microservices.shipmentService.hvlvShipmentService.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.hvlv.microservices.shipmentService.hvlvShipmentService.beans.DataBean;
import com.hvlv.microservices.shipmentService.hvlvShipmentService.beans.JsonResultBean;
import com.hvlv.microservices.shipmentService.hvlvShipmentService.client.ApiServiceClient;
import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.*;
import com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.regex.Pattern;

import static java.math.BigDecimal.ZERO;
import static org.apache.commons.lang3.StringUtils.isNumeric;

@Service
public class ShipmentPriceService {
    @Autowired
    RedisService redisService;

    @Autowired
    OrgRateMapper orgRateMapper;

    @Autowired
    DfeZoneMapper dfeZoneMapper;

    @Autowired
    ZoneRateMapper zoneRateMapper;

    @Autowired
    DfeForwardingFeeMapper dfeForwardingFeeMapper;

    @Autowired
    ZoneMapMapper zoneMapMapper;

    @Autowired
    RemoteChargeRateMapper remoteChargeRateMapper;

    @Autowired
    ImportChargeCodeMapper importChargeCodeMapper;

    @Autowired
    ShipmentMapper shipmentMapper;

    @Autowired
    SuburbPostcodeZoneMapper suburbPostcodeZoneMapper;

    @Autowired
    ZoneMapTestMapper zoneMapTestMapper;

    @Autowired
    SystemSettingService systemSettingService;

    @Autowired
    AddrMapper addrmapper;

    @Autowired
    AddrResidentialMapper addrResidentialMapper;

    @Autowired
    ApiServiceClient apiServiceClient;

    @Autowired
    ImportsFlexibleSurchargeMapper importsFlexibleSurchargeMapper;

    public static final List<String> NEW_RULE_CHARGECODE = Arrays.asList(
            "8634", "7906", "5568", "7080", "7371", "9858", "5422", "5932",
            "4230", "8863", "5013", "2499", "2114", "2991", "2976", "3473",
            "2305", "0786", "1336", "0558", "6959", "4671", "2211", "5638", "2469"
    );

    public JsonResultBean getCourierCostPrice(Integer orgId,String chargeCode , boolean getZoneRate, Integer shipmentId) throws JsonProcessingException {
        OrgRate orgRate = orgRateMapper.selectByPrimaryKey(orgId);
        Shipment shipment = shipmentMapper.selectByPrimaryKey(shipmentId);
        JsonResultBean result = new JsonResultBean();
        result.setSuccess();
        DataBean dataBean = new DataBean();
        result.setData(dataBean);

        String code = orgRate.getCode();
        int pks = shipment.getPkg();
        BigDecimal weightDe = shipment.getWeight();
        double weight = weightDe.doubleValue();
        int cneeId = shipment.getCneeId();
        Addr addr = addrmapper.selectByPrimaryKey(cneeId);
        String postcode =addr.getPostcode();
        String suburb = addr.getSuburb();

        //mytoll tnt allied
        List<Integer> specialOrgIds = Arrays.asList(3752, 4429, 3466);
        if (specialOrgIds.contains(orgRate.getOrgId())) {
            dataBean.setData(costStatus(orgRate, suburb, postcode, weight, shipment,chargeCode));
            return result;
        }
        //UBI
        int ORGID_COURIER_UBI_TOLL = 3079;
        if (orgRate.getOrgId() == ORGID_COURIER_UBI_TOLL) {
            Map<String, Object> cost;
            if (orgRate.getCode().matches("(?i).*TOLL.*")) {
                cost = getCostEtower(orgRate.getId(), suburb, postcode, weight, true, shipment,chargeCode);
            } else {
                cost = getCostEtower(orgRate.getId(), "", postcode, weight, false, null,chargeCode);
            }

            if ("0".equals(cost.get("code").toString())) {
                dataBean.setData(cost.get("data").toString());
                dataBean.setStatus(0);
                return result;
            } else if ("2".equals(cost.get("code").toString())) {
                dataBean.setData(cost.get("data").toString());
                dataBean.setStatus(88888);
                return result;
            } else {
                dataBean.setData(cost.get("data").toString());
                dataBean.setStatus(99999);
                return result;
            }
        }


        BigDecimal price = BigDecimal.ZERO;
        ZoneMap zoneMap =  zoneMapMapper.findByOrgIdZoneIdAndPostcode(orgRate.getOrgId(), orgRate.getZoneId(), Integer.parseInt(postcode));
        if (zoneMap != null && zoneMap.getZ1() != null) {
            chargeCode = zoneMap.getZ1();
        }

        if (orgRate.getOrgId().equals(Org.ORGID_COURIER_AUPOST)) {
            weight = weight / pks;
        }

        List<ZoneRate> zrs = zoneRateMapper.findByZoneWeightAndRateId(chargeCode, weight, orgRate.getId());
        ZoneRate reZoneRate = null;

        if (code.equals("aupost_international")) {
            JsonResultBean zoneSettings = systemSettingService.getSetting("INTZONE", "CH");

            if ((zoneSettings.getCode().equals(60000)) && zoneSettings.getData() != null) {
                DataBean dataBeanau = (DataBean) zoneSettings.getData();
                String zone =  dataBeanau.getData().toString();
                if (zone != null && !zone.isEmpty()) {
                    zrs = zoneRateMapper.findByRateIdWeightAndZone(orgRate.getId(), Math.ceil(weight * 10) / 10, zone);
                }
            }
        }


        RemoteChargeRate remoteCostRate = remoteChargeRateMapper.findByRateIdPostcodeAndSuburb(orgRate.getId(), postcode, suburb.toUpperCase());

        BigDecimal lastOSCost = BigDecimal.ZERO;
        if (shipment != null) {
            BigDecimal shipmentWeight = shipment.getWeight();
            BigDecimal shipmentCBM = shipment.getCbm();
            int pkg = shipment.getPkg();
            Map<String, Object> shipmentMdata = shipment.getMdata();
            Gson gson = new Gson();
            Type type = new TypeToken<List<Map<String, Object>>>() {}.getType();
            List<Map<String, Object>> packs = gson.fromJson(shipment.getPackages(), type);

            String ref =shipment.getRef();

            ObjectMapper objectMapper = new ObjectMapper();
            Map<String, Object> metaMap = objectMapper.readValue(orgRate.getMeta(), Map.class);
            Map<String, Object> costSurchargeInfo = (Map<String, Object>) metaMap.get("truck_delivery");

            if (costSurchargeInfo != null) {
                Map<String, Object> results = calculateSingleOSRule(costSurchargeInfo, "OS\\d{1,2}", false, packs, shipmentWeight, shipmentCBM, shipmentMdata,pkg, ref);
                List<BigDecimal> osChargeArr = (List<BigDecimal>) results.get("osChargeArr");
                lastOSCost = osChargeArr.get(0);
            }
        }


        if (zrs != null && !zrs.isEmpty()) {
            for (ZoneRate zr : zrs) {
                BigDecimal temp = zr.getBase().add(zr.getItem().multiply(BigDecimal.valueOf(pks)));
                if (zr.getNkg().compareTo(0.0f) > 0) {
                    BigDecimal wl = BigDecimal.valueOf(weight).subtract(zr.getMinIncl());
                    BigDecimal nkgBigDecimal = new BigDecimal(zr.getNkg().toString()); // Convert Float to BigDecimal
                    temp = temp.add(wl.divide(nkgBigDecimal, RoundingMode.CEILING).multiply(zr.getPerkg()));
                }else {
                    temp = temp.add(BigDecimal.valueOf(weight).multiply(zr.getPerkg()));
                }
                if (zr.getMinimum().compareTo(BigDecimal.ZERO) > 0 && temp.compareTo(zr.getMinimum()) < 0) {
                    temp = zr.getMinimum();
                }
                if (temp.compareTo(price) > 0) {
                    price = temp;
                    reZoneRate = zr;
                }
            }

            if (remoteCostRate != null) {
                BigDecimal remoteSurcharge = BigDecimal.valueOf(weight).multiply(remoteCostRate.getPerkg()).add(remoteCostRate.getBase());
                price = price.add(remoteSurcharge);
            }

            if (lastOSCost.compareTo(BigDecimal.ZERO) > 0) {
                price = price.add(lastOSCost);
            }

            Gson gson = new Gson();
            Map<String, Object> metaMap = gson.fromJson(orgRate.getMeta(), Map.class);

            if (metaMap.containsKey("fuel")) {
                price = price.add(price.multiply(new BigDecimal(metaMap.get("fuel").toString())));
            }
        }

        if (orgRate.getOrgId().equals(976) || orgRate.getOrgId().equals(3466)) {
            price = price.multiply(BigDecimal.valueOf(1.2));
        }

        if (getZoneRate) {
            dataBean.setData(reZoneRate);
            return result;
        }
        dataBean.setData(price);
        return result;
    }

    public Map<String, Object> calculateSingleOSRule(Map<String, Object> courierSurchargeInfo, String pattern, boolean isCargoProcess, List<Map<String, Object>> packs, BigDecimal weight, BigDecimal cbm, Map<String, Object> mdata, int pkg, String ref) throws JsonProcessingException {
        List<Map<String, Object>> osArr = new ArrayList<>();
        List<String> osCodeArr = new ArrayList<>();
        List<BigDecimal> osChargeArr = new ArrayList<>();
        List<String> osKeyArr = new ArrayList<>();

        if (courierSurchargeInfo != null && !packs.isEmpty()) {
            for (Map<String, Object> pack : packs) {
                Map<String, Object> os = null;
                String osCode = "";
                String osKey = "";
                BigDecimal lastOSCost = BigDecimal.ZERO;

                List<Double> thisPackDim = Arrays.asList((Double) pack.get("length"), (Double) pack.get("width"));
                Collections.sort(thisPackDim, Collections.reverseOrder());
                double length = thisPackDim.get(0) / 100;
                double width = thisPackDim.get(1) / 100;
                double height = (Double) pack.get("height") / 100;

                for (Map.Entry<String, Object> entry : courierSurchargeInfo.entrySet()) {
                    String key = entry.getKey();
                    Map<String, Object> value = (Map<String, Object>) entry.getValue();

                    double packWeight = (Double) pack.get("weight");
                    double cubeWeight = (length * width * height) * 250;
                    Map<String, Object> thisOS = null;
                    String thisOSCode = "";
                    double thisCharge = 0;
                    String thisOSKey = "";

                    if (value.get("type").equals(pattern)) {
                        if ((Integer) value.get("p_shipment") > 0) {
                            packWeight = weight.doubleValue();
                            cubeWeight = (cbm.doubleValue() * pkg) * 250;

                            if (packWeight > (Double) value.get("kgdwf") && packWeight < (Double) value.get("kgdwt") && value.containsKey("kgdwt")) {
                                if (checkIsCargoProcessWithRef(ref, mdata) && !mdata.containsKey("custconfirmforklift") || !checkIsCargoProcessWithRef(ref, mdata)) {
                                    thisOS = value;
                                    thisOSCode = "Weight between " + value.get("kgdwf") + " to " + value.get("kgdwt");
                                    thisOSKey = key;
                                }
                            }
                            if (cubeWeight > (Double) value.get("kgcwf") && cubeWeight < (Double) value.get("kgcwt") && value.containsKey("kgcwt")) {
                                thisOS = value;
                                thisOSCode = "cube Weight between " + value.get("kgcwf") + " to " + value.get("kgcwt");
                                thisOSKey = key;
                            }

                            if ((Double) value.get("metert") > 0.001) {
                                double diagonalLength = Math.round(Math.sqrt(Math.pow(length, 2) + Math.pow(width, 2) + Math.pow(height, 2)) * 100.0) / 100.0;
                                if (diagonalLength >= (Double) value.get("meterf") && diagonalLength <= (Double) value.get("metert")) {
                                    thisOS = value;
                                    thisOSCode = "Diagonal Length between " + value.get("meterf") + " to " + value.get("metert");
                                    thisOSKey = key;
                                }
                            }

                            if ((Double) value.get("length") > 0.001) {
                                if (isCargoProcess) {
                                    if (length >= (Double) value.get("length") && width >= (Double) value.get("width") && height >= (Double) value.get("height")) {
                                        thisOS = value;
                                        thisOSCode = "Limited Length " + value.get("length") + " Width " + value.get("width") + " Height " + value.get("height");
                                        thisOSKey = key;
                                    }
                                } else {
                                    if (length >= (Double) value.get("length") || width >= (Double) value.get("width") || height >= (Double) value.get("height")) {
                                        thisOS = value;
                                        thisOSCode = "Limited Length " + value.get("length") + " Width " + value.get("width") + " Height " + value.get("height");
                                        thisOSKey = key;
                                    }
                                }
                            }

                            if ((Double) value.get("cbm") > 0.001) {
                                if (cbm.doubleValue() > (Double) value.get("cbm")) {
                                    thisOS = value;
                                    thisOSCode = "Over cbm " + value.get("cbm");
                                    thisOSKey = key;
                                }
                            }

                        } else if ((Integer) value.get("p_piece") > 0) {
                            if (weight.compareTo(new BigDecimal(value.get("kgdwf").toString())) > 0 &&
                                    weight.compareTo(new BigDecimal(value.get("kgdwt").toString())) < 0 &&
                                    value.containsKey("kgdwt")) {
                                if ((checkIsCargoProcessWithRef(ref, mdata) && mdata.get("custconfirmforklift") == null) || !checkIsCargoProcessWithRef(ref, mdata)) {
                                    thisOS = value;
                                    thisOSCode = "weight between " + value.get("kgdwf") + " to " + value.get("kgdwt");
                                    thisOSKey = key;
                                }
                            }

                            if (cubeWeight > (Double) value.get("kgcwf") && cubeWeight < (Double) value.get("kgcwt") && value.containsKey("kgcwt")) {
                                thisOS = value;
                                thisOSCode = "cube Weight between " + value.get("kgcwf") + " to " + value.get("kgcwt");
                                thisOSKey = key;
                            }

                            if ((Double) value.get("metert") > 0.001) {
                                double diagonalLength = Math.round(Math.sqrt(Math.pow(length, 2) + Math.pow(width, 2) + Math.pow(height, 2)) * 100.0) / 100.0;
                                if (diagonalLength >= (Double) value.get("meterf") && diagonalLength <= (Double) value.get("metert")) {
                                    thisOS = value;
                                    thisOSCode = "Diagonal Length between " + value.get("meterf") + " to " + value.get("metert");
                                    thisOSKey = key;
                                }
                            }

                            if (isCargoProcess) {
                                if ((Double) value.get("length") > 0.001) {
                                    if (length >= (Double) value.get("length") && width >= (Double) value.get("width") && height >= (Double) value.get("height")) {
                                        thisOS = value;
                                        thisOSCode = "Limited Length " + value.get("length") + " Width " + value.get("width") + " Height " + value.get("height");
                                        thisOSKey = key;
                                    }
                                }
                            } else {
                                if ((Double) value.get("length") > 0.001) {
                                    if (length >= (Double) value.get("length") || width >= (Double) value.get("width") || height >= (Double) value.get("height")) {
                                        thisOS = value;
                                        thisOSCode = "Limited Length " + value.get("length") + " Width " + value.get("width") + " Height " + value.get("height");
                                        thisOSKey = key;
                                    }
                                }
                            }

                            if ((Double) value.get("cbm") > 0.001) {
                                if (cbm.doubleValue() > (Double) value.get("cbm")) {
                                    thisOS = value;
                                    thisOSCode = "Over cbm " + value.get("cbm");
                                    thisOSKey = key;
                                }
                            }

                        }
                    }

                    if (thisOS != null) {
                        thisCharge = (Integer) thisOS.get("p_piece") + (Integer) thisOS.get("p_shipment");
                        if (thisCharge > lastOSCost.doubleValue()) {
                            os = thisOS;
                            osCode = thisOSCode;
                            lastOSCost = BigDecimal.valueOf(thisCharge);
                            osKey = thisOSKey;
                        }
                    }
                }


                if (os != null) {
                    if ((Integer) os.get("p_piece") > 0) {
                        osArr.add(os);
                        osCodeArr.add(osCode);
                        osChargeArr.add(lastOSCost);
                        osKeyArr.add(osKey);
                    } else if ((Integer) os.get("p_shipment") > 0) {
                        if (osArr.isEmpty() || (!osArr.isEmpty() && (Integer) os.get("p_shipment") > (Integer) os.get("p_shipment"))) {
                            osArr = Arrays.asList(os);
                            osCodeArr = Arrays.asList(osCode);
                            osChargeArr = Arrays.asList(lastOSCost);
                            osKeyArr = Arrays.asList(osKey);
                        }
                    }
                }
            }
        }

        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("osArr", osArr);
        resultMap.put("osCodeArr", osCodeArr);
        resultMap.put("osChargeArr", osChargeArr);
        resultMap.put("osKeyArr", osKeyArr);

        return resultMap;
    }

    public boolean checkIsCargoProcessWithRef(String ref, Map<String, Object> mdata) {
        if (ref.matches("(?i)SKP|MKP|BKP|PKP|PICKUP") || mdata.containsKey("cargo_delivery") || mdata.containsKey("cargo_pickup")) {
            return true;
        }
        return false;
    }

    public BigDecimal myChargeCBM(BigDecimal weight, BigDecimal cbm, Map<String, Object> mdata,int pkg) throws JsonProcessingException {
        BigDecimal calculateCBM = BigDecimal.ZERO;
        BigDecimal myCBM = getTotalCBM(cbm, mdata,pkg);

        if (mdata.containsKey("chargecode")) {
            String chargecode = (String) mdata.get("chargecode");
            ImportChargeCode chargeCodeInfo = importChargeCodeMapper.findByChargecode(chargecode);
            if (chargeCodeInfo != null) {
                ObjectMapper objectMapper = new ObjectMapper();
                Map<String, Object> chargeCodeMetaData = objectMapper.readValue(chargeCodeInfo.getMeta(), Map.class);
                if (chargeCodeMetaData.containsKey("calculate_cbm") && (boolean) chargeCodeMetaData.get("calculate_cbm")) {
                    if (chargeCodeInfo.getChargeWt() == null) {
                        BigDecimal ratio = new BigDecimal("250");
                        calculateCBM = weight.divide(ratio, 2, RoundingMode.HALF_UP);
                    }
                }
            }
        }
        return calculateCBM.max(myCBM);
    }

    public BigDecimal getTotalCBM(BigDecimal cbm, Map<String, Object> mdata,int pkg) {
        BigDecimal myCBM = mdata.containsKey("total_cbm") ? new BigDecimal(mdata.get("total_cbm").toString()) : cbm.multiply(new BigDecimal(pkg));
        myCBM = myCBM.max(cbm.multiply(new BigDecimal(pkg)));
        myCBM = myCBM.max(new BigDecimal("0.000001"));
        return myCBM;
    }

    public Map<String, Object> getCostEtower(Integer orgRateId, String suburb, String postcode, double weight, boolean isApi, Shipment shipment,String chargeCode) {

        Map<String, Object> result = new HashMap<>();
        OrgRate or = orgRateMapper.selectByPrimaryKey(orgRateId);

        result.put("code", 0);
        result.put("msg", "");
        result.put("data", 0);

        BigDecimal price = BigDecimal.ZERO;
        int intPostcode = Integer.parseInt(postcode);

        ZoneMap zoneMap;
        if (suburb != null && !suburb.isEmpty()) {
            zoneMap = zoneMapMapper.findByOrgIdZoneIdPostcodeAndSuburb(or.getOrgId(), or.getZoneId(), intPostcode, suburb);
        } else {
            zoneMap = zoneMapMapper.findByOrgIdZoneIdAndPostcode(or.getOrgId(), or.getZoneId(), intPostcode);
        }

        if (zoneMap != null && zoneMap.getZ1() != null) {
            chargeCode = zoneMap.getZ1();
        }

        List<ZoneRate> zrs = zoneRateMapper.findByZoneWeightAndRateId(chargeCode, weight, orgRateId);
        if (zrs != null && !zrs.isEmpty()) {
            for (ZoneRate zr : zrs) {
                BigDecimal temp = zr.getBase().add(zr.getItem());
                if (zr.getNkg().compareTo(0.0f) > 0) {
                    BigDecimal wl = BigDecimal.valueOf(weight).subtract(zr.getMinIncl());
                    BigDecimal nkgBigDecimal = new BigDecimal(zr.getNkg().toString()); // Convert Float to BigDecimal
                    temp = temp.add(wl.divide(nkgBigDecimal, RoundingMode.CEILING).multiply(zr.getPerkg()));
                }  else {
                    temp = temp.add(BigDecimal.valueOf(weight).multiply(zr.getPerkg()));
                }
                if (zr.getMinimum().compareTo(BigDecimal.ZERO) > 0 && temp.compareTo(zr.getMinimum()) < 0) {
                    temp = zr.getMinimum();
                }
                price = price.max(temp);
            }

            if (isApi && shipment != null) {
                BigDecimal levyCostRate = shipmentRemotePercentageRate(orgRateId,postcode,suburb,chargeCode);
                if (levyCostRate != null) {
                    BigDecimal levySurcharge = price.multiply(levyCostRate);
                    price = price.add(levySurcharge);
                }
            }

            RemoteChargeRate remoteCostRate = remoteChargeRateMapper.findByRateIdPostcodeAndSuburb(or.getId(), postcode, suburb.toUpperCase());
            if (remoteCostRate != null) {
                BigDecimal remoteSurcharge = BigDecimal.valueOf(weight).multiply(remoteCostRate.getPerkg()).add(remoteCostRate.getBase());
                price = price.add(remoteSurcharge);
            }

            Gson gson = new Gson();
            Map<String, Object> metaMap = gson.fromJson(or.getMeta(), Map.class);

            if (metaMap.containsKey("fuel")) {
                price = price.add(price.multiply(new BigDecimal(metaMap.get("fuel").toString())));
            }

        } else {
            result.put("code", 1);
            result.put("msg", "no rate for this service");
            return result;
        }

        result.put("msg", "success");
        result.put("data", price);
        return result;

    }

    public BigDecimal shipmentRemotePercentageRate(Integer orgRateId,String postcode,String suburb,String chargeCode) {
        BigDecimal levyCost = BigDecimal.ZERO;

        if (orgRateId != null) {

            RemoteChargeRate levyCostRate = remoteChargeRateMapper.findByRateIdPostcodeAndSuburb(orgRateId, postcode, suburb);

            if (levyCostRate == null) {
                levyCostRate = remoteChargeRateMapper.findByRateIdAndPostcodeRange(orgRateId, postcode);
            }

            if (levyCostRate == null) {
                ImportChargeCode chargecode = importChargeCodeMapper.findByChargeCode(chargeCode);
                if (chargecode != null) {
                    levyCostRate = remoteChargeRateMapper.findByChargeCodeIdRateIdAndPostcode(chargecode.getId(), orgRateId, postcode);
                }
            }

            if (levyCostRate != null) {
                levyCost = levyCostRate.getLevy();
            }
        }

        return levyCost;
    }


    public BigDecimal costStatus(OrgRate orgRate, String suburb, String postcode, double weight, Shipment shipment,String chargeCode) {

        Map<String, Object> costMap;
        switch (orgRate.getOrgId()) {
            case 3752:
                costMap = getCostMyToll(orgRate.getId(), suburb, postcode, weight, true, chargeCode);
                break;
            default:
                costMap = getCostJavaAPI(orgRate.getId(), suburb, postcode, weight, false, false);
                break;
        }

        if (costMap == null || !costMap.containsKey("code")) {
            return new BigDecimal("99999");
        }

        int code = (int) costMap.get("code");
        BigDecimal costValue = (BigDecimal) costMap.get("data");
        if (suburb == null || suburb.isEmpty()) {
            return new BigDecimal("99999");
        }

        if (code == 0) {
            BigDecimal surcharge = getCourierSurchargeCost(shipment, orgRate);
            costValue = costValue.add(surcharge);
            return costValue;
            //return new BigDecimal("88888");
        } else if (code == 2) {
            return new BigDecimal("88888");
        } else {
            return new BigDecimal("99999");
        }
    }


    public Map<String, Object> getCostMyToll(Integer orgRateId, String suburb, String postcode, double weight, boolean noRemote,String chargeCode) {
        Map<String, Object> result = new HashMap<>();
        OrgRate or = orgRateMapper.selectByPrimaryKey(orgRateId);

        result.put("code", 0);
        result.put("msg", "");
        result.put("data", 0);

        BigDecimal price = BigDecimal.ZERO;
        int intPostcode = Integer.parseInt(postcode);

        ZoneMap zoneMap = zoneMapMapper.findByOrgIdZoneIdAndPostcode(or.getOrgId(), or.getZoneId(), intPostcode);

        ZoneMap zoneMap2 = zoneMapMapper.findByOrgIdZoneIdPostcodeAndSuburb(or.getOrgId(), or.getZoneId(), intPostcode, suburb);

        if (zoneMap2 != null) {
            zoneMap = zoneMap2;
        }
        if (zoneMap != null && zoneMap.getZ1() != null) {
            chargeCode = zoneMap.getZ1();
        }

        List<ZoneRate> zrs = zoneRateMapper.findByZoneWeightAndRateId(chargeCode, weight, orgRateId);
        if (zrs != null && !zrs.isEmpty()) {
            for (ZoneRate zr : zrs) {
                BigDecimal temp = zr.getBase().add(zr.getItem());
                if (zr.getNkg().compareTo(0.0f) > 0) {
                    BigDecimal wl = BigDecimal.valueOf(weight);
                    temp = temp.add(wl.divide(new BigDecimal(zr.getNkg().toString()), RoundingMode.CEILING).multiply(zr.getPerkg()));
                } else {
                    temp = temp.add(BigDecimal.valueOf(weight).multiply(zr.getPerkg()));
                }
                if (zr.getMinimum().compareTo(BigDecimal.ZERO) > 0 && temp.compareTo(zr.getMinimum()) < 0) {
                    temp = zr.getMinimum();
                }
                price = price.max(temp);
            }

            BigDecimal levySurcharge = BigDecimal.ZERO;
            BigDecimal levyCostRate = shipmentRemotePercentageRate(orgRateId,postcode,suburb,chargeCode);
            if (levyCostRate != null) {
                levySurcharge = price.multiply(levyCostRate);
            }

            if (!noRemote) {
                RemoteChargeRate remoteCostRate = remoteChargeRateMapper.findByRateIdPostcodeAndSuburb(or.getId(), postcode, suburb.toUpperCase());
                if (remoteCostRate != null) {
                    BigDecimal remoteSurcharge = BigDecimal.valueOf(weight).multiply(remoteCostRate.getPerkg()).add(remoteCostRate.getBase());
                    price = price.add(remoteSurcharge);
                }
            }

            Gson gson = new Gson();
            Map<String, Object> metaMap = gson.fromJson(or.getMeta(), Map.class);

            if (metaMap.containsKey("fuel")) {
                price = price.add(price.multiply(new BigDecimal(metaMap.get("fuel").toString())));
            }

            price = price.add(levySurcharge);
        } else {
            result.put("code", 1);
            result.put("msg", "no rate for this service");
            return result;
        }

        result.put("msg", "success");
        result.put("data", price);
        return result;
    }


    public Map<String, Object> getCostJavaAPI(Integer orgRateId, String suburb, String postcode, double weight, boolean noRemote, boolean isNoFuel) {
        Map<String, Object> result = new HashMap<>();
        OrgRate or = orgRateMapper.selectByPrimaryKey(orgRateId);

        result.put("code", 0);
        result.put("msg", "");
        result.put("data", 0);

        BigDecimal price = BigDecimal.ZERO;
        int intPostcode = Integer.parseInt(postcode);

        ZoneMap hasOne = zoneMapMapper.findByOrgIdAndZoneIdWithNonEmptySuburb(or.getOrgId(), or.getZoneId().intValue());
        ZoneMap zoneMap;

        if (hasOne != null) {
            zoneMap = zoneMapMapper.findByOrgIdZoneIdPostcodeAndSuburb(or.getOrgId(), or.getZoneId(), intPostcode, suburb);
        } else {
            zoneMap = zoneMapMapper.findByOrgIdZoneIdAndPostcode(or.getOrgId(), or.getZoneId(), intPostcode);
        }

        String chargeCode = "xxxxxxxxx";
        if (zoneMap != null && zoneMap.getZ1() != null) {
            chargeCode = zoneMap.getZ1();
        }

        List<ZoneRate> zrs = zoneRateMapper.findByZoneWeightAndRateId(chargeCode, weight, orgRateId);
        if (zrs != null && !zrs.isEmpty()) {
            for (ZoneRate zr : zrs) {
                BigDecimal temp = zr.getBase().add(zr.getItem());
                if (zr.getNkg().compareTo(0.0f) > 0) {
                    BigDecimal wl = BigDecimal.valueOf(weight).subtract(zr.getMinIncl());
                    BigDecimal nkgBigDecimal = new BigDecimal(zr.getNkg().toString()); // Convert Float to BigDecimal
                    temp = temp.add(wl.divide(nkgBigDecimal, RoundingMode.CEILING).multiply(zr.getPerkg()));
                } else {
                    BigDecimal adjustedWeight = BigDecimal.valueOf(weight).subtract(zr.getMinIncl());
                    temp = temp.add(adjustedWeight.multiply(zr.getPerkg()));
                }
                if (zr.getMinimum().compareTo(BigDecimal.ZERO) > 0 && temp.compareTo(zr.getMinimum()) < 0) {
                    temp = zr.getMinimum();
                }
                price = price.max(temp);
            }


            if (!noRemote) {
                RemoteChargeRate remoteCostRate = remoteChargeRateMapper.findByRateIdPostcodeAndSuburb(or.getId(), postcode, suburb.toUpperCase());
                if (remoteCostRate != null) {
                    BigDecimal remoteSurcharge = BigDecimal.valueOf(weight).multiply(remoteCostRate.getPerkg()).add(remoteCostRate.getBase());
                    price = price.add(remoteSurcharge);
                }
            }

            if (or.getMeta().contains("fuel") && !isNoFuel) {
                Gson gson = new Gson();
                Map<String, Object> metaMap = gson.fromJson(or.getMeta(), Map.class);
                String fuelValue = metaMap.get("fuel").toString();
                if (!fuelValue.isEmpty() && isNumeric(fuelValue)) {
                    price = price.add(price.multiply(new BigDecimal(fuelValue)));
                }
            }
        } else {
            result.put("code", 1);
            result.put("msg", "no rate for this service");
            return result;
        }

        result.put("msg", "success");
        result.put("data", price);
        return result;
    }

    public BigDecimal getCourierSurchargeCost(Shipment shipment, OrgRate orgRate) {
        boolean alliedHomeSurcharge = isShipmentResidential(shipment, orgRate);
        if (alliedHomeSurcharge) {
            return BigDecimal.valueOf(getShipmentCostSurcharge(shipment, orgRate, true));
        } else {
            return BigDecimal.valueOf(getShipmentCostSurcharge(shipment, orgRate, false));

        }
    }

    public boolean isShipmentResidential(Shipment shipment, OrgRate orgRate) {
        int cneeId = shipment.getCneeId();
        Addr addr = addrmapper.selectByPrimaryKey(cneeId);
        String postcode =addr.getPostcode();
        String suburb = addr.getSuburb();
        String adress = addr.getAddress();
        if (isFbaShipment(postcode, suburb, adress)) {
            return false;
        }

        int resiC = addrResidentialMapper.countByAddressSuburbPostcode(adress, suburb, postcode);
        if (resiC > 0) {
            return true;
        } else {
            BigDecimal alliedHomeSurcharge = this.getAlliedHomeDelFee(shipment, orgRate);
            if (alliedHomeSurcharge.compareTo(BigDecimal.ZERO) > 0 && alliedHomeSurcharge.compareTo(new BigDecimal("9999")) < 0) {
                AddrResidential addrResidential = new AddrResidential();
                addrResidential.setAddress(adress);
                addrResidential.setSuburb(suburb);
                addrResidential.setPostcode(postcode);
                addrResidential.setCountry("Australia");
                addrResidentialMapper.insertSelective(addrResidential);
                return true;
            }
        }
        return false;
    }

    public BigDecimal getAlliedHomeDelFee(Shipment shipment, OrgRate orgRate) {
        if (shipment.getMdata().containsKey("is_b2c")) {
            return new BigDecimal("100");
        }
        Map<String, Object> result = null;
        int cneeId = shipment.getCneeId();
        Addr addr = addrmapper.selectByPrimaryKey(cneeId);
        String postcode =addr.getPostcode();
        String suburb = addr.getSuburb();
        String adress = addr.getAddress();
        if (isFbaShipment(postcode, suburb, adress)) {
            return BigDecimal.ZERO;
        }
        int alliedRateId = orgRate.getId();
        String metaString = orgRate.getMeta();
        JsonObject metaJson = JsonParser.parseString(metaString).getAsJsonObject();
        int alliedRateDdpt_id = metaJson.get("ddpt_id").getAsInt();
        Map<Integer, Integer> alliedRateIds = Map.of(
                106, 10900,
                218, 10903,
                530, 10906,
                811, 11119
        );
        if (alliedRateIds.containsKey(alliedRateDdpt_id) && alliedRateIds.get(alliedRateDdpt_id).equals(alliedRateId)) {
            result = this.checkAlliedHomeFee(shipment);
            if (!"60000".equals(result.get("code"))) {
                return new BigDecimal("9999");
            } else {
                if (result.get("data") != null && ((Map<String, Object>) result.get("data")).containsKey("freight_oversized_home_del")) {
                    return new BigDecimal(((Map<String, Object>) result.get("data")).get("freight_oversized_home_del").toString());
                }
            }
        }
        return BigDecimal.ZERO;
    }

    public boolean isFbaShipment(String postcode,String suburb,String address) {
        boolean match = false;

        List<String> PUREFBAPOSTCODE = Arrays.asList("3175", "2170", "6105", "4178", "3043", "3023", "2178");
        if (PUREFBAPOSTCODE.contains(postcode)) {
            JsonResultBean regionData = systemSettingService.getSetting("FBARegion","FBA");
            DataBean regionDataFba = (DataBean) regionData.getData();
            Map<String, List<String[]>> regionFba = (Map<String, List<String[]>>) regionDataFba.getData();
            List<String[]> dataForPostcode = regionFba.get(postcode);

            if (dataForPostcode != null) {
                for (String[] value : dataForPostcode) {
                    String[] words = value[0].split(" ");
                    boolean thisMatch = true;
                    for (String word : words) {
                        word = word.replaceAll("/", "\\/");
                        if (!word.isEmpty()) {
                            if (!(Pattern.compile(Pattern.quote(word.toUpperCase())).matcher(address.toUpperCase()).find() &&
                                    value[1].trim().equalsIgnoreCase(suburb.trim()))) {
                                thisMatch = false;
                                break;
                            }
                        }
                    }
                    if (thisMatch) {
                        match = true;
                        break;
                    }
                }
            }
        }
        return match;
    }

    public Map<String, Object> checkAlliedHomeFee(Shipment  shipment){
        //Map<String, Object> params = new HashMap<>();

        if (shipment.getWeight().compareTo(BigDecimal.ONE) < 0) {
            shipment.setWeight(BigDecimal.ONE);
        }

        Gson gson = new Gson();
        Type type = new TypeToken<List<Map<String, Object>>>(){}.getType();
        List<Map<String, Object>> packages = gson.fromJson(shipment.getPackages(), type);
        if (packages == null) {
            packages = new ArrayList<>();
        }
        for (Map<String, Object> pack : packages) {
            Object obj = pack.get("weight");
            if (Double.parseDouble((String) obj)<1.0) {
                pack.put("weight", 1.0);
            }
        }
        Gson gson1 = new Gson();
        String packagesJson = gson1.toJson(packages);
        shipment.setPackages(packagesJson);

        Map<String, Object> data = this.prepareData(shipment);
        data.put("courier", "allied");
        data.put("type", shipment.getType());
        data.put("prefix", "");

        Gson gson3 = new Gson();
        String jsonData = gson3.toJson(data);

        JsonResultBean alliedcharge = apiServiceClient.getAlliedCharge(jsonData);

        Type type1 = new TypeToken<Map<String, Object>>(){}.getType();
        Gson gson4 = new Gson();
        Map<String, Object> resultMap = gson4.fromJson(gson4.toJson(alliedcharge), type1);
        return resultMap;
    }

    public Map<String, Object> prepareData(Shipment shipment) {
        Map<String, Object> data = new HashMap<>();
        Map<String, String> shipper = new HashMap<>();

        Addr cnor = addrmapper.selectByPrimaryKey(shipment.getCnorId());
        shipper.put("name", cnor.getName());
        shipper.put("address", cnor.getAddress());
        shipper.put("state", cnor.getState());
        shipper.put("city", cnor.getCity());
        shipper.put("suburb", cnor.getSuburb());
        shipper.put("postcode", cnor.getPostcode());
        shipper.put("phone", cnor.getTel());
        shipper.put("email", cnor.getEmail());
        shipper.put("company", cnor.getCompany());


        Addr cnee = addrmapper.selectByPrimaryKey(shipment.getCneeId());
        Map<String, String> consignee = new HashMap<>();
        consignee.put("name", cnee.getName());
        consignee.put("address", cnee.getAddress());
        consignee.put("state", cnee.getState());
        consignee.put("city", cnee.getCity());
        consignee.put("suburb", cnee.getSuburb());
        consignee.put("postcode", cnee.getPostcode());
        consignee.put("phone", cnee.getTel());
        consignee.put("company", cnee.getCompany());
        consignee.put("email", cnee.getEmail());

        data.put("custRef", shipment.getCref());
        data.put("type", 10);
        data.put("packs", shipment.getPkg());
        data.put("weight", shipment.getWeight());
        Gson gson = new Gson();
        Type type = new TypeToken<List<Map<String, String>>>() {}.getType();

        String jsonString = shipment.getPackages();
        List<Map<String, String>> packagesList = gson.fromJson(jsonString, type);

        data.put("packages", packagesList);
        data.put("shipper", shipper);
        data.put("consignee", consignee);
        data.put("chargecode", "");
        data.put("barcode", 1);
        data.put("direct", 0);
        data.put("connote", shipment.getHbn());
        data.put("instruction", "No split deliveries;ATL;");
        data.put("hbn", shipment.getHbn());
        data.put("cref", shipment.getCref());
        data.put("agentId", shipment.getAgentId());
        data.put("ref", shipment.getRef());

        // Adding the new data
        Object fastHorseRef = shipment.getMdata().get("fast_horse_ref");
        data.put("fast_horse_ref", fastHorseRef != null ? fastHorseRef.toString() : "");

        Object scanTime = shipment.getMdata().get("scan_time");
        if (scanTime != null) {
            data.put("date", scanTime.toString());
        } else {
            String currentDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            data.put("date", currentDate);
        }

        return data;
    }
//    public double getShipmentCostSurcharge(Shipment shipment, OrgRate orgRate, boolean noRSD) {
//
//        List<List<? extends Serializable>> chargeArr = new ArrayList<>();
//        double amount = 0;
//        Set<String> codeArr = new HashSet<>();
//        int orgId = orgRate.getId();
//        List<ImportsFlexibleSurcharge> courierSurchargeInfo = importsFlexibleSurchargeMapper.selectByRateIdWithConditions(orgId);
//
//        for (ImportsFlexibleSurcharge courierSurcharge : courierSurchargeInfo) {
//            codeArr.add(courierSurcharge.getType());
//        }
//
//        for (String code : codeArr) {
//            if ("OSC".equals(code)) {
//                chargeArr = calculateSingleOSCRule(shipment, courierSurchargeInfo, code);
//            } else if ("RSD".equals(code)) {
//                if (Boolean.TRUE.equals(noRSD)) {
//                    chargeArr.clear();
//                } else {
//                    chargeArr = calculateSingleOSCRule(shipment, courierSurchargeInfo, code);
//                }
//            } else {
//                chargeArr = calculateSingleRule(shipment, courierSurchargeInfo, code);
//            }
//            double lastCost = chargeArr.stream()
//                    .flatMap(innerList -> innerList.stream())
//                    .mapToDouble(value -> ((Double) value).doubleValue())
//                    .sum();
//            amount += lastCost;
//        }
//        return amount;
//    }
public double getShipmentCostSurcharge(Shipment shipment, OrgRate orgRate, boolean noRSD) {

    List<List<? extends Serializable>> chargeArr = new ArrayList<>();
    double amount = 0;
    Set<String> codeArr = new HashSet<>();
    int orgId = orgRate.getId();
    List<ImportsFlexibleSurcharge> courierSurchargeInfo = importsFlexibleSurchargeMapper.selectByRateIdWithConditions(orgId);

    for (ImportsFlexibleSurcharge courierSurcharge : courierSurchargeInfo) {
        codeArr.add(courierSurcharge.getType());
    }

    for (String code : codeArr) {
        if ("OSC".equals(code)) {
            chargeArr = calculateSingleOSCRule(shipment , courierSurchargeInfo, code);
        } else if ("RSD".equals(code)) {
            if (Boolean.TRUE.equals(noRSD)) {
                chargeArr.clear();
            } else {
                chargeArr = calculateSingleOSCRule(shipment,courierSurchargeInfo, code);
            }
        } else {
            chargeArr = calculateSingleRule(shipment, courierSurchargeInfo, code);
        }

        List<Double> OSChargeArr = (List<Double>) chargeArr.get(2);
        double lastCost = OSChargeArr.stream().mapToDouble(Double::doubleValue).sum();
        amount += lastCost;
    }
    return amount;
}


public List<List<? extends Serializable>> calculateSingleOSCRule(Shipment shipment, List<ImportsFlexibleSurcharge> courierSurchargeInfo, String pattern) {
    List<ImportsFlexibleSurcharge> OSArr = new ArrayList<>();
    List<String> OSCodeArr = new ArrayList<>();
    List<Double> OSChargeArr = new ArrayList<>();
    List<String> OSKeyArr = new ArrayList<>();

    if (courierSurchargeInfo != null && !courierSurchargeInfo.isEmpty()) {
        if (shipment.getPacks() != null && !shipment.getPacks().isEmpty()) {
            for (Object packObj : shipment.getPacks()) {
                Map<String, Object> packMap = (Map<String, Object>) packObj;
                ImportsFlexibleSurcharge OS = null;
                String OSCode = "";
                String OSKey = "";
                double lastOSCost = 0;

                Double packLength = Double.parseDouble((String) packMap.get("length"));
                Double packWidth = Double.parseDouble((String) packMap.get("width"));
                Double packHeight = Double.parseDouble((String) packMap.get("height"));

                List<Double> thisPackDim = Arrays.asList(packLength, packWidth);
                Collections.sort(thisPackDim, Collections.reverseOrder());
                double length = thisPackDim.get(0) / 100;
                double width = thisPackDim.get(1) / 100;
                double height = packHeight / 100;

                Double packWeight = ((BigDecimal) packMap.get("weight")).doubleValue();

                double cubeWeight = length * width * height * 250;

                int surchargeIndex = 0;  // Added this line to track the index of surchargeInfo
                for (ImportsFlexibleSurcharge value : courierSurchargeInfo) {
                    double weight = packWeight;

                    ImportsFlexibleSurcharge thisOS = null;
                    String thisOSCode = "";
                    double thisCharge = 0;
                    String thisOSKey = "";

                    if (pattern.equals(value.getType())) {
                        if (value.getpShipment().compareTo(BigDecimal.ZERO) > 0) {
                            if (weight > value.getKgdwf().doubleValue() &&
                                    weight < value.getKgdwt().doubleValue() &&
                                    !value.getKgdwt().equals(BigDecimal.ZERO)) {
                                if (value.getLength() != null &&
                                        length >= value.getLength().doubleValue() &&
                                        width >= value.getWidth().doubleValue() &&
                                        height >= value.getHeight().doubleValue()) {
                                    thisOS = value;
                                    thisOSCode = "Limited Length " + value.getLength() + " Width " + value.getWidth() + " Height " + value.getHeight();
                                    thisOSKey = String.valueOf(surchargeIndex);  // Modified this line to match the PHP logic
                                }
                            }
                        } else if (value.getpPiece().compareTo(BigDecimal.ZERO) > 0) {
                            if (weight > value.getKgdwf().doubleValue() &&
                                    weight < value.getKgdwt().doubleValue() &&
                                    !value.getKgdwt().equals(BigDecimal.ZERO)) {
                                if (value.getLength() != null &&
                                        length >= value.getLength().doubleValue() &&
                                        width >= value.getWidth().doubleValue() &&
                                        height >= value.getHeight().doubleValue()) {
                                    thisOS = value;
                                    thisOSCode = "Limited Length " + value.getLength() + " Width " + value.getWidth() + " Height " + value.getHeight();
                                    thisOSKey = String.valueOf(surchargeIndex);  // Modified this line to match the PHP logic
                                }
                            }
                        }
                    }
                    if (thisOS != null) {
                        thisCharge = thisOS.getpPiece().add(thisOS.getpShipment()).doubleValue();

                        if (thisCharge > lastOSCost) {
                            OS = thisOS;
                            OSCode = thisOSCode;
                            lastOSCost = thisCharge;
                            OSKey = thisOSKey;
                        }
                    }

                    if (OS != null) {
                        if (OS.getpPiece().compareTo(BigDecimal.ZERO) > 0) {
                            OSArr.add(OS);
                            OSCodeArr.add(OSCode);
                            OSChargeArr.add(lastOSCost);
                            OSKeyArr.add(OSKey);
                        } else if (OS.getpShipment().compareTo(BigDecimal.ZERO) > 0) {
                            OSArr.clear();
                            OSCodeArr.clear();
                            OSChargeArr.clear();
                            OSKeyArr.clear();

                            OSArr.add(OS);
                            OSCodeArr.add(OSCode);
                            OSChargeArr.add(lastOSCost);
                            OSKeyArr.add(OSKey);
                        }
                    }
                    surchargeIndex++;
                }
            }
        }
    }
    return Arrays.asList(OSArr, OSCodeArr, OSChargeArr, OSKeyArr);
}


    public List<List<? extends Serializable>> calculateSingleRule(Shipment shipment, List<ImportsFlexibleSurcharge> courierSurchargeInfo, String pattern) {
        List<ImportsFlexibleSurcharge> OSArr = new ArrayList<>();
        List<String> OSCodeArr = new ArrayList<>();
        List<Double> OSChargeArr = new ArrayList<>();
        List<String> OSKeyArr = new ArrayList<>();

        if (courierSurchargeInfo != null && !courierSurchargeInfo.isEmpty()) {
            if (shipment.getPacks() != null && !shipment.getPacks().isEmpty()) {
                for (Object packObj : shipment.getPacks()) {
                    Map<String, Object> packMap = (Map<String, Object>) packObj;
                    ImportsFlexibleSurcharge OS = null;
                    String OSCode = "";
                    String OSKey = "";
                    double lastOSCost = 0;

                    Double packLength = Double.parseDouble((String) packMap.get("length"));
                    Double packWidth = Double.parseDouble((String) packMap.get("width"));
                    Double packHeight = Double.parseDouble((String) packMap.get("height"));

                    List<Double> thisPackDim = Arrays.asList(packLength, packWidth);
                    Collections.sort(thisPackDim, Collections.reverseOrder());
                    double length = thisPackDim.get(0) / 100;
                    double width = thisPackDim.get(1) / 100;
                    double height = packHeight / 100;

                    Double packWeight = new BigDecimal((String) packMap.get("weight")).doubleValue();


                    double cubeWeight = length * width * height * 250;

                    for (ImportsFlexibleSurcharge value : courierSurchargeInfo) {
                        double weight = packWeight;

                        ImportsFlexibleSurcharge thisOS = null;
                        String thisOSCode = "";
                        double thisCharge = 0;
                        String thisOSKey = "";

                        if (value.getType().equals(pattern)) {
                            if (value.getpShipment().compareTo(BigDecimal.ZERO) > 0) {
                                double shipmentWeight = shipment.getWeight().doubleValue();
                                double shipmentCubeWeight = shipment.getCbm().multiply(new BigDecimal(shipment.getPkg())).doubleValue() * 250;

                                if (shipmentWeight > value.getKgdwf().doubleValue() && shipmentWeight < value.getKgdwt().doubleValue() && value.getKgdwt().compareTo(BigDecimal.ZERO) != 0) {
                                    thisOS = value;
                                    thisOSCode = "Weight between " + value.getKgdwf() + " to " + value.getKgdwt();
                                }

                                if (shipmentCubeWeight > value.getKgcwf().doubleValue() && shipmentCubeWeight < value.getKgcwt().doubleValue() && value.getKgcwt().compareTo(BigDecimal.ZERO) != 0) {
                                    thisOS = value;
                                    thisOSCode = "cube Weight between " + value.getKgcwf() + " to " + value.getKgcwt();
                                }

                                double diagonalLength = Math.sqrt(Math.pow(length, 2) + Math.pow(width, 2) + Math.pow(height, 2));
                                if (value.getMetert().compareTo(new BigDecimal("0.001")) > 0 && diagonalLength >= value.getMeterf().doubleValue() && diagonalLength <= value.getMetert().doubleValue()) {
                                    thisOS = value;
                                    thisOSCode = "Diagonal Length between " + value.getMeterf() + " to " + value.getMetert();
                                }

                                String chargecode = shipment.getMdata().getString("chargecode");
                                if (value.getLength().compareTo(new BigDecimal("0.001")) > 0 || value.getWidth().compareTo(new BigDecimal("0.001")) > 0 || value.getHeight().compareTo(new BigDecimal("0.001")) > 0) {
                                    if (NEW_RULE_CHARGECODE.contains(chargecode)) {
                                        if (length >= value.getLength().doubleValue() && width >= value.getWidth().doubleValue() && height >= value.getHeight().doubleValue()) {
                                            thisOS = value;
                                            thisOSCode = "Limited Length " + value.getLength() + " Width " + value.getWidth() + " Height " + value.getHeight();
                                        }
                                    } else {
                                        if (length >= value.getLength().doubleValue() || width >= value.getWidth().doubleValue() || height >= value.getHeight().doubleValue()) {
                                            thisOS = value;
                                            thisOSCode = "Limited Length " + value.getLength() + " Width " + value.getWidth() + " Height " + value.getHeight();
                                        }
                                    }
                                }

                                if (value.getCbm().compareTo(new BigDecimal("0.001")) > 0 && shipment.getCbm().doubleValue() > value.getCbm().doubleValue()) {
                                    thisOS = value;
                                    thisOSCode = "Over cbm " + value.getCbm();
                                }
                            } else if (value.getpPiece().compareTo(BigDecimal.ZERO) > 0) {
                                double shipmentWeight = shipment.getWeight().doubleValue();
                                double shipmentCubeWeight = shipment.getCbm().multiply(new BigDecimal(shipment.getPkg())).doubleValue() * 250;

                                if (shipmentWeight > value.getKgdwf().doubleValue() && shipmentWeight < value.getKgdwt().doubleValue() && value.getKgdwt().compareTo(BigDecimal.ZERO) != 0) {
                                    thisOS = value;
                                    thisOSCode = "Weight between " + value.getKgdwf() + " to " + value.getKgdwt();
                                }

                                if (shipmentCubeWeight > value.getKgcwf().doubleValue() && shipmentCubeWeight < value.getKgcwt().doubleValue() && value.getKgcwt().compareTo(BigDecimal.ZERO) != 0) {
                                    thisOS = value;
                                    thisOSCode = "cube Weight between " + value.getKgcwf() + " to " + value.getKgcwt();
                                }

                                double diagonalLength = Math.sqrt(Math.pow(length, 2) + Math.pow(width, 2) + Math.pow(height, 2));
                                if (value.getMetert().compareTo(new BigDecimal("0.001")) > 0 && diagonalLength >= value.getMeterf().doubleValue() && diagonalLength <= value.getMetert().doubleValue()) {
                                    thisOS = value;
                                    thisOSCode = "Diagonal Length between " + value.getMeterf() + " to " + value.getMetert();
                                }

                                String chargecode = shipment.getMdata().getString("chargecode");
                                if (NEW_RULE_CHARGECODE.contains(chargecode)) {
                                    if (length >= value.getLength().doubleValue() && width >= value.getWidth().doubleValue() && height >= value.getHeight().doubleValue()) {
                                        thisOS = value;
                                        thisOSCode = "Limited Length " + value.getLength() + " Width " + value.getWidth() + " Height " + value.getHeight();
                                    }
                                } else {
                                    if (length >= value.getLength().doubleValue() || width >= value.getWidth().doubleValue() || height >= value.getHeight().doubleValue()) {
                                        thisOS = value;
                                        thisOSCode = "Limited Length " + value.getLength() + " Width " + value.getWidth() + " Height " + value.getHeight();
                                    }
                                }

                                if (value.getCbm().compareTo(new BigDecimal("0.001")) > 0 && shipment.getCbm().doubleValue() > value.getCbm().doubleValue()) {
                                    thisOS = value;
                                    thisOSCode = "Over cbm " + value.getCbm();
                                }
                            }
                        }

                        if (thisOS != null) {
                             thisCharge = thisOS.getpPiece().add(thisOS.getpShipment()).doubleValue();
                            if (thisCharge > lastOSCost) {
                                OS = thisOS;
                                OSCode = thisOSCode;
                                lastOSCost = thisCharge;
                                OSKey = thisOSKey;
                            }
                        }

                        if (OS != null) {
                        if (OS.getpPiece().doubleValue() > 0) {
                            OSArr.add(OS);
                            OSCodeArr.add(OSCode);
                            OSChargeArr.add(lastOSCost);
                            OSKeyArr.add(OSKey);
                        } else if (OS.getpShipment().doubleValue() > 0) {
                            if (OSArr.isEmpty() || (!OSArr.isEmpty() && OS.getpShipment().doubleValue() > OS.getpShipment().doubleValue())) {
                                OSArr.clear();
                                OSCodeArr.clear();
                                OSChargeArr.clear();
                                OSKeyArr.clear();

                                OSArr.add(OS);
                                OSCodeArr.add(OSCode);
                                OSChargeArr.add(lastOSCost);
                                OSKeyArr.add(OSKey);
                            }
                        }
                    }
                }
            }
        }
      }
        return Arrays.asList(OSArr, OSCodeArr, OSChargeArr, OSKeyArr);
    }

}


