package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.ShipmentUpdateHistory;

public interface ShipmentUpdateHistoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ShipmentUpdateHistory record);

    int insertSelective(ShipmentUpdateHistory record);

    ShipmentUpdateHistory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ShipmentUpdateHistory record);

    int updateByPrimaryKeyWithBLOBs(ShipmentUpdateHistory record);

    int updateByPrimaryKey(ShipmentUpdateHistory record);
}