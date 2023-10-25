package com.hvlv.microservices.shipmentService.hvlvShipmentService.service;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.beans.JsonResultBean;
import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.ShipmentProcess;
import com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper.ShipmentProcessMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.regex.Matcher;

@Service
public class CustomProcessService extends HvlvService{
    private List<String> pregMatchs;
    private Matcher m;

    @Autowired
    RedisService redisService;
    @Autowired
    ShipmentProcessMapper shipmentProcessMapper;

    public CustomProcessService() {
        pregMatchs = new ArrayList<String>();
    }

    public JsonResultBean changeShipmentProcessStatus(Integer userId,Integer shipmentId,Integer status)
    {
        JsonResultBean result = new JsonResultBean();
        ShipmentProcess shipmentProcess = new ShipmentProcess();
        shipmentProcess.setPid(shipmentId);
        shipmentProcess.setStatus(status);
        if(shipmentProcessMapper.updateShipmentProcessStatus(shipmentProcess))
        {
            result.setSuccess();
        }else
        {
            result.setNotFound();
        }


        return result;
    }

}
