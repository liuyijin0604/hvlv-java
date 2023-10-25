package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.PickupBooking;

public interface PickupBookingMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PickupBooking record);

    int insertSelective(PickupBooking record);

    PickupBooking selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PickupBooking record);

    int updateByPrimaryKeyWithBLOBs(PickupBooking record);

    int updateByPrimaryKey(PickupBooking record);
}