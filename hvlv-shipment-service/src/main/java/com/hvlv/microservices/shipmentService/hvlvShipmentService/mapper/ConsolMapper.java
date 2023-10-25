package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.Consol;

public interface ConsolMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Consol record);

    int insertSelective(Consol record);

    Consol selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Consol record);

    int updateByPrimaryKeyWithBLOBs(Consol record);

    int updateByPrimaryKey(Consol record);
}