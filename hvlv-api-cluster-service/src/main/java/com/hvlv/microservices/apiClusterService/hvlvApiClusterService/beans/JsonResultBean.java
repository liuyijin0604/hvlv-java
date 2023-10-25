package com.hvlv.microservices.shipmentClusterService.hvlvShipmentClusterService.beans;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

public class JsonResultBean {
    private String code;
    private String msg;
    private Object data;
    private Map<String,Object> status;
    public JsonResultBean(String code, String msg, Object data) {
        this.code = code;
        this.msg = msg;

        this.data = JSON.parse(JSON.toJSONString(data));
        this.status = new HashMap<String, Object>();
    }

    public JsonResultBean(String code, String msg) {
        this.code = code;
        this.msg = msg;
        this.status = new HashMap<String, Object>();
    }

    public JsonResultBean() {
        this.status = new HashMap<String, Object>();
        this.status.put("60000","success");
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data)
    {
        this.data = JSON.parse(JSON.toJSONString(data));
    }

    public void setSuccess()
    {
        this.setCode("60000");
        this.setMsg("success");
    }

    @Override
    public String toString()
    {
        return JSON.toJSONString(this);
    }
}
