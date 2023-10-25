package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.ShipmentScanProcess;

public interface ShipmentScanProcessMapper {
    int deleteByPrimaryKey(Integer shipmentScanId);

    int insert(ShipmentScanProcess record);

    int insertSelective(ShipmentScanProcess record);

    ShipmentScanProcess selectByPrimaryKey(Integer shipmentScanId);

    int updateByPrimaryKeySelective(ShipmentScanProcess record);

    int updateByPrimaryKey(ShipmentScanProcess record);
}