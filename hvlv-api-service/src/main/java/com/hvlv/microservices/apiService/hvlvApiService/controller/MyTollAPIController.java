package com.hvlv.microservices.apiService.hvlvApiService.controller;

import com.hvlv.microservices.apiService.hvlvApiService.beans.DataBean;
import com.hvlv.microservices.apiService.hvlvApiService.beans.JsonResultBean;
import com.hvlv.microservices.apiService.hvlvApiService.client.LabelClient;
import com.hvlv.microservices.apiService.hvlvApiService.myToll.Addr;
import com.hvlv.microservices.apiService.hvlvApiService.myToll.Shipment;
import com.hvlv.microservices.apiService.hvlvApiService.service.MyTollAPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.fastjson.JSONObject;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
public class MyTollAPIController {

    @Autowired
    Environment environment;

    @Autowired
    LabelClient labelClient;
    @PostMapping("/myToll/manifestShipment")
    public JsonResultBean manifestShipment(@RequestParam("data") String data) {
        MyTollAPIService myTollAPIService = new MyTollAPIService(labelClient);
//        {
//            "ref": "8865980003540",
//                "cnee": {
//            "company": "Independent Warehouse Solutions",
//                    "address": "8 Enterprise Pl",
//                    "suburb": "Wetherill Park",
//                    "postcode": "2164",
//                    "state": "NSW",
//                    "name": "julia",
//                    "tel": "0493164795"
//        },
//            "cbm": 0.956385,
//                "weight": 152.20,
//                "pkg": 1,
//                "meta": {
//            "barcode": "00093275102543153473"
//        },
//            "packages": [
//            {
//                "weight": 10.100,
//                    "length": 10.000,
//                    "height": 10.000,
//                    "width": 10.000,
//                    "reference": 0,
//                    "cbm": 0.112500
//            }
//  ],
//            "courierId":1007,
//}
        try {
            // 解析传入的JSON字符串
            JSONObject jsonObject = JSONObject.parseObject(data);

            // 从JSON中获取所需的属性值
            String ref = jsonObject.getString("ref");
            String company = jsonObject.getJSONObject("cnee").getString("company");
            String address = jsonObject.getJSONObject("cnee").getString("address");
            String suburb = jsonObject.getJSONObject("cnee").getString("suburb");
            String postcode = jsonObject.getJSONObject("cnee").getString("postcode");
            String state = jsonObject.getJSONObject("cnee").getString("state");
            String name = jsonObject.getJSONObject("cnee").getString("name");
            String tel = jsonObject.getJSONObject("cnee").getString("tel");
            BigDecimal cbm = jsonObject.getBigDecimal("cbm");
            BigDecimal weight = jsonObject.getBigDecimal("weight");
            int pkg = jsonObject.getInteger("pkg");
            String barcodeValue = jsonObject.getJSONObject("meta").getString("barcode");
            String packages = jsonObject.getJSONArray("packages").toJSONString();
            Integer courierId = jsonObject.getInteger("courierId");
            MyTollAPIService  myTollAPI = myTollAPIService.getAPIInstance(courierId);
            // 创建Shipment对象并设置属性
            Shipment shipment = new Shipment();
            shipment.setRef(ref);
            Addr addr = new Addr();
            addr.setCompany(company);
            addr.setAddress(address);
            addr.setSuburb(suburb);
            addr.setPostcode(postcode);
            addr.setState(state);
            addr.setName(name);
            addr.setTel(tel);
            shipment.setCnee(addr);
            shipment.setCbm(cbm);
            shipment.setWeight(weight);
            shipment.setPkg(pkg);
            shipment.setMeta("{\"barcode\":\"" + barcodeValue + "\"}");
            shipment.setPackages(packages);
            // 创建Shipments列表并添加Shipment对象
            List<Shipment> shipments = new ArrayList<>();
            shipments.add(shipment);
            String manifestResult = myTollAPI.manifestShipment(shipments);
            JSONObject manifestObject = JSONObject.parseObject(manifestResult);
            JsonResultBean result = new JsonResultBean();
            result.setSuccess();
            DataBean dataBean = new DataBean();
            result.setData(dataBean);
            dataBean.setData(manifestObject);
            return result;
        } catch (Exception e) {
            JsonResultBean response = new JsonResultBean();
            response.setSuccess();
            response.setMsg("Error creating shipments: " + e.getMessage());
            return response;
        }

    }

    @PostMapping("/myToll/trackingShipment")
    public JsonResultBean trackingShipment(@RequestParam("data") String data) {
        //{"barcode":"00093275102543153473","courierId":1007}
        MyTollAPIService myTollAPIService = new MyTollAPIService(labelClient);
        try {
            // 解析传入的JSON字符串
            JSONObject jsonObject = JSONObject.parseObject(data);
            Integer courierId = jsonObject.getInteger("courierId");
            MyTollAPIService  myTollAPI = myTollAPIService.getAPIInstance(courierId);
            JSONObject trackingShipmentResult = myTollAPI.trackingShipment(data);
            JsonResultBean result = new JsonResultBean();
            result.setSuccess();
            DataBean dataBean = new DataBean();
            result.setData(dataBean);
            dataBean.setData(trackingShipmentResult);
            return result;
        } catch (Exception e) {
            JsonResultBean response = new JsonResultBean();
            response.setSuccess();
            response.setMsg("Error creating shipments: " + e.getMessage());
            return response;
        }
    }
    @PostMapping("/myToll/createShipment")
    public JsonResultBean createShipment(@RequestParam("data")String data){
        //{"pkg":2,"courierId":1007}
        MyTollAPIService myTollAPIService = new MyTollAPIService(labelClient);
        try {
            // 解析传入的JSON字符串
            JSONObject jsonObject = JSONObject.parseObject(data);
            Integer courierId = jsonObject.getInteger("courierId");
            MyTollAPIService  myTollAPI = myTollAPIService.getAPIInstance(courierId);
            // 创建Shipment对象并设置属性
            Shipment shipment = new Shipment();
            int pkg = jsonObject.getInteger("pkg");
            shipment.setPkg(pkg);
            JSONObject createShipmentResult = myTollAPI.createShipment(shipment);
            JsonResultBean result = new JsonResultBean();
            result.setSuccess();
            DataBean dataBean = new DataBean();
            result.setData(dataBean);
            dataBean.setData(createShipmentResult);
            return result;
        } catch (Exception e) {
            JsonResultBean response = new JsonResultBean();
            response.setSuccess();
            response.setMsg("Error creating shipments: " + e.getMessage());
            return response;
        }
    }
}
