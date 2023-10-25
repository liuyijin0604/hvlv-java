package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.ShipmentRtsRecord;

public interface ShipmentRtsRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ShipmentRtsRecord record);

    int insertSelective(ShipmentRtsRecord record);

    ShipmentRtsRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ShipmentRtsRecord record);

    int updateByPrimaryKey(ShipmentRtsRecord record);
}