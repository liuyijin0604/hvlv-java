package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.ImportZwStorageLog;

public interface ImportZwStorageLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ImportZwStorageLog record);

    int insertSelective(ImportZwStorageLog record);

    ImportZwStorageLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ImportZwStorageLog record);

    int updateByPrimaryKeyWithBLOBs(ImportZwStorageLog record);

    int updateByPrimaryKey(ImportZwStorageLog record);
}