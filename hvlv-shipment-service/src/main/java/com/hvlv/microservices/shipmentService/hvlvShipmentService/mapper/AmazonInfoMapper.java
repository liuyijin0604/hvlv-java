package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.AmazonInfo;

public interface AmazonInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AmazonInfo record);

    int insertSelective(AmazonInfo record);

    AmazonInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AmazonInfo record);

    int updateByPrimaryKeyWithBLOBs(AmazonInfo record);

    int updateByPrimaryKey(AmazonInfo record);
}