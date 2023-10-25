package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.ParcelPriority;

public interface ParcelPriorityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ParcelPriority record);

    int insertSelective(ParcelPriority record);

    ParcelPriority selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ParcelPriority record);

    int updateByPrimaryKey(ParcelPriority record);
}