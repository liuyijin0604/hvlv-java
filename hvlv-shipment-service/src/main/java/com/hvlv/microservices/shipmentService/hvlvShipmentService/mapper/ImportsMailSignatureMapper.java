package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.ImportsMailSignature;

public interface ImportsMailSignatureMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ImportsMailSignature record);

    int insertSelective(ImportsMailSignature record);

    ImportsMailSignature selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ImportsMailSignature record);

    int updateByPrimaryKeyWithBLOBs(ImportsMailSignature record);

    int updateByPrimaryKey(ImportsMailSignature record);
}