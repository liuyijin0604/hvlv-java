package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.ErpProducts;

public interface ErpProductsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ErpProducts record);

    int insertSelective(ErpProducts record);

    ErpProducts selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ErpProducts record);

    int updateByPrimaryKeyWithBLOBs(ErpProducts record);

    int updateByPrimaryKey(ErpProducts record);
}