package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.ShipmentQuestion;

public interface ShipmentQuestionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ShipmentQuestion record);

    int insertSelective(ShipmentQuestion record);

    ShipmentQuestion selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ShipmentQuestion record);

    int updateByPrimaryKeyWithBLOBs(ShipmentQuestion record);

    int updateByPrimaryKey(ShipmentQuestion record);
}