package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.ShipmentPackage;

public interface ShipmentPackageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ShipmentPackage record);

    int insertSelective(ShipmentPackage record);

    ShipmentPackage selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ShipmentPackage record);

    int updateByPrimaryKeyWithBLOBs(ShipmentPackage record);

    int updateByPrimaryKey(ShipmentPackage record);
}