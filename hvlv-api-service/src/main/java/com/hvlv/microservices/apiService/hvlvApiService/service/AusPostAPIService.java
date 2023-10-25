package com.hvlv.microservices.apiService.hvlvApiService.service;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import java.io.*;
import java.lang.String;


import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.*;

import java.lang.Math;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.security.cert.X509Certificate;


@Service
public class AusPostAPIService {

    public static final String CHARGE_CODE_POD = "3D35"; //'7D55';
    public static final String CHARGE_CODE_NO_POD = "3D35"; //'7D53';
    public static final String CHARGE_CODE_EXPRESS = "3J35";
    public static final String EPARCEL_CODE = "00093";
    public static final String EXPRESS_CODE = "00096";
    public static final String test_url = "https://digitalapi.auspost.com.au/test/shipping/v1/";
    public static final String production_url = "https://digitalapi.auspost.com.au/shipping/v1/";
    public static final String COMPANY_NAME_SL = "Top Logistics";
    public static final String IM_COMPANY_ADDRESS_TLA = "1/233 Milperra Rd";
    public static final String IM_COMPANY_SUBURB = "Bankstown Aerodrome";
    public static final String IM_COMPANY_STATE = "NSW";
    public static final String IM_COMPANY_POSTCODE = "2200";

    public static final Map<String, Map<String, String>> API_ACCOUNTS = new HashMap<>();
    public static final Map<String, Map<String, String>> API_ACCOUNTS_INFO = new HashMap<>();

    static {
        API_ACCOUNTS.put("syd", Map.of(
                "id", "AMQ",
                "no", "0006081844",
                "key", "ed40f505-2a88-4596-acf7-3c25ad220764",
                "password", "TopBuy2016"
        ));
        API_ACCOUNTS.put("stone", Map.of(
                "id", "333UF",
                "no", "0007705328",
                "key", "afa846c5-a30f-4e5d-9482-c89cfad6f08f",
                "password", "TopBuy2016"
        ));
        API_ACCOUNTS.put("mel", Map.of(
                "id", "33EVH",
                "no", "0007876937",
                "key", "0980b73a-8438-4bab-b94e-cf4541a6f02a",
                "password", "TopBuy2016"
        ));
        API_ACCOUNTS.put("bne", Map.of(
                "id", "33EVJ",
                "no", "0007876929",
                "key", "64b0739e-9c1a-409d-87f5-75c73fd1b61a",
                "password", "TopBuy2016"
        ));
        API_ACCOUNTS.put("per", Map.of(
                "id", "34AWE",
                "no", "0006920042",
                "key", "ed40f505-2a88-4596-acf7-3c25ad220764",
                "password", "TopBuy2016"
        ));
        API_ACCOUNTS.put("test", Map.of(
                "id", "TEST",
                "no", "1014445357",
                "key", "657f9b96-0dcc-4e15-b84e-cb9736642cc2",
                "password", "x19ee9dea88b1d0563b4"
        ));
        API_ACCOUNTS.put("test2", Map.of(
                "id", "TEST2",
                "no", "2005741161",
                "key", "006ec0be-326b-4efa-845e-af8e2963cf94",
                "password", "xc493904977e34c0315a"
        ));


        API_ACCOUNTS_INFO.put("syd", Map.of("id", "AMQ"));
        API_ACCOUNTS_INFO.put("stone", Map.of("id", "333UF"));
        API_ACCOUNTS_INFO.put("mel", Map.of("id", "33EVH"));
        API_ACCOUNTS_INFO.put("bne", Map.of("id", "33EVJ"));
        API_ACCOUNTS_INFO.put("per", Map.of("id", "34AWE"));
        API_ACCOUNTS_INFO.put("ecof", Map.of("id", "33MBQ"));
    }

    private String api_id;
    private String api_key;
    private String api_pwd;
    private boolean is_test;
    private boolean debug;

    public AusPostAPIService() {

        this.is_test = true;
        this.debug = true;
        if (API_ACCOUNTS.containsKey("test")) {
            Map<String, String> accountInfo = API_ACCOUNTS.get("test");
            this.api_id = accountInfo.get("no");
            this.api_key = accountInfo.get("key");
            this.api_pwd = accountInfo.get("password");
        }
    }

    public Map<String, Object> getAccounts(String id) throws Exception {
        String jsonResponse = request("accounts/" + (id.isEmpty() ? this.api_id : id),"GET",null);
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> result = objectMapper.readValue(jsonResponse, Map.class);
        return result;
    }

    public int validateAddress(String suburb, String state, String postcode) {
        suburb = suburb.trim();
        state =state.trim();
        postcode = postcode.trim();
        String endpoint = "address?suburb="+ URLEncoder.encode(suburb, StandardCharsets.UTF_8)+"&state="+state+"&postcode="+postcode;
        String response = null;
        try {
            response = request(endpoint,"GET",null);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        if (response == null) {
            return 2;
        } else {
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                JsonNode jsonNode = objectMapper.readTree(response);
                boolean test_found =jsonNode.get("found").asBoolean();
                if (jsonNode.has("found") && test_found) {
                    return 1;
                }else{
                    return 0;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return 2;
        }
    }

    public Map<String, Object> getItemPrices(String pcFrom, String pcTo, double weight, double[] dim){
        try{
            Map<String, Object> requestData =new HashMap<>();
            Map<String,String> from =new HashMap<>();
            Map<String,String> to =new HashMap<>();
            from.put("postcode",pcFrom);
            to.put("postcode",pcTo);
            Map<String,Object> item=new HashMap<>();
            item.put("weight",weight);

            if(dim!=null &&dim.length>=3){
                item.put("length",dim[0]);
                item.put("height",dim[1]);
                item.put("width",dim[2]);
            }

            requestData.put("from", from);
            requestData.put("to", to);
            requestData.put("items", new Object[]{item});

            String jsonResponse = request("prices/items","POST", requestData);
            ObjectMapper objectMapper =new ObjectMapper();
            Map<String, Object> result = objectMapper.readValue(jsonResponse, Map.class);
            return result;
        }catch (Exception e) {
            e.printStackTrace();
            return null; // 处理异常情况
        }

    }

    public Map<String, Object> getShipments(String ids, String offset, String nos, String status) throws Exception
    {
        String[] queryParams =new String[4];
        if (ids != null && !ids.isEmpty()) {
            queryParams[0] = "shipment_ids=" + ids;
        }
        if (offset != null && !offset.isEmpty()) {
            queryParams[1] = "offset=" + offset;
        }
        if (nos != null && !nos.isEmpty()) {
            queryParams[2] = "number_of_shipments=" + nos;
        }
        if (status != null && !status.isEmpty()) {
            queryParams[3] = "status=" + status;
        }
        String queryString = String.join("&", queryParams);
        String action = "shipments" + (queryString.isEmpty() ? "" : "?" + queryString);
        String jsonResponse = request(action, "GET", null);
        ObjectMapper objectMapper =new ObjectMapper();
        Map<String, Object> result = objectMapper.readValue(jsonResponse, Map.class);
        return result;
    }

    public Map<String, Object> createShipments(Map<String, Object> p, String prod) throws Exception {
        Map<String, Object> d = new HashMap<>();

        if (p.containsKey("shipments")) {
            List<Map<String, Object>> shipments = (List<Map<String, Object>>) p.get("shipments");
            List<Map<String, Object>> newShipments = new ArrayList<>();

            for (Map<String, Object> s : shipments) {
                Map<String, Object> shipmentData = prepShipmentData(s, prod);
                newShipments.add(shipmentData);
            }

            d.put("shipments", newShipments);
        } else {
            Map<String, Object> shipmentData = prepShipmentData(p, prod);
            List<Map<String, Object>> shipments = new ArrayList<>();
            shipments.add(shipmentData);
            d.put("shipments", shipments);
        }

        String jsonResponse = request("shipments","POST", d);
        ObjectMapper objectMapper =new ObjectMapper();
        Map<String, Object> result = objectMapper.readValue(jsonResponse, Map.class);
        return result;
    }

    public Map<String, Object> createIntShipments(Map<String, Object> p, String prod) throws Exception {
        Map<String, Object> d = new HashMap<>();

        if (p.containsKey("shipments")) {
            List<Map<String, Object>> shipments = (List<Map<String, Object>>) p.get("shipments");
            List<Map<String, Object>> newShipments = new ArrayList<>();

            for (Map<String, Object> s : shipments) {
                Map<String, Object> shipmentData = prepIntShipmentData(s, prod);
                newShipments.add(shipmentData);
            }

            d.put("shipments", newShipments);
        } else {
            Map<String, Object> shipmentData = prepIntShipmentData(p, prod);
            Map<String, Object> shipmentData1=  shipmentData;
            List<Map<String, Object>> shipments = new ArrayList<>();
            shipments.add(shipmentData);
            d.put("shipments", shipments);
        }

        String jsonResponse = request("shipments", "POST", d);
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> result = objectMapper.readValue(jsonResponse, Map.class);

        return result;
    }

    public Map<String, Object> updateShipment(String id, Map<String, Object> p, String prod) throws Exception {
        String jsonResponse = request("shipments/" + id, "PUT", prepShipmentData(p, prod));
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> result = objectMapper.readValue(jsonResponse, Map.class);
        return result;
    }

    public Map<String, Object> updateIntShipment(String id, Map<String, Object> p, String prod) throws Exception {
        String jsonResponse = request("shipments/" + id, "PUT", prepIntShipmentData(p, prod));
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> result = objectMapper.readValue(jsonResponse, Map.class);

        return result;
    }

    public Map<String, Object> updateItems(String id, Map<String, Object> p, String prod) throws Exception {
        Map<String, Object> s = getShipments(id,null,null,null);
        if (s.containsKey("shipments") && s.get("shipments") instanceof List<?>) {
            List<Map<String, Object>> shipments = (List<Map<String, Object>>) s.get("shipments");
            if (shipments.isEmpty()) {
                String jsonResponse = request("shipments/" + id + "/items", "PUT", Collections.emptyMap());
                ObjectMapper objectMapper = new ObjectMapper();
                Map<String, Object> result = objectMapper.readValue(jsonResponse, Map.class);
                return result;
            }
            Map<String, Object> ns = prepShipmentData(p, prod);
            List<Map<String, Object>> items = (List<Map<String, Object>>) ns.get("items");
            List<Map<String, Object>> currentItems = (List<Map<String, Object>>) shipments.get(0).get("items");
            for (int k = 0; k < items.size() && k < currentItems.size(); k++) {
                Map<String, Object> currentItem = currentItems.get(k);
                Map<String, Object> newItem = items.get(k);
                newItem.put("item_id", currentItem.get("item_id"));
            }
            String jsonResponse = request("shipments/" + id + "/items", "PUT", Collections.singletonMap("items", items));
            ObjectMapper objectMapper = new ObjectMapper();
            Map<String, Object> result = objectMapper.readValue(jsonResponse, Map.class);
            return result;
        }
        return null;
    }

    public Map<String, Object> deleteShipment(String ids) throws Exception {
        String jsonResponse = request("shipments?shipment_ids=" + ids, "DELETE", null);
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> result = objectMapper.readValue(jsonResponse, Map.class);
        return result;
    }

    public Map<String, Object> deleteItem(String id, String item_id) throws Exception {
        String jsonResponse = request("shipments/" + id + "/items/" + item_id, "DELETE", null);
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> result = objectMapper.readValue(jsonResponse, Map.class);
        return result;
    }

    public Map<String, Object> getOrder(String id) throws Exception {
        String jsonResponse = request("orders/" + id,"GET",null);
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> result = objectMapper.readValue(jsonResponse, Map.class);
        return result;
    }

    public Map<String, Object> createOrderFromShipments(List<Map<String, Object>> ss, String ref) throws Exception {
        Map<String, Object> d = new HashMap<>();
        if (ref != null && !ref.isEmpty()) {
            d.put("order_reference", ref);
        }

        List<Map<String, Object>> shipments = new ArrayList<>();
        for (Map<String, Object> s : ss) {
            if (s.containsKey("mdata") && s.get("mdata") instanceof Map) {
                Map<String, Object> mdata = (Map<String, Object>) s.get("mdata");
                if (mdata.containsKey("ap_sid")) {
                    Map<String, Object> shipmentMap = new HashMap<>();
                    shipmentMap.put("shipment_id", mdata.get("ap_sid"));
                    shipments.add(shipmentMap);
                }
            } else if (s.containsKey("trans") && s.get("trans") instanceof List) {
                List<Map<String, Object>> trans = (List<Map<String, Object>>) s.get("trans");
                if (!trans.isEmpty() && trans.get(0).containsKey("mdata") && trans.get(0).get("mdata") instanceof Map
                        && ((Map<?, ?>) trans.get(0).get("mdata")).containsKey("sid")) {
                    Map<String, Object> mdata = (Map<String, Object>) trans.get(0).get("mdata");
                    Map<String, Object> shipmentMap = new HashMap<>();
                    shipmentMap.put("shipment_id", mdata.get("sid"));
                    shipments.add(shipmentMap);
                }
            }
        }

        d.put("shipments", shipments);

        String jsonResponse = request("orders", "PUT", d);
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> result = objectMapper.readValue(jsonResponse, Map.class);
        return result;
    }

    public Map<String, Object> createOrderIncludingShipments(List<Map<String, Object>> ss, String ref, String prod)
            throws Exception {
        Map<String, Object> d = new HashMap<>();
        if (ref != null && !ref.isEmpty()) {
            d.put("order_reference", ref);
        }

        List<Map<String, Object>> shipments = new ArrayList<>();
        List<String> errors = new ArrayList<>();
        for (Map<String, Object> p : ss) {
            if (p.containsKey("status") && p.get("status").equals(100)) {
                continue;
            }

            Map<String, Object> shipmentMap;
            if (p.containsKey("mdata") && p.get("mdata") instanceof Map
                    && ((Map<?, ?>) p.get("mdata")).containsKey("test_aupost_2014")) {
                shipmentMap = prepShipmentData2014(p, prod);
            } else {
                shipmentMap = prepShipmentData(p, prod);
            }

            if (shipmentMap != null) {
                shipments.add(shipmentMap);
            } else {
                errors.add("Error message for shipment " + ss.indexOf(p)); // Add an appropriate error message.
            }
        }

        if (!errors.isEmpty()) {
            // Handle errors here or return them in the result map.
        }

        d.put("shipments", shipments);

        String jsonResponse = request("orders", "POST", d);
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> result = objectMapper.readValue(jsonResponse, Map.class);
        return result;
    }

    public Map<String, Object> createOrderIncludingShipments2014(List<Map<String, Object>> ss, String ref, String prod)
            throws Exception {
        Map<String, Object> d = new HashMap<>();
        if (ref!=null) {
            d.put("order_reference", ref);
        }

        List<Map<String, Object>> shipments = new ArrayList<>();
        List<String> errors = new ArrayList<>();
        for (Map<String, Object> p : ss) {
            if (p.get("status").equals(100)) {
                continue;
            }

            Map<String, Object> shipmentMap = prepShipmentData2014(p, prod);

            if (shipmentMap != null) {
                shipments.add(shipmentMap);
            } else {
                errors.add("Error message for shipment " + ss.indexOf(p)); // Add an appropriate error message.
            }
        }

        if (!errors.isEmpty()) {
            // 处理错误信息
        }

        d.put("shipments", shipments);
        String jsonResponse = request("orders", "POST", d);
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> result = objectMapper.readValue(jsonResponse, Map.class);
        return result;
    }

    public Map<String, Object> getOrderSummary(String id) throws Exception {
        String jsonResponse = request("accounts/" + this.api_id + "/orders/" + id + "/summary","GET",null);
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> result = objectMapper.readValue(jsonResponse, Map.class);
        return result;
    }

    public Map<String, Object> createLabels(List<String> ids, String layout) throws Exception {
        Map<String, Object> d = new HashMap<>();
        Map<String, Object> preferences = new HashMap<>();
        preferences.put("type", "PRINT");

        List<Map<String, Object>> groups = new ArrayList<>();
        Map<String, Object> groupParcelPost = new HashMap<>();
        groupParcelPost.put("group", "Parcel Post");
        groupParcelPost.put("layout", layout.equals("A4") ? "A4-4pp" : "A6-1pp");
        groupParcelPost.put("branded", layout.equals("A4") ? false : true);
        groupParcelPost.put("left_offset", 0);
        groupParcelPost.put("top_offset", 0);

        Map<String, Object> groupExpressPost = new HashMap<>();
        groupExpressPost.put("group", "Express Post");
        groupExpressPost.put("layout", layout.equals("A4") ? "A4-4pp" : "A6-1pp");
        groupExpressPost.put("branded", layout.equals("A4") ? false : true);
        groupExpressPost.put("left_offset", 0);
        groupExpressPost.put("top_offset", 0);

        groups.add(groupParcelPost);
        groups.add(groupExpressPost);

        preferences.put("groups", groups);
        d.put("preferences", preferences);

        List<Map<String, Object>> shipments = new ArrayList<>();
        if (!ids.isEmpty()) {
            for (String id : ids) {
                Map<String, Object> shipmentMap = new HashMap<>();
                shipmentMap.put("shipment_id", id);
                shipments.add(shipmentMap);
            }
        }
        d.put("shipments", shipments);

        String jsonResponse = request("labels", "POST", d);
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> result = objectMapper.readValue(jsonResponse, Map.class);
        return result;
    }

    public Map<String, Object> getLabel(String id) throws Exception {
        String jsonResponse = request("labels/" + id, "GET", null);
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> result = objectMapper.readValue(jsonResponse, Map.class);
        return result;
    }

    public Map<String, Object> trackItems(List<String> ids) throws Exception {
        String trackingIds = String.join(",", ids);
        String jsonResponse = request("track?tracking_ids=" + trackingIds, "GET", null);
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> result = objectMapper.readValue(jsonResponse, Map.class);
        return result;
    }

    public static int calculateAidCheckDigit(String aid) {
        String st = "";
        int dt = 0;

        for (int i = 0; i < aid.length(); i++) {
            st += Character.isUpperCase(aid.charAt(i)) ? String.valueOf(aid.charAt(i) % 10) : aid.charAt(i);
        }

        st = new StringBuilder(st).reverse().toString();

        for (int i = 0; i < st.length(); i++) {
            int digit = Integer.parseInt(String.valueOf(st.charAt(i)));
            dt += (i % 2 == 0) ? digit * 3 : digit;
        }

        return Integer.parseInt(String.valueOf(10 - (dt % 10)));
    }

    public boolean validSuburb(String suburb, String state, String postcode){
        if(suburb.toUpperCase().equals("BRISBANE")&&postcode.equals("4000")){
            return false;
        }
        int result = validateAddress(suburb, state, postcode);

        // 根据返回值定义返回逻辑
        if (result == 2||result == 0) {
            // 返回 2 表示验证失败
            return false;
        } else {
            // 返回 1 表示验证成功，0 表示未找到匹配
            return result == 1;
        }
    }

    protected List<String> prepAddrLines(String addr) {
        // 替换特殊字符
        addr = addr.replaceAll("&#xd", "\n");
        addr = addr.replaceAll("&#xa", "\n");
        addr = addr.replaceAll("&#39", "'");
        addr = addr.replaceAll(" ", " "); // 注意这里的空格是普通的空格
        addr = addr.replaceAll("–", "-");

        // 使用正则表达式拆分地址
        String[] lines = addr.split("[\n\r;]+");

        // 如果只有一行地址，且长度超过 40 个字符，拆分为多行
        List<String> result = new ArrayList<>();
        if (lines.length == 1 && addr.length() > 40) {
            for (int i = 0; i < addr.length(); i += 40) {
                result.add(addr.substring(i, Math.min(i + 40, addr.length())));
            }
        } else {
            // 否则，最多取前三行，并确保每行不超过 40 个字符
            for (int i = 0; i < Math.min(lines.length, 3); i++) {
                String line = lines[i].trim();
                if (line.length() > 40) {
                    line = line.substring(0, 40);
                }
                result.add(line);
            }
        }

        return result;
    }


    public Map<String, Double> getVirtualWeightAndDim(double weight) {
        Map<String, Double> result = new HashMap<>();

        double units = weight > 0 ? weight : 1;
        weight = Math.round(weight * 70) / 100; // 缩小到 70%
        double normalCubic = weight / 250;

        // 除以 250 获取虚拟立方体
        double averageCube = Math.floor(Math.cbrt(normalCubic) * 100);
        double width, height, length;

        if (averageCube <= 5) {
            width = 5;
            height = 5;
            length = 5;
        } else {
            double adjust = averageCube - 5;
            double adjustValue = Math.random() * adjust + 1;

            if (Math.random() * 100 > 50) {
                width = averageCube - adjustValue;
                height = averageCube;
                length = averageCube + adjustValue;
            } else {
                height = averageCube - adjustValue;
                width = averageCube;
                length = averageCube + adjustValue;
            }
        }

        weight = Math.round(weight * 100) / 100;
        width = Math.round(width * 10) / 10;
        height = Math.round(height * 10) / 10;
        length = Math.round(length * 10) / 10;

        result.put("weight", weight);
        result.put("width", width);
        result.put("height", height);
        result.put("length", length);

        return result;
    }

    public double getBreakWeight(double weight) {
        if (weight <= 0.500) {
            return weight;
        } else if (weight <= 1.0) {
            return doTheWeight(weight, 0.5, 1.0, 0.4, 0.5);
        } else if (weight <= 2) {
            return doTheWeight(weight, 1, 2, 0.8, 1.0);
        } else if (weight <= 3) {
            return doTheWeight(weight, 2, 3, 1.8, 2.0);
        } else if (weight <= 4) {
            return doTheWeight(weight, 3, 4, 2.5, 3.0);
        } else if (weight <= 5) {
            return doTheWeight(weight, 4, 5, 3.5, 4.0);
        } else if (weight <= 7) {
            return doTheWeight(weight, 5, 7, 4.5, 5.0);
        } else if (weight <= 10) {
            double scale = Math.pow(10, 3);
            double breakWeight = Math.round((weight * (80 + Math.random() * 20) / 100.0)*scale)/scale;
            return breakWeight;
        } else return Math.round(weight);
    }

    public double doTheWeight(double w, double x1, double x2, double y1, double y2) {
        double scale = Math.pow(10, 3);
        double doTheWeight= Math.round((y1 - Math.abs(y1 - y2) / Math.abs(x1 - x2) * x1) + Math.abs(y1 - y2) / Math.abs(x1 - x2) * w*scale)/scale;
        return doTheWeight;
    }

    public Map<String, Object> prepShipmentData(Map<String, Object> p, String prod){
        Map<String,Object> s = new HashMap<>();
        if(!(p instanceof Map)){
        return p;
        }

        s.put("shipment_reference",p.get("hbn"));
        s.put("customer",p.get("cref"));

        Map<String,Object> from =new HashMap<>();
        if ("0008406727".equals(this.api_id)) {
            from.put("name", ("Peter - " + p.get("agent_id")).substring(0, 40));
            from.put("lines", prepAddrLines("PO Box 7199"));
            from.put("suburb", "Wetherill Park");
            from.put("state", "NSW");
            from.put("postcode", "2164");
        } else {
            from.put("name", COMPANY_NAME_SL);
            from.put("lines", prepAddrLines(COMPANY_NAME_SL + "\n" + IM_COMPANY_ADDRESS_TLA));
            from.put("suburb", IM_COMPANY_SUBURB);
            from.put("state", IM_COMPANY_STATE);
            from.put("postcode", IM_COMPANY_POSTCODE);
        }
        if ("PR".equals(prod)) {
            s.put("movement_type", "RETURN");

            String cnorName = (String) p.get("cnor.name");
            String cnorCompany = (String) p.get("cnor.company");
            String cnorAddress = (String) p.get("cnor.address");
            String cnorSuburb = (String) p.get("cnor.suburb");
            String cnorState = (String) p.get("cnor.state");
            Integer cnorPostcode = (Integer) p.get("cnor.postcode");


            from.put("name", trimAndReplace(cnorName, 35));
            from.put("business_name", trimAndReplace(cnorCompany, 40));
            from.put("lines", prepAddrLines(cnorAddress));
            from.put("suburb", trimAndReplace(cnorSuburb, 40));
            from.put("state", cnorState);
            from.put("postcode", String.format("%04d", cnorPostcode));

            // 将 from 对象添加到 s 中
            s.put("from", from);
        }
        s.put("from", from);

        Map<String, Object> to = new HashMap<>();
        String cneeName = (String) p.get("cnee.name");
        String cneeCompany = (String) p.get("cnee.company");
        String cneeAddress = (String) p.get("cnee.address");
        String cneeSuburb = (String) p.get("cnee.suburb");
        String cneeState = (String) p.get("cnee.state");
        Integer cneePostcode = (Integer) p.get("cnee.postcode");

        to.put("name", trimAndReplace(cneeName, 35));
        to.put("business_name", trimAndReplace(cneeCompany, 40));
        to.put("lines", prepAddrLines(cneeAddress));
        to.put("suburb", trimAndReplace(cneeSuburb, 40));
        to.put("state", cneeState);
        to.put("postcode", String.format("%04d", cneePostcode));

        if (p.get("cnee.tel") != null && !p.get("cnee.tel").toString().isEmpty()) {
            to.put("phone", auTel(p.get("cnee.tel").toString()));
        }
        s.put("to", to);

        // 处理 $insurance
        double scale = Math.pow(10, 2);
        BigDecimal insuranceBigDecimal = (BigDecimal) p.get("insurance");
        double insurance = insuranceBigDecimal.doubleValue();
         insurance = Math.round(insurance / (((int) p.get("pkg") > 0) ? ((int) p.get("pkg")) : 1)*scale)/scale;
        // 处理 $itm
        List<Map<String, Object>> items = new ArrayList<>();
        int pkg = (int) p.get("pkg");
        for (int i = 1; i <= pkg; i++) {
            Map<String, Object> itm = new HashMap<>();
            itm.put("item_reference", p.get("hbn") + "-" + i);

            // always set with 7D53
            itm.put("product_id", prod);
            // itm.put("product_id", AusPostAPI.CHARGE_CODE_NO_POD);

            // shrink weight to 75%
            int units = (pkg > 0) ? pkg : 1;
            BigDecimal weightBigDecimal = (BigDecimal) p.get("weight");
            double weight = weightBigDecimal.doubleValue();
            weight = Double.parseDouble(String.format("%.02f", getBreakWeight(weight/ units)));
            itm.put("weight", weight);
            itm.put("length",p.get("length"));
            itm.put("height",p.get("height"));
            itm.put("width",p.get("width"));
            if (i == 1) {
                p.put("manifest_weight", weight * units);
                // Call p.updateMeta() method here if available in your Java code
            }

            String serviceCode = EPARCEL_CODE; // Define your service code here
            if (CHARGE_CODE_NO_POD.equals(prod)) {
                itm.put("authority_to_leave", true);
            }
            if (CHARGE_CODE_EXPRESS.equals(prod)) {
                itm.put("authority_to_leave", false);
                serviceCode = EXPRESS_CODE; // Define your express code here
            }
            itm.put("partial_delivery_allowed", false);
            if ("PR".equals(prod)) {
                itm.put("type", "EPARCEL POST RETURNS");
                itm.put("group", "Parcel Post");
                itm.put("product_id", "PR");
                itm.put("authority_to_leave", false);
                itm.remove("weight");
            }

            // Calculate aid and set tracking details
            if (p.get("ref") != null && !p.get("ref").toString().isEmpty()) {
                String aid = p.get("ref") + String.format("%02d", i) + serviceCode + "50" + "0";
                aid += String.valueOf(calculateAidCheckDigit(aid));
                Map<String, Object> trackingDetails = new HashMap<>();
                String ref = p.get("ref").toString();
                String suffix = (p.get("mdata.ap_consignment_id_suffix") == null) ? "" : p.get("mdata.ap_consignment_id_suffix").toString();
                String result = ref + suffix;
                trackingDetails.put("consignment_id", result);
                trackingDetails.put("article_id", aid);
                // Add other tracking details if needed
                itm.put("tracking_details", trackingDetails);
            }

            // Set insurance features
            if (insurance > 0) {
                Map<String, Object> features = new HashMap<>();
                Map<String, Object> transitCover = new HashMap<>();
                Map<String, Object> attributes = new HashMap<>();
                attributes.put("cover_amount", insurance);
                transitCover.put("attributes", attributes);
                features.put("TRANSIT_COVER", transitCover);
                itm.put("features", features);
            }

            // Set authority_to_leave and safe_drop_enabled based on insurance value
            if (insurance > 500) {
                itm.put("authority_to_leave", false);
                itm.put("safe_drop_enabled", false);
            }

            items.add(itm);
        }

        s.put("insurance", insurance);
        s.put("items", items);

        return s;
    }

    private String trimAndReplace(String input, int maxLength) {
        if (input == null) {
            return "";
        }
        String trimmed = input.replaceAll("(&#xd|&#xa|&#39| |–)", "\n").trim();
        return trimmed.length() > maxLength ? trimmed.substring(0, maxLength) : trimmed;
    }

    public String auTel(String no) {
        String tel = no.replaceAll("[^\\d]+", "").trim();
        String realTel = tel;

        Pattern pattern = Pattern.compile("^1300(\\d{6})$");
        Matcher matcher = pattern.matcher(tel);
        if (matcher.matches()) {
            realTel = tel;
        } else {
            pattern = Pattern.compile("^61(\\d{10})$");
            matcher = pattern.matcher(tel);
            if (matcher.matches()) {
                realTel = matcher.group(1);
            } else {
                pattern = Pattern.compile("^61(\\d{9})$");
                matcher = pattern.matcher(tel);
                if (matcher.matches()) {
                    realTel = "0" + matcher.group(1);
                } else if (tel.matches("^0\\d{9}$")) {
                    realTel = tel;
                } else {
                    pattern = Pattern.compile("^\\d{9}$");
                    matcher = pattern.matcher(tel);
                    if (matcher.matches()) {
                        realTel = "0" + tel;
                    } else {
                        return "";
                    }
                }
            }
        }

        if (realTel.length() > 10) {
            realTel = realTel.substring(0, 10);
        }
        return realTel;
    }

    public Map<String, Object> prepShipmentData2014(Map<String, Object> p, String prod) {

        Map<String, Object> s = new HashMap<>();
        s.put("shipment_reference", p.get("hbn"));
        s.put("customer_reference_1", p.get("cref"));

        Map<String, Object> from = new HashMap<>();
        from.put("name", COMPANY_NAME_SL.substring(0, Math.min(40, COMPANY_NAME_SL.length())));
        from.put("lines", prepAddrLines(COMPANY_NAME_SL + "\n" + IM_COMPANY_ADDRESS_TLA));
        from.put("suburb", IM_COMPANY_SUBURB);
        from.put("state", IM_COMPANY_STATE);
        from.put("postcode", IM_COMPANY_POSTCODE);

        s.put("from", from);

        Map<String, Object> to = new HashMap<>();
        to.put("name", p.get("cnee.name").toString().substring(0, Math.min(35, p.get("cnee.name").toString().length())));
        to.put("business_name", p.get("cnee.company"));
        to.put("lines", prepAddrLines(p.get("cnee.address").toString()));
        to.put("suburb", p.get("cnee.suburb"));
        to.put("state", p.get("cnee.state"));
        to.put("postcode", String.format("%04d", p.get("cnee.postcode")));

        if (p.get("cnee.tel") != null && !p.get("cnee.tel").toString().isEmpty()) {
            to.put("phone", auTel(p.get("cnee.tel").toString()));
        }

        s.put("to", to);
        double scale = Math.pow(10, 2);
        double insurance = Math.round(Double.parseDouble(p.get("insurance").toString()) / (Integer.parseInt(p.get("pkg").toString()) > 0 ? Integer.parseInt(p.get("pkg").toString()) : 1)*scale)/scale;

        List<Map<String, Object>> items = new ArrayList<>();

        for (int i = 1; i <= Integer.parseInt(p.get("pkg").toString()); i++) {
            Map<String, Object> itm = new HashMap<>();
            itm.put("item_reference", p.get("hbn") + "-" + i);
            itm.put("product_id", CHARGE_CODE_NO_POD);

            int units = Integer.parseInt(p.get("pkg").toString()) > 0 ? Integer.parseInt(p.get("pkg").toString()) : 1;
            double weight = Double.parseDouble(String.format("%.02f", getBreakWeight(Double.parseDouble(p.get("weight").toString()) / units)));
            itm.put("weight", weight);

            if (i == 1) {
                p.put("manifest_weight", weight * units);
                // 调用 p.updateMeta() 方法
            }

            itm.put("authority_to_leave", true);
            itm.put("partial_delivery_allowed", false);

            String aid = p.get("ref").toString() + String.format("%02d", i) + "50" + "2";
            aid += calculateAidCheckDigit(aid);

            Map<String, Object> trackingDetails = new HashMap<>();
            trackingDetails.put("consignment_id", p.get("ref").toString());
            trackingDetails.put("article_id", aid);
            trackingDetails.put("barcode_id", "99700160" + aid + "0" + String.format("%04d", Integer.parseInt(p.get("cnee.postcode").toString())));

            itm.put("tracking_details", trackingDetails);

            if (insurance > 0) {
                Map<String, Object> features = new HashMap<>();
                Map<String, Object> transitCover = new HashMap<>();
                Map<String, Object> attributes = new HashMap<>();
                attributes.put("cover_amount", insurance);

                transitCover.put("attributes", attributes);
                features.put("TRANSIT_COVER", transitCover);
                itm.put("features", features);
            }

            items.add(itm);
        }

        s.put("items", items);

        return s;
    }

    public static Map<String, Object> prepIntShipmentData(Map<String, Object> p, String prod) {
        Map<String, Object> s = new HashMap<>();
        s.put("shipment_reference", p.get("hbn"));
        s.put("customer_reference_1", p.get("cref"));


        Map<String, Object> from = new HashMap<>();
        from.put("name", p.get("cnor.name"));
        from.put("lines", Arrays.asList("Top Logistics", "1/233 Milperra Rd"));
        from.put("suburb", "Bankstown Aerodrome");
        from.put("state", "NSW");
        from.put("postcode", "2200");

        s.put("from", from);

        boolean toChina = p.get("cnee.country").toString().matches("(?i).*\\b(China|PRC|CN)\\b.*");

        Map<String, Object> to = new HashMap<>();
        to.put("name", "Name: " + p.get("cnee.name").toString().substring(0, Math.min(35, p.get("cnee.name").toString().length())));
        to.put("business_name", p.get("cnee.company"));
        to.put("lines", Arrays.asList("Addr: " + p.get("cnee.name") + "  " + p.get("cnee.tel"), p.get("cnee.address")));
        to.put("suburb", toChina ? " " + p.get("cnee.city") + p.get("cnee.suburb") : p.get("cnee.suburb") + " " + p.get("cnee.city"));
        to.put("state", " " + p.get("cnee.state"));
        to.put("postcode", p.get("cnee.postcode"));
        to.put("country", toChina ? "CN" : p.get("cnee.country"));

        if (p.get("cnee.tel") != null && !p.get("cnee.tel").toString().isEmpty()) {
            to.put("phone", p.get("cnee.tel"));
        }

        s.put("to", to);

        Map<String, Object> item = new HashMap<>();
        item.put("item_reference", p.get("hbn"));
        item.put("product_id", prod);
        item.put("weight", p.get("weight"));
        item.put("commercial_value", true);
        item.put("description_of_other", p.get("eitems.g"));
        item.put("classification_type",p.get("classification_type"));

        if (Double.parseDouble(p.get("insurance").toString()) > 0) {
            Map<String, Object> features = new HashMap<>();
            Map<String, Object> transitCover = new HashMap<>();
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("cover_amount", Math.round(Double.parseDouble(p.get("insurance").toString())));
            transitCover.put("attributes", attributes);
            features.put("TRANSIT_COVER", transitCover);
            item.put("features", features);
        }

        List<Map<String, Object>> itemContents = new ArrayList<>();
        Map<String, Object> itemContent = new HashMap<>();
        itemContent.put("country_of_origin", "AU");
        itemContent.put("description", "description");
        itemContent.put("quantity", 1);
        itemContent.put("tariff_code", p.get("eitems.hs[0]"));
        itemContent.put("value", 10.0);
        itemContents.add(itemContent);
        item.put("item_contents", itemContents);

        List<Map<String, Object>> items = new ArrayList<>();
        items.add(item);

        s.put("items", items);

        return s;
    }


        public String request(String action, String method, Object data) throws Exception {
            String result = null;
            String apiUrl = (this.is_test ? this.test_url : this.production_url) + action;
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Set basic authentication
            String auth = this.api_key + ":" + this.api_pwd;
            String encodedAuth = Base64.getEncoder().encodeToString(auth.getBytes());
            connection.setRequestProperty("Authorization", "Basic " + encodedAuth);

            connection.setRequestMethod(method);
            connection.setDoOutput(true);

            // Set headers
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Account-Number", this.api_id);

            // Set data
            if (data != null) {
                String dataString = JSONObject.toJSONString(data);
                byte[] postData = dataString.getBytes("UTF-8");
                connection.setRequestProperty("Content-Length", String.valueOf(postData.length));
                try (DataOutputStream wr = new DataOutputStream(connection.getOutputStream())) {
                    wr.write(postData);
                }
            }

            // Disable SSL certificate verification
            if (connection instanceof HttpsURLConnection) {
                HttpsURLConnection httpsConnection = (HttpsURLConnection) connection;
                SSLContext sslContext = SSLContext.getInstance("TLS");
                sslContext.init(null, new TrustManager[] { new X509TrustManager() {
                    public X509Certificate[] getAcceptedIssuers() {
                        return null;
                    }
                    public void checkClientTrusted(X509Certificate[] certs, String authType) {
                    }
                    public void checkServerTrusted(X509Certificate[] certs, String authType) {
                    }
                }
                }, new java.security.SecureRandom());
                httpsConnection.setSSLSocketFactory(sslContext.getSocketFactory());
                httpsConnection.setHostnameVerifier((hostname, session) -> true);
            }

            // Set a timeout
            connection.setConnectTimeout(600);
            connection.setReadTimeout(600);
            int responseCode = connection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK||responseCode == 201) {
                try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                    String inputLine;
                    StringBuilder response = new StringBuilder();

                    while ((inputLine = in.readLine()) != null) {
                        response.append(inputLine);
                    }

                    result = response.toString();
                }
            }else {
                    // 获取错误响应的内容
                    InputStream errorStream = connection.getErrorStream();
                    if (errorStream != null) {
                        BufferedReader errorReader = new BufferedReader(new InputStreamReader(errorStream));
                        StringBuilder errorResponse = new StringBuilder();
                        String line;

                        while ((line = errorReader.readLine()) != null) {
                            errorResponse.append(line);
                        }

                        errorReader.close();
                        logToFile("Time: " + java.time.LocalDateTime.now() + "\nURL: " + apiUrl + "\nRequest: " + data +
                                "\nResponse Code: " + responseCode + "\nResponse: " + errorResponse.toString() + "\n\n");
                        // 打印错误响应内容
                        System.out.println("HTTP Error Code: " + responseCode);
                        System.out.println("Error Response: " + errorResponse.toString());
                        throw new Exception("HTTP Error: " + responseCode);

                    }
                }

            return result;
    }

    private void logToFile(String message) {
        String logFilePath = "E:\\auspost_api_ErrorLog\\auspost_api_" + getCurrentDate() + ".log";
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(logFilePath, true));
            writer.write(message);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getCurrentDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        return dateFormat.format(date);
    }
}


