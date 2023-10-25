package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.CourierDeliveryAreas;

public interface CourierDeliveryAreasMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CourierDeliveryAreas record);

    int insertSelective(CourierDeliveryAreas record);

    CourierDeliveryAreas selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CourierDeliveryAreas record);

    int updateByPrimaryKey(CourierDeliveryAreas record);
}