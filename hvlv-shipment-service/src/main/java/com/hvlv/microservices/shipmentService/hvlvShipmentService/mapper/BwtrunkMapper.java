package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.Bwtrunk;

public interface BwtrunkMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Bwtrunk record);

    int insertSelective(Bwtrunk record);

    Bwtrunk selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Bwtrunk record);

    int updateByPrimaryKey(Bwtrunk record);
}