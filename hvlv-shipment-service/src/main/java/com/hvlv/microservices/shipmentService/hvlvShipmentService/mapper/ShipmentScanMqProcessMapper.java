package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.ShipmentScanMqProcess;

public interface ShipmentScanMqProcessMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ShipmentScanMqProcess record);

    int insertSelective(ShipmentScanMqProcess record);

    ShipmentScanMqProcess selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ShipmentScanMqProcess record);

    int updateByPrimaryKey(ShipmentScanMqProcess record);
}