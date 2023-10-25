package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.ImportsMailFilter;

public interface ImportsMailFilterMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ImportsMailFilter record);

    int insertSelective(ImportsMailFilter record);

    ImportsMailFilter selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ImportsMailFilter record);

    int updateByPrimaryKey(ImportsMailFilter record);
}