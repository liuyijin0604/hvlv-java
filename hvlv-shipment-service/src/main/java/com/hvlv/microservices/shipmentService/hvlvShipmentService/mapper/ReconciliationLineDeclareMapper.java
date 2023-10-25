package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.ReconciliationLineDeclare;

public interface ReconciliationLineDeclareMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ReconciliationLineDeclare record);

    int insertSelective(ReconciliationLineDeclare record);

    ReconciliationLineDeclare selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ReconciliationLineDeclare record);

    int updateByPrimaryKeyWithBLOBs(ReconciliationLineDeclare record);

    int updateByPrimaryKey(ReconciliationLineDeclare record);
}