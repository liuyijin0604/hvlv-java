package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.CreditLine;

public interface CreditLineMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CreditLine record);

    int insertSelective(CreditLine record);

    CreditLine selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CreditLine record);

    int updateByPrimaryKeyWithBLOBs(CreditLine record);

    int updateByPrimaryKey(CreditLine record);
}