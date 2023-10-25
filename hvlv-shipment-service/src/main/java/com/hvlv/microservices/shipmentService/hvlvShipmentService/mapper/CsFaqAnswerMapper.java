package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.CsFaqAnswer;

public interface CsFaqAnswerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CsFaqAnswer record);

    int insertSelective(CsFaqAnswer record);

    CsFaqAnswer selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CsFaqAnswer record);

    int updateByPrimaryKey(CsFaqAnswer record);
}