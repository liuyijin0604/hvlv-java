package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.EmailTpl;

public interface EmailTplMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(EmailTpl record);

    int insertSelective(EmailTpl record);

    EmailTpl selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EmailTpl record);

    int updateByPrimaryKeyWithBLOBs(EmailTpl record);

    int updateByPrimaryKey(EmailTpl record);
}