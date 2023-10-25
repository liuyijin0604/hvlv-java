package com.hvlv.microservices.apiService.hvlvApiService.controller;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hvlv.microservices.apiService.hvlvApiService.beans.ApiAddrBean;
import com.hvlv.microservices.apiService.hvlvApiService.beans.DataBean;
import com.hvlv.microservices.apiService.hvlvApiService.beans.JsonResultBean;

import com.hvlv.microservices.apiService.hvlvApiService.client.LabelClient;
import com.hvlv.microservices.apiService.hvlvApiService.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;
import com.hvlv.microservices.apiService.hvlvApiService.service.IMileService;
import java.math.BigDecimal;
import java.util.Map;

@RestController
public class ApiController {

    @Autowired
    Environment environment;

    @Autowired
    StorageService storageService;
    @Autowired
    GoogleMapAPIService googleMapAPIService;
    @Autowired
    @Qualifier("alliedProductionService")
    AlliedInterface alliedService;
    @Autowired
    FastHorseInterface fastHorseService;

    @Autowired
    AlliedLocalCourierProductionService alliedLocalCourierService;

    @Autowired
    IMileService iMileService;

    @Autowired
    RedisService redisService;
    @Autowired
    LabelClient labelClient;

    @PostMapping("/api/orderAochenStorage")
    public JsonResultBean orderAochenStorage(@RequestParam("data") String data)
    {
        JSONObject obj = JSONObject.parseObject(data);
        JsonResultBean result = storageService.orderAochenStorage(obj);
        return result;
    }

    @PostMapping("/api/checkAochenOrder")
    public JsonResultBean checkAochenOrder(@RequestParam("data") String data)
    {
        JSONObject obj = JSONObject.parseObject(data);
        JsonResultBean result = storageService.checkAochenOrder(obj);
        return result;
    }
    @PostMapping("/api/createShipment")
    public JsonResultBean createShipment(@RequestParam("data") String data)
    {
        JSONObject obj = JSONObject.parseObject(data);
        String courier = obj.getString("courier");
        JsonResultBean result = null;
        if(courier.equals("allied")) {
            result = alliedService.createAlliedShipment(obj);
        } else if(courier.equals("fasthorse")) {
            result = fastHorseService.createFastHorseShipment(obj);
        }
        if(courier.equals("allied_local")) {
            result = alliedLocalCourierService.createAlliedShipment(obj);
        }
        if(courier.equals("imile")) {
            result = iMileService.createIMileShipment(obj);
    }
        return result;
    }

    @PostMapping("/api/canDeliverImile")
    public JsonResultBean canDeliverImile(@RequestParam("data") String data)
    {
        JSONObject obj = JSONObject.parseObject(data);
        String courier = obj.getString("courier");
        JsonResultBean result = null;
        if(courier.equals("imile")) {
            result = iMileService.canDeliverImile(obj);
        }
        return result;
    }

    @PostMapping("/api/getAlliedCharge")
    public JsonResultBean getAlliedCharge(@RequestParam("data") String data)
    {
        JSONObject obj = JSONObject.parseObject(data);
        String courier = obj.getString("courier");
        JsonResultBean result = null;
        if(courier.equals("allied")) {
            result = alliedService.getAlliedCharge(obj);
        }
        if(courier.equals("allied_local")) {
            result = alliedLocalCourierService.getAlliedCharge(obj);
        }
        return result;
    }

    @PostMapping("/api/manifestShipment")
    public JsonResultBean manifestShipment(@RequestParam("data") String data)
    {
        JSONObject obj = JSONObject.parseObject(data);
        String courier = obj.getString("courier");
        JsonResultBean result = null;
        if(courier.equals("allied")) {
            result = alliedService.manifestAllied(obj);
        } else if (courier.equals("fasthorse")) {
            result = fastHorseService.manifestFastHorse(obj);

        }
        if(courier.equals("allied_local")) {
            result = alliedLocalCourierService.manifestAllied(obj);
        }
        if(courier.equals("imile")){
            result= iMileService.createOrder(obj);
        }
        return result;
    }

    @PostMapping("/api/trackShipment")
    public JsonResultBean trackShipment(@RequestParam("data") String data)
    {
        JSONObject obj = JSONObject.parseObject(data);
        String courier = obj.getString("courier");
        JsonResultBean result = null;
        if(courier.equals("allied")) {
            result = alliedService.trackAllied(obj);
        }
        if(courier.equals("allied_local")) {
            result = alliedLocalCourierService.trackAllied(obj);
        }
        if(courier.equals("imile")){
            result= iMileService.trackList(obj);
        }
        return result;
    }

    @PostMapping("/api/cancelShipment")
    public JsonResultBean cancelShipment(@RequestParam("data") String data)
    {
        JSONObject obj = JSONObject.parseObject(data);
        String courier = obj.getString("courier");
        JsonResultBean result = null;
        if(courier.equals("allied")) {
            result = alliedService.cancelAllied(obj);
        }

        return result;
    }

    @PostMapping("/api/getDistanceBetweenPostcode")
    public JsonResultBean getDistanceBetweenPostcode(@RequestParam("data") String data)
    {
        JSONObject obj = JSONObject.parseObject(data);
        Integer warehouse =(Integer) obj.get("warehouse");
        String destination= obj.getString("destination");

        Integer distance = googleMapAPIService.getDistanceBetweenPostcode(warehouse,destination);
        JsonResultBean result = new JsonResultBean();
        DataBean dataBean = new DataBean();
        result.setData(dataBean);
        result.setSuccess();
        dataBean.setData(distance);
        return result;
    }

    @PostMapping("/api/getDistance")
    public JsonResultBean getDistance() {
        ApiAddrBean addr = new ApiAddrBean();
        addr.setDptId(106);
        addr.setPostcode("3026");
        addr.setSuburb("DERRIMUT");
        addr.setState("VIC");
        addr.setCountry("Australia");
        Integer distance = googleMapAPIService.getDistance(addr);
        // Return a response
        JsonResultBean result = new JsonResultBean();
        result.setData(distance);
        result.setSuccess();
        return result;
    }

    @PostMapping("/api/getAddress")
    public JsonResultBean getAddress() {
        ApiAddrBean addr = new ApiAddrBean();
        addr.setDptId(106);
        addr.setPostcode("2200");
        addr.setSuburb("BANKSTOWN");
        addr.setState("NSW");
        addr.setCountry("Australia");
        addr.setAddress("20 Restwell St");

        // 设定额外参数
        boolean missPostcode = false; // 设置为true或false，视情况而定
        boolean isBreak = false; // 设置为true或false，视情况而定

        // 调用服务方法，传递地址信息和额外参数
        Map<String, Object> addressData = googleMapAPIService.getAddress(addr, "Australia", missPostcode, isBreak);

        // 处理服务方法的返回数据
        JsonResultBean result = new JsonResultBean();
        DataBean dataBean = new DataBean();
        result.setData(dataBean);
        dataBean.setData(addressData);
        result.setSuccess();
        return result;
    }

    @PostMapping("/api/correctAddress")
    public JsonResultBean correctAddress(@RequestParam("streetLine") String streetLine,
                                         @RequestParam("suburb") String suburb,
                                         @RequestParam("state") String state,
                                         @RequestParam("postcode") String postcode,
                                         @RequestParam(value = "country", defaultValue = "Australia") String country,
                                         @RequestParam(value = "missPostcode", defaultValue = "false") boolean missPostcode,
                                         @RequestParam(value = "returnError", defaultValue = "false") boolean returnError) {

        // 调用服务方法，传递地址信息和额外参数
        Map<String, Object> addressData = googleMapAPIService.correctAddress(streetLine, suburb, state, postcode, country, missPostcode, returnError);

        // 处理服务方法的返回数据
        JsonResultBean result = new JsonResultBean();
        DataBean dataBean = new DataBean();
        result.setData(dataBean);
        dataBean.setData(addressData);
        result.setSuccess();
        return result;
    }

    @PostMapping("/api/cancelFastHorseOrder")
    public JsonResultBean cancelFastHorseOrder(@RequestParam("data") String data)
    {
        JSONObject obj = JSONObject.parseObject(data);
        JsonResultBean result = fastHorseService.cancelFastHorse(obj);
        return result;
    }

    @PostMapping("/api/decryptFastHorseOrder")
    public JsonResultBean decryptFastHorseOrder(@RequestParam("data") String data) throws Exception {
        JSONObject obj = JSONObject.parseObject(data);
        JsonResultBean result = fastHorseService.trackFastHorse(obj);
        return result;
    }
}
