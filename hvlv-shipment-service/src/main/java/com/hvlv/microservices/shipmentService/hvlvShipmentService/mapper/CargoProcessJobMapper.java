package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.CargoProcessJob;

public interface CargoProcessJobMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CargoProcessJob record);

    int insertSelective(CargoProcessJob record);

    CargoProcessJob selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CargoProcessJob record);

    int updateByPrimaryKeyWithBLOBs(CargoProcessJob record);

    int updateByPrimaryKey(CargoProcessJob record);
}