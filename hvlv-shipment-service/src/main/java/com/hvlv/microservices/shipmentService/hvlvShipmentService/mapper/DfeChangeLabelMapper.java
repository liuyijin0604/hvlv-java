package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.DfeChangeLabel;

public interface DfeChangeLabelMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DfeChangeLabel record);

    int insertSelective(DfeChangeLabel record);

    DfeChangeLabel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DfeChangeLabel record);

    int updateByPrimaryKey(DfeChangeLabel record);
}