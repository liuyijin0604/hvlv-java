package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.SfTrackingRelationInfo;

public interface SfTrackingRelationInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SfTrackingRelationInfo record);

    int insertSelective(SfTrackingRelationInfo record);

    SfTrackingRelationInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SfTrackingRelationInfo record);

    int updateByPrimaryKey(SfTrackingRelationInfo record);
}