package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.ExProdbMap;

public interface ExProdbMapMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ExProdbMap record);

    int insertSelective(ExProdbMap record);

    ExProdbMap selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ExProdbMap record);

    int updateByPrimaryKeyWithBLOBs(ExProdbMap record);

    int updateByPrimaryKey(ExProdbMap record);
}