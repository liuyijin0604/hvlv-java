package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.Yiisession;

public interface YiisessionMapper {
    int deleteByPrimaryKey(String id);

    int insert(Yiisession record);

    int insertSelective(Yiisession record);

    Yiisession selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Yiisession record);

    int updateByPrimaryKeyWithBLOBs(Yiisession record);

    int updateByPrimaryKey(Yiisession record);
}