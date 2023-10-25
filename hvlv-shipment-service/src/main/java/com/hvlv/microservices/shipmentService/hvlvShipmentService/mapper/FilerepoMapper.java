package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.Filerepo;

public interface FilerepoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Filerepo record);

    int insertSelective(Filerepo record);

    Filerepo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Filerepo record);

    int updateByPrimaryKeyWithBLOBs(Filerepo record);

    int updateByPrimaryKey(Filerepo record);
}