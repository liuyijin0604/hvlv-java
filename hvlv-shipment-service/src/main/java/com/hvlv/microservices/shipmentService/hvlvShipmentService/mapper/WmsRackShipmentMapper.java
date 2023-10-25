package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.WmsRackShipment;

public interface WmsRackShipmentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WmsRackShipment record);

    int insertSelective(WmsRackShipment record);

    WmsRackShipment selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WmsRackShipment record);

    int updateByPrimaryKey(WmsRackShipment record);
}