package com.hvlv.microservices.apiService.hvlvApiService.controller;

import com.alibaba.fastjson.JSONObject;
import com.hvlv.microservices.apiService.hvlvApiService.beans.Addr;
import com.hvlv.microservices.apiService.hvlvApiService.beans.DataBean;
import com.hvlv.microservices.apiService.hvlvApiService.beans.JsonResultBean;
import com.hvlv.microservices.apiService.hvlvApiService.beans.ShipmentBean;
import com.hvlv.microservices.apiService.hvlvApiService.client.LabelClient;
import com.hvlv.microservices.apiService.hvlvApiService.service.FastwayAPIService;
import com.hvlv.microservices.apiService.hvlvApiService.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class FastwayAPIController {
    @Autowired
    Environment environment;

    @Autowired
    LabelClient labelClient;
    @Autowired
    RedisService redisService;

    @PostMapping("/fastway/ftpManifest")
    public JsonResultBean ftpManifest(@RequestParam("data") String data) {
//        {
//            "id":123456,
//            "Charge_wt": 5.5,
//            "Weight": 6.6,
//            "Cbm": 7.7,
//            "Chargecode": "CC123",
//            "Charge_cbm": 8.8,
//            "Pkg": 5,
//            "Currency": 1,
//            "Dvalue": 100.5,
//            "Cref": "CREF123",
//            "Hbn": "TSN3321139653",
//            "Ref": "8865980001032",
//            "Cbwf": 101,
//            "Agent_id": 102,
//            "No": "NO123",
//            "Meta": {},
//            "Address": "456 Another Street",
//            "Cnee": {
//                "Name": "John Doe",
//                "Company": "JDoe Inc.",
//                "Address": "123 Street",
//                "Suburb": "bankstown",
//                "Postcode": "2200",
//                "Tel": "1234567890",
//                "Email": "donotreply@toplogistics.com.au"
//            }
//        }
        FastwayAPIService fastwayAPIService = new FastwayAPIService(true,true,"syd",labelClient,redisService);

        try {
            // 解析传入的JSON字符串
            JSONObject jsonObject = JSONObject.parseObject(data);

            ShipmentBean shipmentBean = new ShipmentBean();
            shipmentBean.setId(jsonObject.getInteger("id"));
            shipmentBean.setCharge_wt(jsonObject.getDoubleValue("Charge_wt"));
            shipmentBean.setWeight(jsonObject.getDoubleValue("Weight"));
            shipmentBean.setCbm(jsonObject.getDoubleValue("Cbm"));
            shipmentBean.setChargecode(jsonObject.getString("Chargecode"));
            shipmentBean.setCharge_cbm(jsonObject.getDoubleValue("Charge_cbm"));

            JSONObject cneeJson = jsonObject.getJSONObject("Cnee");

            Addr cnee = new Addr();
            cnee.setName(cneeJson.getString("Name"));
            cnee.setCompany(cneeJson.getString("Company"));
            cnee.setAddress(cneeJson.getString("Address"));
            cnee.setSuburb(cneeJson.getString("Suburb"));
            cnee.setPostcode(cneeJson.getString("Postcode"));
            cnee.setTel(cneeJson.getString("Tel"));
            cnee.setEmail(cneeJson.getString("Email"));
            shipmentBean.setCnee(cnee);

            shipmentBean.setPkg(jsonObject.getIntValue("Pkg"));
            shipmentBean.setCurrency((byte)jsonObject.getIntValue("Currency"));
            shipmentBean.setDvalue(jsonObject.getBigDecimal("Dvalue"));
            shipmentBean.setCref(jsonObject.getString("Cref"));
            shipmentBean.setHbn(jsonObject.getString("Hbn"));
            shipmentBean.setRef(jsonObject.getString("Ref"));
            shipmentBean.setCbwf(jsonObject.getInteger("Cbwf"));
            shipmentBean.setAgent_id(jsonObject.getIntValue("Agent_id"));
            shipmentBean.setNo(jsonObject.getString("No"));
            shipmentBean.setMeta(jsonObject.getJSONObject("Meta"));
            shipmentBean.setAddress(jsonObject.getString("Address"));
            List<ShipmentBean> ss = new ArrayList<>();
            ss.add(shipmentBean);

            boolean ftpManifestResult = fastwayAPIService.ftpManifest(ss);
            JsonResultBean result = new JsonResultBean();
            result.setSuccess();
            DataBean dataBean = new DataBean();
            result.setData(dataBean);
            dataBean.setData(ftpManifestResult);
            return result;
        } catch (Exception e) {
            JsonResultBean response = new JsonResultBean();
            response.setSuccess();
            response.setMsg("Error creating shipments: " + e.getMessage());
            return response;
        }
    }

    @PostMapping("/fastway/weCanDelivery")
    public JsonResultBean weCanDelivery(@RequestParam("data") String data) {
//        {
//            "id":123456,
//            "Charge_wt": 5.5,
//            "Weight": 6.6,
//            "Cbm": 7.7,
//            "Chargecode": "CC123",
//            "Charge_cbm": 8.8,
//            "Pkg": 5,
//            "Currency": 1,
//            "Dvalue": 100.5,
//            "Cref": "CREF123",
//            "Hbn": "TSN3321139653",
//            "Ref": "8865980001032",
//            "Cbwf": 101,
//            "Agent_id": 102,
//            "No": "NO123",
//            "Meta": {},
//            "Address": "456 Another Street",
//            "Cnee": {
//                "Name": "John Doe",
//                "Company": "JDoe Inc.",
//                "Address": "123 Street",
//                "Suburb": "bankstown",
//                "Postcode": "2200",
//                "Tel": "1234567890",
//                "Email": "johndoe@example.com"
//            }
//        }
        FastwayAPIService fastwayAPIService = new FastwayAPIService(true,true,"syd",labelClient,redisService);

        try {
            // 解析传入的JSON字符串
            JSONObject jsonObject = JSONObject.parseObject(data);

            ShipmentBean shipmentBean = new ShipmentBean();
            shipmentBean.setId(jsonObject.getInteger("id"));
            shipmentBean.setCharge_wt(jsonObject.getDoubleValue("Charge_wt"));
            shipmentBean.setWeight(jsonObject.getDoubleValue("Weight"));
            shipmentBean.setCbm(jsonObject.getDoubleValue("Cbm"));
            shipmentBean.setChargecode(jsonObject.getString("Chargecode"));
            shipmentBean.setCharge_cbm(jsonObject.getDoubleValue("Charge_cbm"));

            JSONObject cneeJson = jsonObject.getJSONObject("Cnee");

            Addr cnee = new Addr();
            cnee.setName(cneeJson.getString("Name"));
            cnee.setCompany(cneeJson.getString("Company"));
            cnee.setAddress(cneeJson.getString("Address"));
            cnee.setSuburb(cneeJson.getString("Suburb"));
            cnee.setPostcode(cneeJson.getString("Postcode"));
            cnee.setTel(cneeJson.getString("Tel"));
            cnee.setEmail(cneeJson.getString("Email"));
            shipmentBean.setCnee(cnee);

            shipmentBean.setPkg(jsonObject.getIntValue("Pkg"));
            shipmentBean.setCurrency((byte)jsonObject.getIntValue("Currency"));
            shipmentBean.setDvalue(jsonObject.getBigDecimal("Dvalue"));
            shipmentBean.setCref(jsonObject.getString("Cref"));
            shipmentBean.setHbn(jsonObject.getString("Hbn"));
            shipmentBean.setRef(jsonObject.getString("Ref"));
            shipmentBean.setCbwf(jsonObject.getInteger("Cbwf"));
            shipmentBean.setAgent_id(jsonObject.getIntValue("Agent_id"));
            shipmentBean.setNo(jsonObject.getString("No"));
            shipmentBean.setMeta(jsonObject.getJSONObject("Meta"));
            shipmentBean.setAddress(jsonObject.getString("Address"));
            List<ShipmentBean> ss = new ArrayList<>();
            ss.add(shipmentBean);

            boolean weCanDeliveryResult = fastwayAPIService.weCanDelivery(shipmentBean);
            JsonResultBean result = new JsonResultBean();
            result.setSuccess();
            DataBean dataBean = new DataBean();
            result.setData(dataBean);
            dataBean.setData(weCanDeliveryResult);
            return result;
        } catch (Exception e) {
            JsonResultBean response = new JsonResultBean();
            response.setSuccess();
            response.setMsg("Error creating shipments: " + e.getMessage());
            return response;
        }
    }
    @PostMapping("/fastway/addConsignment")
    public JsonResultBean addConsignment(@RequestParam("data") String data) {
//        {
//            "id":123456,
//            "Charge_wt": 5.5,
//            "Weight": 6.6,
//            "Cbm": 7.7,
//            "Chargecode": "CC123",
//            "Charge_cbm": 8.8,
//            "Pkg": 5,
//            "Currency": 1,
//            "Dvalue": 100.5,
//            "Cref": "CREF123",
//            "Hbn": "TSN3321139653",
//            "Ref": "8865980001032",
//            "Cbwf": 101,
//            "Agent_id": 102,
//            "No": "NO123",
//            "Meta": {},
//            "Address": "456 Another Street",
//            "Cnee": {
//                "Name": "John Doe",
//                "Company": "JDoe Inc.",
//                "Address": "123 Street",
//                "Suburb": "bankstown",
//                "Postcode": "2200",
//                "Tel": "1234567890",
//                "Email": "johndoe@example.com"
//            }
//        }
        FastwayAPIService fastwayAPIService = new FastwayAPIService(true,true,"syd",labelClient,redisService);

        try {
            // 解析传入的JSON字符串
            JSONObject jsonObject = JSONObject.parseObject(data);

            ShipmentBean shipmentBean = new ShipmentBean();
            shipmentBean.setId(jsonObject.getInteger("id"));
            shipmentBean.setCharge_wt(jsonObject.getDoubleValue("Charge_wt"));
            shipmentBean.setWeight(jsonObject.getDoubleValue("Weight"));
            shipmentBean.setCbm(jsonObject.getDoubleValue("Cbm"));
            shipmentBean.setChargecode(jsonObject.getString("Chargecode"));
            shipmentBean.setCharge_cbm(jsonObject.getDoubleValue("Charge_cbm"));
            JSONObject cneeJson = jsonObject.getJSONObject("Cnee");

            Addr cnee = new Addr();
            cnee.setName(cneeJson.getString("Name"));
            cnee.setCompany(cneeJson.getString("Company"));
            cnee.setAddress(cneeJson.getString("Address"));
            cnee.setSuburb(cneeJson.getString("Suburb"));
            cnee.setPostcode(cneeJson.getString("Postcode"));
            cnee.setTel(cneeJson.getString("Tel"));
            cnee.setEmail(cneeJson.getString("Email"));
            shipmentBean.setCnee(cnee);

            shipmentBean.setPkg(jsonObject.getIntValue("Pkg"));
            shipmentBean.setCurrency((byte)jsonObject.getIntValue("Currency"));
            shipmentBean.setDvalue(jsonObject.getBigDecimal("Dvalue"));
            shipmentBean.setCref(jsonObject.getString("Cref"));
            shipmentBean.setHbn(jsonObject.getString("Hbn"));
            shipmentBean.setRef(jsonObject.getString("Ref"));
            shipmentBean.setCbwf(jsonObject.getInteger("Cbwf"));
            shipmentBean.setAgent_id(jsonObject.getIntValue("Agent_id"));
            shipmentBean.setNo(jsonObject.getString("No"));
            shipmentBean.setMeta(jsonObject.getJSONObject("Meta"));
            shipmentBean.setAddress(jsonObject.getString("Address"));
            List<ShipmentBean> ss = new ArrayList<>();
            ss.add(shipmentBean);

            String addConsignmentResult = fastwayAPIService.addConsignment(shipmentBean);
            JsonResultBean result = new JsonResultBean();
            result.setSuccess();
            DataBean dataBean = new DataBean();
            result.setData(dataBean);
            dataBean.setData(addConsignmentResult);
            return result;
        } catch (Exception e) {
            JsonResultBean response = new JsonResultBean();
            response.setSuccess();
            response.setMsg("Error creating shipments: " + e.getMessage());
            return response;
        }
    }

    @PostMapping("/fastway/sortingCode")
    public JsonResultBean sortingCode(@RequestParam("data") String data) {
        FastwayAPIService fastwayAPIService = new FastwayAPIService(true,true,"syd",labelClient,redisService);
        try {
            // 解析传入的JSON字符串
            JSONObject jsonObject = JSONObject.parseObject(data);
            String postcode = jsonObject.getString("postcode");
            String suburb = jsonObject.getString("suburb");

            String sortingCodeResult = fastwayAPIService.sortingCode(postcode,suburb);
            JsonResultBean result = new JsonResultBean();
            result.setSuccess();
            DataBean dataBean = new DataBean();
            result.setData(dataBean);
            dataBean.setData(sortingCodeResult);
            return result;
        } catch (Exception e) {
            JsonResultBean response = new JsonResultBean();
            response.setSuccess();
            response.setMsg("Error creating shipments: " + e.getMessage());
            return response;
        }
    }

    @PostMapping("/fastway/genNumber")
    public JsonResultBean sortingCode() {
        FastwayAPIService fastwayAPIService = new FastwayAPIService(true,true,"syd",labelClient,redisService);
        try {
            String genNumberResult = fastwayAPIService.genNumber();
            JsonResultBean result = new JsonResultBean();
            result.setSuccess();
            DataBean dataBean = new DataBean();
            result.setData(dataBean);
            dataBean.setData(genNumberResult);
            return result;
        } catch (Exception e) {
            JsonResultBean response = new JsonResultBean();
            response.setSuccess();
            response.setMsg("Error creating shipments: " + e.getMessage());
            return response;
        }
    }

}

