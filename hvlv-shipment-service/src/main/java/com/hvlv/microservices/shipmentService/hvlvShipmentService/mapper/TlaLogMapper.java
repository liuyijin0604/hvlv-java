package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.TlaLog;

public interface TlaLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TlaLog record);

    int insertSelective(TlaLog record);

    TlaLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TlaLog record);

    int updateByPrimaryKeyWithBLOBs(TlaLog record);

    int updateByPrimaryKey(TlaLog record);
}