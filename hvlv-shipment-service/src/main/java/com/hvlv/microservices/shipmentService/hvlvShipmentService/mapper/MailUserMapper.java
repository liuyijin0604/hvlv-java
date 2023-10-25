package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.MailUser;

public interface MailUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MailUser record);

    int insertSelective(MailUser record);

    MailUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MailUser record);

    int updateByPrimaryKeyWithBLOBs(MailUser record);

    int updateByPrimaryKey(MailUser record);
}