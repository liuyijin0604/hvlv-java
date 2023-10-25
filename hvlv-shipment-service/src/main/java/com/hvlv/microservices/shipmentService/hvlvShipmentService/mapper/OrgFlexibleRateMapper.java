package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.OrgFlexibleRate;

public interface OrgFlexibleRateMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OrgFlexibleRate record);

    int insertSelective(OrgFlexibleRate record);

    OrgFlexibleRate selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OrgFlexibleRate record);

    int updateByPrimaryKey(OrgFlexibleRate record);
}