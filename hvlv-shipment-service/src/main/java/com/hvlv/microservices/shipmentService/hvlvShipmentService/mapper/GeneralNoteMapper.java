package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.GeneralNote;

public interface GeneralNoteMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GeneralNote record);

    int insertSelective(GeneralNote record);

    GeneralNote selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GeneralNote record);

    int updateByPrimaryKeyWithBLOBs(GeneralNote record);

    int updateByPrimaryKey(GeneralNote record);
}