package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.ErpProductRoutes;

public interface ErpProductRoutesMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ErpProductRoutes record);

    int insertSelective(ErpProductRoutes record);

    ErpProductRoutes selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ErpProductRoutes record);

    int updateByPrimaryKeyWithBLOBs(ErpProductRoutes record);

    int updateByPrimaryKey(ErpProductRoutes record);
}