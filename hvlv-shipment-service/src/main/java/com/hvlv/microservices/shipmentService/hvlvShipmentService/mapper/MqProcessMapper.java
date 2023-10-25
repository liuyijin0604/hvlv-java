package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.MqProcess;

public interface MqProcessMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MqProcess record);

    int insertSelective(MqProcess record);

    MqProcess selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MqProcess record);

    int updateByPrimaryKeyWithBLOBs(MqProcess record);

    int updateByPrimaryKey(MqProcess record);
}