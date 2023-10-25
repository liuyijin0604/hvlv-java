package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.CogsLineHasSiReconcileLine;
import org.apache.ibatis.annotations.Param;

public interface CogsLineHasSiReconcileLineMapper {
    int deleteByPrimaryKey(@Param("cogsLineId") Integer cogsLineId, @Param("siReconcileLineId") Integer siReconcileLineId);

    int insert(CogsLineHasSiReconcileLine record);

    int insertSelective(CogsLineHasSiReconcileLine record);
}