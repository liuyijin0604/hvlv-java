package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.FastwayTrackingFileImport;

public interface FastwayTrackingFileImportMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FastwayTrackingFileImport record);

    int insertSelective(FastwayTrackingFileImport record);

    FastwayTrackingFileImport selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FastwayTrackingFileImport record);

    int updateByPrimaryKey(FastwayTrackingFileImport record);
}