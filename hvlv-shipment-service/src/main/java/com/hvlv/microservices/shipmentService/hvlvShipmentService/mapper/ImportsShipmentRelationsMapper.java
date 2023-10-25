package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.ImportsShipmentRelations;

public interface ImportsShipmentRelationsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ImportsShipmentRelations record);

    int insertSelective(ImportsShipmentRelations record);

    ImportsShipmentRelations selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ImportsShipmentRelations record);

    int updateByPrimaryKey(ImportsShipmentRelations record);
}