package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.OrgPricingLog;

public interface OrgPricingLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OrgPricingLog record);

    int insertSelective(OrgPricingLog record);

    OrgPricingLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OrgPricingLog record);

    int updateByPrimaryKeyWithBLOBs(OrgPricingLog record);

    int updateByPrimaryKey(OrgPricingLog record);
}