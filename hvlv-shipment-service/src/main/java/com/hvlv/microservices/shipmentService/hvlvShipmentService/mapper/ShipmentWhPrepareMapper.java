package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.ShipmentWhPrepare;

public interface ShipmentWhPrepareMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ShipmentWhPrepare record);

    int insertSelective(ShipmentWhPrepare record);

    ShipmentWhPrepare selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ShipmentWhPrepare record);

    int updateByPrimaryKey(ShipmentWhPrepare record);
}