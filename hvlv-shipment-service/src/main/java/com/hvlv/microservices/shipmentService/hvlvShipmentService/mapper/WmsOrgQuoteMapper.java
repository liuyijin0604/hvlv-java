package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.WmsOrgQuote;

public interface WmsOrgQuoteMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WmsOrgQuote record);

    int insertSelective(WmsOrgQuote record);

    WmsOrgQuote selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WmsOrgQuote record);

    int updateByPrimaryKeyWithBLOBs(WmsOrgQuote record);

    int updateByPrimaryKey(WmsOrgQuote record);
}