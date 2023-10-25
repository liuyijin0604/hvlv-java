package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.ShipmentProcess;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ShipmentProcessMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ShipmentProcess record);

    int insertSelective(ShipmentProcess record);

    ShipmentProcess selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ShipmentProcess record);

    int updateByPrimaryKeyWithBLOBs(ShipmentProcess record);

    int updateByPrimaryKey(ShipmentProcess record);

    Boolean updateShipmentProcessStatus(ShipmentProcess shipmentProcess);
}