package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.Hs;

public interface HsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Hs record);

    int insertSelective(Hs record);

    Hs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Hs record);

    int updateByPrimaryKey(Hs record);
}