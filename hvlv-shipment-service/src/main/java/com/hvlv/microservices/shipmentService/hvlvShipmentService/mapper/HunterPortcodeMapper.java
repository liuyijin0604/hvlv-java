package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.HunterPortcode;
import org.apache.ibatis.annotations.Param;

public interface HunterPortcodeMapper {
    int deleteByPrimaryKey(@Param("suburb") String suburb, @Param("postcode") Integer postcode);

    int insert(HunterPortcode record);

    int insertSelective(HunterPortcode record);

    HunterPortcode selectByPrimaryKey(@Param("suburb") String suburb, @Param("postcode") Integer postcode);

    int updateByPrimaryKeySelective(HunterPortcode record);

    int updateByPrimaryKey(HunterPortcode record);
}