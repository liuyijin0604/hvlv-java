package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.WmsProdPack;

public interface WmsProdPackMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WmsProdPack record);

    int insertSelective(WmsProdPack record);

    WmsProdPack selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WmsProdPack record);

    int updateByPrimaryKey(WmsProdPack record);
}