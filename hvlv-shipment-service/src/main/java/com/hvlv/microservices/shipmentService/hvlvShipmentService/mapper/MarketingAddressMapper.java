package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.MarketingAddress;

public interface MarketingAddressMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MarketingAddress record);

    int insertSelective(MarketingAddress record);

    MarketingAddress selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MarketingAddress record);

    int updateByPrimaryKeyWithBLOBs(MarketingAddress record);

    int updateByPrimaryKey(MarketingAddress record);
}