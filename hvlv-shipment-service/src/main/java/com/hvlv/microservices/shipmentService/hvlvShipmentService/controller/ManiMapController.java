package com.hvlv.microservices.shipmentService.hvlvShipmentService.controller;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.ManiMap;
import com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper.ManiMapMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ManiMapController {
    @Autowired
    ManiMapMapper maniMapMapper;
    @PostMapping("/manimap/insert")
    public int insert(@RequestBody ManiMap manimap) {
        return maniMapMapper.insert(manimap);
    }
}
