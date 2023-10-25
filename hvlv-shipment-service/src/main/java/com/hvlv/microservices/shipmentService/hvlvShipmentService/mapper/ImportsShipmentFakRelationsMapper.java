package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.ImportsShipmentFakRelations;

public interface ImportsShipmentFakRelationsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ImportsShipmentFakRelations record);

    int insertSelective(ImportsShipmentFakRelations record);

    ImportsShipmentFakRelations selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ImportsShipmentFakRelations record);

    int updateByPrimaryKey(ImportsShipmentFakRelations record);
}