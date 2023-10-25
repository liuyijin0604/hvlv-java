package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.ProcessLog;

public interface ProcessLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProcessLog record);

    int insertSelective(ProcessLog record);

    ProcessLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProcessLog record);

    int updateByPrimaryKey(ProcessLog record);
}