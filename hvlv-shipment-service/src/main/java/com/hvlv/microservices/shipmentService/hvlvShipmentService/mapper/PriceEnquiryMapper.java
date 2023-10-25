package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.PriceEnquiry;
import io.lettuce.core.dynamic.annotation.Param;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository

public interface PriceEnquiryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PriceEnquiry record);

    int insertSelective(PriceEnquiry record);

    PriceEnquiry selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PriceEnquiry record);

    int updateByPrimaryKeyWithBLOBs(PriceEnquiry record);

    PriceEnquiry findByCodeAndOrgIdAndStatus(@Param("code") String code,
                                             @Param("orgId") Integer orgId,
                                             @Param("status") Integer status);

    int updateByPrimaryKey(PriceEnquiry record);
}