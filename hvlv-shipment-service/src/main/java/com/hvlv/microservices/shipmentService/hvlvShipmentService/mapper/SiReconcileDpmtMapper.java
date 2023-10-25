package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.SiReconcileDpmt;

public interface SiReconcileDpmtMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SiReconcileDpmt record);

    int insertSelective(SiReconcileDpmt record);

    SiReconcileDpmt selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SiReconcileDpmt record);

    int updateByPrimaryKeyWithBLOBs(SiReconcileDpmt record);

    int updateByPrimaryKey(SiReconcileDpmt record);
}