package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.ZoneMapTest;
import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.ZoneMapTestImport;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ZoneMapTestImportMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ZoneMapTestImport record);

    int insertSelective(ZoneMapTestImport record);

    ZoneMapTestImport selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ZoneMapTestImport record);

    int updateByPrimaryKey(ZoneMapTestImport record);

}