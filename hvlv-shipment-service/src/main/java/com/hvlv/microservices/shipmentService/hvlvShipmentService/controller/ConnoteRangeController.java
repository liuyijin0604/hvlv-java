package com.hvlv.microservices.shipmentService.hvlvShipmentService.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hvlv.microservices.shipmentService.hvlvShipmentService.beans.JsonResultBean;
import com.hvlv.microservices.shipmentService.hvlvShipmentService.beans.ShipmentBean;
import com.hvlv.microservices.shipmentService.hvlvShipmentService.service.ConnoteRangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ConnoteRangeController{
    @Autowired
    Environment environment;
    @Autowired
    ConnoteRangeService connoteRangeService;

    @PostMapping("/connoteRang/checkReserved")
    public JsonResultBean checkReserved()
    {
        ShipmentBean shipment = new ShipmentBean();
        shipment.setAgent_id(4699);
        shipment.setNo("MS8001527465");
        shipment.setHbn("SKP3103013095");
        JsonResultBean result = connoteRangeService.checkReserved(shipment);
        return result;
    }

    @PostMapping("/connoteRang/checkPENumberCanUse")
    public JsonResultBean checkPENumberCanUse()
    {
        ShipmentBean shipment = new ShipmentBean();
        JSONObject meta = new JSONObject();
        meta.put("pe_number", "PE00000001");
        shipment.setMeta(meta);
        shipment.setAddress("286 Burwood Rd");
        shipment.setWeight(340.0);
        JSONArray packs = new JSONArray();
        String jsonString = "[{\"weight\":\"50.100\",\"length\":\"90.000\",\"height\":\"110.000\",\"width\":\"100.000\",\"reference\":0,\"cbm\":\"0.112500\"},{\"weight\":\"50.100\",\"length\":\"90.000\",\"height\":\"110.000\",\"width\":\"100.000\",\"reference\":0,\"cbm\":\"0.112500\"},{\"weight\":\"50.100\",\"length\":\"90.000\",\"height\":\"110.000\",\"width\":\"100.000\",\"reference\":0,\"cbm\":\"0.112500\"},{\"weight\":\"80.100\",\"length\":\"170.000\",\"height\":\"100.000\",\"width\":\"100.000\",\"reference\":0,\"cbm\":\"0.112500\"},{\"weight\":\"50.100\",\"length\":\"90.000\",\"height\":\"110.000\",\"width\":\"100.000\",\"reference\":0,\"cbm\":\"0.112500\"},{\"weight\":\"50.100\",\"length\":\"90.000\",\"height\":\"110.000\",\"width\":\"100.000\",\"reference\":0,\"cbm\":\"0.112500\"},{\"weight\":\"80.100\",\"length\":\"170.000\",\"height\":\"100.000\",\"width\":\"100.000\",\"reference\":0,\"cbm\":\"0.112500\"},{\"weight\":\"50.100\",\"length\":\"90.000\",\"height\":\"110.000\",\"width\":\"100.000\",\"reference\":0,\"cbm\":\"0.112500\"},{\"weight\":\"50.100\",\"length\":\"90.000\",\"height\":\"110.000\",\"width\":\"100.000\",\"reference\":0,\"cbm\":\"0.112500\"},{\"weight\":\"80.100\",\"length\":\"170.000\",\"height\":\"100.000\",\"width\":\"100.000\",\"reference\":0,\"cbm\":\"0.112500\"}]";
        JSONArray jsonArray = JSONArray.parseArray(jsonString);
        shipment.setPackages(jsonArray);
        int courier = 114;
        JsonResultBean result = connoteRangeService.checkPENumberCanUse(shipment,courier);
        return result;
    }

}
