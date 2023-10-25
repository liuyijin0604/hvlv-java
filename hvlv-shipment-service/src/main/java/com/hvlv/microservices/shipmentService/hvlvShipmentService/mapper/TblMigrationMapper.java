package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.TblMigration;

public interface TblMigrationMapper {
    int deleteByPrimaryKey(String version);

    int insert(TblMigration record);

    int insertSelective(TblMigration record);

    TblMigration selectByPrimaryKey(String version);

    int updateByPrimaryKeySelective(TblMigration record);

    int updateByPrimaryKey(TblMigration record);
}