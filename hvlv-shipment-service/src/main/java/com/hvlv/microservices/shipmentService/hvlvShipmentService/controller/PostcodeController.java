package com.hvlv.microservices.shipmentService.hvlvShipmentService.controller;

import com.alibaba.fastjson.JSONObject;
import com.hvlv.microservices.shipmentService.hvlvShipmentService.beans.JsonResultBean;
import com.hvlv.microservices.shipmentService.hvlvShipmentService.service.PostcodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostcodeController {

    @Autowired
    Environment environment;
    @Autowired
    PostcodeService postCodeService;

    @PostMapping("/postcode/getCountrylist")
    public JsonResultBean getCountrylist() {
        return postCodeService.countryList();
    }

    @PostMapping("/postcode/getStatelist")
    public JsonResultBean getStatelist() {
        return postCodeService.stateList();
    }
    @PostMapping("/postcode/getStateByPostcode")
    public JsonResultBean getStateByPostcode(@RequestParam("data") String data) {
        JSONObject obj = JSONObject.parseObject(data);
        String postcodeString = obj.getString("postcode");
        int postcode = Integer.parseInt(postcodeString);
        JsonResultBean result = postCodeService.getStateByPostcode(postcode);
        return result;
    }
    @PostMapping("/postcode/validateAddress")
    public JsonResultBean validateAddress(@RequestParam("data") String data) {
        JSONObject obj = JSONObject.parseObject(data);
        String suburb = obj.getString("suburb");
        String state = obj.getString("state");
        String postcode = obj.getString("postcode");
        String country = obj.getString("country");
//        System.out.println("Input values: suburb=" + suburb + ", state=" + state + ", postcode=" + postcode + ", country=" + country);
        JsonResultBean result = postCodeService.validateAddress(suburb, state, postcode, country);
        return result;
    }

    @PostMapping("/postcode/autoSuburbByPostcode")
    public JsonResultBean autoSuburbByPostcode(@RequestParam("data") String data) {
        JSONObject obj = JSONObject.parseObject(data);
        String suburb = obj.getString("suburb");
        String state = obj.getString("state");
        String postcode = obj.getString("postcode");
        String country = obj.getString("country");

        JsonResultBean result = postCodeService.autoSuburbByPostcode(suburb, state, postcode, country);
        return result;
    }


}
