package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.OrgBankAccount;

public interface OrgBankAccountMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OrgBankAccount record);

    int insertSelective(OrgBankAccount record);

    OrgBankAccount selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OrgBankAccount record);

    int updateByPrimaryKeyWithBLOBs(OrgBankAccount record);

    int updateByPrimaryKey(OrgBankAccount record);
}