package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.DeliveryRecord;

public interface DeliveryRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DeliveryRecord record);

    int insertSelective(DeliveryRecord record);

    DeliveryRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DeliveryRecord record);

    int updateByPrimaryKeyWithBLOBs(DeliveryRecord record);

    int updateByPrimaryKey(DeliveryRecord record);
}