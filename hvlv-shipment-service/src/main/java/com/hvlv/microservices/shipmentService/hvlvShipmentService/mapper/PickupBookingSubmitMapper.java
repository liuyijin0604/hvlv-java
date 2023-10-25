package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.PickupBookingSubmit;

public interface PickupBookingSubmitMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PickupBookingSubmit record);

    int insertSelective(PickupBookingSubmit record);

    PickupBookingSubmit selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PickupBookingSubmit record);

    int updateByPrimaryKeyWithBLOBs(PickupBookingSubmit record);

    int updateByPrimaryKey(PickupBookingSubmit record);
}