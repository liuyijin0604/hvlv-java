package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.GatepassCourier;

public interface GatepassCourierMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GatepassCourier record);

    int insertSelective(GatepassCourier record);

    GatepassCourier selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GatepassCourier record);

    int updateByPrimaryKeyWithBLOBs(GatepassCourier record);

    int updateByPrimaryKey(GatepassCourier record);
}