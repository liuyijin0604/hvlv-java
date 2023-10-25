package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.SmsNotice;

public interface SmsNoticeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SmsNotice record);

    int insertSelective(SmsNotice record);

    SmsNotice selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SmsNotice record);

    int updateByPrimaryKeyWithBLOBs(SmsNotice record);

    int updateByPrimaryKey(SmsNotice record);
}