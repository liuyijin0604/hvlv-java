package com.hvlv.microservices.shipmentService.hvlvShipmentService.service;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.OrgRate;
import com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper.OrgRateMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrgRateService {
    @Autowired
    RedisService redisService;
    @Autowired
    OrgRateMapper orgRateMapper;

      public OrgRate getOrgRate(Integer data){
          return orgRateMapper.selectByPrimaryKey(data);
      }
}
