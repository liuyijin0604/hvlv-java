package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.PoliHistory;

public interface PoliHistoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PoliHistory record);

    int insertSelective(PoliHistory record);

    PoliHistory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PoliHistory record);

    int updateByPrimaryKeyWithBLOBs(PoliHistory record);

    int updateByPrimaryKey(PoliHistory record);
}