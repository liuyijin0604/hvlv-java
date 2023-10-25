package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.CogsLine;

public interface CogsLineMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CogsLine record);

    int insertSelective(CogsLine record);

    CogsLine selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CogsLine record);

    int updateByPrimaryKeyWithBLOBs(CogsLine record);

    int updateByPrimaryKey(CogsLine record);
}