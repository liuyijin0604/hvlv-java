package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.ImportsUnknownShipment;

public interface ImportsUnknownShipmentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ImportsUnknownShipment record);

    int insertSelective(ImportsUnknownShipment record);

    ImportsUnknownShipment selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ImportsUnknownShipment record);

    int updateByPrimaryKey(ImportsUnknownShipment record);
}