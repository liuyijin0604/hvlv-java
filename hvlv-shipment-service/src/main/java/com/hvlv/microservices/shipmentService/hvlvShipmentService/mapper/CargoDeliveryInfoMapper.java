package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.CargoDeliveryInfo;

public interface CargoDeliveryInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CargoDeliveryInfo record);

    int insertSelective(CargoDeliveryInfo record);

    CargoDeliveryInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CargoDeliveryInfo record);

    int updateByPrimaryKey(CargoDeliveryInfo record);
}