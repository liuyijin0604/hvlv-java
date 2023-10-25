package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.WpUsers;

public interface WpUsersMapper {
    int deleteByPrimaryKey(Long id);

    int insert(WpUsers record);

    int insertSelective(WpUsers record);

    WpUsers selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(WpUsers record);

    int updateByPrimaryKey(WpUsers record);
}