package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.Emailog;

public interface EmailogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Emailog record);

    int insertSelective(Emailog record);

    Emailog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Emailog record);

    int updateByPrimaryKeyWithBLOBs(Emailog record);

    int updateByPrimaryKey(Emailog record);
}