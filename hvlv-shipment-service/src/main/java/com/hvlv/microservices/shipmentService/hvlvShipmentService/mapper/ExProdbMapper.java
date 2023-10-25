package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.ExProdb;

public interface ExProdbMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ExProdb record);

    int insertSelective(ExProdb record);

    ExProdb selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ExProdb record);

    int updateByPrimaryKeyWithBLOBs(ExProdb record);

    int updateByPrimaryKey(ExProdb record);
}