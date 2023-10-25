package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.SalesfunnelRequirementsRecords;

public interface SalesfunnelRequirementsRecordsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SalesfunnelRequirementsRecords record);

    int insertSelective(SalesfunnelRequirementsRecords record);

    SalesfunnelRequirementsRecords selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SalesfunnelRequirementsRecords record);

    int updateByPrimaryKey(SalesfunnelRequirementsRecords record);
}