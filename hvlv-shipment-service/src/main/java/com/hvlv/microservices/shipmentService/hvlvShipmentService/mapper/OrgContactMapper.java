package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.OrgContact;

public interface OrgContactMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OrgContact record);

    int insertSelective(OrgContact record);

    OrgContact selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OrgContact record);

    int updateByPrimaryKeyWithBLOBs(OrgContact record);

    int updateByPrimaryKey(OrgContact record);
}