package com.hvlv.microservices.shipmentService.hvlvShipmentService.controller;

import com.alibaba.fastjson.JSONObject;
import com.hvlv.microservices.shipmentService.hvlvShipmentService.beans.JsonResultBean;
import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.Shipment;
import com.hvlv.microservices.shipmentService.hvlvShipmentService.service.SystemSettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SystemSettingController {

    @Autowired
    Environment environment;
    @Autowired
    SystemSettingService systemSettingService;

    @PostMapping("/systemsetting/getSetting")
    public JsonResultBean getSetting(@RequestParam("data") String data) {
        JSONObject obj = JSONObject.parseObject(data);
        String key1 = obj.getString("key1");
        String key2 = obj.getString("key2");
        JsonResultBean result = systemSettingService.getSetting(key1,key2);
        return result;
    }
}



