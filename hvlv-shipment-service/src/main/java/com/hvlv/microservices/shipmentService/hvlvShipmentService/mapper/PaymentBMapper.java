package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.PaymentB;

public interface PaymentBMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PaymentB record);

    int insertSelective(PaymentB record);

    PaymentB selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PaymentB record);

    int updateByPrimaryKeyWithBLOBs(PaymentB record);

    int updateByPrimaryKey(PaymentB record);
}