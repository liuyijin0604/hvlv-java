package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.ExImage;

public interface ExImageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ExImage record);

    int insertSelective(ExImage record);

    ExImage selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ExImage record);

    int updateByPrimaryKey(ExImage record);
}