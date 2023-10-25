package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.ManiMap;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ManiMapMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ManiMap record);

    int insertSelective(ManiMap record);

    ManiMap selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ManiMap record);

    int updateByPrimaryKeyWithBLOBs(ManiMap record);

    int updateByPrimaryKey(ManiMap record);
}