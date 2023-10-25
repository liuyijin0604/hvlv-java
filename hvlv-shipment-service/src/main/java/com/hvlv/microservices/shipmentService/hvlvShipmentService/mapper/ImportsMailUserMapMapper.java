package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.ImportsMailUserMap;

public interface ImportsMailUserMapMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ImportsMailUserMap record);

    int insertSelective(ImportsMailUserMap record);

    ImportsMailUserMap selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ImportsMailUserMap record);

    int updateByPrimaryKey(ImportsMailUserMap record);
}