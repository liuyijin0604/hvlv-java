package com.hvlv.microservices.shipmentService.hvlvShipmentService.service;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.User;
import com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    public User select(int id)
    {
        return userMapper.select(id);
    }
}
