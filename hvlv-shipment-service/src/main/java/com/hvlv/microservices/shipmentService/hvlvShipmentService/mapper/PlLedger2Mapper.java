package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.PlLedger2;

public interface PlLedger2Mapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PlLedger2 record);

    int insertSelective(PlLedger2 record);

    PlLedger2 selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PlLedger2 record);

    int updateByPrimaryKeyWithBLOBs(PlLedger2 record);

    int updateByPrimaryKey(PlLedger2 record);
}