package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.AirFreightInvoiceReconciliation;

public interface AirFreightInvoiceReconciliationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AirFreightInvoiceReconciliation record);

    int insertSelective(AirFreightInvoiceReconciliation record);

    AirFreightInvoiceReconciliation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AirFreightInvoiceReconciliation record);

    int updateByPrimaryKeyWithBLOBs(AirFreightInvoiceReconciliation record);

    int updateByPrimaryKey(AirFreightInvoiceReconciliation record);
}