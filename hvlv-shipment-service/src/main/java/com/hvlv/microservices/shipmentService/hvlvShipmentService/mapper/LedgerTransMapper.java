package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.LedgerTrans;

public interface LedgerTransMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LedgerTrans record);

    int insertSelective(LedgerTrans record);

    LedgerTrans selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LedgerTrans record);

    int updateByPrimaryKeyWithBLOBs(LedgerTrans record);

    int updateByPrimaryKey(LedgerTrans record);
}