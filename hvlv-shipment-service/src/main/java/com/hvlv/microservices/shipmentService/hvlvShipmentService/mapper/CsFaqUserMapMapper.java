package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.CsFaqUserMap;

public interface CsFaqUserMapMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CsFaqUserMap record);

    int insertSelective(CsFaqUserMap record);

    CsFaqUserMap selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CsFaqUserMap record);

    int updateByPrimaryKey(CsFaqUserMap record);
}