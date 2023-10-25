package com.hvlv.microservices.apiService.hvlvApiService.beans;

public class DataBean {
    private int status;
    private String msg;
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

    public void setData(Object data) {
        this.data = data;
    }
}
