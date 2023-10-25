package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.SeaProcess;

public interface SeaProcessMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SeaProcess record);

    int insertSelective(SeaProcess record);

    SeaProcess selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SeaProcess record);

    int updateByPrimaryKeyWithBLOBs(SeaProcess record);

    int updateByPrimaryKey(SeaProcess record);
}