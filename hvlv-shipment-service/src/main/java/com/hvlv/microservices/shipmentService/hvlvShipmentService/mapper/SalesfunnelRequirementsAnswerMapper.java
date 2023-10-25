package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.SalesfunnelRequirementsAnswer;

public interface SalesfunnelRequirementsAnswerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SalesfunnelRequirementsAnswer record);

    int insertSelective(SalesfunnelRequirementsAnswer record);

    SalesfunnelRequirementsAnswer selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SalesfunnelRequirementsAnswer record);

    int updateByPrimaryKey(SalesfunnelRequirementsAnswer record);
}