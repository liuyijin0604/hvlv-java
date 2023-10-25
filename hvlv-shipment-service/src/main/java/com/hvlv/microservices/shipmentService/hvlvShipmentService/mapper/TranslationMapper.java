package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.Translation;

public interface TranslationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Translation record);

    int insertSelective(Translation record);

    Translation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Translation record);

    int updateByPrimaryKey(Translation record);
}