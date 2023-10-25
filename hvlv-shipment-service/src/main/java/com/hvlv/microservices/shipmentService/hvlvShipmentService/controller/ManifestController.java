package com.hvlv.microservices.shipmentService.hvlvShipmentService.controller;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.Manifest;
import com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper.ManifestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ManifestController {
    @Autowired
    ManifestMapper manifestMapper;
    @PostMapping("/manifest/insert")
    public int createManifest(@RequestBody Manifest manifest) {
        return manifestMapper.insert(manifest);
    }
}
