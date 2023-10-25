package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.Yiicache;

public interface YiicacheMapper {
    int deleteByPrimaryKey(String id);

    int insert(Yiicache record);

    int insertSelective(Yiicache record);

    Yiicache selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Yiicache record);

    int updateByPrimaryKeyWithBLOBs(Yiicache record);

    int updateByPrimaryKey(Yiicache record);
}