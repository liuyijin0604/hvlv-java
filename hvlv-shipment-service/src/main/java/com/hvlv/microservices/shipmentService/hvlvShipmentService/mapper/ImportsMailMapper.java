package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.ImportsMail;

public interface ImportsMailMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ImportsMail record);

    int insertSelective(ImportsMail record);

    ImportsMail selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ImportsMail record);

    int updateByPrimaryKeyWithBLOBs(ImportsMail record);

    int updateByPrimaryKey(ImportsMail record);
}