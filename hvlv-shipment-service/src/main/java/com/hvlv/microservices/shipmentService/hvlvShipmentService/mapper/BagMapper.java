package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.Bag;

public interface BagMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Bag record);

    int insertSelective(Bag record);

    Bag selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Bag record);

    int updateByPrimaryKeyWithBLOBs(Bag record);

    int updateByPrimaryKey(Bag record);
}