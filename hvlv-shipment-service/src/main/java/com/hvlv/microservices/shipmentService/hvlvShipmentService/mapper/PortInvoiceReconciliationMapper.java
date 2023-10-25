package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.PortInvoiceReconciliation;

public interface PortInvoiceReconciliationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PortInvoiceReconciliation record);

    int insertSelective(PortInvoiceReconciliation record);

    PortInvoiceReconciliation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PortInvoiceReconciliation record);

    int updateByPrimaryKeyWithBLOBs(PortInvoiceReconciliation record);

    int updateByPrimaryKey(PortInvoiceReconciliation record);
}