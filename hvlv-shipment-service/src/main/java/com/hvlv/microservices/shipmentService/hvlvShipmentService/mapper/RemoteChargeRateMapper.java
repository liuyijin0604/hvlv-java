package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.RemoteChargeRate;
import java.util.List;
import io.lettuce.core.dynamic.annotation.Param;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface RemoteChargeRateMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RemoteChargeRate record);

    int insertSelective(RemoteChargeRate record);

    RemoteChargeRate selectByPrimaryKey(Integer id);
    List<RemoteChargeRate> findRemoteChargeRateByRateIdAndPostcodeAndSuburb(Integer rateId, String postcode, String suburb);
    List<RemoteChargeRate> findRemoteChargeRateByChargecodeIdAndPostcodeAndSuburb(Integer chargecodeId, String postcode, String suburb);

    int updateByPrimaryKeySelective(RemoteChargeRate record);

    int updateByPrimaryKey(RemoteChargeRate record);

    RemoteChargeRate findByRateIdPostcodeAndSuburb(Integer rateId, String postcode, String suburb);

    RemoteChargeRate findByRateIdAndPostcodeRange(Integer rateId, String postcode);

    RemoteChargeRate findByChargeCodeIdRateIdAndPostcode(Integer chargecodeId, Integer rateId, String postcode);
}
