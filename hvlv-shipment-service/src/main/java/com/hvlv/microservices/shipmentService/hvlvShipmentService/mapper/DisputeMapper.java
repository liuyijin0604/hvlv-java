package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.Dispute;

public interface DisputeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Dispute record);

    int insertSelective(Dispute record);

    Dispute selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Dispute record);

    int updateByPrimaryKeyWithBLOBs(Dispute record);

    int updateByPrimaryKey(Dispute record);
}