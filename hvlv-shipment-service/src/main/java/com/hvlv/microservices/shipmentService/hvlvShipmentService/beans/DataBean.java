package com.hvlv.microservices.shipmentService.hvlvShipmentService.beans;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

public class DataBean {
    private int status;
    private String msg ="";
    private Object data;

    public DataBean(int status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public DataBean(){
    }

    public void setStatus(int status){
        this.status = status;
    }
    public int getStatus(){
        return status;
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

    public void appendMsg(String errorMsg) {
        if (!msg.isEmpty()) {
            msg += "\n";
        }
        msg += errorMsg;
    }
    public void setData(Object data) {
        this.data = data;
    }
}
