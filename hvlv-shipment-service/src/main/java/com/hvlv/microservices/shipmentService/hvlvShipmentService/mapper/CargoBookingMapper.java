package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.CargoBooking;

public interface CargoBookingMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CargoBooking record);

    int insertSelective(CargoBooking record);

    CargoBooking selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CargoBooking record);

    int updateByPrimaryKeyWithBLOBs(CargoBooking record);

    int updateByPrimaryKey(CargoBooking record);
}