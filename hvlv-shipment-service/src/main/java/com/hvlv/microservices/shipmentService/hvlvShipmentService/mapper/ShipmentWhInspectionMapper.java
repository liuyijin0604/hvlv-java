package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.ShipmentWhInspection;

public interface ShipmentWhInspectionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ShipmentWhInspection record);

    int insertSelective(ShipmentWhInspection record);

    ShipmentWhInspection selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ShipmentWhInspection record);

    int updateByPrimaryKeyWithBLOBs(ShipmentWhInspection record);

    int updateByPrimaryKey(ShipmentWhInspection record);

}