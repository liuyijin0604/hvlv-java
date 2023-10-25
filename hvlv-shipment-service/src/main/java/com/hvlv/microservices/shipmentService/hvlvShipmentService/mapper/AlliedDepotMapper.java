package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.AlliedDepot;

public interface AlliedDepotMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AlliedDepot record);

    int insertSelective(AlliedDepot record);

    AlliedDepot selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AlliedDepot record);

    int updateByPrimaryKey(AlliedDepot record);
}