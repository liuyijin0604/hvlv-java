package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.TlaTaskUser;

public interface TlaTaskUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TlaTaskUser record);

    int insertSelective(TlaTaskUser record);

    TlaTaskUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TlaTaskUser record);

    int updateByPrimaryKey(TlaTaskUser record);
}