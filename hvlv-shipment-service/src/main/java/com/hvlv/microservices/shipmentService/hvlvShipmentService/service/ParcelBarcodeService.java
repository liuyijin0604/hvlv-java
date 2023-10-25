package com.hvlv.microservices.shipmentService.hvlvShipmentService.service;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.ParcelBarcode;
import com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper.ParcelBarcodeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParcelBarcodeService {
    @Autowired
    RedisService redisService;
    @Autowired
    ParcelBarcodeMapper parcelBarcodeMapper;

    public ParcelBarcode getParcelBarcode(String data){
        return  parcelBarcodeMapper.findByBarcode(data);
    }
}
