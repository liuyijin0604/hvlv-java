package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.WmsJob;

public interface WmsJobMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WmsJob record);

    int insertSelective(WmsJob record);

    WmsJob selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WmsJob record);

    int updateByPrimaryKeyWithBLOBs(WmsJob record);

    int updateByPrimaryKey(WmsJob record);
}