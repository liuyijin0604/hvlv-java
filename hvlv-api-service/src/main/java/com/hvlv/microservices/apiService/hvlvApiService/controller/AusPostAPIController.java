package com.hvlv.microservices.apiService.hvlvApiService.controller;

import com.alibaba.fastjson.JSONException;
import com.hvlv.microservices.apiService.hvlvApiService.beans.DataBean;
import com.hvlv.microservices.apiService.hvlvApiService.beans.JsonResultBean;

import com.hvlv.microservices.apiService.hvlvApiService.service.AusPostAPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class AusPostAPIController {

    @Autowired
    Environment environment;
    @Autowired
    AusPostAPIService ausPostAPIService;

    @PostMapping("/ausPost/getAccounts")
    public JsonResultBean ausPostGetAccounts() throws Exception {
        String id_test="1014445357";
        Map<String, Object> addressData = ausPostAPIService.getAccounts(id_test);

        // 处理服务方法的返回数据
        JsonResultBean result = new JsonResultBean();
        DataBean dataBean = new DataBean();
        result.setData(dataBean);
        dataBean.setData(addressData);
        result.setSuccess();
        return result;
    }
    @PostMapping("/ausPost/validateAddress")
    public JsonResultBean validateAddress(
            @RequestParam String suburb,
            @RequestParam String state,
            @RequestParam String postcode) {
        int validationResult = ausPostAPIService.validateAddress(suburb, state, postcode);

        // 处理服务方法的返回数据
        JsonResultBean result = new JsonResultBean();
        DataBean dataBean = new DataBean();

        if (validationResult == 1) {
            dataBean.setStatus(1);
            dataBean.setMsg("Address is valid.");
        } else if (validationResult == 0) {
            dataBean.setStatus(0);
            dataBean.setMsg("Address is invalid.");
        } else {
            dataBean.setStatus(0);
            dataBean.setMsg("Address validation failed.");
        }
        result.setData(dataBean);
        result.setSuccess();
        return result;
    }
    @PostMapping("/ausPost/getItemPrices")
    public JsonResultBean getItemPrices(
            @RequestParam("pcFrom") String pcFrom,
            @RequestParam("pcTo") String pcTo,
            @RequestParam("weight") double weight,
            @RequestParam(value = "dim", required = false) double[] dim) {

        Map<String, Object> itemPricesData = ausPostAPIService.getItemPrices(pcFrom, pcTo, weight, dim);

        JsonResultBean result = new JsonResultBean();
        DataBean dataBean = new DataBean();
        result.setData(dataBean);
        dataBean.setData(itemPricesData);

        if (itemPricesData != null) {
            dataBean.setStatus(1);
        } else {
            dataBean.setStatus(0);
        }
        result.setSuccess();
        return result;
    }

    @PostMapping("/ausPost/getShipments")
    public JsonResultBean getShipments(
            @RequestParam(value = "ids", required = false) String ids,
            @RequestParam(value = "offset", required = false) String offset,
            @RequestParam(value = "nos", required = false) String nos,
            @RequestParam(value = "status", required = false) String status) {

        try {
            Map<String, Object> shipmentsData = ausPostAPIService.getShipments(ids, offset, nos, status);

            JsonResultBean result = new JsonResultBean();
            result.setSuccess();
            DataBean dataBean = new DataBean();
            result.setData(dataBean);
            dataBean.setData(shipmentsData);

            if (shipmentsData != null) {
                dataBean.setStatus(1);
            } else {
                dataBean.setStatus(0);
            }
            return result;
        } catch (Exception e) {
            // 处理异常情况，可以返回适当的错误信息
            JsonResultBean result = new JsonResultBean();
            result.setError();
            return result;
        }
    }
    @PostMapping("/ausPost/createShipments")
    public JsonResultBean createShipments(@RequestParam("data") String data) throws JSONException {

        JSONObject jsonData =  JSONObject.parseObject(data);
        // Extract values from jsonData
        String cref = jsonData.getString("cref");
        String cnorName = jsonData.getJSONObject("cnor").getString("name");
        String cneeCountry = jsonData.getJSONObject("cnee").getString("country");
        String cneeName = jsonData.getJSONObject("cnee").getString("name");
        String cneeCompany = jsonData.getJSONObject("cnee").getString("company");
        String cneeAddress = jsonData.getJSONObject("cnee").getString("address");
        String cneeCity = jsonData.getJSONObject("cnee").getString("city");
        String cneeSuburb = jsonData.getJSONObject("cnee").getString("suburb");
        String cneeState = jsonData.getJSONObject("cnee").getString("state");
        int cneePostcode = jsonData.getJSONObject("cnee").getInteger("postcode");
        String cneeTel = jsonData.getJSONObject("cnee").getString("tel");
        int pkg = jsonData.getInteger("pkg");
        double weight = jsonData.getDouble("weight");
        double insurance = jsonData.getDouble("insurance");
        String eitemsHs = jsonData.getJSONArray("eitems").getJSONObject(0).getString("hs");
        String eitemsM = jsonData.getJSONArray("eitems").getJSONObject(0).getString("m");
        String eitemsG = jsonData.getString("eitems_g");
        String ref = jsonData.getString("ref");
        String classificationType = jsonData.getString("classification_type");
        String prod = jsonData.getString("prod");
        // Create a Map to hold the extracted data
        Map<String, Object> p = new HashMap<>();
        p.put("hbn", "shipment reference 1");
        p.put("cref", cref);
        p.put("cnor.name", cnorName);
        p.put("cnee.country", cneeCountry);
        p.put("cnee.name", cneeName);
        p.put("cnee.company", cneeCompany);
        p.put("cnee.address", cneeAddress);
        p.put("cnee.city", cneeCity);
        p.put("cnee.suburb", cneeSuburb);
        p.put("cnee.state", cneeState);
        p.put("cnee.postcode", cneePostcode);
        p.put("cnee.tel", cneeTel);
        p.put("pkg", pkg);
        p.put("weight", weight);
        p.put("insurance", insurance);
        p.put("eitems.hs[0]", eitemsHs);
        p.put("eitems.m[0]", eitemsM);
        p.put("eitems.g", eitemsG);
        p.put("ref", ref);
        p.put("classification_type", classificationType);

        try {
            Map<String, Object> createShipment = ausPostAPIService.createShipments(p, prod);
            // 构建成功的响应
            JsonResultBean result = new JsonResultBean();
            result.setSuccess();
            DataBean dataBean = new DataBean();
            result.setData(dataBean);
            dataBean.setData(createShipment);
            return result;
        } catch (Exception e) {
            // 处理异常情况
            JsonResultBean response = new JsonResultBean();
            response.setSuccess();
            response.setMsg("Error creating shipments: " + e.getMessage());
            return response;
        }
    }
    @PostMapping("/ausPost/createIntShipments")
    public JsonResultBean createIntShipments(@RequestParam("data") String data) throws JSONException {
//        {
//            "hbn":"shipment reference 1",
//                "cref":"7890",
//                "cnor.name":"Your Company",
//                "cnee.country":"NZ",
//                "cnee.name":"Jane Buyer",
//                "cnee.company":"ABC Inc.",
//                "cnee.address":"5 Main Street",
//                "cnee.city":"Karori",
//                "cnee.suburb":"Suburb",
//                "cnee.state":"WLG",
//                "cnee.postcode":6012,
//                "cnee.tel":"555-123-4567",
//                "pkg":1,
//                "weight":5.5,
//                "insurance":9.5,
//                "eitems.hs[0]":"123456",
//                "eitems.m[0]":"Category A",
//                "eitems.g":"Product Description",
//                "ref":"REF123",
//                "classification_type":"OTHER",
//                "prod":"PTI8"
//        }
        Map<String, Object> p = new HashMap<>();
        // Parse the JSON data string
        JSONObject jsonData = JSONObject.parseObject(data);
        // Extract and populate the map
        p.put("hbn", jsonData.getString("hbn"));
        p.put("cref", jsonData.getString("cref"));

        p.put("cnor.name", jsonData.getString("cnor.name"));

        p.put("cnee.country", jsonData.getString("cnee.country"));
        p.put("cnee.name", jsonData.getString("cnee.name"));
        p.put("cnee.company", jsonData.getString("cnee.company"));
        p.put("cnee.address", jsonData.getString("cnee.address"));
        p.put("cnee.city", jsonData.getString("cnee.city"));
        p.put("cnee.suburb", jsonData.getString("cnee.suburb"));
        p.put("cnee.state", jsonData.getString("cnee.state"));
        p.put("cnee.postcode", jsonData.getInteger("cnee.postcode"));
        p.put("cnee.tel", jsonData.getString("cnee.tel"));

        p.put("pkg", jsonData.getInteger("pkg"));
        p.put("weight", jsonData.getDouble("weight"));
        p.put("insurance", jsonData.getDouble("insurance"));

        p.put("eitems.hs[0]", jsonData.getString("eitems.hs[0]"));
        p.put("eitems.m[0]", jsonData.getString("eitems.m[0]"));
        p.put("eitems.g", jsonData.getString("eitems.g"));

        p.put("ref", jsonData.getString("ref"));
        p.put("classification_type", jsonData.getString("classification_type"));
        String prod =jsonData.getString("prod");
        try {
            Map<String, Object> createShipment = ausPostAPIService.createIntShipments(p, prod);
            // 构建成功的响应
            JsonResultBean result = new JsonResultBean();
            result.setSuccess();
            DataBean dataBean = new DataBean();
            result.setData(dataBean);
            dataBean.setData(createShipment);
            return result;
        } catch (Exception e) {
            // 处理异常情况
            JsonResultBean response = new JsonResultBean();
            response.setSuccess();
            response.setMsg("Error creating shipments: " + e.getMessage());
            return response;
        }
    }

    @PostMapping("/ausPost/updateShipment")
    public JsonResultBean updateShipment() {
        String prod = "7E55";
        Map<String, Object> p = new HashMap<>();
        p.put("status", 200);
        p.put("hbn", "shipment reference 1");
        p.put("cref", "7890");
        p.put("cnee.name", "Jane Buyer");
        p.put("cnee.company", "ABC Inc.");
        p.put("cnee.address", "20 restwell Street");
        p.put("cnee.suburb", "Bankstown");
        p.put("cnee.state", "NSW");
        p.put("cnee.postcode", 2200);
        p.put("cnee.tel", "555-123-4567");
        p.put("insurance", 100.50);
        p.put("pkg", 1);
        p.put("length",10);
        p.put("height",10);
        p.put("width",10);
        p.put("weight", 5.5);
        //p.put("ref", "REF123");
        p.put("mdata.ap_consignment_id_suffix", "SUFFIX");

        try {
            Map<String, Object> createShipment = ausPostAPIService.updateShipment("O20K0ENwE6wAAAGKvmICFX4V",p, prod);
            JsonResultBean result = new JsonResultBean();
            result.setSuccess();
            DataBean dataBean = new DataBean();
            result.setData(dataBean);
            dataBean.setData(createShipment);
            return result;
        } catch (Exception e) {
            // 处理异常情况
            JsonResultBean response = new JsonResultBean();
            response.setSuccess();
            response.setMsg("Error creating shipments: " + e.getMessage());
            return response;
        }
    }
    @PostMapping("/ausPost/updateIntShipment")
    public JsonResultBean updateIntShipment() {
        String prod = "qweqwe";
        Map<String, Object> p = new HashMap<>();
        p.put("hbn", "shipment reference 1");
        p.put("cref", "7890");
        p.put("cnee.name", "Jane Buyer");
        p.put("cnee.company", "ABC Inc.");
        p.put("cnee.address", "20 restwell Street");
        p.put("cnee.suburb", "Bankstown");
        p.put("cnee.state", "NSW");
        p.put("cnee.postcode", 2200);
        p.put("cnee.tel", "555-123-4567");
        p.put("insurance", 100.50);
        p.put("pkg", 3);
        p.put("weight", 5.5);
        p.put("ref", "REF123");
        p.put("mdata.ap_consignment_id_suffix", "SUFFIX");

        try {
            Map<String, Object> createShipment = ausPostAPIService.updateIntShipment("O20K0ENwE6wAAAGKvmICFX4V",p, prod);
            JsonResultBean result = new JsonResultBean();
            result.setSuccess();
            DataBean dataBean = new DataBean();
            result.setData(dataBean);
            dataBean.setData(createShipment);
            return result;
        } catch (Exception e) {
            // 处理异常情况
            JsonResultBean response = new JsonResultBean();
            response.setSuccess();
            response.setMsg("Error creating shipments: " + e.getMessage());
            return response;
        }
    }
    @PostMapping("/ausPost/updateItems")
    public JsonResultBean updateItems() {
        String prod = "qweqwe";
        Map<String, Object> p = new HashMap<>();
        p.put("hbn", "shipment reference 1");
        p.put("cref", "7890");
        p.put("cnee.name", "Jane Buyer");
        p.put("cnee.company", "ABC Inc.");
        p.put("cnee.address", "20 restwell Street");
        p.put("cnee.suburb", "Bankstown");
        p.put("cnee.state", "NSW");
        p.put("cnee.postcode", 2200);
        p.put("cnee.tel", "555-123-4567");
        p.put("insurance", 100.50);
        p.put("pkg", 3);
        p.put("weight", 5.5);
        p.put("ref", "REF123");
        p.put("mdata.ap_consignment_id_suffix", "SUFFIX");

        try {
            Map<String, Object> createShipment = ausPostAPIService.updateItems("JS8K0ENwoZgAAAGK.fYCFX4O",p, prod);
            JsonResultBean result = new JsonResultBean();
            result.setSuccess();
            DataBean dataBean = new DataBean();
            result.setData(dataBean);
            dataBean.setData(createShipment);
            return result;
        } catch (Exception e) {
            // 处理异常情况
            JsonResultBean response = new JsonResultBean();
            response.setSuccess();
            response.setMsg("Error creating shipments: " + e.getMessage());
            return response;
        }
    }

    @PostMapping("/ausPost/deleteShipment")
    public JsonResultBean deleteShipment() {
        try {
            Map<String, Object> createShipment = ausPostAPIService.deleteShipment("JS8K0ENwoZgAAAGK.fYCFX4O");
            JsonResultBean result = new JsonResultBean();
            result.setSuccess();
            DataBean dataBean = new DataBean();
            result.setData(dataBean);
            dataBean.setData(createShipment);
            return result;
        } catch (Exception e) {
            JsonResultBean response = new JsonResultBean();
            response.setSuccess();
            response.setMsg("Error creating shipments: " + e.getMessage());
            return response;
        }
    }

    @PostMapping("/ausPost/deleteItem")
    public JsonResultBean deleteItem() {
        try {
            Map<String, Object> createShipment = ausPostAPIService.deleteItem("JS8K0ENwoZgAAAGK.fYCFX4O","oMgK0ENwwnQAAAGK._YCFX4O");
            JsonResultBean result = new JsonResultBean();
            result.setSuccess();
            DataBean dataBean = new DataBean();
            result.setData(dataBean);
            dataBean.setData(createShipment);
            return result;
        } catch (Exception e) {
            JsonResultBean response = new JsonResultBean();
            response.setSuccess();
            response.setMsg("Error creating shipments: " + e.getMessage());
            return response;
        }
    }

    @PostMapping("/ausPost/getOrder")
    public JsonResultBean getOrder() {
        try {
            Map<String, Object> createShipment = ausPostAPIService.getOrder("TB02391761");
            JsonResultBean result = new JsonResultBean();
            result.setSuccess();
            DataBean dataBean = new DataBean();
            result.setData(dataBean);
            dataBean.setData(createShipment);
            return result;
        } catch (Exception e) {
            JsonResultBean response = new JsonResultBean();
            response.setSuccess();
            response.setMsg("Error creating shipments: " + e.getMessage());
            return response;
        }
    }
    @PostMapping("/ausPost/createOrderFromShipments")
    public JsonResultBean createOrderFromShipments() {
        try {
            String ref = "shipment reference 1";
            List<Map<String, Object>> testShipments = new ArrayList<>();

            Map<String, Object> shipment1 = new HashMap<>();
            Map<String, Object> mdata1 = new HashMap<>();
            mdata1.put("ap_sid", "xfEK0ENwB5kAAAGKjtICFYws");
            shipment1.put("mdata", mdata1);
            testShipments.add(shipment1);

            Map<String, Object> createOrder = ausPostAPIService.createOrderFromShipments(testShipments, ref);
            JsonResultBean result = new JsonResultBean();
            result.setSuccess();
            DataBean dataBean = new DataBean();
            result.setData(dataBean);
            dataBean.setData(createOrder);
            return result;
        } catch (Exception e) {
            // 处理异常情况
            JsonResultBean response = new JsonResultBean();
            response.setSuccess();
            response.setMsg("Error creating order from shipments: " + e.getMessage());
            return response;
        }
    }

    @PostMapping("/ausPost/createOrderIncludingShipments")
    public JsonResultBean createOrderIncludingShipments(@RequestParam("data") String data) {
        try {
//            {
//                "ref": "shipment reference 1",
//                    "prod": "7E55",
//                    "shipments": [
//                {
//                    "status": 200,
//                        "hbn": "shipment reference 1",
//                        "cref": "7890",
//                        "cnee.company": "ABC Inc.",
//                        "cnee.address": "20 restwell Street",
//                        "cnee.suburb": "Bankstown",
//                        "cnee.name":"Jane Buyer",
//                        "cnee.state": "NSW",
//                        "cnee.postcode": 2200,
//                        "cnee.tel": "555-123-4567",
//                        "insurance": 100.50,
//                        "pkg": 1,
//                        "length": 10,
//                        "height": 10,
//                        "width": 10,
//                        "weight": 5.5,
//                        "mdata.ap_consignment_id_suffix": "SUFFIX"
//                }
//  ]
//            }

            JSONObject jsonObject = JSON.parseObject(data);

            String ref = jsonObject.getString("ref");
            String prod = jsonObject.getString("prod");
            String shipmentsData = jsonObject.getString("shipments");

            List<Map<String, Object>> testShipments = JSON.parseObject(shipmentsData, new TypeReference<List<Map<String, Object>>>() {});

            Map<String, Object> createOrder = ausPostAPIService.createOrderIncludingShipments(testShipments,ref,prod);
            JsonResultBean result = new JsonResultBean();
            result.setSuccess();
            DataBean dataBean = new DataBean();
            result.setData(dataBean);
            dataBean.setData(createOrder);
            return result;
        } catch (Exception e) {
            // 处理异常情况
            JsonResultBean response = new JsonResultBean();
            response.setSuccess();
            response.setMsg("Error creating order from shipments: " + e.getMessage());
            return response;
        }
    }
    @PostMapping("/ausPost/createOrderIncludingShipments2014")
    public JsonResultBean createOrderIncludingShipments2014() {
        try {
            String ref = "shipment reference 1";
            String prod ="123132132";
            List<Map<String, Object>> testShipments = new ArrayList<>();

            Map<String, Object> p = new HashMap<>();
            p.put("status", 200);
            p.put("hbn", "shipment reference 1");
            p.put("cref", "7890");
            p.put("cnee.name", "Jane Buyer");
            p.put("cnee.company", "ABC Inc.");
            p.put("cnee.address", "20 restwell Street");
            p.put("cnee.suburb", "Bankstown");
            p.put("cnee.state", "NSW");
            p.put("cnee.postcode", 2200);
            p.put("cnee.tel", "555-123-4567");
            p.put("insurance", 100.50);
            p.put("pkg", 3);
            p.put("weight", 5.5);
            p.put("ref", "REF123");
            p.put("mdata.ap_consignment_id_suffix", "SUFFIX");
            testShipments.add(p);

            Map<String, Object> createOrder = ausPostAPIService.createOrderIncludingShipments2014(testShipments,ref,prod);
            JsonResultBean result = new JsonResultBean();
            result.setSuccess();
            DataBean dataBean = new DataBean();
            result.setData(dataBean);
            dataBean.setData(createOrder);
            return result;
        } catch (Exception e) {
            // 处理异常情况
            JsonResultBean response = new JsonResultBean();
            response.setSuccess();
            response.setMsg("Error creating order from shipments: " + e.getMessage());
            return response;
        }
    }
    @PostMapping("/ausPost/getOrderSummary")
    public JsonResultBean getOrderSummary() {
        try {
            String order_id = "TB02391761";
            Map<String, Object> createOrder = ausPostAPIService.getOrderSummary(order_id);
            JsonResultBean result = new JsonResultBean();
            result.setSuccess();
            DataBean dataBean = new DataBean();
            result.setData(dataBean);
            dataBean.setData(createOrder);
            return result;
        } catch (Exception e) {
            // 处理异常情况
            JsonResultBean response = new JsonResultBean();
            response.setSuccess();
            response.setMsg("Error creating order from shipments: " + e.getMessage());
            return response;
        }
    }

    @PostMapping("/ausPost/createLabels")
    public JsonResultBean createLabels() {
        try {
            List<String> ids = new ArrayList<>();

            String newId = "xfEK0ENwB5kAAAGKjtICFYws";
            ids.add(newId);
            String layout = "PDF";
            Map<String, Object> createOrder = ausPostAPIService.createLabels(ids,layout);
            JsonResultBean result = new JsonResultBean();
            result.setSuccess();
            DataBean dataBean = new DataBean();
            result.setData(dataBean);
            dataBean.setData(createOrder);
            return result;
        } catch (Exception e) {
            // 处理异常情况
            JsonResultBean response = new JsonResultBean();
            response.setSuccess();
            response.setMsg("Error creating order from shipments: " + e.getMessage());
            return response;
        }
    }

    @PostMapping("/ausPost/getLabel")
    public JsonResultBean getLabel() {
        try {
            String labelId = "b5bd20fa-f2c0-4ec8-a914-b00ae04baa2f";
            Map<String, Object> createOrder = ausPostAPIService.getLabel(labelId);
            JsonResultBean result = new JsonResultBean();
            result.setSuccess();
            DataBean dataBean = new DataBean();
            result.setData(dataBean);
            dataBean.setData(createOrder);
            return result;
        } catch (Exception e) {
            // 处理异常情况
            JsonResultBean response = new JsonResultBean();
            response.setSuccess();
            response.setMsg("Error creating order from shipments: " + e.getMessage());
            return response;
        }
    }
    @PostMapping("/ausPost/trackItems")
    public JsonResultBean trackItems() {
        List<String> ids = new ArrayList<>();
        String s = "CG100351044AU";
        ids.add(s);
        try {
            Map<String, Object> trackingResult = ausPostAPIService.trackItems(ids);

            JsonResultBean result = new JsonResultBean();
            result.setSuccess();
            DataBean dataBean = new DataBean();
            result.setData(dataBean);
            dataBean.setData(trackingResult);

            return result;
        } catch (Exception e) {
            // 处理异常情况
            JsonResultBean response = new JsonResultBean();
            response.setSuccess();
            response.setMsg("Error tracking items: " + e.getMessage());
            return response;
        }
    }

}
