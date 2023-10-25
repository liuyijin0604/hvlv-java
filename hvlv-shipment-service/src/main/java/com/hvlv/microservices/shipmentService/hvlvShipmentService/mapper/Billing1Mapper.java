package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.Billing1;

public interface Billing1Mapper {
    int insert(Billing1 record);

    int insertSelective(Billing1 record);
}