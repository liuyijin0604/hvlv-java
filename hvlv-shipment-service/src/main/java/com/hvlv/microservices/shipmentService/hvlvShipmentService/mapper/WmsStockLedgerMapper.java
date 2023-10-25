package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.WmsStockLedger;

public interface WmsStockLedgerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WmsStockLedger record);

    int insertSelective(WmsStockLedger record);

    WmsStockLedger selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WmsStockLedger record);

    int updateByPrimaryKeyWithBLOBs(WmsStockLedger record);

    int updateByPrimaryKey(WmsStockLedger record);
}