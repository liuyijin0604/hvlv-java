package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.ErpVendors;

public interface ErpVendorsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ErpVendors record);

    int insertSelective(ErpVendors record);

    ErpVendors selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ErpVendors record);

    int updateByPrimaryKeyWithBLOBs(ErpVendors record);

    int updateByPrimaryKey(ErpVendors record);
}