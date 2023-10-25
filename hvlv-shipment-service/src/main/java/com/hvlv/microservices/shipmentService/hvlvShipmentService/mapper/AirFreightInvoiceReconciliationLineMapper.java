package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.AirFreightInvoiceReconciliationLine;

public interface AirFreightInvoiceReconciliationLineMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AirFreightInvoiceReconciliationLine record);

    int insertSelective(AirFreightInvoiceReconciliationLine record);

    AirFreightInvoiceReconciliationLine selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AirFreightInvoiceReconciliationLine record);

    int updateByPrimaryKeyWithBLOBs(AirFreightInvoiceReconciliationLine record);

    int updateByPrimaryKey(AirFreightInvoiceReconciliationLine record);
}