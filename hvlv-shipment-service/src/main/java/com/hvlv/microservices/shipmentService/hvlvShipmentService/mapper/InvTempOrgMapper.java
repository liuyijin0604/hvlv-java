package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.InvTempOrg;

public interface InvTempOrgMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(InvTempOrg record);

    int insertSelective(InvTempOrg record);

    InvTempOrg selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(InvTempOrg record);

    int updateByPrimaryKey(InvTempOrg record);
}