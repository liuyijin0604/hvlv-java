package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.LiveChatDetail;

public interface LiveChatDetailMapper {
    int insert(LiveChatDetail record);

    int insertSelective(LiveChatDetail record);
}