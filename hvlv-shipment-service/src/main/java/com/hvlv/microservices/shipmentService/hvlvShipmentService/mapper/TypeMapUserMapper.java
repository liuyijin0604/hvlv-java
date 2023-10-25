package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.TypeMapUser;

public interface TypeMapUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TypeMapUser record);

    int insertSelective(TypeMapUser record);

    TypeMapUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TypeMapUser record);

    int updateByPrimaryKey(TypeMapUser record);
}