package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.CnProvince;

public interface CnProvinceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CnProvince record);

    int insertSelective(CnProvince record);

    CnProvince selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CnProvince record);

    int updateByPrimaryKey(CnProvince record);
}