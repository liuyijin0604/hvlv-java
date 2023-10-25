package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.Olist;

public interface OlistMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Olist record);

    int insertSelective(Olist record);

    Olist selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Olist record);

    int updateByPrimaryKey(Olist record);
}