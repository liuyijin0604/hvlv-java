package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.PlLedgerManagement;

public interface PlLedgerManagementMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PlLedgerManagement record);

    int insertSelective(PlLedgerManagement record);

    PlLedgerManagement selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PlLedgerManagement record);

    int updateByPrimaryKeyWithBLOBs(PlLedgerManagement record);

    int updateByPrimaryKey(PlLedgerManagement record);
}