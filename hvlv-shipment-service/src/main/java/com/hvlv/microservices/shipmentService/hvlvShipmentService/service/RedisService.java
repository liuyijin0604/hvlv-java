package com.hvlv.microservices.shipmentService.hvlvShipmentService.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 */
@Service
public class RedisService {
    @Autowired
    private StringRedisTemplate template;
    private String keyPrefix;
    RedisService()
    {
        keyPrefix = "java:";
    }
    public void setKey(String key, String value) {
        ValueOperations<String, String> ops = this.template.opsForValue();
        ops.set(keyPrefix+key, value);
        this.template.expire(keyPrefix+key, 3000, TimeUnit.SECONDS);
    }

    public void setKey(String key, String value,Integer expired) {
        ValueOperations<String, String> ops = this.template.opsForValue();
        ops.set(keyPrefix+key, value);
        this.template.expire(keyPrefix+key, expired, TimeUnit.SECONDS);
    }

    public String getValue(String key) {
        ValueOperations<String, String> ops = this.template.opsForValue();
        return ops.get(keyPrefix+key);
    }

    public JSONArray getArray(String key)
    {
        ValueOperations<String, String> ops = this.template.opsForValue();
        String value = ops.get(keyPrefix+key);
        if(value!=null)
        {
            return JSONArray.parseArray(value);
        }else
        {
            return null;
        }
    }

    public JSONObject getObject(String key)
    {
        ValueOperations<String, String> ops = this.template.opsForValue();
        String value = ops.get(keyPrefix+key);
        if(value!=null)
        {
            return JSONObject.parseObject(value);
        }else
        {
            return null;
        }
    }
}
