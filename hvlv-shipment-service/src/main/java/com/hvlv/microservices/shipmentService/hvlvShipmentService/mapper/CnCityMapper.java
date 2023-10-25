package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.CnCity;

public interface CnCityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CnCity record);

    int insertSelective(CnCity record);

    CnCity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CnCity record);

    int updateByPrimaryKey(CnCity record);
}