package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.CargoProcess;

public interface CargoProcessMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CargoProcess record);

    int insertSelective(CargoProcess record);

    CargoProcess selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CargoProcess record);

    int updateByPrimaryKeyWithBLOBs(CargoProcess record);

    int updateByPrimaryKey(CargoProcess record);
}