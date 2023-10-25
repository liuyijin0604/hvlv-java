package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.CargoAddressBook;

public interface CargoAddressBookMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CargoAddressBook record);

    int insertSelective(CargoAddressBook record);

    CargoAddressBook selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CargoAddressBook record);

    int updateByPrimaryKeyWithBLOBs(CargoAddressBook record);

    int updateByPrimaryKey(CargoAddressBook record);
}