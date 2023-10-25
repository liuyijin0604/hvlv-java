package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.AddrResidential;
import io.lettuce.core.dynamic.annotation.Param;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface AddrResidentialMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AddrResidential record);

    int insertSelective(AddrResidential record);

    AddrResidential selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AddrResidential record);

    int updateByPrimaryKey(AddrResidential record);

    int countByAddressSuburbPostcode(@Param("address") String address,
                                     @Param("suburb") String suburb,
                                     @Param("postcode") String postcode);

}