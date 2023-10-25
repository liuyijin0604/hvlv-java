package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.DxtPushQueue;

public interface DxtPushQueueMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DxtPushQueue record);

    int insertSelective(DxtPushQueue record);

    DxtPushQueue selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DxtPushQueue record);

    int updateByPrimaryKey(DxtPushQueue record);
}