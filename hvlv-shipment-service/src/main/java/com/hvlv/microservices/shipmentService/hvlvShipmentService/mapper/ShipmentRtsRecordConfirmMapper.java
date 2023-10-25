package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.ShipmentRtsRecordConfirm;

public interface ShipmentRtsRecordConfirmMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ShipmentRtsRecordConfirm record);

    int insertSelective(ShipmentRtsRecordConfirm record);

    ShipmentRtsRecordConfirm selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ShipmentRtsRecordConfirm record);

    int updateByPrimaryKey(ShipmentRtsRecordConfirm record);
}