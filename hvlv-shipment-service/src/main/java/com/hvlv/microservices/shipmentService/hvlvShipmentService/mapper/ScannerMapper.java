package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.Scanner;

public interface ScannerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Scanner record);

    int insertSelective(Scanner record);

    Scanner selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Scanner record);

    int updateByPrimaryKeyWithBLOBs(Scanner record);

    int updateByPrimaryKey(Scanner record);
}