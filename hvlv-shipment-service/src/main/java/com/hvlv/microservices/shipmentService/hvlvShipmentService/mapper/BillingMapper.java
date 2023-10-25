package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.Billing;

public interface BillingMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Billing record);

    int insertSelective(Billing record);

    Billing selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Billing record);

    int updateByPrimaryKeyWithBLOBs(Billing record);

    int updateByPrimaryKey(Billing record);
}