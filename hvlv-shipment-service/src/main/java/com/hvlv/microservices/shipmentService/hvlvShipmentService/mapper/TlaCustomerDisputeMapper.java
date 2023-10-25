package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.TlaCustomerDispute;

public interface TlaCustomerDisputeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TlaCustomerDispute record);

    int insertSelective(TlaCustomerDispute record);

    TlaCustomerDispute selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TlaCustomerDispute record);

    int updateByPrimaryKey(TlaCustomerDispute record);
}