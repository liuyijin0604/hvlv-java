package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.ZoneMapTest;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ZoneMapTestMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ZoneMapTest record);

    int insertSelective(ZoneMapTest record);

    ZoneMapTest selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ZoneMapTest record);

    int updateByPrimaryKeyWithBLOBs(ZoneMapTest record);

    int updateByPrimaryKey(ZoneMapTest record);

    ZoneMapTest findByRateIdZoneIdAndPostcode(Integer rateId, Byte zoneId, Integer postcode);
}