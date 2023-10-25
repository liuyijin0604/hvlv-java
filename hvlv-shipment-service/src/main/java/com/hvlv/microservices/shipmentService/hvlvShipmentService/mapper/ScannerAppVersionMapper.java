package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.ScannerAppVersion;

public interface ScannerAppVersionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ScannerAppVersion record);

    int insertSelective(ScannerAppVersion record);

    ScannerAppVersion selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ScannerAppVersion record);

    int updateByPrimaryKey(ScannerAppVersion record);
}