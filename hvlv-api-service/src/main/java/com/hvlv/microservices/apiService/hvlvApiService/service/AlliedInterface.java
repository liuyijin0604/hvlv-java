package com.hvlv.microservices.apiService.hvlvApiService.service;

import com.alibaba.fastjson.JSONObject;
import com.hvlv.microservices.apiService.hvlvApiService.beans.JsonResultBean;

public interface AlliedInterface {
    JsonResultBean createAlliedShipment(JSONObject jsonData);

    JsonResultBean manifestAllied(JSONObject jsonData);

    JsonResultBean getAlliedCharge(JSONObject jsonData);

    JsonResultBean trackAllied(JSONObject jsonData);

    JsonResultBean cancelAllied(JSONObject jsonData);
}
