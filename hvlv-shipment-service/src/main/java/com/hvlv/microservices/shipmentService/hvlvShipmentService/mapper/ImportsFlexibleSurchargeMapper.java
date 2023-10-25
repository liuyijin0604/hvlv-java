package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;
import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.ImportsFlexibleSurcharge;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ImportsFlexibleSurchargeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ImportsFlexibleSurcharge record);

    int insertSelective(ImportsFlexibleSurcharge record);

    ImportsFlexibleSurcharge selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ImportsFlexibleSurcharge record);

    int updateByPrimaryKey(ImportsFlexibleSurcharge record);

    List<ImportsFlexibleSurcharge> selectByRateIdWithConditions(Integer rateId);
}