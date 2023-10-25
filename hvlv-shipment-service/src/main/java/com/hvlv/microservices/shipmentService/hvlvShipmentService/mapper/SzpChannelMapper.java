package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.SzpChannel;

public interface SzpChannelMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SzpChannel record);

    int insertSelective(SzpChannel record);

    SzpChannel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SzpChannel record);

    int updateByPrimaryKeyWithBLOBs(SzpChannel record);

    int updateByPrimaryKey(SzpChannel record);
}