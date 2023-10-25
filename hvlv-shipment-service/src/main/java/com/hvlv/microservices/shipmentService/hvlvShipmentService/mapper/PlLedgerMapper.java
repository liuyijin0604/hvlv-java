package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.PlLedger;

public interface PlLedgerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PlLedger record);

    int insertSelective(PlLedger record);

    PlLedger selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PlLedger record);

    int updateByPrimaryKeyWithBLOBs(PlLedger record);

    int updateByPrimaryKey(PlLedger record);
}