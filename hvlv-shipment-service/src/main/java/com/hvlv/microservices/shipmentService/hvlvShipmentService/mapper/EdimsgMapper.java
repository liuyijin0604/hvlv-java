package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.Edimsg;

public interface EdimsgMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Edimsg record);

    int insertSelective(Edimsg record);

    Edimsg selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Edimsg record);

    int updateByPrimaryKeyWithBLOBs(Edimsg record);

    int updateByPrimaryKey(Edimsg record);
}