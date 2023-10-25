package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.ImportZwStorage;

public interface ImportZwStorageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ImportZwStorage record);

    int insertSelective(ImportZwStorage record);

    ImportZwStorage selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ImportZwStorage record);

    int updateByPrimaryKeyWithBLOBs(ImportZwStorage record);

    int updateByPrimaryKey(ImportZwStorage record);
}