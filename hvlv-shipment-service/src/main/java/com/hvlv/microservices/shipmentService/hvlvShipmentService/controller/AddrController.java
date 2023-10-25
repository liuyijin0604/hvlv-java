package com.hvlv.microservices.shipmentService.hvlvShipmentService.controller;

import com.alibaba.fastjson.JSONObject;
import com.hvlv.microservices.shipmentService.hvlvShipmentService.beans.AddrBean;
import com.hvlv.microservices.shipmentService.hvlvShipmentService.beans.ApiAddrBean;
import com.hvlv.microservices.shipmentService.hvlvShipmentService.beans.JsonResultBean;
import com.hvlv.microservices.shipmentService.hvlvShipmentService.beans.SaveDistanceRequest;
import com.hvlv.microservices.shipmentService.hvlvShipmentService.service.AddrService;
import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.PostcodeDistance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddrController {

    @Autowired
    Environment environment;
    @Autowired
    AddrService addrService;
    @PostMapping("/addr/checkAuState")
    public JsonResultBean checkAuState(@RequestParam("data") String data){
        JSONObject obj = JSONObject.parseObject(data);
        String state = obj.getString("state");
        JsonResultBean result = addrService.checkAuState(state);
        return result;
    }
    @PostMapping("/addr/checkIsPoBox")
    public JsonResultBean checkIsPoBox(@RequestParam("data") String data){
        JSONObject obj = JSONObject.parseObject(data);
        String address = obj.getString("address");
        JsonResultBean result = addrService.checkIsPoBox(address);
        return result;
    }
    @PostMapping("/addr/isMatchAmazon")
    public JsonResultBean isMatchAmazon(@RequestParam("data") String data){
        JSONObject obj = JSONObject.parseObject(data);
        String address = obj.getString("address");
        String suburb = obj.getString("suburb");
        String postcode = obj.getString("postcode");
        JsonResultBean result = addrService.isMatchAmazon(postcode,suburb,address);
        return result;
    }
    @PostMapping("/addr/isMatchAmazonOrB2B")
    public JsonResultBean isMatchAmazonOrB2B(@RequestParam("data") String data){
        JSONObject obj = JSONObject.parseObject(data);
        String address = obj.getString("address");
        String suburb = obj.getString("suburb");
        String postcode = obj.getString("postcode");
        JsonResultBean result = addrService.isMatchAmazonOrB2B(postcode,suburb,address);
        return result;
    }

    @PostMapping("/addr/isShipmentAmazon")
    public JsonResultBean isShipmentAmazon(){
        AddrBean cnee = new AddrBean();
        cnee.setAddress("NATIONAL DRIVE");
        cnee.setSuburb("DANDENONG SOUTH");
        cnee.setPostcode("3175");
        JsonResultBean result = addrService.isShipmentAmazon(cnee);
        return result;
    }
    @PostMapping("/addr/getPostcodeDistance")
    public PostcodeDistance getPostcodeDistance(@RequestParam("data") String data) {
        return addrService.getPostcodeDistance(data);
    }

    @PostMapping("/addr/savePostcodeDistance")
    public void savePostcodeDistance(@RequestBody SaveDistanceRequest request) {
        ApiAddrBean addr = request.getAddr();
        Integer distance = request.getDistance();
        addrService.savePostcodeDistance(addr, distance);
    }

}
