package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.ShipmentQuestionSubmit;

public interface ShipmentQuestionSubmitMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ShipmentQuestionSubmit record);

    int insertSelective(ShipmentQuestionSubmit record);

    ShipmentQuestionSubmit selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ShipmentQuestionSubmit record);

    int updateByPrimaryKeyWithBLOBs(ShipmentQuestionSubmit record);

    int updateByPrimaryKey(ShipmentQuestionSubmit record);
}