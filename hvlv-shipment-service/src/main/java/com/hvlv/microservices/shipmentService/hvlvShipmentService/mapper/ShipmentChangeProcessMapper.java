package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.ShipmentChangeProcess;

public interface ShipmentChangeProcessMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ShipmentChangeProcess record);

    int insertSelective(ShipmentChangeProcess record);

    ShipmentChangeProcess selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ShipmentChangeProcess record);

    int updateByPrimaryKeyWithBLOBs(ShipmentChangeProcess record);

    int updateByPrimaryKey(ShipmentChangeProcess record);
}