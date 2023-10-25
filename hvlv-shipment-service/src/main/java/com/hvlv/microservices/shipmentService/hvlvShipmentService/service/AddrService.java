package com.hvlv.microservices.shipmentService.hvlvShipmentService.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hvlv.microservices.shipmentService.hvlvShipmentService.beans.AddrBean;
import com.hvlv.microservices.shipmentService.hvlvShipmentService.beans.ApiAddrBean;
import com.hvlv.microservices.shipmentService.hvlvShipmentService.beans.DataBean;
import com.hvlv.microservices.shipmentService.hvlvShipmentService.beans.JsonResultBean;
import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.CargoProcess;
import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.PostcodeDistance;
import com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class AddrService extends HvlvService {

    @Autowired
    RedisService redisService;
    @Autowired
    AddrMapper addrMapper;
    @Autowired
    SystemSettingService systemSettingService;
    @Autowired
    PostcodeDistanceMapper postcodeDistanceMapper;

    public JsonResultBean checkAuState(String state) {
        JsonResultBean result = new JsonResultBean();
        Map<String,String> statesReg =new HashMap<>();
        statesReg.put("NSW", "New South Wales|^NSW$");
        statesReg.put("ACT", "AUSTRALIAN CAPITAL TERRITORY|^ACT$");
        statesReg.put("NT", "NORTHERN TERRITORY|^NT$");
        statesReg.put("QLD", "QUEENSLAND|^QLD$");
        statesReg.put("SA", "SOUTH AUSTRALIA|^SA$");
        statesReg.put("TAS", "TASMANIA|^TAS$");
        statesReg.put("VIC", "VICTORIA|^VIC$");
        statesReg.put("WA", "WESTERN AUSTRALIA|^WA$");
        String stateKey =state;
        for(Map.Entry<String,String> entry:statesReg.entrySet()){
           String key =entry.getKey();
           String reg =entry.getValue();
           if(Pattern.compile(reg,Pattern.CASE_INSENSITIVE).matcher(state).find()){
               stateKey = key;
               break;
           }
        }
        result.setData(stateKey);
        result.setSuccess();
        return result;
    }

    public JsonResultBean checkIsPoBox(String address){
        JsonResultBean result = new JsonResultBean();
        DataBean dataBean = new DataBean();
        result.setData(dataBean);
        result.setSuccess();

        String pattern1 = "(?i)P\\.O\\.|PO \\d+ABN#|P[\\s\\.OST]*O[\\s\\.FICE]*B\\s*O\\s*X[\\s\\,\\.]*\\d*|POST OFFICE|Australia Post|Postal\\s*Locker|Parcel\\s*Locker|post\\s*Locker|Locker\\s*Number|Parcel\\s*collect|PMB\\s*\\d+|\\d+\\s*P[\\s\\.OST]*O[\\s\\.FICE]*BOX|CnC\\s?Woolworths|Cnc\\s?BIG\\s?W|(^| )Box\\s*\\d+";
        String pattern2 = "(?i)(post office street|post office st|Post Office Lane)";

        // Create Pattern objects
        Pattern regexPattern1 = Pattern.compile(pattern1);
        Pattern regexPattern2 = Pattern.compile(pattern2);

        // Match the patterns against the address
        Matcher matcher1 = regexPattern1.matcher(address);
        Matcher matcher2 = regexPattern2.matcher(address);

        // Perform the matching
        boolean matchesCriteria = matcher1.find()&&!matcher2.find();

        // Create JsonResultBean based on matching result
        if (matchesCriteria) {
            dataBean.setStatus(1);
            return result;
        } else {
            dataBean.setStatus(0);
            return result;
        }
    }

    public JsonResultBean isMatchAmazonOrB2B(String postcode, String suburb, String address)
    {
        JsonResultBean result = new JsonResultBean();
        DataBean dataBean = new DataBean();
        result.setData(dataBean);
        result.setSuccess();
        dataBean.setStatus(0);
        if(postcode!=null){
          if(CargoProcess.FBAPOSTCODE.indexOf("'" + postcode + "'") != -1)
          {
              JsonResultBean  isMatchAmazon = isMatchAmazon(postcode,suburb,address);
              DataBean isMatchAmazonBean = (DataBean) isMatchAmazon.getData();
              int isAmazon =  isMatchAmazonBean.getStatus();
              if((CargoProcess.OVERSEAPOSTCODE.indexOf("'" + postcode + "'") != -1)&&isAmazon!=1)
              {
                  JsonResultBean intzonejson = systemSettingService.getSetting("FBARegion","B2B");
                  DataBean regionDataBean = (DataBean) intzonejson.getData();
                  JSONObject regionDataJson = (JSONObject) regionDataBean.getData();
                  String regionData = regionDataJson.getString(postcode);
                  if(regionData!=null){
                      JSONArray regionDataArray = JSON.parseArray(regionData);
                      for (Object regionObj : regionDataArray){
                          JSONArray regionArray =(JSONArray)regionObj;
                          String addressValue = regionArray.getString(0);
                          String suburbValue = regionArray.getString(1);
                          String[] words = addressValue.split(" ");
                          boolean thisMatch = true;
                          for(String word : words)
                          {
                              word=word.replace("/", "\\/");
                              if(!word.isEmpty()){
                                  String pattern ="(?i)"+Pattern.quote(word);
                                  Pattern wordPattern = Pattern.compile(pattern);
                                  Matcher matcher = wordPattern.matcher(address.toUpperCase());
                                  if(!(matcher.find()&&suburbValue.trim().equalsIgnoreCase(suburb.trim()))){
                                      thisMatch = false;
                                      break;
                                  }
                              }
                          }
                          if (thisMatch){
                              dataBean.setStatus(1);
                              return result;
                          }
                      }
                  }
              }
          }
        }
        return result;
    }

    public JsonResultBean isMatchAmazon(String postcode, String suburb, String address)
    {
        JsonResultBean result = new JsonResultBean();
        DataBean dataBean = new DataBean();
        result.setData(dataBean);
        result.setSuccess();
        dataBean.setStatus(0);
        if(postcode!=null){
            if(CargoProcess.FBAPOSTCODE.indexOf("'" + postcode + "'") != -1)
            {
              JsonResultBean intzonejson = systemSettingService.getSetting("FBARegion","FBA");
              DataBean regionDataBean = (DataBean) intzonejson.getData();
              JSONObject regionDataJson = (JSONObject) regionDataBean.getData();
              String regionData = regionDataJson.getString(postcode);
              if(regionData!=null){
                  JSONArray regionDataArray = JSON.parseArray(regionData);
                  for (Object regionObj : regionDataArray){
                     JSONArray regionArray =(JSONArray)regionObj;
                     String addressValue = regionArray.getString(0);
                     String suburbValue = regionArray.getString(1);
                     String[] words = addressValue.split(" ");
                     boolean thisMatch = true;
                     for(String word : words)
                     {
                         word=word.replace("/", "\\/");
                         if(!word.isEmpty()){
                             String pattern ="(?i)"+Pattern.quote(word);
                             Pattern wordPattern = Pattern.compile(pattern);
                             Matcher matcher = wordPattern.matcher(address.toUpperCase());
                             if(!(matcher.find()&&suburbValue.trim().equalsIgnoreCase(suburb.trim()))){
                                 thisMatch = false;
                                 break;
                             }
                         }
                     }
                     if (thisMatch){
                         dataBean.setStatus(1);
                         return result;
                     }
                  }
              }
            }
        }
        return result;
    }

    public JsonResultBean isShipmentAmazon(AddrBean addr)
    {
        String address = addr.getAddress();
        String postcode = addr.getPostcode();
        String suburb = addr.getSuburb();
        return isMatchAmazon(postcode,suburb,address);
    }

    public PostcodeDistance getPostcodeDistance(String data) {
        JSONObject obj = JSONObject.parseObject(data);
        String originstr = obj.getString("origin");
        Integer origin = Integer.parseInt(originstr);
        String destination = obj.getString("destination");
        String suburb = obj.getString("suburb").toUpperCase();
        String state = obj.getString("state");
        return postcodeDistanceMapper.findByOriginDestinationSuburbState(origin, destination, suburb, state);
    }
    public void savePostcodeDistance(ApiAddrBean addr, Integer distance) {
        PostcodeDistance postcodeDistance = new PostcodeDistance();
        postcodeDistance.setSuburb(addr.getSuburb());
        postcodeDistance.setState(addr.getState());
        postcodeDistance.setCountry(addr.getCountry());
        postcodeDistance.setDestination(addr.getPostcode());
        postcodeDistance.setOrigin(addr.getDptId());
        postcodeDistance.setDistance(distance);
        postcodeDistanceMapper.insertFromGoogleAPI(postcodeDistance);
    }
}
