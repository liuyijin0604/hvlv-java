package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.OrgFlexibleRateBk;

public interface OrgFlexibleRateBkMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OrgFlexibleRateBk record);

    int insertSelective(OrgFlexibleRateBk record);

    OrgFlexibleRateBk selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OrgFlexibleRateBk record);

    int updateByPrimaryKey(OrgFlexibleRateBk record);
}