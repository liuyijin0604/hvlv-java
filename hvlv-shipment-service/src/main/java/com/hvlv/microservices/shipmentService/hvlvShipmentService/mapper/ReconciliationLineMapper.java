package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.ReconciliationLine;
import org.apache.ibatis.annotations.Param;

public interface ReconciliationLineMapper {
    int deleteByPrimaryKey(@Param("id") Integer id, @Param("parentId") Integer parentId);

    int insert(ReconciliationLine record);

    int insertSelective(ReconciliationLine record);

    ReconciliationLine selectByPrimaryKey(@Param("id") Integer id, @Param("parentId") Integer parentId);

    int updateByPrimaryKeySelective(ReconciliationLine record);

    int updateByPrimaryKeyWithBLOBs(ReconciliationLine record);

    int updateByPrimaryKey(ReconciliationLine record);
}