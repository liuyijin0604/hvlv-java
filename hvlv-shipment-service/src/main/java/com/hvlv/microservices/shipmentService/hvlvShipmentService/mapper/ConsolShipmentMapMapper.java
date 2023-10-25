package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.ConsolShipmentMap;

public interface ConsolShipmentMapMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ConsolShipmentMap record);

    int insertSelective(ConsolShipmentMap record);

    ConsolShipmentMap selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ConsolShipmentMap record);

    int updateByPrimaryKey(ConsolShipmentMap record);
}