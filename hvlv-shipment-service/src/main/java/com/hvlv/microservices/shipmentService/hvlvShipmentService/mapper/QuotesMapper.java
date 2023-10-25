package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.Quotes;

public interface QuotesMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Quotes record);

    int insertSelective(Quotes record);

    Quotes selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Quotes record);

    int updateByPrimaryKey(Quotes record);
}