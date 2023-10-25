package com.hvlv.microservices.shipmentService.hvlvShipmentService.controller;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.Tranship;
import com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper.TranshipMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TranshipController {
    @Autowired
    TranshipMapper transhipMapper;

    @PostMapping("/tranShip/getTranshipByShipmentId")
    public List<Tranship> getTranshipByShipmentId(@RequestParam("data") Integer data){
        return transhipMapper.selectByShipmentId(data);
    }

    @PostMapping("/tranShip/updateByPrimaryKeySelective")
    public int updateByPrimaryKeySelective(@RequestBody Tranship tranship){
        return transhipMapper.updateByPrimaryKeySelective(tranship);
    }

}
