package com.hvlv.microservices.shipmentService.hvlvShipmentService.entity;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSON;

import java.util.HashMap;

public class MetaModel {
    private String meta;
    protected JSONObject mdata;

    public String getMeta() {
        if(this.mdata!=null)
        {
            this.meta = JSONObject.toJSONString(this.meta);
        }
        return meta;
    }

    public void setMeta(String meta) {
        this.meta = meta;
        this.mdata = JSON.parseObject(this.meta);
    }

    public JSONObject getMdata() {
        if(this.mdata==null)
        {
            this.setMeta(this.meta);
        }
        return this.mdata;
    }

    public void setMdata(JSONObject mdata) {
        this.mdata = mdata;
        setMeta(JSONObject.toJSONString(this.mdata));
    }
}
