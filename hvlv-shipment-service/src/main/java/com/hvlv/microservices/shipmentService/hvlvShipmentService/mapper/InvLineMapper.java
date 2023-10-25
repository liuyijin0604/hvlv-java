package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.InvLine;

public interface InvLineMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(InvLine record);

    int insertSelective(InvLine record);

    InvLine selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(InvLine record);

    int updateByPrimaryKeyWithBLOBs(InvLine record);

    int updateByPrimaryKey(InvLine record);
}