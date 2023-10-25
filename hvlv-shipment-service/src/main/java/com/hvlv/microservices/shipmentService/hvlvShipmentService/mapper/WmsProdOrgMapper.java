package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.WmsProdOrg;
import org.apache.ibatis.annotations.Param;

public interface WmsProdOrgMapper {
    int deleteByPrimaryKey(@Param("prodId") Integer prodId, @Param("orgId") Integer orgId);

    int insert(WmsProdOrg record);

    int insertSelective(WmsProdOrg record);

    WmsProdOrg selectByPrimaryKey(@Param("prodId") Integer prodId, @Param("orgId") Integer orgId);

    int updateByPrimaryKeySelective(WmsProdOrg record);

    int updateByPrimaryKeyWithBLOBs(WmsProdOrg record);

    int updateByPrimaryKey(WmsProdOrg record);
}