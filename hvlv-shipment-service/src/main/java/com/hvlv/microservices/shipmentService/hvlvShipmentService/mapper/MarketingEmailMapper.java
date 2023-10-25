package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.MarketingEmail;

public interface MarketingEmailMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MarketingEmail record);

    int insertSelective(MarketingEmail record);

    MarketingEmail selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MarketingEmail record);

    int updateByPrimaryKeyWithBLOBs(MarketingEmail record);

    int updateByPrimaryKey(MarketingEmail record);
}