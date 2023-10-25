package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.CargoProcessJobRelations;

public interface CargoProcessJobRelationsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CargoProcessJobRelations record);

    int insertSelective(CargoProcessJobRelations record);

    CargoProcessJobRelations selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CargoProcessJobRelations record);

    int updateByPrimaryKey(CargoProcessJobRelations record);
}