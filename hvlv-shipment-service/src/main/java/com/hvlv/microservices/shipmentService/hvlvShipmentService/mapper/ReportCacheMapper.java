package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.ReportCache;

public interface ReportCacheMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ReportCache record);

    int insertSelective(ReportCache record);

    ReportCache selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ReportCache record);

    int updateByPrimaryKeyWithBLOBs(ReportCache record);

    int updateByPrimaryKey(ReportCache record);
}