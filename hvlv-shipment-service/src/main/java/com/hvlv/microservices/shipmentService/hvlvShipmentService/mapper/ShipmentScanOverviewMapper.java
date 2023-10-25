package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.ShipmentScanOverview;

public interface ShipmentScanOverviewMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ShipmentScanOverview record);

    int insertSelective(ShipmentScanOverview record);

    ShipmentScanOverview selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ShipmentScanOverview record);

    int updateByPrimaryKeyWithBLOBs(ShipmentScanOverview record);

    int updateByPrimaryKey(ShipmentScanOverview record);
}