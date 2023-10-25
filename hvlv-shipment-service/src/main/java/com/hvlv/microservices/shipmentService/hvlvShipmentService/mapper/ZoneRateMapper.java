package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.ZoneRate;
import io.lettuce.core.dynamic.annotation.Param;

import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository

public interface ZoneRateMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ZoneRate record);

    int insertSelective(ZoneRate record);

    ZoneRate selectByPrimaryKey(Integer id);
    List<ZoneRate> findZoneRatesByWeightAndZoneAndRateId(String zone, BigDecimal weight, Integer orgRate);

    int updateByPrimaryKeySelective(ZoneRate record);

    List<ZoneRate> findZoneRates(@Param("chargecodeId") Integer chargecodeId, @Param("weight") BigDecimal weight, @Param("zone") String zone);

    BigDecimal selectMaxWeightHiByChargecodeIdAndZone(@Param("chargecodeId") Integer chargecodeId, @Param("zone") String zone);

    int updateByPrimaryKey(ZoneRate record);

    List<ZoneRate> findByZoneWeightAndRateId(@Param("zone") String zone, @Param("weight") double weight, @Param("rateId") Integer rateId);

    List<ZoneRate> findByRateIdWeightAndZone(@Param("rateId") Integer rateId, @Param("weight") double weight, @Param("zone") String zone);
}