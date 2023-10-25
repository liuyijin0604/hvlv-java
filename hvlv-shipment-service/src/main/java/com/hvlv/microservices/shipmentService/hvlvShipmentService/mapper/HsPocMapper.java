package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.HsPoc;

public interface HsPocMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(HsPoc record);

    int insertSelective(HsPoc record);

    HsPoc selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(HsPoc record);

    int updateByPrimaryKey(HsPoc record);
}