package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.PickupBookingSlot;

public interface PickupBookingSlotMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PickupBookingSlot record);

    int insertSelective(PickupBookingSlot record);

    PickupBookingSlot selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PickupBookingSlot record);

    int updateByPrimaryKey(PickupBookingSlot record);
}