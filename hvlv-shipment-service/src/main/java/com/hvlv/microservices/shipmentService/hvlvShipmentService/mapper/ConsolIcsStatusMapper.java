package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.ConsolIcsStatus;
import org.apache.ibatis.annotations.Param;

public interface ConsolIcsStatusMapper {
    int deleteByPrimaryKey(@Param("consolId") Integer consolId, @Param("type") String type);

    int insert(ConsolIcsStatus record);

    int insertSelective(ConsolIcsStatus record);

    ConsolIcsStatus selectByPrimaryKey(@Param("consolId") Integer consolId, @Param("type") String type);

    int updateByPrimaryKeySelective(ConsolIcsStatus record);

    int updateByPrimaryKey(ConsolIcsStatus record);
}