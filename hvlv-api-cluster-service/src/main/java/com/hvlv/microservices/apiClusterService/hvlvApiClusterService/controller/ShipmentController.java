package com.hvlv.microservices.shipmentClusterService.hvlvShipmentClusterService.controller;

import com.alibaba.fastjson.JSONObject;
import com.hvlv.microservices.shipmentClusterService.hvlvShipmentClusterService.beans.JsonResultBean;
import com.hvlv.microservices.shipmentClusterService.hvlvShipmentClusterService.client.ShipmentScanClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ShipmentController {

    @Autowired
    ShipmentScanClient shipmentScanClient;

    @PostMapping("/shipment/scan")
    public JsonResultBean scanShipment(@RequestParam("data") String data)
    {
        JsonResultBean result = shipmentScanClient.scanShipment(data);

        return result;
    }

    @PostMapping("/shipment/recognize")
    public JsonResultBean recognize(@RequestParam("data") String data)
    {
        JsonResultBean result = shipmentScanClient.recognize(data);

        return result;
    }
}
