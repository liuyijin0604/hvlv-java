package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.PayBill;
import org.apache.ibatis.annotations.Param;

public interface PayBillMapper {
    int deleteByPrimaryKey(@Param("payId") Integer payId, @Param("billId") Integer billId);

    int insert(PayBill record);

    int insertSelective(PayBill record);

    PayBill selectByPrimaryKey(@Param("payId") Integer payId, @Param("billId") Integer billId);

    int updateByPrimaryKeySelective(PayBill record);

    int updateByPrimaryKey(PayBill record);
}