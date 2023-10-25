package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.ImportsSystemFuel;

public interface ImportsSystemFuelMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ImportsSystemFuel record);

    int insertSelective(ImportsSystemFuel record);

    ImportsSystemFuel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ImportsSystemFuel record);

    int updateByPrimaryKey(ImportsSystemFuel record);
}