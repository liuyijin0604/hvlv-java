package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.WmsBilling;

public interface WmsBillingMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WmsBilling record);

    int insertSelective(WmsBilling record);

    WmsBilling selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WmsBilling record);

    int updateByPrimaryKeyWithBLOBs(WmsBilling record);

    int updateByPrimaryKey(WmsBilling record);
}