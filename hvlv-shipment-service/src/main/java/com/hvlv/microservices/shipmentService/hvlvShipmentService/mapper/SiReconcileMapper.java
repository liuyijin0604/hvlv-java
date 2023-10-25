package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.SiReconcile;

public interface SiReconcileMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SiReconcile record);

    int insertSelective(SiReconcile record);

    SiReconcile selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SiReconcile record);

    int updateByPrimaryKeyWithBLOBs(SiReconcile record);

    int updateByPrimaryKey(SiReconcile record);
}