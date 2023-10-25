package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.SupplierInvoiceLine;

public interface SupplierInvoiceLineMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SupplierInvoiceLine record);

    int insertSelective(SupplierInvoiceLine record);

    SupplierInvoiceLine selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SupplierInvoiceLine record);

    int updateByPrimaryKeyWithBLOBs(SupplierInvoiceLine record);

    int updateByPrimaryKey(SupplierInvoiceLine record);
}