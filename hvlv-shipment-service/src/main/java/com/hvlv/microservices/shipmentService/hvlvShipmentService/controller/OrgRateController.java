package com.hvlv.microservices.shipmentService.hvlvShipmentService.controller;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.OrgRate;
import com.hvlv.microservices.shipmentService.hvlvShipmentService.service.OrgRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrgRateController {
    @Autowired
    Environment environment;
    @Autowired
    OrgRateService orgRateService;

    @PostMapping("/orgRate/getOrgRate")
    public OrgRate getOrgRate(@RequestParam("data") Integer data) {
        return orgRateService.getOrgRate(data);
    }
}
