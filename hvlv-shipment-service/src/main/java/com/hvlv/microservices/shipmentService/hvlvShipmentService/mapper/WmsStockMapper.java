package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.WmsStock;

public interface WmsStockMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WmsStock record);

    int insertSelective(WmsStock record);

    WmsStock selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WmsStock record);

    int updateByPrimaryKey(WmsStock record);
}