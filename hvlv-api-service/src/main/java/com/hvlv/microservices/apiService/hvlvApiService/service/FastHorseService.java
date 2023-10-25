package com.hvlv.microservices.apiService.hvlvApiService.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hvlv.microservices.apiService.hvlvApiService.beans.JsonResultBean;
import com.hvlv.microservices.apiService.hvlvApiService.client.LabelClient;
import com.qudian.lme.open.gateway.api.cancel_order.CancelOrderRequest;
import com.qudian.lme.open.gateway.api.cancel_order.data.OrderCancelData;
import com.qudian.lme.open.gateway.api.cancel_order.param.OrderCancelParam;
import com.qudian.lme.open.gateway.api.create_order.CreateOrderRequest;
import com.qudian.lme.open.gateway.api.create_order.param.OrderCreateParam;
import com.qudian.lme.open.gateway.core.*;
import com.qudian.lme.open.gateway.utils.SignUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Map;

@Service

public class FastHorseService extends HvlvService implements FastHorseInterface {
    private String lmePublicKey;
    private String lmePublicKeyTest;
    private String thirdPublicKey;
    private String thirdPublicKeyTest;
    private String thirdPrivateKey;
    private String thirdPrivateKeyTest;
    private String hostUrl;
    private String hostUrlTest;


    @Autowired
    LabelClient labelClient;

    @Autowired
    RedisService redisService;

    // Default Constructor
    public FastHorseService()
    {
        //lmePublicKeyTest = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCyK+xa6i3bWneL9e2nUvqgCCnXBHTh2Z1q4Rf7WvHCkJSNroRSAg2xcwhTt9kcQJMTVq8ySoHnO0vmWPLRtBlF1Q8xqz3+OaePKzcBLqFLm8djpP8woV72zsvtoJbysOxE3+LAjF4HlL4BMFw+Kfz3BZEZUjSY/wR5QogFP6gCyQIDAQAB";
        lmePublicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCPHezBW2Iegu4W8CnfW9qsCe5/xp0q2Szi2TtB++ACpc5/q+ts5ylvCWh+GVvkSiPGVAQNVN5qS5E9nMf8ni0KeFlmwyDaEfnIkPH28e3DQsLv6StGwV6ovFgQR4D28bEMIrx8NxGCiizIMSpJimT937K6RnDY2GoHpoL3UZq4kwIDAQAB";
        //thirdPublicKeyTest = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDQeOg8IkHhPbbbCRRlKcWtBbvyQ8LQYomYhv63eusHQKn58swcxZaxRmEoFZ3q9MWK7bN4a7q490ZNdETU9NTJucPgVW2eNqFaiwrDMnc3oxgyWxuiDN0gTo8iSDfPYsU+++FHjavYE6eZK2ATBUiQ6xsHhpfLTYHOrI6NjXW5zwIDAQAB";
        //thirdPrivateKeyTest = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBANB46DwiQeE9ttsJFGUpxa0Fu/JDwtBiiZiG/rd66wdAqfnyzBzFlrFGYSgVner0xYrts3hrurj3Rk10RNT01Mm5w+BVbZ42oVqLCsMydzejGDJbG6IM3SBOjyJIN89ixT774UeNq9gTp5krYBMFSJDrGweGl8tNgc6sjo2NdbnPAgMBAAECgYBE+FtM2cCV9kbyvFRFC8bccVM22XgwXQlMrwzCQyZSpfAWQ1+H/U7Xo4MtMcmnHAfm6LFBm9KQsy5NHbRQCBgFc67XtY81X+QY2OjSxmni4PQs9rRfHMm7nEZjd03axGwnKEdrZlfp28kN+f6vYYZQqa/mKHjsZi91UbHpe22YYQJBAP1ef/1mRGiUyLyG8gw9TRgfID21LXGxUL1Q+hhZDfwGtyNrkOEhgLjEAAPgnKfw+kwX0L/MzWoX/zGZDv1giIkCQQDSoxA9f9GWBOjuQY9GbZGIFF6dLwkT4E/cyMA91YWDSGT8cNpVgdBtiIuWYbdNATrDLsKXStP11X8VndM6HWmXAkBBtw7vRGUd0uk1rLJ+5i9mwDv2hVViFaFhWO1k/0QXSA6cCzwqiCwAwCVY3BsFnATvU4X7GT119P9ld9NheHYxAkEAto2KgrJnk6xXsD5zjSdi7Nwyj+n25RoQPRpjunN2ziwNEdhA8cCbQoMH72Jq+bsqEYVSMsswXqwVA0gQjBp3qwJBAJ0oZOzDMXlpwIBZHvBF6JcOSjr1gzm2S0fmWwPjwadPwAdsQ9mCUzE8xX1+pZzqrn4VzpktC8B+T2yeQ3NdNmw=";
        thirdPublicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQD4K6TT2Uw+BRz0SPEkpl5jfH2xdMHE0gH3ZOjpQvnRBmrXfY9hxVkNJAvJYXOaBKneglxqr5M++aq76BxfJPhXc+TXvcyyDvlv6NiSG3XCZgIq3XHRgJrOp9prtO59fw4nk56XHuoTQCYmBSdqbr4sUS9BOIOFt5+OkfGoNjEv/QIDAQAB";
        thirdPrivateKey = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAPgrpNPZTD4FHPRI8SSmXmN8fbF0wcTSAfdk6OlC+dEGatd9j2HFWQ0kC8lhc5oEqd6CXGqvkz75qrvoHF8k+Fdz5Ne9zLIO+W/o2JIbdcJmAirdcdGAms6n2mu07n1/DieTnpce6hNAJiYFJ2puvixRL0E4g4W3n46R8ag2MS/9AgMBAAECgYEAiI+DmOvHD43CvA3zXCaMZBRaGi9UfRjO6jLGE62+SC5O1puKLdPpx9hhAAS3FzafvwhfEHni/dFnCRWVnyl52ZhLbc70Suh/bLeDVH3pjSDWI1uuEzMKnHtrOwNLxYRSg+FgnjJ8YvlyJfTMe3ee6cuh9Quu5VYanhsjRFvllqUCQQD+mrFYLtrq6w7LZTxcMDZjMyklQMrhEWbvCEqOXebyh5sMI2Op4mI3uP614D6/GEiV7RZx8MSzKoMpyYe+Y0vLAkEA+YfsCwIYnRCthMdZD35fIy0/XaUIkxKiH2YesNWnDX6MGqQADDa5Y6aX4YzrpBpTj3J2NXn6utDUQHVOreWKVwJANcNWtadXRQoT2rFq+JCZu4LfKmWvMa2qDcmzbLK5hPdLr1l9vy71zIx9BMzwkwu+sCIbfj34W1kbz2QmDPcM1wJANGf7hwRVrwcFqlFDvyFHUdf66uvyNRFAw19rKrB0eT0Op7mx2N7VaLxgQZqbEsgErKfZc7m+kuWw7ii08Yi32QJALnYRxXK/lFJEc2x/etTQMzF1CrAZBJHoTH/SCVTS+MR55vAGlSL/0UIi1yRU6VVg9p82mRHTLzk/rHyGgEQNgA==";
        //hostUrlTest = "https://test.open-gateway.fh.express/";
        hostUrl = "https://open-gateway.fh.express/";
    }
    public JsonResultBean generateOrderNoFastHorse(JSONObject jsonData)
    {
        JsonResultBean result = new JsonResultBean();

        return result;
    }

    public JsonResultBean createFastHorseShipment(JSONObject jsonData)
    {
        JsonResultBean labelResult = labelClient.generateRefByPrefix("{\"prefix\":\""+jsonData.getString("prefix")+"\",\"orgId\":4987}");
        if(labelResult.isSuccess())
        {
            String jsonString = JSON.toJSONString(labelResult.getData());
            JSONObject data = JSON.parseObject(jsonString);
            Integer pkg = jsonData.getInteger("packs");
            String[] barcodes = new String[pkg];
            for (int i = 0; i < pkg; i++) {
                barcodes[i] = data.getString("ref")+"-"+String.format("%03d", i+1);
            }
            data.put("barcode", StringUtils.join(barcodes, ","));
            labelResult.setData(data);
        }
        return labelResult;
    }
    public JsonResultBean manifestFastHorse(JSONObject jsonData)
    {
        JsonResultBean result = new JsonResultBean();
        try
        {
            CreateOrderRequest createOrderRequest = new CreateOrderRequest();
            OrderCreateParam param = new OrderCreateParam();
            GlobalConfig.initAppKey("TLA");
            GlobalConfig.initPrivateSecret(this.thirdPrivateKey);
            GlobalConfig.initPublicSecret(this.thirdPublicKey);
            GlobalConfig.initLmePublicSecret(this.lmePublicKey);


            param.setOrderNo(jsonData.getString("fast_horse_ref"));
            param.setOutOrderNo(jsonData.getString("fast_horse_ref"));
            param.setChannel("TLA");
            param.setCargoDesc("Small package");
            param.setCargoDetail(jsonData.getString("instruction"));

            /**
             * Set package length, width, height, and weight
             * Fast horse only support single package per order,
             * so only get packages[0]'s value
             */
            JSONArray packages = jsonData.getJSONArray("packages");
            int size = packages.size();
            BigDecimal length = BigDecimal.valueOf(0.01);
            BigDecimal width =  BigDecimal.valueOf(0.01);
            BigDecimal height = BigDecimal.valueOf(0.01);
            BigDecimal weight = jsonData.getBigDecimal("weight");

            if(size>0)
            {
                length = packages.getJSONObject(0).getBigDecimal("length").divide(new BigDecimal(100));
                width = packages.getJSONObject(0).getBigDecimal("width").divide(new BigDecimal(100));
                height = packages.getJSONObject(0).getBigDecimal("height").divide(new BigDecimal(100));
                weight = packages.getJSONObject(0).getBigDecimal("weight").divide(new BigDecimal(100));
            }

            param.setTotalLength(length);
            param.setTotalWidth(width);
            param.setTotalHeight(height);
            param.setTotalWeight(weight);

            /**
             * Set Poster info
             */
            OrderCreateParam.ContactInfo poster = new OrderCreateParam.ContactInfo();
            JSONObject shipper = jsonData.getJSONObject("shipper");
            poster.setContact(shipper.getString("name"));
            poster.setTel(shipper.getString("phone"));
            poster.setMobile(shipper.getString("phone"));
            poster.setEmail(shipper.getString("email"));
            poster.setZoneCode("AUS-Australia");
            poster.setCountry("Australia");
            poster.setProvince(shipper.getString("state"));
            poster.setCity(shipper.getString("suburb"));
            poster.setAddress(shipper.getString("address"));
            poster.setPostCode(shipper.getString("postcode"));
            param.setPoster(poster);

            /**
             * Set receiver info
             */
            OrderCreateParam.ContactInfo receiver = new OrderCreateParam.ContactInfo();
            JSONObject consignee = jsonData.getJSONObject("consignee");
            receiver.setContact(consignee.getString("name"));
            receiver.setTel(consignee.getString("phone"));
            receiver.setMobile(consignee.getString("phone"));
            receiver.setEmail(consignee.getString("email"));
            receiver.setZoneCode("AUS-Australia");
            receiver.setCountry("Australia");
            receiver.setProvince(consignee.getString("state"));
            receiver.setCity(consignee.getString("suburb"));
            receiver.setAddress(consignee.getString("address"));
            receiver.setPostCode(consignee.getString("postcode"));
            param.setReceiver(receiver);

            OpConfig opConfig = new OpConfig();
            opConfig.setOpenRequestUrl(this.hostUrl);
            opConfig.setAppKey("TLA");
            opConfig.setLmePublicSecret(this.lmePublicKey);
            opConfig.setPublicSecret(this.thirdPublicKey);
            opConfig.setPrivateSecret(this.thirdPrivateKey);
            createOrderRequest.setConfig(opConfig);
            createOrderRequest.setParam(param);
            OpResponse reponse = createOrderRequest.execute();
            result.setData(reponse);
            result.setSuccess();
            return result;
        }catch (Exception ex) {
            ex.printStackTrace();
            ArrayList<String> errorStr = new ArrayList();
            errorStr.add("Unexpected Error");
            errorStr.add("FastHorse:" + ex.getMessage());
            result.setError();
            result.setData(errorStr);
            return result;
        }
    }
    public JsonResultBean orderDetailFastHorse(JSONObject jsonData)
    {
        JsonResultBean result = new JsonResultBean();

        return result;
    }
    public JsonResultBean billInfoFastHorse(JSONObject jsonData)
    {
        JsonResultBean result = new JsonResultBean();

        return result;
    }
    public JsonResultBean trackFastHorse(JSONObject jsonData) throws Exception {
        JsonResultBean result = new JsonResultBean();
        /*JSONObject obj = new JSONObject();
        obj.put("action", "sign_in");
        obj.put("channel", "TLA");
        obj.put("occurLocation", "Point Cook");
        obj.put("operatorTime", "2023-09-25 10:58:00");
        obj.put("orderNo", "T20000000000094");
        obj.put("routingDescription", "The parcel has been delivered. If not, please contact parcel_query_au@fh.express and we will deal with it as soon as possible.");
        obj.put("timeZone", "UTC+10");
        long updateTime = 1695603480000L;
        obj.put("updatedTime", updateTime);
        obj.put("utcOperatorTime", "2023-09-25 00:58:00");
        String jsonString = obj.toJSONString();
        byte[] byteArray = jsonString.getBytes("UTF-8");
        String encrypted = SignUtil.encryptByPublicKey(byteArray,this.thirdPublicKey);*/
        String encrypted = jsonData.getString("data");
        String decrypted = SignUtil.decryptByShort(encrypted, this.thirdPrivateKey);
        ObjectMapper mapper = new ObjectMapper();
        Map<String,Object> map = mapper.readValue(decrypted, Map.class);
        result.setSuccess();
        result.setMsg(encrypted);
        result.setData(map);
        return result;
    }
    public JsonResultBean cancelFastHorse(JSONObject jsonData)
    {
        GlobalConfig.initAppKey("TLA");
        GlobalConfig.initPrivateSecret(this.thirdPrivateKey);
        GlobalConfig.initPublicSecret(this.thirdPublicKey);
        GlobalConfig.initLmePublicSecret(this.lmePublicKey);

        OpConfig opConfig = new OpConfig();
        opConfig.setOpenRequestUrl(this.hostUrl);
        opConfig.setAppKey("TLA");
        opConfig.setLmePublicSecret(this.lmePublicKey);
        opConfig.setPublicSecret(this.thirdPublicKey);
        opConfig.setPrivateSecret(this.thirdPrivateKey);

        JsonResultBean result = new JsonResultBean();
        CancelOrderRequest request = new CancelOrderRequest();
        request.setConfig(opConfig);
        OrderCancelParam orderCancelParam = new OrderCancelParam();

        orderCancelParam.setOrderNo(jsonData.getString("ref"));
        request.setParam(orderCancelParam);
        try {
            OpResponse<OrderCancelData> cancelOrdelResponse = request.execute();
            if (cancelOrdelResponse.isSuccess()) {
                OrderCancelData cancelData = cancelOrdelResponse.getData();
                String cancelCode = cancelOrdelResponse.getCode();
                //System.out.println(cancelData);
                result.setData(cancelData);
                result.setSuccess();
                return result;
            }
        } catch (Exception e) {
            e.printStackTrace();
            ArrayList<String> errorStr = new ArrayList();
            errorStr.add("Unexpected Error");
            errorStr.add("FastHorse:" + e.getMessage());
            result.setError();
            result.setData(errorStr);
            return result;
        }
        return result;
    }
    public JsonResultBean orderSuspensionFastHorse(JSONObject jsonData)
    {
        JsonResultBean result = new JsonResultBean();

        return result;
    }
}
