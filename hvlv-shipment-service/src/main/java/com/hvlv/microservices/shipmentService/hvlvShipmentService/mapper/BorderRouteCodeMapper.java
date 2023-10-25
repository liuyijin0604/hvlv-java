package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.BorderRouteCode;
import org.apache.ibatis.annotations.Param;

public interface BorderRouteCodeMapper {
    int deleteByPrimaryKey(@Param("suburb") String suburb, @Param("state") String state, @Param("postcode") String postcode);

    int insert(BorderRouteCode record);

    int insertSelective(BorderRouteCode record);

    BorderRouteCode selectByPrimaryKey(@Param("suburb") String suburb, @Param("state") String state, @Param("postcode") String postcode);

    int updateByPrimaryKeySelective(BorderRouteCode record);

    int updateByPrimaryKey(BorderRouteCode record);
}