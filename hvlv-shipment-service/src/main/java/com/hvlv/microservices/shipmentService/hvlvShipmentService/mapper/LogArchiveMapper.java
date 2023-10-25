package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.LogArchive;

public interface LogArchiveMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LogArchive record);

    int insertSelective(LogArchive record);

    LogArchive selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LogArchive record);

    int updateByPrimaryKeyWithBLOBs(LogArchive record);

    int updateByPrimaryKey(LogArchive record);
}