package com.hvlv.microservices.apiService.hvlvApiService.service;

import com.alibaba.fastjson.JSONObject;
import com.hvlv.microservices.apiService.hvlvApiService.beans.JsonResultBean;

import java.io.UnsupportedEncodingException;

public interface FastHorseInterface {
    JsonResultBean generateOrderNoFastHorse(JSONObject jsonData);
    JsonResultBean createFastHorseShipment(JSONObject jsonData);
    JsonResultBean manifestFastHorse(JSONObject jsonData);
    JsonResultBean orderDetailFastHorse(JSONObject jsonData);
    JsonResultBean billInfoFastHorse(JSONObject jsonData);
    JsonResultBean trackFastHorse(JSONObject jsonData) throws Exception;
    JsonResultBean cancelFastHorse(JSONObject jsonData);
    JsonResultBean orderSuspensionFastHorse(JSONObject jsonData);
}
