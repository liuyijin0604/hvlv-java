package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.AuPostcode;
import org.apache.ibatis.annotations.Param;

public interface AuPostcodeMapper {
    int deleteByPrimaryKey(@Param("postcode") String postcode, @Param("suburb") String suburb);

    int insert(AuPostcode record);

    int insertSelective(AuPostcode record);

    AuPostcode selectByPrimaryKey(@Param("postcode") String postcode, @Param("suburb") String suburb);

    int updateByPrimaryKeySelective(AuPostcode record);

    int updateByPrimaryKey(AuPostcode record);
}