package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.SupplierInvoice;

public interface SupplierInvoiceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SupplierInvoice record);

    int insertSelective(SupplierInvoice record);

    SupplierInvoice selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SupplierInvoice record);

    int updateByPrimaryKeyWithBLOBs(SupplierInvoice record);

    int updateByPrimaryKey(SupplierInvoice record);
}