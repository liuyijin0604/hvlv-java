package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.ShipmentUpdate;

public interface ShipmentUpdateMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ShipmentUpdate record);

    int insertSelective(ShipmentUpdate record);

    ShipmentUpdate selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ShipmentUpdate record);

    int updateByPrimaryKey(ShipmentUpdate record);
}