package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.WmsStockLocation;

public interface WmsStockLocationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WmsStockLocation record);

    int insertSelective(WmsStockLocation record);

    WmsStockLocation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WmsStockLocation record);

    int updateByPrimaryKeyWithBLOBs(WmsStockLocation record);

    int updateByPrimaryKey(WmsStockLocation record);
}