package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.GatepassShipment;

public interface GatepassShipmentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GatepassShipment record);

    int insertSelective(GatepassShipment record);

    GatepassShipment selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GatepassShipment record);

    int updateByPrimaryKeyWithBLOBs(GatepassShipment record);

    int updateByPrimaryKey(GatepassShipment record);
}