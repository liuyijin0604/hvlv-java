package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.ShipmentFbaView;

public interface ShipmentFbaViewMapper {
    int insert(ShipmentFbaView record);

    int insertSelective(ShipmentFbaView record);
}