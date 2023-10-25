package com.hvlv.microservices.apiService.hvlvApiService.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.util.*;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hvlv.microservices.apiService.hvlvApiService.beans.DataBean;
import com.hvlv.microservices.apiService.hvlvApiService.beans.JsonResultBean;
import com.hvlv.microservices.apiService.hvlvApiService.client.LabelClient;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.ObjectMapper;
@Service
public class IMileService {

    private static final String TEST_API_URL = "https://openapi.52imile.cn";
    private static final String PROD_API_URL = "https://openapi.imile.com";
    private static final  String PROD_CustomerId ="C2103769801";
    private static final  String PROD_secretKey ="MIICeAIBADANBgkqhkiG9w0BAQEFAASCAmIwggJeAgEAAoGBAMXIye9V1B0GNVaF";
    private static final  String TEST_CustomerId ="C21018582";
    private static final  String TEST_secretKey ="MIICeAIBADANBgkqhkiG9w0BAQEFAASCAmIwggJeAgEAAoGBANLDzDcUt6Ju4yqR";

    private String apiUrl;
    private String secretKey;
    private String customerId;
    @Autowired
    RedisService redisService;
    @Autowired
    LabelClient labelClient;

    public IMileService() {
        boolean isTest = true;
        this.apiUrl = isTest ? TEST_API_URL : PROD_API_URL;
        this.secretKey = isTest ? TEST_secretKey : PROD_secretKey;
        this.customerId = isTest ? TEST_CustomerId : PROD_CustomerId;
    }

    public JsonResultBean createIMileShipment(JSONObject obj) {
        String accessToken = getAccessToken();
        Map<String, Object> data = new HashMap<>();
        data.put("customerId", customerId);
        data.put("signMethod", "MD5");
        data.put("format", "json");
        data.put("version", "1.0.0");
        data.put("timeZone", "+8");
        data.put("timestamp", String.valueOf(System.currentTimeMillis()));
        data.put("accessToken", accessToken);

        Map<String, Object> modifyData = JSON.parseObject(obj.toJSONString(), Map.class);
        Map<String, Object> consignee = (Map<String, Object>) modifyData.get("consignee");
        Map<String, Object> paramData = new HashMap<>();
        paramData.put("orderCode", modifyData.get("hbn"));
        paramData.put("contacts", consignee.get("phone"));
        paramData.put("phone", consignee.get("phone"));
        paramData.put("country", "AUS");
        paramData.put("city", consignee.get("suburb"));
        paramData.put("suburb", consignee.get("suburb"));
        paramData.put("zipCode", consignee.get("postcode"));
        paramData.put("address", consignee.get("address"));
        data.put("param", paramData);

        String sign = generateSign(data);
        data.put("sign", sign);
        System.out.println(data);
        String labelResponse = request("/client/order/getSortInfo", "POST", data);
        JSONObject labelResponseData = JSONObject.parseObject(labelResponse);

        // Part from createIMileShipment
        LocalDate currentDate = LocalDate.now();
        String month = String.format("%02d", currentDate.getMonthValue());
        String day = String.format("%02d", currentDate.getDayOfMonth());
        String year = String.format("%02d", currentDate.getYear() % 100);
        String newPrefix = obj.getString("prefix") + month + day + year;

        JsonResultBean shipmentResult = labelClient.generateRefByPrefix("{\"prefix\":\"" + newPrefix + "\",\"orgId\":4990}");
        String refValue = null;
        if (shipmentResult.isSuccess()) {
            LinkedHashMap shipmentData = (LinkedHashMap) shipmentResult.getData();
            refValue = (String) shipmentData.get("ref");
        }

        JsonResultBean combinedResult = new JsonResultBean();
        combinedResult.setSuccess();
        JSONObject labelData = labelResponseData.getJSONObject("data");
        if (labelResponseData.getString("code").equals("200") &&
                labelData.getString("zoneCode") != null && !labelData.getString("zoneCode").isEmpty() &&
                labelData.getString("stationShortCode") != null && !labelData.getString("stationShortCode").isEmpty()) {
            combinedResult.setCode("60000");
        }else{combinedResult.setCode("60001");}
        combinedResult.setMsg(labelResponseData.getString("message"));
        if (labelResponseData.containsKey("data") && labelResponseData.get("data") != null) {

            labelData.put("ref", refValue);
            labelData.put("barcode", refValue);
            combinedResult.setData(labelData);
        }
        return combinedResult;
    }

    public JsonResultBean canDeliverImile(JSONObject obj) {
        String accessToken = getAccessToken();
        Map<String, Object> data = new HashMap<>();
        data.put("customerId", customerId);
        data.put("signMethod", "MD5");
        data.put("format", "json");
        data.put("version", "1.0.0");
        data.put("timeZone", "+8");
        data.put("timestamp", String.valueOf(System.currentTimeMillis()));
        data.put("accessToken", accessToken);

        Map<String, Object> modifyData = JSON.parseObject(obj.toJSONString(), Map.class);
        Map<String, Object> consignee = (Map<String, Object>) modifyData.get("consignee");
        Map<String, Object> paramData = new HashMap<>();
        paramData.put("orderCode", modifyData.get("hbn"));
        paramData.put("contacts", consignee.get("phone"));
        paramData.put("phone", consignee.get("phone"));
        paramData.put("country", "AUS");
        paramData.put("city", consignee.get("suburb"));
        paramData.put("suburb", consignee.get("suburb"));
        paramData.put("zipCode", consignee.get("postcode"));
        paramData.put("address", consignee.get("address"));
        data.put("param", paramData);

        String sign = generateSign(data);
        data.put("sign", sign);
        System.out.println(data);
        String labelResponse = request("/client/order/getSortInfo", "POST", data);
        JSONObject labelResponseData = JSONObject.parseObject(labelResponse);
        JsonResultBean Result = new JsonResultBean();
        Result.setSuccess();
        JSONObject labelData = labelResponseData.getJSONObject("data");
        if (labelResponseData.getString("code").equals("200") &&
                labelData.getString("zoneCode") != null && !labelData.getString("zoneCode").isEmpty() &&
                labelData.getString("stationShortCode") != null && !labelData.getString("stationShortCode").isEmpty()) {
            Result.setCode("60000");
        }else{Result.setCode("60001");}
           Result.setMsg(labelResponseData.getString("message"));
        if (labelResponseData.containsKey("data") && labelResponseData.get("data") != null) {
            Result.setData(labelData);
        }
        return Result;
    }


    public JsonResultBean createOrder(JSONObject obj) {
        // 获取 accessToken
        String accessToken = getAccessToken();
        Map<String, Object> data = new HashMap<>();
        data.put("customerId", customerId);
        data.put("signMethod", "MD5");
        data.put("format", "json");
        data.put("version", "1.0.0");
        data.put("timeZone", "+8");
        data.put("timestamp", String.valueOf(System.currentTimeMillis()));
        data.put("accessToken", accessToken);

        //param
        Map<String, Object> paramData = JSON.parseObject(obj.toJSONString(), LinkedHashMap.class);
        System.out.print(paramData);
        Map<String, Object> result = new LinkedHashMap<>();

        // Map Basic Order Details
        result.put("orderNo", paramData.get("hbn"));
        result.put("orderType", "100");
        result.putIfAbsent("sourceWaybillNo", paramData.get("ref"));
        result.putIfAbsent("WaybillNo", paramData.get("ref"));
        // Map Sender (Shipper) Information
        Map<String, Object> shipper = (Map<String, Object>) paramData.get("shipper");
        Map<String, Object> senderInfo = new LinkedHashMap<>();
        senderInfo.put("contactCompany", shipper.get("company"));
        senderInfo.put("contacts", shipper.get("name"));
        senderInfo.put("phone", shipper.get("phone"));
        senderInfo.put("country", "AU");  // Assuming a fixed value
        senderInfo.put("city",  shipper.get("suburb"));
        senderInfo.put("address", shipper.get("address"));
        senderInfo.put("zipCode", shipper.get("postcode"));
        senderInfo.put("suburb", shipper.get("suburb"));
        senderInfo.put("addressType", "warehouse");
        senderInfo.put("backupPhone", "");
        senderInfo.put("longitude", "");
        senderInfo.put("latitude", "");
        senderInfo.put("email", "");
        senderInfo.put("street", "");
        senderInfo.put("externalNo", "");
        senderInfo.put("internalNo", "");
        senderInfo.put("province", shipper.get("state"));
        result.put("senderInfo", senderInfo);

        // Map Receiver (Consignee) Information
        Map<String, Object> consignee = (Map<String, Object>) paramData.get("consignee");
        Map<String, Object> consigneeInfo = new LinkedHashMap<>();
        consigneeInfo.put("contacts", consignee.get("name"));
        consigneeInfo.put("phone", consignee.get("phone"));
        consigneeInfo.put("country", "AU");  // Assuming a fixed value
        consigneeInfo.put("city", consignee.get("suburb"));
        consigneeInfo.put("address", consignee.get("address"));
        consigneeInfo.put("zipCode", consignee.get("postcode"));
        consigneeInfo.put("addressType", "customer");
        consigneeInfo.put("contactCompany", "");
        consigneeInfo.put("backupPhone", "");
        consigneeInfo.put("email", "");
        consigneeInfo.put("area", "");
        consigneeInfo.put("longitude", "");
        consigneeInfo.put("latitude", "");
        consigneeInfo.put("suburb", consignee.get("suburb"));
        consigneeInfo.put("street", consignee.get("address"));
        consigneeInfo.put("externalNo", "");
        consigneeInfo.put("internalNo", "");
        consigneeInfo.put("idNo", "");
        consigneeInfo.put("idCardFrontImg", "");
        consigneeInfo.put("idCardBackImg", "");
        consigneeInfo.put("province", consignee.get("state"));
        result.put("consigneeInfo", consigneeInfo);

        Map<String, Object> serviceInfo = new LinkedHashMap<>();
        serviceInfo.put("pickupService", "0");
        serviceInfo.put("deliveryService", "Delivery");
        serviceInfo.put("deliveryRequirements", paramData.get("instruction"));
        serviceInfo.put("expectedPickupDate", "");
        result.put("serviceInfo", serviceInfo);

// Map Package Information
        Map<String, Object> packageInfo = new LinkedHashMap<>();
        List<Map<String, Object>> packages = (List<Map<String, Object>>) paramData.get("packages");
        if (packages.size() > 0) {
            Map<String, Object> firstPackage = packages.get(0);
            packageInfo.put("length", 5);
            packageInfo.put("width", 5);
            packageInfo.put("high", 5);
            packageInfo.put("grossWeight", paramData.get("weight"));
            packageInfo.put("goodsType", "Normal");
            packageInfo.put("paymentMethod", "PPD");
            packageInfo.put("collectingMoney", 1.00);
            packageInfo.put("clientDeclaredValue", 1.00);
            packageInfo.put("clientDeclaredCurrency", "Local");
            packageInfo.put("productValue", 1.00);
            packageInfo.put("productValueCurrency", "Local");
            packageInfo.put("totalVolume", 0.001);
        }
        result.put("packageInfo", packageInfo);

        List<Map<String, Object>> skuInfos = new ArrayList<>();
        Map<String, Object> skuInfo = new LinkedHashMap<>();
        skuInfo.put("skuNo", "");
        skuInfo.put("skuName", "sku name");
        skuInfo.put("skuDesc", "sku zh name");
        skuInfo.put("skuQty", 1);
        skuInfo.put("skuDeclaredValue", 1.00);
        skuInfo.put("skuWeight", paramData.get("weight"));
        skuInfo.put("skuVolume", 1);
        skuInfo.put("skuHsCode", "");
        skuInfo.put("skuUrl", "");
        skuInfos.add(skuInfo);
        result.put("skuInfos", skuInfos);
        data.put("param", result);
        String sign = generateSign(data);
        data.put("sign", sign);
        System.out.print(data);
        String response = request("/client/order/v2/createOrder", "POST", data);
        JSONObject responseData = JSONObject.parseObject(response);
        JsonResultBean resBean = new JsonResultBean();
        resBean.setSuccess();

        if(responseData.getString("code").equals("200")){resBean.setCode("60000");}
        resBean.setMsg(responseData.getString("message"));
        if (responseData.containsKey("data") && responseData.get("data") != null) {
            resBean.setData(responseData.get("data"));
        }
        return resBean;
    }

    public JsonResultBean trackList(JSONObject obj) {
        // 获取 accessToken
        String accessToken = getAccessToken();
        Map<String, Object> data = new HashMap<>();
        data.put("customerId", customerId);
        data.put("signMethod", "MD5");
        data.put("format", "json");
        data.put("version", "1.0.0");
        data.put("timeZone", "+8");
        data.put("timestamp", String.valueOf(System.currentTimeMillis()));
        data.put("accessToken", accessToken);

        Map<String, Object> modifyData = JSON.parseObject(obj.toJSONString(), Map.class);
        Map<String, Object> paramData = new HashMap<>();

        paramData.put("orderType", "1");
        paramData.put("language", "2");
        List<String> orderNos = new ArrayList<>();
        orderNos.add(modifyData.get("ref").toString());
        paramData.put("orderNo", orderNos);

        data.put("param", paramData);

        String sign = generateSign(data);
        data.put("sign", sign);
        System.out.print(data);
        String response = request("/client/track/list", "POST", data);
        JSONObject responseData = JSONObject.parseObject(response);
        JsonResultBean resBean = new JsonResultBean();
        if(responseData.getString("code").equals("200")){resBean.setCode("60000");}
        resBean.setMsg(responseData.getString("message"));
        if (responseData.containsKey("data") && responseData.get("data") != null) {
            resBean.setData(responseData.get("data"));
        }
        return resBean;
    }

    public String getAccessToken() {
        // 尝试从 Redis 中获取 accessToken
        String accessToken = redisService.getValue("iMileAccessToken");
        if (accessToken != null && !accessToken.isEmpty()) {
            return accessToken;
        }

        Map<String, Object> data = new HashMap<>();
        data.put("customerId", customerId);
        data.put("signMethod", "MD5");
        data.put("format", "json");
        data.put("version", "1.0.0");
        data.put("timeZone", "+8");
        data.put("timestamp", String.valueOf(System.currentTimeMillis()));
        Map<String, String> param = new HashMap<>();
        param.put("grantType", "clientCredential");
        data.put("param", param);

        String response = request("/auth/accessToken/grant", "POST", data);
         accessToken = parseAccessToken(response);

        // 将 accessToken 存储到 Redis 中，并设置 2 小时的过期时间
        redisService.setKey("iMileAccessToken", accessToken, 7200);

        return accessToken;
    }



    private String parseAccessToken(String response) {
        // 解析 response，提取 accessToken 并返回
        JSONObject jsonResponse = JSONObject.parseObject(response);
        if (jsonResponse != null && "200".equals(jsonResponse.getString("code"))) {
            JSONObject data = jsonResponse.getJSONObject("data");
            if (data != null) {
                return data.getString("accessToken");
            }
        }
        return null;
    }

    public String request(String action, String method, Object data) {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String, Object> body = (Map<String, Object>) data;
        if(action=="/auth/accessToken/grant")
        {
            body.put("sign", generateSign(body));
        }

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(body, headers);
        ResponseEntity<String> response = restTemplate.exchange(apiUrl + action, HttpMethod.valueOf(method.toUpperCase()), entity, String.class);

        return response.getBody();
    }



    private String generateSign(Map<String, Object> data) {
        TreeMap<String, Object> sortedMap = new TreeMap<>(data);
        StringBuilder sb = new StringBuilder(secretKey);

        ObjectMapper objectMapper = new ObjectMapper();

        // 拼接排序后的参数名和参数值
        sortedMap.forEach((key, value) -> {
            if (!"param".equals(key)) {
                sb.append(key).append(value);
            }
        });

        try {
            // 将 param 值转换为 JSON 格式并拼接到字符串中
            String paramJson = objectMapper.writeValueAsString(data.get("param"));
            sb.append(paramJson);
        } catch (Exception e) {
            throw new RuntimeException("Error converting param to JSON", e);
        }

        // 在末尾加上 secretKey
        sb.append(secretKey);
        String signStr = sb.toString();
        return md5(sb.toString()).toUpperCase();
    }
    private String md5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : messageDigest) {
                String h = Integer.toHexString(0xFF & b);
                while (h.length() < 2)
                    h = "0" + h;
                hexString.append(h);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
