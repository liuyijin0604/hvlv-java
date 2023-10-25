package com.hvlv.microservices.apiService.hvlvApiService.entity;

import com.alibaba.fastjson.JSONObject;

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
        this.mdata = JSONObject.parseObject(this.meta);
    }

    public JSONObject getMdata() {
        return mdata;
    }

    public void setMdata(JSONObject mdata) {
        this.mdata = mdata;
    }
}
