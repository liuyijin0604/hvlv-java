package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.WmsTaskItem;

public interface WmsTaskItemMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WmsTaskItem record);

    int insertSelective(WmsTaskItem record);

    WmsTaskItem selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WmsTaskItem record);

    int updateByPrimaryKeyWithBLOBs(WmsTaskItem record);

    int updateByPrimaryKey(WmsTaskItem record);
}