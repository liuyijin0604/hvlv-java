package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.Holidays;

public interface HolidaysMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Holidays record);

    int insertSelective(Holidays record);

    Holidays selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Holidays record);

    int updateByPrimaryKey(Holidays record);
}