package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.SuburbPostcodeZone;
import io.lettuce.core.dynamic.annotation.Param;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface SuburbPostcodeZoneMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SuburbPostcodeZone record);

    int insertSelective(SuburbPostcodeZone record);

    SuburbPostcodeZone selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SuburbPostcodeZone record);

    int updateByPrimaryKey(SuburbPostcodeZone record);

    SuburbPostcodeZone findByPostcodeSuburbAndOrgId(@Param("postcode") String postcode, @Param("suburb") String suburb, @Param("orgId") Integer orgId);
}