package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.PaymentArrangeSignature;

public interface PaymentArrangeSignatureMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PaymentArrangeSignature record);

    int insertSelective(PaymentArrangeSignature record);

    PaymentArrangeSignature selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PaymentArrangeSignature record);

    int updateByPrimaryKeyWithBLOBs(PaymentArrangeSignature record);

    int updateByPrimaryKey(PaymentArrangeSignature record);
}