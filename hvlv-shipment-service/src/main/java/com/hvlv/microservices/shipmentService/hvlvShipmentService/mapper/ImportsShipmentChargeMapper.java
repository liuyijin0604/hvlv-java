package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.ImportsShipmentCharge;

public interface ImportsShipmentChargeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ImportsShipmentCharge record);

    int insertSelective(ImportsShipmentCharge record);

    ImportsShipmentCharge selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ImportsShipmentCharge record);

    int updateByPrimaryKey(ImportsShipmentCharge record);
}