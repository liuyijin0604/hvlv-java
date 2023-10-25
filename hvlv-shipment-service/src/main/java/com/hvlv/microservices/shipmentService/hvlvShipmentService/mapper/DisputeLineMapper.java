package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.DisputeLine;

public interface DisputeLineMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DisputeLine record);

    int insertSelective(DisputeLine record);

    DisputeLine selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DisputeLine record);

    int updateByPrimaryKeyWithBLOBs(DisputeLine record);

    int updateByPrimaryKey(DisputeLine record);
}