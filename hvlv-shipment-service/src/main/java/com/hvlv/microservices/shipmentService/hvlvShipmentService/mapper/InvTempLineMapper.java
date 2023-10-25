package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.InvTempLine;

public interface InvTempLineMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(InvTempLine record);

    int insertSelective(InvTempLine record);

    InvTempLine selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(InvTempLine record);

    int updateByPrimaryKeyWithBLOBs(InvTempLine record);

    int updateByPrimaryKey(InvTempLine record);
}