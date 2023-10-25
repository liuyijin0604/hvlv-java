package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.WmsLocation;

public interface WmsLocationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WmsLocation record);

    int insertSelective(WmsLocation record);

    WmsLocation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WmsLocation record);

    int updateByPrimaryKeyWithBLOBs(WmsLocation record);

    int updateByPrimaryKey(WmsLocation record);
}