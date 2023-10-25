package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.Chargecode;

public interface ChargecodeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Chargecode record);

    int insertSelective(Chargecode record);

    Chargecode selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Chargecode record);

    int updateByPrimaryKey(Chargecode record);
}