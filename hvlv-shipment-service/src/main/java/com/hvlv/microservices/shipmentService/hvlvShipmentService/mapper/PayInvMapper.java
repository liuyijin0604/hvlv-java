package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.PayInv;
import org.apache.ibatis.annotations.Param;

public interface PayInvMapper {
    int deleteByPrimaryKey(@Param("payId") Integer payId, @Param("invId") Integer invId);

    int insert(PayInv record);

    int insertSelective(PayInv record);

    PayInv selectByPrimaryKey(@Param("payId") Integer payId, @Param("invId") Integer invId);

    int updateByPrimaryKeySelective(PayInv record);

    int updateByPrimaryKey(PayInv record);
}