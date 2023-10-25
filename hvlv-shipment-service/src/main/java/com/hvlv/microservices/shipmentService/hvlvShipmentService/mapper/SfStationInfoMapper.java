package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.SfStationInfo;

public interface SfStationInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SfStationInfo record);

    int insertSelective(SfStationInfo record);

    SfStationInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SfStationInfo record);

    int updateByPrimaryKey(SfStationInfo record);
}