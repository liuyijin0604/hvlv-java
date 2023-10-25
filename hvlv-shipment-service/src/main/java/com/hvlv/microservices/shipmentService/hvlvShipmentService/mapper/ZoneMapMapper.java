package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.ZoneMap;
import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.ZoneRate;
import io.lettuce.core.dynamic.annotation.Param;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Mapper
@Repository

public interface ZoneMapMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ZoneMap record);

    int insertSelective(ZoneMap record);

    ZoneMap selectByPrimaryKey(Integer id);

    ZoneMap findZoneMapsByOrgIdAndZoneId(Integer orgId, Integer zoneId);

    ZoneMap findZoneMapsByOrgIdAndZoneIdAndPostcodeAndSuburb(Integer orgId, Integer zoneId, String postcode, String suburb);
    ZoneMap findZoneMapsByOrgIdAndZoneIdAndPostcode(Integer orgId, Integer zoneId, String postcode);

    List<ZoneMap> findZoneMapsByChargecodeIdAndPostcode(@Param("chargecodeId") Integer chargecodeId, @Param("cneePostcode") Integer cneePostcode);

    int updateByPrimaryKeySelective(ZoneMap record);

    int updateByPrimaryKey(ZoneMap record);

    int countZoneMapByOrgAndZoneFw(@Param("postcode") int postcode);

    ZoneMap findByOrgIdZoneIdAndPostcode(@Param("orgId") Integer orgId, @Param("zoneId") Byte zoneId, @Param("postcode") Integer postcode);

    ZoneMap findByOrgIdZoneIdPostcodeAndSuburb(@Param("orgId") Integer orgId, @Param("zoneId") Byte zoneId, @Param("postcode") Integer postcode, @Param("suburb") String suburb);

    ZoneMap findByOrgIdAndZoneIdWithNonEmptySuburb(Integer orgId, Integer zoneId);

}