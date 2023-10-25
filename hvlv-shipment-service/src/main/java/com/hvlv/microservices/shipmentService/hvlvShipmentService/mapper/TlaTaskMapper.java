package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.TlaTask;

public interface TlaTaskMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TlaTask record);

    int insertSelective(TlaTask record);

    TlaTask selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TlaTask record);

    int updateByPrimaryKeyWithBLOBs(TlaTask record);

    int updateByPrimaryKey(TlaTask record);
}