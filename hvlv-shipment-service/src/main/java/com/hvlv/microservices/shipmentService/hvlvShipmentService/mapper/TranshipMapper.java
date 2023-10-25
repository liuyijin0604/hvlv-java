package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.Tranship;
import io.lettuce.core.dynamic.annotation.Param;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
@Repository
public interface TranshipMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Tranship record);

    int insertSelective(Tranship record);

    Tranship selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Tranship record);

    int updateByPrimaryKeyWithBLOBs(Tranship record);

    int updateByPrimaryKey(Tranship record);

    Tranship getShipmentFinalTranship(Integer shipmentId);

    List<Tranship> selectByShipmentId(@Param("pid") Integer pid);
}