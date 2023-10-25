package com.hvlv.microservices.shipmentService.hvlvShipmentService.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hvlv.microservices.shipmentService.hvlvShipmentService.beans.DataBean;
import com.hvlv.microservices.shipmentService.hvlvShipmentService.beans.JsonResultBean;
import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.SystemSetting;
import com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper.SystemSettingMapper;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;


@Service
public class SystemSettingService extends HvlvService{

    @Autowired
    RedisService redisService;
    @Autowired
    SystemSettingMapper systemSettingMapper;

    public JsonResultBean getSetting(String key1,String key2)
    {
        JsonResultBean result = new JsonResultBean();
        DataBean dataBean = new DataBean();
        result.setData(dataBean);
        result.setSuccess();
        String key = key1+key2;

        String cachedMetaJson = redisService.getValue(key);

        if(cachedMetaJson !=null){
            if(key1=="INTZONE"){
                dataBean.setData(cachedMetaJson);
            }else {
                JSONObject parsedMeta = JSONObject.parseObject(cachedMetaJson);
                dataBean.setData(parsedMeta);
            }
        } else {
            SystemSetting systemSetting = systemSettingMapper.selectByKey(key1);
            if(systemSetting!=null){
                String metaSetting = systemSetting.getMeta();
                JSONObject jsonObject =  JSON.parseObject(metaSetting);
                String setting = jsonObject.getString(key2);
                redisService.setKey(key, setting);
                JSONObject parsedMeta = JSONObject.parseObject(setting);
                dataBean.setData(parsedMeta);
            }else{
                result.setNotFound();
            }
        }
        return result;
    }
    public JsonResultBean getKeySetting(String key)
    {
        JsonResultBean result = new JsonResultBean();
        DataBean dataBean = new DataBean();
        result.setData(dataBean);
        result.setSuccess();

        String cachedMetaJson = redisService.getValue(key);

        if(cachedMetaJson !=null){
            JSONObject parsedMeta = JSONObject.parseObject(cachedMetaJson);
            dataBean.setData(parsedMeta);
        } else {
            SystemSetting systemSetting = systemSettingMapper.selectByKey(key);
            if(systemSetting!=null){
                String metaSetting = systemSetting.getMeta();
                JSONObject jsonObject =  JSON.parseObject(metaSetting);
                String setting = jsonObject.toString();
                redisService.setKey(key, setting);
                dataBean.setData(jsonObject);
            }else{
                result.setNotFound();
            }
        }
        return result;
    }
}
