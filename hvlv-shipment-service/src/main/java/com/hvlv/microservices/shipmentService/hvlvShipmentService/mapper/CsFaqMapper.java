package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.CsFaq;

public interface CsFaqMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CsFaq record);

    int insertSelective(CsFaq record);

    CsFaq selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CsFaq record);

    int updateByPrimaryKey(CsFaq record);
}