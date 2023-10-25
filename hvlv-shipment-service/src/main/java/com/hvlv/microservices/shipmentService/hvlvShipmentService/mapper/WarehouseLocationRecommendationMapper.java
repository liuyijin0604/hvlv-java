package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.WarehouseLocationRecommendation;

public interface WarehouseLocationRecommendationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WarehouseLocationRecommendation record);

    int insertSelective(WarehouseLocationRecommendation record);

    WarehouseLocationRecommendation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WarehouseLocationRecommendation record);

    int updateByPrimaryKey(WarehouseLocationRecommendation record);
}