package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.Ledger;

public interface LedgerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Ledger record);

    int insertSelective(Ledger record);

    Ledger selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Ledger record);

    int updateByPrimaryKeyWithBLOBs(Ledger record);

    int updateByPrimaryKey(Ledger record);
}