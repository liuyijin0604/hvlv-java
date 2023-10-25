package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.Tracking;

public interface TrackingMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Tracking record);

    int insertSelective(Tracking record);

    Tracking selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Tracking record);

    int updateByPrimaryKeyWithBLOBs(Tracking record);

    int updateByPrimaryKey(Tracking record);
}