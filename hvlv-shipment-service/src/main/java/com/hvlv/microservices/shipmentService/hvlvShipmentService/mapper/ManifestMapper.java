package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.Manifest;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ManifestMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Manifest record);

    int insertSelective(Manifest record);

    Manifest selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Manifest record);

    int updateByPrimaryKeyWithBLOBs(Manifest record);

    int updateByPrimaryKey(Manifest record);
}