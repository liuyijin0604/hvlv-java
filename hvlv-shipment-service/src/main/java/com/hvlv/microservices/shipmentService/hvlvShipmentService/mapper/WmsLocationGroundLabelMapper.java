package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.WmsLocationGroundLabel;

public interface WmsLocationGroundLabelMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WmsLocationGroundLabel record);

    int insertSelective(WmsLocationGroundLabel record);

    WmsLocationGroundLabel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WmsLocationGroundLabel record);

    int updateByPrimaryKey(WmsLocationGroundLabel record);
}