package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.HeldScanCheck;

public interface HeldScanCheckMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(HeldScanCheck record);

    int insertSelective(HeldScanCheck record);

    HeldScanCheck selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(HeldScanCheck record);

    int updateByPrimaryKey(HeldScanCheck record);
}