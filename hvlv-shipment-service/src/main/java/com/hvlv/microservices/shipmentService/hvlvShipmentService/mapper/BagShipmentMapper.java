package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.BagShipment;

public interface BagShipmentMapper {
    int deleteByPrimaryKey(Long id);

    int insert(BagShipment record);

    int insertSelective(BagShipment record);

    BagShipment selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BagShipment record);

    int updateByPrimaryKey(BagShipment record);
}