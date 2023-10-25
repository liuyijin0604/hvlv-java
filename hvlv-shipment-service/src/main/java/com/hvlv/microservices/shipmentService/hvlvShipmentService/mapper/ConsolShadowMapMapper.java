package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.ConsolShadowMap;

public interface ConsolShadowMapMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ConsolShadowMap record);

    int insertSelective(ConsolShadowMap record);

    ConsolShadowMap selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ConsolShadowMap record);

    int updateByPrimaryKey(ConsolShadowMap record);
}