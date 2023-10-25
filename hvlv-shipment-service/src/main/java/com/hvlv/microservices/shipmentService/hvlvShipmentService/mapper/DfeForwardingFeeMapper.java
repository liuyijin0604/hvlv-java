package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.DfeForwardingFee;
import io.lettuce.core.dynamic.annotation.Param;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface DfeForwardingFeeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DfeForwardingFee record);

    int insertSelective(DfeForwardingFee record);

    DfeForwardingFee selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DfeForwardingFee record);

    int updateByPrimaryKey(DfeForwardingFee record);

    DfeForwardingFee findByPostcodeSuburbAndOrgId(@Param("postcode") Integer postcode, @Param("suburb") String suburb, @Param("orgId") Integer orgId);

    DfeForwardingFee findByPostcodeAndOrgId(@Param("postcode") Integer postcode, @Param("orgId") Integer orgId);

}