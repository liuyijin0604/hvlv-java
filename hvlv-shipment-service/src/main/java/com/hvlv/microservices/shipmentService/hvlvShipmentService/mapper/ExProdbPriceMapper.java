package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.ExProdbPrice;

public interface ExProdbPriceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ExProdbPrice record);

    int insertSelective(ExProdbPrice record);

    ExProdbPrice selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ExProdbPrice record);

    int updateByPrimaryKeyWithBLOBs(ExProdbPrice record);

    int updateByPrimaryKey(ExProdbPrice record);
}