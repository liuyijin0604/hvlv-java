package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.BillingLine;

public interface BillingLineMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BillingLine record);

    int insertSelective(BillingLine record);

    BillingLine selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BillingLine record);

    int updateByPrimaryKeyWithBLOBs(BillingLine record);

    int updateByPrimaryKey(BillingLine record);
}