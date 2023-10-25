package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.CnId;

public interface CnIdMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CnId record);

    int insertSelective(CnId record);

    CnId selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CnId record);

    int updateByPrimaryKeyWithBLOBs(CnId record);

    int updateByPrimaryKey(CnId record);
}