package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.InvoiceTemplate;

public interface InvoiceTemplateMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(InvoiceTemplate record);

    int insertSelective(InvoiceTemplate record);

    InvoiceTemplate selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(InvoiceTemplate record);

    int updateByPrimaryKeyWithBLOBs(InvoiceTemplate record);

    int updateByPrimaryKey(InvoiceTemplate record);
}