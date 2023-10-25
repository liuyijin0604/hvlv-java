package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.JobLine;

public interface JobLineMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(JobLine record);

    int insertSelective(JobLine record);

    JobLine selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(JobLine record);

    int updateByPrimaryKey(JobLine record);
}