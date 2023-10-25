package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.ForDelete2;

public interface ForDelete2Mapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ForDelete2 record);

    int insertSelective(ForDelete2 record);
}