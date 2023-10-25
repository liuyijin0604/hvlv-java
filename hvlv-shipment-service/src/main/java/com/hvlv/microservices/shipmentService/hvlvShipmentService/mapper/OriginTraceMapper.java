package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.OriginTrace;

public interface OriginTraceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OriginTrace record);

    int insertSelective(OriginTrace record);

    OriginTrace selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OriginTrace record);

    int updateByPrimaryKey(OriginTrace record);
}