package com.hvlv.microservices.shipmentService.hvlvShipmentService.controller;


import com.alibaba.fastjson.JSONObject;
import com.hvlv.microservices.shipmentService.hvlvShipmentService.beans.JsonResultBean;
import com.hvlv.microservices.shipmentService.hvlvShipmentService.service.CustomProcessService;
import com.hvlv.microservices.shipmentService.hvlvShipmentService.service.ShipmentScanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomProcessController {

    @Autowired
    Environment environment;

    @Autowired
    CustomProcessService customProcessService;

    @PostMapping("/customProcess/changeShipmentProcessStatus")
    public JsonResultBean changeShipmentProcessStatus(@RequestParam("data") String data)
    {
        JSONObject obj = JSONObject.parseObject(data);
        Integer userId = obj.getInteger("userId");
        Integer shipmentId = obj.getInteger("shipmentId");
        Integer status = obj.getInteger("status");
        JsonResultBean result = customProcessService.changeShipmentProcessStatus(userId,shipmentId,status);
        return result;
    }

}
