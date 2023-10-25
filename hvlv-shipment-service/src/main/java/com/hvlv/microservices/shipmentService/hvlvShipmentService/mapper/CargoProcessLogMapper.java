package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.CargoProcessLog;

public interface CargoProcessLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CargoProcessLog record);

    int insertSelective(CargoProcessLog record);

    CargoProcessLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CargoProcessLog record);

    int updateByPrimaryKey(CargoProcessLog record);
}