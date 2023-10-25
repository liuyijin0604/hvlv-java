package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.ImportsFlexibleSurchargeBk;

public interface ImportsFlexibleSurchargeBkMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ImportsFlexibleSurchargeBk record);

    int insertSelective(ImportsFlexibleSurchargeBk record);

    ImportsFlexibleSurchargeBk selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ImportsFlexibleSurchargeBk record);

    int updateByPrimaryKey(ImportsFlexibleSurchargeBk record);
}