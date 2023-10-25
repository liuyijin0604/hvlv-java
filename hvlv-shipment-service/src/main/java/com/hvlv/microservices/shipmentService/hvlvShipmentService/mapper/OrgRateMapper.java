package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.OrgRate;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository

public interface OrgRateMapper
{
    int deleteByPrimaryKey(Integer id);

    int insert(OrgRate record);

    int insertSelective(OrgRate record);

    OrgRate selectByPrimaryKey(Integer id);

    Integer selectByCourierId(Integer courierId);

    String selectCodeByCourierId(Integer courierId);

    int updateByPrimaryKeySelective(OrgRate record);

    int updateByPrimaryKeyWithBLOBs(OrgRate record);

    int updateByPrimaryKey(OrgRate record);
}