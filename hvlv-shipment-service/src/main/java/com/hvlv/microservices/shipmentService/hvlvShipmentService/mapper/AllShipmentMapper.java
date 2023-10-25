package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.AllShipment;

public interface AllShipmentMapper {
    int insert(AllShipment record);

    int insertSelective(AllShipment record);
}