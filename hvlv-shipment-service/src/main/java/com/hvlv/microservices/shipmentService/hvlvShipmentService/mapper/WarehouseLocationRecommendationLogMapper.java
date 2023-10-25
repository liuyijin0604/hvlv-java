package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.WarehouseLocationRecommendationLog;

public interface WarehouseLocationRecommendationLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WarehouseLocationRecommendationLog record);

    int insertSelective(WarehouseLocationRecommendationLog record);

    WarehouseLocationRecommendationLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WarehouseLocationRecommendationLog record);

    int updateByPrimaryKey(WarehouseLocationRecommendationLog record);
}