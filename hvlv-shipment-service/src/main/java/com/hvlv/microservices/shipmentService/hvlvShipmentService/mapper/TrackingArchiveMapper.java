package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.TrackingArchive;

public interface TrackingArchiveMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TrackingArchive record);

    int insertSelective(TrackingArchive record);

    TrackingArchive selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TrackingArchive record);

    int updateByPrimaryKeyWithBLOBs(TrackingArchive record);

    int updateByPrimaryKey(TrackingArchive record);
}