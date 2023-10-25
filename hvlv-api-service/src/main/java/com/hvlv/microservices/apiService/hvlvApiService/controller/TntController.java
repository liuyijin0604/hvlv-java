package com.hvlv.microservices.apiService.hvlvApiService.controller;

import com.alibaba.fastjson.JSONObject;
import com.hvlv.microservices.apiService.hvlvApiService.beans.DataBean;
import com.hvlv.microservices.apiService.hvlvApiService.beans.JsonResultBean;
import com.hvlv.microservices.apiService.hvlvApiService.service.TNTService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
@RestController
public class TntController {
    @PostMapping("/Tnt/doRoutingRequest")
    public JsonResultBean doRoutingRequest(@RequestParam("data") String data) {
        TNTService tntService = TNTService.getTntInterface("TNT_SYDNEY");
        try {
            JSONObject jsonObject = JSONObject.parseObject(data);
            Map<String, String> dataMap = jsonObject.toJavaObject(Map.class);
            Map<String, String> genNumberResult = tntService.doRoutingRequest(dataMap);
            JsonResultBean result = new JsonResultBean();
            result.setSuccess();
            DataBean dataBean = new DataBean();
            result.setData(dataBean);
            dataBean.setData(genNumberResult);
            return result;
        } catch (Exception e) {
            JsonResultBean response = new JsonResultBean();
            response.setSuccess();
            response.setMsg("Error creating shipments: " + e.getMessage());
            return response;
        }
    }
}
