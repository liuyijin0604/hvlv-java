package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.DfeZone;
import io.lettuce.core.dynamic.annotation.Param;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface DfeZoneMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DfeZone record);

    int insertSelective(DfeZone record);

    DfeZone selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DfeZone record);

    int updateByPrimaryKey(DfeZone record);

    DfeZone findByPostcodeAndSuburb(@Param("postcode") Integer postcode, @Param("suburb") String suburb);

}