package com.hvlv.microservices.shipmentService.hvlvShipmentService.controller;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.OrgRate;
import com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper.ZoneMapMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ZoneMapController {
    @Autowired
    ZoneMapMapper zoneMapMapper;
    @PostMapping("/zoneMap/getZoneMapFw")
    public int getZoneMapFw(@RequestParam("data") Integer data) {
        return zoneMapMapper.countZoneMapByOrgAndZoneFw(data);
    }
}