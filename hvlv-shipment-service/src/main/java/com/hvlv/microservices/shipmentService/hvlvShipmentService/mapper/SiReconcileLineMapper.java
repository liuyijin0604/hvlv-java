package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.SiReconcileLine;

public interface SiReconcileLineMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SiReconcileLine record);

    int insertSelective(SiReconcileLine record);

    SiReconcileLine selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SiReconcileLine record);

    int updateByPrimaryKeyWithBLOBs(SiReconcileLine record);

    int updateByPrimaryKey(SiReconcileLine record);
}