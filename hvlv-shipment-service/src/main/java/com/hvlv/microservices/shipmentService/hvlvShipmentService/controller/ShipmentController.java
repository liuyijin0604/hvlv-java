package com.hvlv.microservices.shipmentService.hvlvShipmentService.controller;

import com.alibaba.fastjson.JSONObject;
import com.hvlv.microservices.shipmentService.hvlvShipmentService.beans.JsonResultBean;
import com.hvlv.microservices.shipmentService.hvlvShipmentService.service.ShipmentScanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

@RestController
public class ShipmentController {

    @Autowired
    Environment environment;

    @Autowired
    ShipmentScanService shipmentScanService;

    @PostMapping("/shipment/scan")
    public JsonResultBean scanShipment(@RequestParam("data") String data)
    {
        JSONObject obj = JSONObject.parseObject(data);
        Integer userId = obj.getInteger("userId");
        String barcode = obj.getString("barcode");
        Integer type = obj.getInteger("type");
        Integer warehouse = obj.getInteger("warehouse");
        JsonResultBean result = shipmentScanService.scanShipment(userId,barcode,type,warehouse);
        return result;
    }

    @PostMapping("/shipment/recognize")
    public JsonResultBean recognize(@RequestParam("data") String data)
    {
        JSONObject obj = JSONObject.parseObject(data);
        String barcode = obj.getString("barcode");
        JsonResultBean result = shipmentScanService.recognize(barcode);
        return result;
    }
}
