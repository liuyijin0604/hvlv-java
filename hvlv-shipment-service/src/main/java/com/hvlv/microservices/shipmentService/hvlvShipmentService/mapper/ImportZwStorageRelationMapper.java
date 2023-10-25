package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.ImportZwStorageRelation;

public interface ImportZwStorageRelationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ImportZwStorageRelation record);

    int insertSelective(ImportZwStorageRelation record);

    ImportZwStorageRelation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ImportZwStorageRelation record);

    int updateByPrimaryKeyWithBLOBs(ImportZwStorageRelation record);

    int updateByPrimaryKey(ImportZwStorageRelation record);
}