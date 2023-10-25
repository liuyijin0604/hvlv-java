package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.ImportsAmazonPlan;

public interface ImportsAmazonPlanMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ImportsAmazonPlan record);

    int insertSelective(ImportsAmazonPlan record);

    ImportsAmazonPlan selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ImportsAmazonPlan record);

    int updateByPrimaryKey(ImportsAmazonPlan record);
}