package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.PaymentArrangeBilling;

public interface PaymentArrangeBillingMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PaymentArrangeBilling record);

    int insertSelective(PaymentArrangeBilling record);

    PaymentArrangeBilling selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PaymentArrangeBilling record);

    int updateByPrimaryKey(PaymentArrangeBilling record);
}