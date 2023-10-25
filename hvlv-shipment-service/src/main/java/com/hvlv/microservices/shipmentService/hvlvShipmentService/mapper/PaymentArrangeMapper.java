package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.PaymentArrange;

public interface PaymentArrangeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PaymentArrange record);

    int insertSelective(PaymentArrange record);

    PaymentArrange selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PaymentArrange record);

    int updateByPrimaryKeyWithBLOBs(PaymentArrange record);

    int updateByPrimaryKey(PaymentArrange record);
}