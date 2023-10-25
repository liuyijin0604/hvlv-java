package com.hvlv.microservices.apiService.hvlvApiService.beans;

import com.alibaba.fastjson.JSON;
import java.util.HashMap;
import java.util.Map;

public class JsonResultBean {
    private String code;
    private String msg;
    private Object data;
    private Map<String,String> status;
    public JsonResultBean(String code, String msg, Object data) {
        this.code = code;
        this.msg = msg;

        this.data = JSON.parse(JSON.toJSONString(data));
        this.status = new HashMap<String, String>();
    }

    public JsonResultBean(String code, String msg) {
        this.code = code;
        this.msg = msg;
        this.status = new HashMap<String, String>();
    }

    public JsonResultBean() {
        this.status = new HashMap<String, String>();
        this.status.put("60000","success");
        this.status.put("60001","Not Found Shipment");
        this.status.put("60002","Error");
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

    public void setData(Object data) {
        this.data = data;
    }

    public void setSuccess()
    {
        this.setCode("60000");
        this.setMsg("success");
    }
    public void setNotFound()
    {
        this.setCode("60001");
        this.setMsg(this.status.get("60001"));
    }
    public void setError()
    {
        this.setCode("60002");
        this.setMsg(this.status.get("60002"));
    }

    public Boolean isSuccess() {
        return this.getCode().equals("60000");
    }


    @Override
    public String toString()
    {
        return JSON.toJSONString(this);
    }
}
