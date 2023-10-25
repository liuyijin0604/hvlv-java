package com.hvlv.microservices.shipmentService.hvlvShipmentService.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hvlv.microservices.shipmentService.hvlvShipmentService.beans.*;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.*;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.Currency;
import com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper.ImportChargeCodeMapper;
import com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper.AddrMapper;
import com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper.OrgRateMapper;
import com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper.ZoneRateMapper;
import com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper.ZoneMapMapper;
import com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper.CurrencyMapper;
import com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper.ShipmentMapper;
import com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper.ConnoteRangeMapper;
import com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper.PriceEnquiryMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.stream.Collectors;

import static java.lang.Math.ceil;

@Service
public class ImportChargecodeService extends HvlvService{

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

      public JsonResultBean hasChargeSetUp(ShipmentBean shipment, String chargeCode, AddrBean cnee)
      {
              JsonResultBean result = new JsonResultBean();
              DataBean dataBean = new DataBean();
              result.setData(dataBean);
              result.setSuccess();

          ImportChargeCode importChargeCode = importChargeCodeMapper.findByChargeCode(chargeCode);

          if (importChargeCode == null)
          {
              dataBean.setMsg("[60005] - "+ "Invalid charge code : " + chargeCode);
              dataBean.setStatus(0);
              return result;
          }

              if(shipment.getMdata()!=null&&shipment.getMdata().containsKey("pe_number")){
                  dataBean.setStatus(1);
                  return result;
              }

              boolean isCBM = importChargeCode.getMeta()!=null && importChargeCode.getMeta().contains("calculate_cbm");
              double chargeWeight = importChargeCode.getChargeWt()!= 0? shipment.getCharge_wt():shipment.getWeight();
              String ChargeLabel ="weight";

              if(isCBM){
                  chargeWeight = importChargeCode.getChargeWt()!=0? shipment.getCharge_cbm(): shipment.getCbm();
                  ChargeLabel ="CBM";
              }
              String code ="";

              String couriersStr = importChargeCode.getCouriers();
              couriersStr = couriersStr.replaceAll("\"", "");
              JSONArray couriersArray = JSONArray.parseArray(couriersStr);
              List<Integer> courierLists = new ArrayList<>();
              for (int i = 0; i < couriersArray.size(); i++) {
                  String courierIdStr = couriersArray.getString(i);
                  Integer courierId = Integer.parseInt(courierIdStr);
                  courierLists.add(courierId);
              }

              if(courierLists !=null && courierLists.size()==1)
              {
                Integer courierId = courierLists.get(0);
                String courierCode = orgRateMapper.selectCodeByCourierId(courierId);
                code = courierCode;
              }
              //for international
              if(code.equals(ImportChargeCodeBean.AUPOST_INTERNATIONAL_CODE))
              {
                String country = cnee.getCountry();
                JsonResultBean intzonejson = systemSettingService.getKeySetting("INTZONE");
                DataBean intzonejsonData = (DataBean) intzonejson.getData();
                JSONObject intZoneData = (JSONObject) intzonejsonData.getData();
                if (intZoneData != null && intZoneData.containsKey(country))
                {
                  double theWeight = chargeWeight;
                  String zone = intZoneData.getString(country);
                  List<ZoneRate> zoneRates = zoneRateMapper.findZoneRates(importChargeCode.getId(), BigDecimal.valueOf(ceil(theWeight * 10) / 10),zone);
                    if (!zoneRates.isEmpty()) {
                        dataBean.setStatus(0);
                        return result;
                    }
                    dataBean.setStatus(0);
                    dataBean.setMsg( "with Weight: " + shipment.getWeight() + "kg, CBM: " + shipment.getPkg() + " &times; " + shipment.getCbm() + "M<sup>3</sup>, Chargeble " + ChargeLabel + ": " + chargeWeight + "kg not in the Chargecode: " + importChargeCode.getChargecode() + " weight Range!");
                    return result;
                    } else {
                    String cneePostcode = cnee.getPostcode();
                    dataBean.setStatus(0);
                    dataBean.setMsg("with postcode: " + cneePostcode + " Not in the international Chargecode: " + importChargeCode.getChargecode() + " delivery Zone!");
                    return result;
                }
              }


              String cneePostcodeStr =cnee.getPostcode();
              int cneePostcode = Integer.parseInt(cneePostcodeStr);
              List<ZoneMap> zoneMaps = zoneMapMapper.findZoneMapsByChargecodeIdAndPostcode(importChargeCode.getId(),cneePostcode);
              if (!zoneMaps.isEmpty()) {
                  for(ZoneMap zoneMap : zoneMaps){
                      BigDecimal theWeight = BigDecimal.valueOf(chargeWeight);

                      String mdataString =importChargeCode.getMeta();
                      JSONObject mdata = JSONObject.parseObject(mdataString);
                      Object eparcelSingleValue = mdata.get("eparcel_single");
                      Integer eparcelSingleInt = (Integer) eparcelSingleValue;
                      if ((mdata.containsKey("eparcel_single") && eparcelSingleInt.equals(0)) || (eparcelSingleInt == null && shipment.getPkg() > 1)) {
                          if (courierLists.contains(Org.ORGID_COURIER_AUPOST)) {
                              BigDecimal maxWeight = zoneRateMapper.selectMaxWeightHiByChargecodeIdAndZone(importChargeCode.getId(), zoneMap.getZ1());
                              if (maxWeight.compareTo(new BigDecimal(100)) < 0) {
                                  theWeight = BigDecimal.valueOf(chargeWeight).divide(new BigDecimal(shipment.getPkg()), 10, RoundingMode.CEILING);
                              }
                          }
                      }
                      List<ZoneRate> zoneRates = zoneRateMapper.findZoneRates(importChargeCode.getId(), theWeight.setScale(1, RoundingMode.CEILING), zoneMap.getZ1());
                      if (!zoneRates.isEmpty()) {
                          dataBean.setStatus(1);
                          return result;
                      }
                      dataBean.setStatus(0);
                      dataBean.setMsg("with Weight: " + shipment.getWeight() + "kg, CBM: " + shipment.getPkg() + " × " + shipment.getCbm() + "M³, Chargeble " + ChargeLabel + ": " + chargeWeight + "kg not in the Chargecode: " + importChargeCode.getChargecode() + " weight Range!");
                      return result;
                  }
              }else {
                  dataBean.setStatus(0);
                  dataBean.setMsg("with postcode: " + cneePostcode + " Not in the Chargecode: " + importChargeCode.getChargecode() + " delivery Zone!");
                  return result;
              }
          dataBean.setStatus(1);
          return result;
      }

    public JsonResultBean checkChargecodeCanDeliveryservice(ShipmentBean shipment, String chargeCode, AddrBean cnee)
    {
        JsonResultBean result = new JsonResultBean();
        DataBean dataBean = new DataBean();
        result.setData(dataBean);
        result.setSuccess();

        ImportChargeCode chargeCodeInfo = importChargeCodeMapper.findByChargeCode(chargeCode);

        if (chargeCodeInfo == null)
        {
            dataBean.setMsg("[60005] - "+ "Invalid charge code : " + chargeCode);
            dataBean.setStatus(0);
            return result;
        }

        if (chargeCodeInfo.getStatus() != 1)
        {
            dataBean.setMsg("[40001] - Chargecode : " + chargeCode+ " has been disabled");
            dataBean.setStatus(0);
            return result;
        }

        if (chargeCode == "3600") {
            String data = "";
            int type = 2;
            Currency r= currencyMapper.getExrate(data,type);
            double extrate;
            if(r==null){
                 extrate = 0.66;
            }else{
                extrate = Double.parseDouble(r.getCurrency());
            }

            if ((shipment.getCurrency() == 1 && shipment.getDvalue().compareTo(BigDecimal.valueOf(1000)) >= 0) ||
                    (shipment.getCurrency() != 1 && shipment.getDvalue().compareTo(BigDecimal.valueOf(1000* extrate)) >= 0))
            {
                dataBean.setMsg("[90005] - Shipment " + shipment.getCref() + " value is Over AUD $1000");
                dataBean.setStatus(0);
                return result;
            }
        }

        JsonResultBean chargeCodeSetUp = hasChargeSetUp(shipment,chargeCode,cnee);
        DataBean chargeCodeSetUpData = (DataBean) chargeCodeSetUp.getData();
        int ifSetUp= chargeCodeSetUpData.getStatus();
        if (ifSetUp==0) {

            dataBean.setMsg("[90010] - Shipment " + chargeCodeSetUpData.getMsg());
            dataBean.setStatus(0);
            return result;
        }

        String couriersStr = chargeCodeInfo.getCouriers();
        couriersStr = couriersStr.replaceAll("\"", "");
        JSONArray couriersArray = JSONArray.parseArray(couriersStr);
        List<Integer> courierLists = new ArrayList<>();
        for (int i = 0; i < couriersArray.size(); i++) {
            String courierIdStr = couriersArray.getString(i);
            Integer courierId = Integer.parseInt(courierIdStr);
            courierLists.add(courierId);
        }

        if (!chargeCodeInfo.getMeta().isEmpty()&&chargeCodeInfo.getMeta().contains("no_courier") && courierLists.size() == 0) {
            String no_courierStr = "{\"no_courier\": \"true\"}";
            JSONObject no_courierJson = JSONObject.parseObject(no_courierStr);
            dataBean.setData(no_courierJson);
            if (shipment.getHbn() == null) {
                dataBean.setMsg("[90009] - Please supply the connote no for this custom only service");
                dataBean.setStatus(0);
                return result;
            }
        }
        dataBean.setStatus(1);
        return result;
    }

    public JsonResultBean checkPoboxAddressDelivebilityservice(String chargeCode, AddrBean cnee)
    {
        JsonResultBean result = new JsonResultBean();
        DataBean dataBean = new DataBean();
        result.setData(dataBean);
        result.setSuccess();

        boolean poboxerror = false;
        ImportChargeCode chargeCodeInfo = importChargeCodeMapper.findByChargeCode(chargeCode);

        if (chargeCodeInfo == null)
        {
            dataBean.setMsg("[60005] - "+ "Invalid charge code : " + chargeCode);
            dataBean.setStatus(0);
            return result;
        }

        String address = cnee.getAddress();
        JsonResultBean addrcheck =addrService.checkIsPoBox(address);
        DataBean addrcheckData = (DataBean)addrcheck.getData();
        int isAddr = addrcheckData.getStatus();

        if (isAddr == 1) {
            String couriersStr = chargeCodeInfo.getCouriers();
            couriersStr = couriersStr.replaceAll("\"", "");
            JSONArray couriersArray = JSONArray.parseArray(couriersStr);
            List<Integer> courierLists = new ArrayList<>();
            for (int i = 0; i < couriersArray.size(); i++) {
                String courierIdStr = couriersArray.getString(i);
                Integer courierId = Integer.parseInt(courierIdStr);
                courierLists.add(courierId);
            }

            poboxerror = false;
            for (int i = 0; i < courierLists.size(); i++) {
                Integer courier = courierLists.get(i);
                OrgRate thisCourier = orgRateMapper.selectByPrimaryKey(courier);
                if (!ImportChargeCode.AUPOST_CODES.contains(thisCourier.getCode())) {
                    poboxerror = true;
                }
            }
        }

        if (chargeCodeInfo.getCouriers().isEmpty()) {
            String errorMsg = poboxerror ? "[60001] - Po Box not supported" : "[60004] - Charge code : " + chargeCode + " has no courier set";
            dataBean.setMsg(errorMsg);
            dataBean.setStatus(0);
            return result;
        }
        dataBean.setStatus(1);
        return result;
    }

}
