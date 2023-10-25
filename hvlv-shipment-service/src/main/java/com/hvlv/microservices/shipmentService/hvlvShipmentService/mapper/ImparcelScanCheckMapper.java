package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.ImparcelScanCheck;

public interface ImparcelScanCheckMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ImparcelScanCheck record);

    int insertSelective(ImparcelScanCheck record);

    ImparcelScanCheck selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ImparcelScanCheck record);

    int updateByPrimaryKeyWithBLOBs(ImparcelScanCheck record);

    int updateByPrimaryKey(ImparcelScanCheck record);
}