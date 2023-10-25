package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.CrmLog;

public interface CrmLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CrmLog record);

    int insertSelective(CrmLog record);

    CrmLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CrmLog record);

    int updateByPrimaryKeyWithBLOBs(CrmLog record);

    int updateByPrimaryKey(CrmLog record);
}