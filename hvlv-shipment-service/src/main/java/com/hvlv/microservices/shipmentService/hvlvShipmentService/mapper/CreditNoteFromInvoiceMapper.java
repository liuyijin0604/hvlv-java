package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.CreditNoteFromInvoice;

public interface CreditNoteFromInvoiceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CreditNoteFromInvoice record);

    int insertSelective(CreditNoteFromInvoice record);

    CreditNoteFromInvoice selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CreditNoteFromInvoice record);

    int updateByPrimaryKey(CreditNoteFromInvoice record);
}