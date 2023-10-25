package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.TlaCustomerDisputeLine;

public interface TlaCustomerDisputeLineMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TlaCustomerDisputeLine record);

    int insertSelective(TlaCustomerDisputeLine record);

    TlaCustomerDisputeLine selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TlaCustomerDisputeLine record);

    int updateByPrimaryKey(TlaCustomerDisputeLine record);
}