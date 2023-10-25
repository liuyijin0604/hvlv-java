package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.WmsProd;

public interface WmsProdMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WmsProd record);

    int insertSelective(WmsProd record);

    WmsProd selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WmsProd record);

    int updateByPrimaryKeyWithBLOBs(WmsProd record);

    int updateByPrimaryKey(WmsProd record);
}