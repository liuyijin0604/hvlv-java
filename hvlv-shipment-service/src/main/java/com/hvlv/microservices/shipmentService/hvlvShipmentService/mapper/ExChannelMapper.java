package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.ExChannel;

public interface ExChannelMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ExChannel record);

    int insertSelective(ExChannel record);

    ExChannel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ExChannel record);

    int updateByPrimaryKeyWithBLOBs(ExChannel record);

    int updateByPrimaryKey(ExChannel record);
}