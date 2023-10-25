package com.hvlv.microservices.shipmentService.hvlvShipmentService.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONArray;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hvlv.microservices.apiService.hvlvApiService.service.TlaAPIService;
import com.hvlv.microservices.shipmentService.hvlvShipmentService.beans.DataBean;
import com.hvlv.microservices.shipmentService.hvlvShipmentService.beans.JsonResultBean;
import com.hvlv.microservices.shipmentService.hvlvShipmentService.client.ApiServiceClient;
import com.hvlv.microservices.shipmentService.hvlvShipmentService.config.Const;
import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.*;
import com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.stereotype.Service;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.FileCopyUtils;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class CourierCanDeliveryService {
    @Autowired
    RedisService redisService;
    @Autowired
    ImportChargeCodeMapper importChargeCodeMapper;
    @Autowired
    OrgRateMapper orgRateMapper;
    @Autowired
    AddrMapper addrMapper;
    @Autowired
    SystemSettingService systemSettingService;
    @Autowired
    ZoneRateMapper zoneRateMapper;
    @Autowired
    ZoneMapMapper zoneMapMapper;
    @Autowired
    CurrencyMapper currencyMapper;
    @Autowired
    AddrService addrService;
    @Autowired
    ShipmentMapper shipmentMapper;
    @Autowired
    ConnoteRangeMapper connoteRangeMapper;
    @Autowired
    PriceEnquiryMapper priceEnquiryMapper;
    @Autowired
    SystemSettingMapper systemSettingMapper;
    @Autowired
    ShipmentService shipmentService;
    @Autowired
    RemoteChargeRateMapper remoteChargeRateMapper;
    @Autowired
    ApiServiceClient apiServiceClient;

    private boolean isDebug;
    protected String select_service_code = "76";
    protected String collection_suburb = "Bankstown Aerodrome";
    protected String collection_postcode = "2200";
    protected String IM_COMPANY_PHONE = "02-90668200";

    public JsonResultBean courierCheck(int courierId, Shipment shipment, boolean verbose, int orgRateId, int chargecodeId) {
        JsonResultBean response = new JsonResultBean();
        DataBean dataBean = new DataBean();
        response.setData(dataBean);
        Map<String, Object> params = new HashMap<>();

        switch (courierId) {
            case Const.ORGID_COURIER_AUPOST:
                if (shipment.getPkg() > 5) {
                    if (shipment.getAgentId() == Const.ORGID_CLIENT_NINJA && shipment.getPkg() <= 10) {
                        response.setSuccess();
                    } else if (shipment.getAgentId() == Const.ORGID_CLIENT_NINJA && shipment.getPkg() > 10) {
                        params.put("status", 0);
                        params.put("msg", "Auspost does not support more than 5 packages");
                        response.setData(params);
                        response.setError();
                    } else {
                        params.put("status", 0);
                        params.put("msg", "Auspost does not support more than 5 packages");
                        response.setData(params);
                        response.setError();
                    }
                } else {
                    params.put("status", 1);
                    params.put("msg", "Success");
                    response.setData(params);
                    response.setSuccess();
                }
                break;
            case Const.ORGID_COURIER_FASTWAY:
                if (shipment.getPkg() > 1) {
                    params.put("status", 0);
                    params.put("msg", "Fastway does not support multiple packages");
                    response.setData(params);
                    response.setError();
                } else if (!this.weCanDelivery(shipment)) {
                    params.put("status", 0);
                    params.put("msg", "Shipment is not in Fastway delivery area");
                    response.setData(params);
                    response.setError();
                } else {
                    params.put("status", 1);
                    params.put("msg", "Success");
                    response.setData(params);
                    response.setSuccess();
                }
                break;
//            case Const.ORGID_COURIER_TNT:
//            case Const.ORGID_COURIER_TNT_TOP:
//                if (shipment.getMeta()==null||!shipment.getMdata().containsKey("chargecode")|| !"4723".equals(shipment.getMdata().getString("chargecode"))) {
//                    params.put("status", 0);
//                    params.put("msg", "TNT is unavailable now");
//                    response.setData(params);
//                    response.setError();
//                    if(verbose) {
//                        return response;
//                    }
//                    else {
//                        params.put("status", 1);
//                        params.put("msg", "Success");
//                        response.setData(params);
//                        response.setSuccess();
//                        return response;
//                    }
//
//                }
//
//                OrgRate courier = orgRateMapper.selectByPrimaryKey(orgRateId);
//                if (shipment.getMdata()!=null&&shipment.getMdata().containsKey("business_type")) {
//                    String code = courier.getCode();
//                    if (!code.toLowerCase().contains("amazon")) {
//                        if (Const.B2B_TYPE.equals(courier.getMdata().getInteger("business_type")) && shipment.getMdata().containsKey("is_b2b")) {
//                            params.put("status", 0);
//                            params.put("msg", "Shipment is not for TNT B2B");
//                            response.setData(params);
//                            response.setError();
//                            if(verbose) {
//                                return response;
//                            }
//                            else {
//                                params.put("status", 1);
//                                params.put("msg", "Success");
//                                response.setData(params);
//                                response.setSuccess();
//                                return response;
//                            }
//                        }
//                    }
//                }
//
//                TntAPI tnt = TntAPI.getTntInterface("syd");
//                if (checkIfDelivery(shipment.getCnee().getSuburb(), shipment.getCnee().getPostcode(), shipment.getCnee().getAddress(), orgRateId)) {
//                    response.success = false;
//                    response.error.add("Shipment is not in TNT delivery area");
//                }
//
//                if (chargeCodeId != 0) {
//                    int cRemote = checkCanBeDeliveryForRemote(shipment, orgRateId, chargeCodeId);
//                    if (cRemote == 2) {
//                        response.success = false;
//                        response.error.add("Chargecode does not allow remote area");
//                    } else if (cRemote == 3) {
//                        response.success = false;
//                        response.error.add("Chargecode do not set TNT remote area");
//                    }
//                }
//                break;
            case Const.ORGID_COURIER_UBI:
                if (orgRateId>0 && canDeliveryUBI(shipment, orgRateId)){
                    params.put("status", 0);
                    params.put("msg", "shipment is not in "+Const.ORGID_COURIER_UBI+" Courier delivery area");
                    response.setData(params);
                    response.setError();
                }
                if (orgRateId>0 && chargecodeId>0){
                    int cRemote = checkCanBeDeliveryForRemote(shipment,orgRateId,chargecodeId);
                    if (cRemote == 2){
                        params.put("status", 0);
                        params.put("msg", "chargecode do not allow remote area");
                        response.setData(params);
                        response.setError();
                    } else if (cRemote == 3) {
                        params.put("status", 0);
                        params.put("msg", "chargecode do not set "+Const.ORGID_COURIER_UBI+" remote area");
                        response.setData(params);
                        response.setError();
                    }
                }
                if (shipment.getMdata()!=null&&shipment.getMdata().containsKey("wooden_box")){
                    params.put("status", 0);
                    params.put("msg", "Toll does not support wooden box packing");
                    response.setData(params);
                    response.setError();
                }
                if (response.getMsg()==null){
                    params.put("status", 1);
                    params.put("msg", "Success");
                    response.setData(params);
                    response.setSuccess();
                }
                break;
            case Const.ORGID_COURIER_TOLL_IPEC:
                if (canDeliveryToll(shipment,orgRateId)){
                    params.put("status", 0);
                    params.put("msg", "shipment is not in "+Const.ORGID_COURIER_TOLL_IPEC+" Courier delivery area");
                    response.setData(params);
                    response.setError();
                }
                if (orgRateId>0 && chargecodeId>0) {
                    int cRemote = checkCanBeDeliveryForRemote(shipment,orgRateId,chargecodeId);
                    if (cRemote == 2){
                        params.put("status", 0);
                        params.put("msg", "chargecode do not allow remote area");
                        response.setData(params);
                        response.setError();
                    } else if (cRemote == 3) {
                        params.put("status", 0);
                        params.put("msg", "chargecode do not set "+Const.ORGID_COURIER_TOLL_IPEC+" remote area");
                        response.setData(params);
                        response.setError();
                    }
                }
                if (shipment.getMdata()!=null&&shipment.getMdata().containsKey("wooden_box")){
                    params.put("status", 0);
                    params.put("msg", "Toll does not support wooden box packing");
                    response.setData(params);
                    response.setError();
                }
                if (response.getMsg()==null){
                    params.put("status", 1);
                    params.put("msg", "Success");
                    response.setData(params);
                    response.setSuccess();
                }
                break;
            case Const.ORGID_COURIER_TLA:
                if (!canDeliverTLA(shipment, orgRateId) && !canDeliveryHvlvJava(shipment, orgRateId)){
                    params.put("status", 0);
                    params.put("msg", "shipment is not in "+courierId+" Courier delivery area");
                    response.setData(params);
                    response.setError();
                }
                else {
                    params.put("status", 1);
                    params.put("msg", "Success");
                    response.setData(params);
                    response.setSuccess();
                }
                break;
            case Const.ORGID_COURIER_ALLIED_TOP:
                if (shipment.getWeight().compareTo(BigDecimal.ONE)<0){
                    params.put("status", 0);
                    params.put("msg", "To Allied, the weight must be larger than 1KG");
                    response.setData(params);
                    response.setError();
                }else {
                    if (!canDeliveryHvlvJava(shipment, orgRateId)){
                        params.put("status", 0);
                        params.put("msg", "shipment is not in "+courierId+" Courier delivery area");
                        response.setData(params);
                        response.setError();
                    }

                    if (orgRateId>0 && chargecodeId>0){
                        int cRemote = checkCanBeDeliveryForRemote(shipment,orgRateId,chargecodeId);
                        if (cRemote == 2){
                            params.put("status", 0);
                            params.put("msg", "chargecode do not allow remote area");
                            response.setData(params);
                            response.setError();
                        } else if (cRemote == 3) {
                            params.put("status", 0);
                            params.put("msg", "chargecode do not set Allied remote area");
                            response.setData(params);
                            response.setError();
                        }
                    }
                }
                break;
            case Const.ORGID_COURIER_FASTHORSE:
                if (shipment.getPkg()>1){
                    params.put("status", 0);
                    params.put("msg", "Fasthorse not support multiple packages");
                    response.setData(params);
                    response.setError();
                } else if (!fastHorseCanDeliver(shipment, orgRateId)) {
                    params.put("status", 0);
                    params.put("msg", "Fasthorse cannot deliver this package");
                    response.setData(params);
                    response.setError();
                }
                break;
            default:
                if (!canDeliveryHvlvJava(shipment, orgRateId)){
                    params.put("status", 0);
                    params.put("msg", "shipment is not in "+courierId+" Courier delivery area");
                    response.setData(params);
                    response.setError();
                }
                else {
                    params.put("status", 1);
                    params.put("msg", "Success");
                    response.setData(params);
                    response.setSuccess();
                }
                break;
        }

        if (!params.containsKey("status")){
            params.put("status", 1);
            params.put("msg", "Success");
            response.setData(params);
            response.setSuccess();
        }

        if (verbose) {
            return response;
        } else {
            response.setSuccess();
            return response;
        }
    }

    public boolean weCanDelivery(Shipment shipment) {
        if (shipment != null && shipment.getCnee() != null) {
            String postcode = shipment.getCnee().getPostcode();
            // String postcode = shipment.getCnor().getPostcode();
            String suburb = shipment.getCnee().getSuburb();
            if (!postcode.isEmpty() && !suburb.isEmpty()) {
                boolean isInDeliveryArea = isInDeliveryArea(postcode, suburb);
                boolean hasProductCode = getProductCode(postcode, shipment.getWeight().doubleValue()) > 0;
                return isInDeliveryArea && hasProductCode;
            }
        }
        return false; // 处理为空的情况或不在交付区域的情况
    }

    public boolean isInDeliveryArea(String postcode, String suburb) {
        Map<String, Map<String, Object>> fad = loadFastwayAreaData();
        suburb = suburb.toUpperCase();
        return fad.containsKey(postcode) && (suburb.isEmpty() || fad.get(postcode).containsKey(suburb));
    }

    public Map<String, Map<String, Object>> loadFastwayAreaData() {
        String redisKey = "fastwayArea";
        JSONObject jsonObject = redisService.getObject(redisKey);
        if (jsonObject != null) {
            Type type = new TypeToken<Map<String, Map<String, Object>>>() {
            }.getType();
            Map<String, Map<String, Object>> fad = new Gson().fromJson(jsonObject.toString(), type);
            return fad;
        } else {
            String filePath = "data\\fastway_area.json";
            try {
                ClassPathResource resource = new ClassPathResource(filePath);
                byte[] jsonData = FileCopyUtils.copyToByteArray(resource.getInputStream());
                // System.out.println(jsonData);
                String jsonString = new String(jsonData, "UTF-8");
                Gson gson = new Gson();
                Map<String, Map<String, Object>> fad = gson.fromJson(jsonString, new HashMap<String, Map<String, String>>().getClass());
                String fadString = gson.toJson(fad);
                redisService.setKey(redisKey, fadString, 864000);
                return fad;
            } catch (IOException e) {
                e.printStackTrace();
                return new HashMap<>();
            }
        }
    }

    public int getProductCode(String postcode, Double weight) {
        int postcodeInt = 0;
        int count = 0;
        if (!postcode.isEmpty()) {
            postcodeInt = Integer.parseInt(postcode);
            count = zoneMapMapper.countZoneMapByOrgAndZoneFw(postcodeInt);
        } else {
            return -1;
        }
        if (count > 0) {
            return 1;
        } else {
            double[][] weightsCode = {
                    {0, 0.5, 7},
                    {0.5, 1, 6},
                    {1, 2, 16},
                    {2, 3, 5},
                    {3, 5, 4},
                    {5, 10, 17},
                    {10, 20, 18}
            };

            for (double[] code : weightsCode) {
                if (weight > code[0] && weight <= code[1]) {
                    return (int) code[2];
                }
            }
        }
//        if(isDebug==true){
//            log2file("Cannot find Product Type for postcode: "+ postcode + " , weight : " + weight.toString());
//        }
        return -1;
    }

    protected boolean log2file(String message) {
        String logFilePath = "E:\\fastway_api_ErrorLog\\fastway_api" + java.time.LocalDate.now() + ".log";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(logFilePath, true))) {
            writer.write(message);
            writer.newLine();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public HashMap<String, Object> getTntRoutingInfoFromTlaHK(HashMap<String, String> data) {
        HashMap<String, Object> params = new HashMap<>();
        params.put("data", data);

        TlaAPIService tlaApi = new TlaAPIService();
        Map<String, Object> result = tlaApi.doTNTRouting(params);

        if (result.get("status") instanceof Integer && (Integer) result.get("status") == 1) {
            HashMap<String, Object> responseData = (HashMap<String, Object>) result.get("result");
            return responseData;
        } else {
            HashMap<String, Object> response = new HashMap<>();
            response.put("status", false);
            return response;
        }
    }

    public boolean canDeliveryUBI(Shipment shipment, int orgRate) {
        if (shipment.getPkg() > 98) {
            return false;
        }

        OrgRate or = orgRateMapper.selectByPrimaryKey(orgRate);

        double price = 0;
        String postcode = shipment.getCnee().getPostcode();
        // String postcode = shipment.getCnor().getPostcode();
        String suburb = shipment.getCnee().getSuburb();
        BigDecimal weight = shipment.getWeight();

        ZoneMap zoneMap = null;
        ZoneMap hasOne = zoneMapMapper.findZoneMapsByOrgIdAndZoneId(or.getOrgId(), or.getZoneId().intValue());
        if (hasOne != null) {
            zoneMap = zoneMapMapper.findZoneMapsByOrgIdAndZoneIdAndPostcodeAndSuburb(
                    or.getOrgId(), or.getZoneId().intValue(), postcode, suburb);
        } else {
            zoneMap = zoneMapMapper.findZoneMapsByOrgIdAndZoneIdAndPostcode(
                    or.getOrgId(), or.getZoneId().intValue(), postcode);
        }

        String chargeCode = "xxxxxxxxx";
        if (zoneMap != null && zoneMap.getZ1() != null) {
            chargeCode = zoneMap.getZ1();
        }

        List<ZoneRate> zrs = zoneRateMapper.findZoneRatesByWeightAndZoneAndRateId(
                chargeCode, weight, orgRate);

        return !zrs.isEmpty();
    }

    public int checkCanBeDeliveryForRemote(Shipment shipment, int orgRateId, int chargecodeId) {
        ImportChargeCode chargecode = importChargeCodeMapper.selectByPrimaryKey(chargecodeId);
        List<RemoteChargeRate> remoteCostRate1 = remoteChargeRateMapper.findRemoteChargeRateByRateIdAndPostcodeAndSuburb(orgRateId,shipment.getCnee().getPostcode(),shipment.getCnee().getSuburb());

        if (remoteCostRate1.isEmpty()) {
            return 1; // not remote, can be delivery
        }

        // now this is remote, need to check chargecode
        if (chargecode != null && !chargecode.getMdata().containsKey("can_remote")) {
            return 2; // chargecode not allowed
        }

        List<RemoteChargeRate> remoteCostRate2 = remoteChargeRateMapper.findRemoteChargeRateByChargecodeIdAndPostcodeAndSuburb(chargecodeId,shipment.getCnee().getPostcode(),shipment.getCnee().getSuburb());

        if (remoteCostRate2.isEmpty()) {
            return 3; // remote not set chargecode
        }
        return 1;
    }

    public boolean canDeliveryToll(Shipment shipment, int orgRate) {
        if (shipment.getPkg() > 99) {
            return false;
        }
        if (shipment.getPacks() != null) {
            JSONArray packs = shipment.getPacks();
            for (Iterator<Object> obj = packs.iterator(); obj.hasNext();){
                Object item = obj.next();
                if (item instanceof JSONObject) {
                    JSONObject pack = (JSONObject) item;
                    if (pack.getIntValue("length") > 240 || pack.getIntValue("width") > 240 || pack.getIntValue("height") > 240) {
                        return false;
                    }
                }
            }
        }

        OrgRate or = orgRateMapper.selectByPrimaryKey(orgRate);

        double price = 0;
        String postcode = shipment.getCnee().getPostcode();
        String suburb = shipment.getCnee().getSuburb();
        BigDecimal weight = shipment.getWeight();

        ZoneMap zoneMap = zoneMapMapper.findZoneMapsByOrgIdAndZoneIdAndPostcodeAndSuburb(or.getOrgId().intValue(), or.getZoneId().intValue(),postcode, suburb);
        String chargeCode = "xxxxxxxxx";
        if (zoneMap != null && zoneMap.getZ1() != null) {
            chargeCode = zoneMap.getZ1();
        }

        List<ZoneRate> zrs = zoneRateMapper.findZoneRatesByWeightAndZoneAndRateId(
                chargeCode, weight, orgRate);

        return !zrs.isEmpty();
    }

    public boolean canDeliverTLA(Shipment shipment, int orgRateId){
        OrgRate orgRate = orgRateMapper.selectByPrimaryKey(orgRateId);
        return true;
    }

    public boolean canDeliveryHvlvJava(Shipment shipment, int orgRateId) {
        OrgRate or = orgRateMapper.selectByPrimaryKey(orgRateId);
        shipmentService.setupWeights(shipment);

        double price = 0;
        String postcode = shipment.getCnee().getPostcode();
        String suburb = shipment.getCnee().getSuburb();
        BigDecimal weight = shipment.getCourierWeight();

        ZoneMap zoneMap = null;
        ZoneMap hasOne = zoneMapMapper.findZoneMapsByOrgIdAndZoneId(or.getOrgId(), or.getZoneId().intValue());
        if (hasOne != null) {
            zoneMap = zoneMapMapper.findZoneMapsByOrgIdAndZoneIdAndPostcodeAndSuburb(
                    or.getOrgId(), or.getZoneId().intValue(), postcode, suburb);
        } else {
            zoneMap = zoneMapMapper.findZoneMapsByOrgIdAndZoneIdAndPostcode(
                    or.getOrgId(), or.getZoneId().intValue(), postcode);
        }

        String chargeCode = "xxxxxxxxx";
        if (zoneMap != null && zoneMap.getZ1() != null) {
            chargeCode = zoneMap.getZ1();
        }

        List<ZoneRate> zrs = zoneRateMapper.findZoneRatesByWeightAndZoneAndRateId(
                chargeCode, weight, orgRateId);

        return !zrs.isEmpty();
    }

    public Map<String, Object> prepareDataForFasthorse(Shipment shipment, boolean isGen, boolean isCreate,String depot) {
        Map<String, Object> data = new HashMap<>();
        Map<String, Object> shipper = new HashMap<>();
        Map<String, Object> consignee = new HashMap<>();
        Map<String, Object> fromInfo = getFromInfo(depot);



        if (shipment.getCnor()==null || shipment.getCnee()==null){
            shipmentService.setupAllRelations(shipment);
        }
        Addr cnor = shipment.getCnor();
        Addr cnee = shipment.getCnee();

        // 设置 shipper 和 consignee 数据
        if (isCreate) {
            shipper.put("name", cnor.getName());
            shipper.put("address", cnor.getAddress());
            shipper.put("state", cnor.getState());
            shipper.put("city", cnor.getCity());
            shipper.put("suburb", cnor.getSuburb());
            shipper.put("postcode", cnor.getPostcode());
            shipper.put("phone", cnor.getTel());
            shipper.put("email", cnor.getEmail());
        } else {
            shipper.put("name", "Top Logistics Australia");
            shipper.put("company", "Top Logistics Australia");
            shipper.put("address", fromInfo.get("address"));
            shipper.put("state", fromInfo.get("state"));
            shipper.put("city", fromInfo.get("suburb"));
            shipper.put("suburb", fromInfo.get("suburb"));
            shipper.put("postcode", fromInfo.get("postcode"));
            shipper.put("phone", IM_COMPANY_PHONE);
            shipper.put("email", "impors@toplogistics.com.au");
        }

        // 设置 consignee 数据
        consignee.put("name", cnee.getName());
        consignee.put("address", cnee.getAddress());
        consignee.put("state", cnee.getState());
        consignee.put("city", cnee.getCity());
        consignee.put("suburb", cnee.getSuburb());
        consignee.put("postcode", cnee.getPostcode());
        consignee.put("phone", cnee.getTel());
        consignee.put("company", cnee.getCompany());
        consignee.put("email", cnee.getEmail());

        data.put("shipper", shipper);
        data.put("consignee", consignee);
        data.put("packages", shipment.getPacks());
        data.put("cref", shipment.getCref());
        data.put("packs", shipment.getPkg());
        data.put("weight", shipment.getWeight());
        data.put("connote", shipment.getHbn());
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedDate = dateFormat.format(new Date()); // 获取当前日期并将其格式化为字符串
        data.put("date", formattedDate);
        data.put("agent_id", shipment.getAgentId());
        if (shipment.getMdata().get("fast_horse_ref")!=null){
            data.put("fast_horse_ref", shipment.getMdata().get("fast_horse_ref"));
        }
        // 设置其他数据项，类似方式添加到data中

        return data;
    }

    public Map<String, Object> getFromInfo(String type) {
        Map<String, Object> fromInfo = new HashMap<>();

        if (type == null || type.isEmpty() || type.equals("SYD") || type.equals(Const.TLA_DEPARTMENT_SYDNEY)) {
            fromInfo.put("suburb", "BANKSTOWN AERODROME");
            fromInfo.put("postcode", "2200");
            fromInfo.put("address", "1/233 Milperra Rd");
            fromInfo.put("state", "NSW");
        } else if (type.equals("MEL") || type.equals(Const.TLA_DEPARTMENT_MELBOURNE)) {
            fromInfo.put("suburb", "Sunshine");
            fromInfo.put("postcode", "3020");
            fromInfo.put("address", "3B/8 Judge St");
            fromInfo.put("state", "VIC");
        } else if (type.equals("BNE") || type.equals(Const.TLA_DEPARTMENT_BRISBANE)) {
            fromInfo.put("suburb", "Coopers Plains");
            fromInfo.put("postcode", "4108");
            fromInfo.put("address", "6/55 Musgrave Rd");
            fromInfo.put("state", "QLD");
        } else if (type.equals("PER") || type.equals(Const.TLA_DEPARTMENT_PERTH)) {
            fromInfo.put("suburb", "HIGH WYCOMBE");
            fromInfo.put("postcode", "6057");
            fromInfo.put("address", "151 Milner Rd");
            fromInfo.put("state", "WA");
        }

        return fromInfo;
    }

    protected String getRequestUrl(String endpoint, Map<String, Object> params) {

        StringBuilder urlBuilder = new StringBuilder(endpoint);
        if (params != null && !params.isEmpty()) {
            urlBuilder.append("?");

            for (Map.Entry<String, Object> entry : params.entrySet()) {

                String key = entry.getKey();
                Object value = entry.getValue();

                urlBuilder.append(key).append("=").append(value).append("&");
            }
        }

        urlBuilder.append("/").append(endpoint);
        return urlBuilder.toString();
    }

    public boolean fastHorseCanDeliver(Shipment shipment, int orgRateId) {
        if (shipment.getWeight().compareTo(BigDecimal.valueOf(5)) > 0) {
            return false;
        }

        OrgRate orgRate = orgRateMapper.selectByPrimaryKey(orgRateId);
        ZoneMap zoneMap = zoneMapMapper.findZoneMapsByOrgIdAndZoneIdAndPostcode(4987, orgRate.getZoneId().intValue(), shipment.getCnee().getPostcode());

//        if (zoneMap == null) {
//            return false;
//        }

        boolean result = false;
        String firstDigitOfPostcode = "";
        if (!shipment.getCnee().getPostcode().isEmpty()){
            firstDigitOfPostcode = shipment.getCnee().getPostcode().substring(0, 1);
        }
        String depot, prefix;

        switch (firstDigitOfPostcode) {
            case "2":
                depot = "SYD";
                prefix = "T70000";
                break;
            case "3":
                depot = "MEL";
                prefix = "T30000";
                break;
            case "4":
                depot = "BNE";
                prefix = "T40000";
                break;
            case "6":
                depot = "PER";
                prefix = "T60000";
                break;
            default:
                depot = "SYD";
                prefix = "T70000";
        }

        if (shipment.getRef() == null || !shipment.getRef().startsWith(prefix) || shipment.getMdata().get("fast_horse_ref") == null) {
            // Prevent repeat request
            JsonResultBean generateFastHorseRefResponse = createShipment(shipment,depot, "fasthorse", prefix);

            if (generateFastHorseRefResponse.getData() != null) {
                String jsonString = JSON.toJSONString(generateFastHorseRefResponse.getData());
                JSONObject jsonObject = JSON.parseObject(jsonString);
                String ref = jsonObject.getString("ref");
                if (ref != null && !ref.isEmpty()) {
                    JSONObject mdata = shipment.getMdata();
                    mdata.put("fast_horse_ref", ref);
                    shipment.setMdata(mdata);
                }
            }

            JsonResultBean response = manifestShipment(shipment,depot, "fasthorse", prefix);
            System.out.println(response);

            if (response.getData() != null) {
                String jsonString = JSON.toJSONString(response.getData());
                JSONObject jsonObject = JSON.parseObject(jsonString);
                if (jsonObject.get("data") != null ) {
                    String jsonString1 = JSON.toJSONString(jsonObject.get("data"));
                    JSONObject jsonObject1 = JSON.parseObject(jsonString1);
                    if (jsonObject1.get("orderNo") != null){
                        shipment.setRef(jsonObject1.getString("orderNo"));
                        JSONObject mdata = shipment.getMdata();
                        mdata.put("preDeliverWarehouseName", jsonObject1.getString("preDeliverWarehouseName"));
                        shipment.setMdata(mdata);
                        result = true;
                    }
                }
            }
        }

        return result;
    }

    public JsonResultBean createShipment(Shipment shipment,String depot, String courier, String prefix){
        Map<String, Object> params = new HashMap<>();
        Map<String, Object> data = prepareDataForFasthorse(shipment, true, false,depot);
        data.put("courier",courier);
        data.put("type",depot);
        data.put("prefix",prefix);
        // params.put("data",data);
        String jsonString = JSON.toJSONString(data);
        JsonResultBean jsonResultBean = apiServiceClient.createShipment(jsonString);
        return jsonResultBean;
    }

    public JsonResultBean manifestShipment(Shipment shipment,String depot, String courier, String prefix){
        Map<String, Object> params = new HashMap<>();
        Map<String, Object> data = prepareDataForFasthorse(shipment, true, false,depot);
        data.put("courier",courier);
        data.put("type",depot);
        data.put("prefix",prefix);
        // params.put("data",data);
        String jsonString = JSON.toJSONString(data);
        JsonResultBean jsonResultBean = apiServiceClient.manifestShipment(jsonString);
        return jsonResultBean;
    }

}
