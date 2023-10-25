package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.ChargeItemType;

public interface ChargeItemTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ChargeItemType record);

    int insertSelective(ChargeItemType record);

    ChargeItemType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ChargeItemType record);

    int updateByPrimaryKey(ChargeItemType record);
}