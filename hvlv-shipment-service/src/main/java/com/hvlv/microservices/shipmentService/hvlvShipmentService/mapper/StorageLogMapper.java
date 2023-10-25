package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.StorageLog;

public interface StorageLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(StorageLog record);

    int insertSelective(StorageLog record);

    StorageLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(StorageLog record);

    int updateByPrimaryKey(StorageLog record);
}