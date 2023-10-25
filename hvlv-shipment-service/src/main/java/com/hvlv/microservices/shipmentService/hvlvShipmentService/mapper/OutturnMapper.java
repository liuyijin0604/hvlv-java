package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.Outturn;

public interface OutturnMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Outturn record);

    int insertSelective(Outturn record);

    Outturn selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Outturn record);

    int updateByPrimaryKeyWithBLOBs(Outturn record);

    int updateByPrimaryKey(Outturn record);
}