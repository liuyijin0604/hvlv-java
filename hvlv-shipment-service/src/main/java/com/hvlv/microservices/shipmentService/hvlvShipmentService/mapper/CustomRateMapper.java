package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.CustomRate;

public interface CustomRateMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CustomRate record);

    int insertSelective(CustomRate record);

    CustomRate selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CustomRate record);

    int updateByPrimaryKeyWithBLOBs(CustomRate record);

    int updateByPrimaryKey(CustomRate record);
}