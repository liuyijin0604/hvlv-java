package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.AirFreightInvoiceReconciliationHistory;

public interface AirFreightInvoiceReconciliationHistoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AirFreightInvoiceReconciliationHistory record);

    int insertSelective(AirFreightInvoiceReconciliationHistory record);

    AirFreightInvoiceReconciliationHistory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AirFreightInvoiceReconciliationHistory record);

    int updateByPrimaryKeyWithBLOBs(AirFreightInvoiceReconciliationHistory record);

    int updateByPrimaryKey(AirFreightInvoiceReconciliationHistory record);
}