package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.ChangeShipmentLabel;

public interface ChangeShipmentLabelMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ChangeShipmentLabel record);

    int insertSelective(ChangeShipmentLabel record);

    ChangeShipmentLabel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ChangeShipmentLabel record);

    int updateByPrimaryKey(ChangeShipmentLabel record);
}