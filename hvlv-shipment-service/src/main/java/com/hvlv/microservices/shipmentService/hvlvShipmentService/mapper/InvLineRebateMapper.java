package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.InvLineRebate;

public interface InvLineRebateMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(InvLineRebate record);

    int insertSelective(InvLineRebate record);

    InvLineRebate selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(InvLineRebate record);

    int updateByPrimaryKeyWithBLOBs(InvLineRebate record);

    int updateByPrimaryKey(InvLineRebate record);
}