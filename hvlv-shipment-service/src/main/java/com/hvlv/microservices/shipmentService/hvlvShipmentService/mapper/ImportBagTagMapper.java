package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.ImportBagTag;

public interface ImportBagTagMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ImportBagTag record);

    int insertSelective(ImportBagTag record);

    ImportBagTag selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ImportBagTag record);

    int updateByPrimaryKey(ImportBagTag record);
}