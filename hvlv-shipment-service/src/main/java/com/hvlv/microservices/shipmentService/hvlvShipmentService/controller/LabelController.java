package com.hvlv.microservices.shipmentService.hvlvShipmentService.controller;


import com.alibaba.fastjson.JSONObject;
import com.hvlv.microservices.shipmentService.hvlvShipmentService.beans.JsonResultBean;
import com.hvlv.microservices.shipmentService.hvlvShipmentService.service.LabelService;
import com.hvlv.microservices.shipmentService.hvlvShipmentService.service.ShipmentScanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LabelController {

    @Autowired
    Environment environment;

    @Autowired
    LabelService labelService;

    @PostMapping("/label/generateRefByPrefix")
    public JsonResultBean generateRefByPrefix(@RequestParam("data") String data)
    {
        JSONObject obj = JSONObject.parseObject(data);
        String prefix = obj.getString("prefix");
        Integer orgId = obj.getInteger("orgId");
        JsonResultBean result = labelService.generateRefByPrefix(prefix,orgId);

        return result;
    }
}
