package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.AclObj;

public interface AclObjMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AclObj record);

    int insertSelective(AclObj record);

    AclObj selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AclObj record);

    int updateByPrimaryKeyWithBLOBs(AclObj record);

    int updateByPrimaryKey(AclObj record);
}