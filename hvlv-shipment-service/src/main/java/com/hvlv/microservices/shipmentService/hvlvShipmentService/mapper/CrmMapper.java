package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.Crm;

public interface CrmMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Crm record);

    int insertSelective(Crm record);

    Crm selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Crm record);

    int updateByPrimaryKey(Crm record);
}