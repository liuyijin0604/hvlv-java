package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.PortInvoiceReconciliationLine;

public interface PortInvoiceReconciliationLineMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PortInvoiceReconciliationLine record);

    int insertSelective(PortInvoiceReconciliationLine record);

    PortInvoiceReconciliationLine selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PortInvoiceReconciliationLine record);

    int updateByPrimaryKeyWithBLOBs(PortInvoiceReconciliationLine record);

    int updateByPrimaryKey(PortInvoiceReconciliationLine record);
}