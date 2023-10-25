package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.Unloco;

public interface UnlocoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Unloco record);

    int insertSelective(Unloco record);

    Unloco selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Unloco record);

    int updateByPrimaryKey(Unloco record);
}