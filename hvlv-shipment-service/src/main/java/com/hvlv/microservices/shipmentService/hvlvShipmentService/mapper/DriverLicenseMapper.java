package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.DriverLicense;

public interface DriverLicenseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DriverLicense record);

    int insertSelective(DriverLicense record);

    DriverLicense selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DriverLicense record);

    int updateByPrimaryKeyWithBLOBs(DriverLicense record);

    int updateByPrimaryKey(DriverLicense record);
}