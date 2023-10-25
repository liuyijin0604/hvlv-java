package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.ConsolProcess;

public interface ConsolProcessMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ConsolProcess record);

    int insertSelective(ConsolProcess record);

    ConsolProcess selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ConsolProcess record);

    int updateByPrimaryKeyWithBLOBs(ConsolProcess record);

    int updateByPrimaryKey(ConsolProcess record);
}