package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.LiveChatRecord;

public interface LiveChatRecordMapper {
    int insert(LiveChatRecord record);

    int insertSelective(LiveChatRecord record);
}