package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.BankStatement;

public interface BankStatementMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BankStatement record);

    int insertSelective(BankStatement record);

    BankStatement selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BankStatement record);

    int updateByPrimaryKey(BankStatement record);
}