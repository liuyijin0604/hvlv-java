package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.HashVerify;

public interface HashVerifyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(HashVerify record);

    int insertSelective(HashVerify record);

    HashVerify selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(HashVerify record);

    int updateByPrimaryKeyWithBLOBs(HashVerify record);

    int updateByPrimaryKey(HashVerify record);
}