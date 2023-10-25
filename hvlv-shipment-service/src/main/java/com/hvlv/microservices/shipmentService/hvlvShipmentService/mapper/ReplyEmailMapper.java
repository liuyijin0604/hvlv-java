package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.ReplyEmail;

public interface ReplyEmailMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ReplyEmail record);

    int insertSelective(ReplyEmail record);

    ReplyEmail selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ReplyEmail record);

    int updateByPrimaryKeyWithBLOBs(ReplyEmail record);

    int updateByPrimaryKey(ReplyEmail record);
}