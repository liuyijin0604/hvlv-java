package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.CourierNearestDepot;

public interface CourierNearestDepotMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CourierNearestDepot record);

    int insertSelective(CourierNearestDepot record);

    CourierNearestDepot selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CourierNearestDepot record);

    int updateByPrimaryKey(CourierNearestDepot record);
}