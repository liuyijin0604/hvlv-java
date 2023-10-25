package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.ZoneRateBk;

public interface ZoneRateBkMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ZoneRateBk record);

    int insertSelective(ZoneRateBk record);

    ZoneRateBk selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ZoneRateBk record);

    int updateByPrimaryKey(ZoneRateBk record);
}