package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.ShipmentArchive;

public interface ShipmentArchiveMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ShipmentArchive record);

    int insertSelective(ShipmentArchive record);

    ShipmentArchive selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ShipmentArchive record);

    int updateByPrimaryKeyWithBLOBs(ShipmentArchive record);

    int updateByPrimaryKey(ShipmentArchive record);
}