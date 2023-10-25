package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.Airline;

public interface AirlineMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Airline record);

    int insertSelective(Airline record);

    Airline selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Airline record);

    int updateByPrimaryKey(Airline record);
}