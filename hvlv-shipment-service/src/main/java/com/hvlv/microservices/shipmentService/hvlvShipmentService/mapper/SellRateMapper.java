package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.SellRate;

public interface SellRateMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SellRate record);

    int insertSelective(SellRate record);

    SellRate selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SellRate record);

    int updateByPrimaryKeyWithBLOBs(SellRate record);

    int updateByPrimaryKey(SellRate record);
}