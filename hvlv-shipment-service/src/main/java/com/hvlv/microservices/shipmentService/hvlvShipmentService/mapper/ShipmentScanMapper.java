package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.ShipmentScan;
import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.ShipmentScanMqProcess;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ShipmentScanMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ShipmentScan record);

    int insertSelective(ShipmentScan record);

    ShipmentScan selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ShipmentScan record);

    int updateByPrimaryKey(ShipmentScan record);

    Integer checkCurrentShipmentScanRecord(Integer shipmentId,Integer sn);

    Boolean insertShipmentScanProcessRecord(ShipmentScanMqProcess shipmentScanMqProcess);
}