package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.CnArea;

public interface CnAreaMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CnArea record);

    int insertSelective(CnArea record);

    CnArea selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CnArea record);

    int updateByPrimaryKey(CnArea record);
}