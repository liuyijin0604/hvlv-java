package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.Cmr;

public interface CmrMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Cmr record);

    int insertSelective(Cmr record);

    Cmr selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Cmr record);

    int updateByPrimaryKeyWithBLOBs(Cmr record);

    int updateByPrimaryKey(Cmr record);
}