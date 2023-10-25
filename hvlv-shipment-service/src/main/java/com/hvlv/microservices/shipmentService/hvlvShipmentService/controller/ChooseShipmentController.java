package com.hvlv.microservices.shipmentService.hvlvShipmentService.controller;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.hvlv.microservices.shipmentService.hvlvShipmentService.beans.AddrBean;
import com.hvlv.microservices.shipmentService.hvlvShipmentService.beans.JsonResultBean;
import com.hvlv.microservices.shipmentService.hvlvShipmentService.beans.ShipmentBean;
import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.Shipment;
import com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper.ShipmentMapper;
import com.hvlv.microservices.shipmentService.hvlvShipmentService.service.ChooseShipmentService;
import com.hvlv.microservices.shipmentService.hvlvShipmentService.service.ShipmentPriceService;
import com.hvlv.microservices.shipmentService.hvlvShipmentService.service.CourierCanDeliveryService;
import com.hvlv.microservices.shipmentService.hvlvShipmentService.service.ShipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ChooseShipmentController {
    @Autowired
    Environment environment;

    @Autowired
    ChooseShipmentService chooseShipmentService;

    @Autowired
    ShipmentPriceService shipmentPriceService;

    @Autowired
    CourierCanDeliveryService courierCanDeliveryService;

    @Autowired
    ShipmentMapper shipmentMapper;

    @Autowired
    ShipmentService shipmentService;

    @PostMapping("/chooseShipment/packagesCheck")
    public JsonResultBean packagesCheck()
    {
        ShipmentBean shipment = new ShipmentBean();
        shipment.setCref("ACWL23011100110");
        shipment.setWeight(200.0);
        shipment.setCbm(0.112500);
        shipment.setPacks(2);
        String jsonString = "[{\"weight\":\"50.100\",\"length\":\"90.000\",\"height\":\"110.000\",\"width\":\"100.000\",\"reference\":0,\"cbm\":\"0.112500\"},{\"weight\":\"50.100\",\"length\":\"90.000\",\"height\":\"110.000\",\"width\":\"100.000\",\"reference\":0,\"cbm\":\"0.112500\"}]";
        JSONArray jsonArray = JSONArray.parseArray(jsonString);
        shipment.setPackages(jsonArray);
        JsonResultBean result = chooseShipmentService.packagesCheck(shipment);
        return result;
    }

    @PostMapping("/chooseShipment/addressesCheck")
    public JsonResultBean addressesCheck()
    {
        AddrBean cnee1 = new AddrBean();
        cnee1.setCref("SKP3103013095");
        cnee1.setAddress("1/134 Quarry Rd");
        cnee1.setSuburb("DANDENONG SOUTH");
        cnee1.setState("NSW");
        cnee1.setPostcode("3175");
        cnee1.setName("zhangsan");
        cnee1.setCity("sydney");
        cnee1.setTel("0418419737");
        cnee1.setEmail("zuzuabrim81@hotmail.com");
        AddrBean cnee2 = new AddrBean();
        cnee2.setCref("SKP3103013095");
        cnee2.setAddress("1/134 Quarry Rd");
        cnee2.setSuburb("DANDENONG SOUTH");
        cnee2.setPostcode("3175");
        cnee2.setName("zhangsan");
        cnee2.setCity("sydney");
        cnee2.setTel("0418419737");
        cnee2.setEmail("zuzuabrim81@hotmail.com");
        cnee2.setState("NSW");
        AddrBean cnee3 = new AddrBean();
        cnee3.setCref("SKP3103013095");
        cnee3.setAddress("QuarryRd");
        cnee3.setSuburb("DANDENONG SOUTH");
        cnee3.setPostcode("3175");
        cnee3.setCity("sydney");
        cnee3.setTel("0418419737");
        cnee3.setEmail("zuzuabrim81@hotmail.com");
        cnee3.setState("NSW");
        cnee3.setName("张三");
        String chargecode ="9427";
        JsonResultBean result = chooseShipmentService.addressesCheck(cnee1,cnee2,cnee3,chargecode);
        return result;
    }

    @PostMapping("/chooseShipment/itemsCheck")
    public JsonResultBean itemsCheck()
    {
        Map<String, Object> item1 = new HashMap<>();
        item1.put("name", "Product A");
        item1.put("qty", "3");
        item1.put("price", "10.50");

        Map<String, Object> item2 = new HashMap<>();
        item2.put("name", "Product B");
        item2.put("qty", "2");
        item2.put("price", "3.50");

        List<Map<String, Object>> items = new ArrayList<>();
        items.add(item1);
        items.add(item2);
        JsonResultBean result = chooseShipmentService.itemCheck(items);
        return result;
    }


    @PostMapping("/chooseShipment/getCourierCostPrice")
    public JsonResultBean getCourierCostPrice(@RequestParam("data") String data) throws JsonProcessingException {

        JSONObject jsonObject = JSONObject.parseObject(data);
        Integer orgId = jsonObject.getInteger("orgId");
        String chargeCode = jsonObject.getString("chargeCode");
        boolean getZoneRate = jsonObject.getBoolean("getZoneRate");
        Integer shipmentId = jsonObject.getInteger("shipmentId");

        return shipmentPriceService.getCourierCostPrice(orgId, chargeCode, getZoneRate, shipmentId);
    }


    @PostMapping("/chooseShipment/courierCanDelivery")
    public JsonResultBean courierCanDelivery(@RequestParam("data") String data)
    {
        JSONObject obj = JSONObject.parseObject(data);
        Shipment shipment = null;

        int courierid = 0;
        int orgRateId = 0;
        int chargecodeId = 0;
        int shipmentId = 0;
        String shipmentHbn = null;
        if (obj.containsKey("courierid") && obj.get("courierid")!= null){
            courierid = obj.getIntValue("courierid");
        }
        if (obj.containsKey("orgRateId") && obj.get("orgRateId")!= null) {
            orgRateId = obj.getIntValue("orgRateId");
        }
        if (obj.containsKey("chargecodeId") && obj.get("chargecodeId")!= null) {
            chargecodeId = obj.getIntValue("chargecodeId");
        }

        if (obj.containsKey("shipmentId") && obj.get("shipmentId")!= null) {
            shipmentId = obj.getIntValue("shipmentId");
            shipment = shipmentMapper.findImparcelById(shipmentId);
        }
        else if (obj.containsKey("shipmentHbn") && obj.get("shipmentHbn")!= null) {
            shipmentHbn = obj.getString("shipmentHbn");
            shipment = shipmentMapper.findShipmentForShipmentRecognition(shipmentHbn);
            System.out.println(shipment.getId());
        }
        shipmentService.setupAllRelations(shipment);

        JsonResultBean result = courierCanDeliveryService.courierCheck(courierid,shipment,true,orgRateId,chargecodeId);
        return result;
    }

}
