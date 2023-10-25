package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.ImportsRefPool;

public interface ImportsRefPoolMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ImportsRefPool record);

    int insertSelective(ImportsRefPool record);

    ImportsRefPool selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ImportsRefPool record);

    int updateByPrimaryKey(ImportsRefPool record);
}