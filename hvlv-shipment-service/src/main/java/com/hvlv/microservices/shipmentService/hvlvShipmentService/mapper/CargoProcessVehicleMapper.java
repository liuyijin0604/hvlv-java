package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.CargoProcessVehicle;

public interface CargoProcessVehicleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CargoProcessVehicle record);

    int insertSelective(CargoProcessVehicle record);

    CargoProcessVehicle selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CargoProcessVehicle record);

    int updateByPrimaryKeyWithBLOBs(CargoProcessVehicle record);

    int updateByPrimaryKey(CargoProcessVehicle record);
}