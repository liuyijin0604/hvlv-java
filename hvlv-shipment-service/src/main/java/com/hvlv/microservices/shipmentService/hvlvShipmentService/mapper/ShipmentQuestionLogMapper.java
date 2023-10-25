package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.ShipmentQuestionLog;

public interface ShipmentQuestionLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ShipmentQuestionLog record);

    int insertSelective(ShipmentQuestionLog record);

    ShipmentQuestionLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ShipmentQuestionLog record);

    int updateByPrimaryKey(ShipmentQuestionLog record);
}