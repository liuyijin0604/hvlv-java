package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.AddrArchive;

public interface AddrArchiveMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AddrArchive record);

    int insertSelective(AddrArchive record);

    AddrArchive selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AddrArchive record);

    int updateByPrimaryKeyWithBLOBs(AddrArchive record);

    int updateByPrimaryKey(AddrArchive record);
}