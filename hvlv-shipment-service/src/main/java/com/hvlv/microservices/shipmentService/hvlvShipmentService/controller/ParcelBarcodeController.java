package com.hvlv.microservices.shipmentService.hvlvShipmentService.controller;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.ParcelBarcode;
import com.hvlv.microservices.shipmentService.hvlvShipmentService.service.ParcelBarcodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ParcelBarcodeController {
    @Autowired
    Environment environment;
    @Autowired
    ParcelBarcodeService parcelBarcodeService;
    @PostMapping("/parcelBarcode/getParcelBarcode")
    public ParcelBarcode getParcelBarcode(@RequestParam("data") String data) {
        return parcelBarcodeService.getParcelBarcode(data);
    }
}
