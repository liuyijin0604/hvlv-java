package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.WmsTask;

public interface WmsTaskMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WmsTask record);

    int insertSelective(WmsTask record);

    WmsTask selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WmsTask record);

    int updateByPrimaryKeyWithBLOBs(WmsTask record);

    int updateByPrimaryKey(WmsTask record);
}