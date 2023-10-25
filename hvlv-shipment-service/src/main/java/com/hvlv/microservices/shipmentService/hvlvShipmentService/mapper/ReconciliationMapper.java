package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.Reconciliation;

public interface ReconciliationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Reconciliation record);

    int insertSelective(Reconciliation record);

    Reconciliation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Reconciliation record);

    int updateByPrimaryKeyWithBLOBs(Reconciliation record);

    int updateByPrimaryKey(Reconciliation record);
}