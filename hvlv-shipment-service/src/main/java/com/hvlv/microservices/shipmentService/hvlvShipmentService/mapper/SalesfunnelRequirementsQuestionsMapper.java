package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.SalesfunnelRequirementsQuestions;

public interface SalesfunnelRequirementsQuestionsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SalesfunnelRequirementsQuestions record);

    int insertSelective(SalesfunnelRequirementsQuestions record);

    SalesfunnelRequirementsQuestions selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SalesfunnelRequirementsQuestions record);

    int updateByPrimaryKey(SalesfunnelRequirementsQuestions record);
}