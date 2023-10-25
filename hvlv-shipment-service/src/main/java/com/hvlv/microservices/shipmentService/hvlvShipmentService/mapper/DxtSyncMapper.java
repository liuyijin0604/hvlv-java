package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.DxtSync;

public interface DxtSyncMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DxtSync record);

    int insertSelective(DxtSync record);

    DxtSync selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DxtSync record);

    int updateByPrimaryKey(DxtSync record);
}