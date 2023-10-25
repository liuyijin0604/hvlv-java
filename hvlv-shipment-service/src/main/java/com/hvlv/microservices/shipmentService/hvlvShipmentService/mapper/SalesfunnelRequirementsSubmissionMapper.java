package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.SalesfunnelRequirementsSubmission;

public interface SalesfunnelRequirementsSubmissionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SalesfunnelRequirementsSubmission record);

    int insertSelective(SalesfunnelRequirementsSubmission record);

    SalesfunnelRequirementsSubmission selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SalesfunnelRequirementsSubmission record);

    int updateByPrimaryKeyWithBLOBs(SalesfunnelRequirementsSubmission record);

    int updateByPrimaryKey(SalesfunnelRequirementsSubmission record);
}