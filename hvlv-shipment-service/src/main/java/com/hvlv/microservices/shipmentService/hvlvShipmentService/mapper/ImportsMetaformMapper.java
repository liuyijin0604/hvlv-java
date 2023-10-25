package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.ImportsMetaform;

public interface ImportsMetaformMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ImportsMetaform record);

    int insertSelective(ImportsMetaform record);

    ImportsMetaform selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ImportsMetaform record);

    int updateByPrimaryKeyWithBLOBs(ImportsMetaform record);

    int updateByPrimaryKey(ImportsMetaform record);
}