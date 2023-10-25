package com.hvlv.microservices.apiService.hvlvApiService.service;

import com.hvlv.microservices.apiService.hvlvApiService.beans.ApiAddrBean;
import com.hvlv.microservices.apiService.hvlvApiService.beans.SaveDistanceRequest;
import com.hvlv.microservices.apiService.hvlvApiService.entity.*;
import com.hvlv.microservices.apiService.hvlvApiService.client.LabelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


@Service
public class GoogleMapAPIService {
//    @Autowired
//    AddrBean addr;
//    @Autowired
//    PostcodeDistance postcodeDistance;
    @Autowired
    LabelClient labelClient;

    private String API_KEY;
    private String AVOID;
    private String BASE_URL;
    private String GEOCODE_URL;
    private static final int PCAE_DEPARTMENT_SYDNEY = 106;
    private static final int PCAE_DEPARTMENT_MELBOURNE = 218;
    private static final int PCAE_DEPARTMENT_BRISBANE = 530;
    private static final int PCAE_DEPARTMENT_PERTH = 529;
    private static final int PCAE_DEPARTMENT_ADELAIDE = 811;
    private static final String syndey = "-33.93081528218377, 151.0056033399989";
    private static final String melbourne = "-37.80115472967032, 144.8410692764063";
    private static final String brisbane = "-27.5628709,153.0247358";
    private static final String perth = "-31.9516594,115.8622073";
    private static final String adelaide = "-34.9199013,138.601643";
    public GoogleMapAPIService() {
        AVOID = "toll";
        API_KEY = "AIzaSyCFGT6c16Ja26GRVWYHAAJeLVOTtVGJU20";
        BASE_URL = "https://maps.googleapis.com/maps/api/distancematrix/json";
        GEOCODE_URL = "https://maps.googleapis.com/maps/api/geocode/json";
    }

    public Map<String, Object> requestAPI(String origin, String destination) {
        Map<String,String> params = new HashMap<>();
        params.put("origins",origin);
        params.put("destinations", destination);
        params.put("avoid", AVOID);
        params.put("key", API_KEY);
        Map<String, Object> apiResponse = performActualAPIRequest(BASE_URL, params);
        return apiResponse;
    }
    public Map<String, Object> requestGeocodeAPI(String address) {
        Map<String, String> params = new HashMap<>();
        params.put("address", address);
        params.put("key", API_KEY);

        Map<String, Object> apiResponse = performActualAPIRequest(GEOCODE_URL, params);
        return apiResponse;
    }
    public Integer getDistanceBetweenPostcode(int warehouse, String destination) {
        String origin =null;
        switch(warehouse){
          case PCAE_DEPARTMENT_SYDNEY:
            origin = syndey;
            break;
          case PCAE_DEPARTMENT_MELBOURNE:
             origin = melbourne;
             break;
          case PCAE_DEPARTMENT_BRISBANE:
             origin = brisbane;
             break;
          case PCAE_DEPARTMENT_PERTH:
              origin = perth;
              break;
          case PCAE_DEPARTMENT_ADELAIDE:
              origin = adelaide;
              break;
        }
        Map<String,Object> result = requestAPI(origin,destination);
        Integer distanceValue = null;

        List<Map<String, Object>> rows = (List<Map<String, Object>>) result.get("rows");
        if (rows != null && !rows.isEmpty()) {
            Map<String, Object> firstRow = rows.get(0);
            List<Map<String, Object>> elements = (List<Map<String, Object>>) firstRow.get("elements");
            if (elements != null && !elements.isEmpty()) {
                Map<String, Object> firstElement = elements.get(0);
                Map<String, Object> distance = (Map<String, Object>) firstElement.get("distance");
                distanceValue = (Integer) distance.get("value");
            }
        }

        if (distanceValue != null) {
            return (int) Math.ceil(distanceValue / 1000.0);
        } else {
            return null;
        }
    }
    public Integer getDistance(ApiAddrBean addr) {
        String jsonData = "{\"origin\":\"" + addr.getDptId() + "\",\"destination\":\"" + addr.getPostcode() + "\",\"suburb\":\"" + addr.getSuburb().toUpperCase() + "\",\"state\":\"" + addr.getState() + "\"}";
        System.out.println(jsonData);
        PostcodeDistance distanceObj = labelClient.getPostcodeDistance(jsonData);
        Integer distance = 0;
        if (distanceObj == null) {
            String destination = addr.getSuburb() + " " + addr.getState() + " " + addr.getCountry() + " " + addr.getPostcode();
            distance = getDistanceBetweenPostcode(addr.getDptId(), destination);

            SaveDistanceRequest saveDistanceRequest = new SaveDistanceRequest(addr, distance);
            labelClient.savePostcodeDistance(saveDistanceRequest);
        } else {
            distance = distanceObj.getDistance();
        }
        return distance;
    }

    public Map<String, Object> getAddress(ApiAddrBean addr, String country, boolean missPostcode, boolean isBreak) {
        Map<String, Object> result = new HashMap<>();

        // 1. 根据传入的addr对象构建地址字符串
        String address = addr.getAddress().replaceAll("^\\d+([A-z]{3,})", "$1 $2") + "," +
                addr.getSuburb() + "," +
                addr.getState() + " " + addr.getPostcode() + "," +
                country;

        if (missPostcode) {
            address = addr.getAddress() + "," + addr.getSuburb() + " " + addr.getState() + "," + country;
        }

        // 2. 调用请求Geocode API的方法
        Map<String, Object> geocodeResponse = requestGeocodeAPI(address);

        // 3. 解析Geocode API的响应数据并构建结果对象
        if (geocodeResponse.containsKey("results") && geocodeResponse.get("results") instanceof List) {
            List<Map<String, Object>> results = (List<Map<String, Object>>) geocodeResponse.get("results");

            if (!results.isEmpty()) {
                Map<String, Object> com = results.get(0);
                List<Map<String, Object>> coms = com.containsKey("address_components") ? (List<Map<String, Object>>) com.get("address_components") : null;

                if (com.containsKey("geometry") && com.get("geometry") instanceof Map) {
                    Map<String, Object> geometry = (Map<String, Object>) com.get("geometry");
                    String locationType = geometry.containsKey("location_type") ? geometry.get("location_type").toString() : "";

                    if ("APPROXIMATE".equals(locationType) && !checkIsPoBox(addr.getAddress())) {
                        return null;
                    }
                }

                // 4. 解析地址组件数据
                Map<String, Object> addressData = new HashMap<>();
                addressData.put("address", "");
                addressData.put("suburb", "");
                addressData.put("state", "");
                addressData.put("postcode", "");
                addressData.put("country", country);

                if (coms != null) {
                    for (Map<String, Object> value : coms) {
                        List<String> types = (List<String>) value.get("types");
                        if (types != null && !types.isEmpty()) {
                            String firstType = types.get(0);
                            if ("subpremise".equals(firstType)) {
                                addressData.put("address", addressData.get("address").toString() + value.get("long_name").toString() + "/");
                            } else if ("street_number".equals(firstType)) {
                                addressData.put("address", addressData.get("address").toString() + value.get("long_name") + " ");
                            } else if ("route".equals(firstType)) {
                                addressData.put("address", addressData.get("address").toString() + value.get("long_name"));
                            } else if (("locality".equals(firstType) && types.contains("political")) ||
                                    ("colloquial_area".equals(firstType) && types.contains("locality") && types.contains("political"))) {
                                addressData.put("suburb", value.get("short_name"));
                            }
                            else if ("administrative_area_level_1".equals(firstType) && types.contains("political")) {
                                addressData.put("state", value.get("short_name"));
                            }
                            else if ("postal_code".equals(firstType)) {
                                addressData.put("postcode", value.get("short_name"));
                            } else if ("country".equals(firstType) && types.contains("political")) {
                                addressData.put("country", value.get("short_name"));
                                if (!"AU".equals(addressData.get("country"))) {
                                    return null;
                                }
                            }
                        }
                    }
                }

                result.put("address", addressData);
            }
        }
        return result;
    }

    public Map<String, Object> correctAddress(String streetLine, String suburb, String state, String postcode, String country, boolean missPostcode, boolean returnError) {
        // 构建地址字符串
        String address = streetLine + "," + suburb + "," + state + " " + postcode + "," + country;
        if (missPostcode) {
            address = streetLine + "," + suburb + "," + state + "," + country;
        }

        // 调用请求地理编码的方法
        Map<String, Object> result = requestGeocodeAPI(address);

        // 创建 Map 用于存储结果
        Map<String, Object> addressData = new HashMap<>();
        addressData.put("address", "");
        addressData.put("suburb", "");
        addressData.put("state", "");
        addressData.put("postcode", "");
        addressData.put("country", country);
        addressData.put("notFound", 0);
        addressData.put("error", "");

        if (!result.isEmpty() && result.containsKey("results")) {
            List<Map<String, Object>> results = (List<Map<String, Object>>) result.get("results");
            if (!results.isEmpty()) {
                Map<String, Object> com = results.get(0);
                List<Map<String, Object>> coms = com.containsKey("address_components") ? (List<Map<String, Object>>) com.get("address_components") : new ArrayList<>();

                if ("APPROXIMATE".equals(com.get("geometry.location_type")) && !checkIsPoBox(streetLine)) {
                    addressData.put("notFound", 1);
                    addressData.put("error", " - System can not validate this address.");
                }

                for (Map<String, Object> value : coms) {
                    List<String> types = (List<String>) value.get("types");

                    if (types != null && !types.isEmpty()) {
                        if ("subpremise".equals(types.get(0))) {
                            addressData.put("address", addressData.get("address").toString() + value.get("long_name") + "/");
                        } else if ("street_number".equals(types.get(0))) {
                            addressData.put("address", addressData.get("address").toString() + value.get("long_name") + " ");
                        } else if ("route".equals(types.get(0))) {
                            addressData.put("address", addressData.get("address").toString() + value.get("long_name"));
                        } else if (("locality".equals(types.get(0)) && "political".equals(types.get(1))) ||
                                ("colloquial_area".equals(types.get(0)) && "locality".equals(types.get(1)) && "political".equals(types.get(2)))) {
                            addressData.put("suburb", value.get("short_name"));
                        } else if ("administrative_area_level_1".equals(types.get(0)) && "political".equals(types.get(1))) {
                            addressData.put("state", value.get("short_name"));
                        } else if ("postal_code".equals(types.get(0))) {
                            addressData.put("postcode", value.get("short_name"));
                        } else if ("country".equals(types.get(0)) && "political".equals(types.get(1))) {
                            addressData.put("country", value.get("short_name"));
                            if (!"AU".equals(addressData.get("country"))) {
                                addressData.put("error", " - This address is not in Australia.");
                            }
                        }
                    }
                }
            }
        }

        if (returnError || !addressData.get("error").toString().isEmpty()) {
            // 如果需要返回错误信息
            if (!addressData.get("suburb").toString().equalsIgnoreCase(suburb)) {
                addressData.put("error", "- Wrong Suburb: " + suburb + ", approximate should be: " + addressData.get("suburb"));
            }
            if (!addressData.get("state").toString().equalsIgnoreCase(state)) {
                addressData.put("error", "- Wrong State: " + state + ", approximate should be: " + addressData.get("state"));
            }
            if (!addressData.get("postcode").toString().equals(postcode)) {
                addressData.put("error", "- Wrong Postcode: " + postcode + ", approximate should be: " + addressData.get("postcode"));
            }
            if (!addressData.get("error").toString().isEmpty()) {
                addressData.put("error", "[90001] " + addressData.get("error"));
            }
        }

        return addressData;
    }

    private boolean checkIsPoBox(String address) {
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
        return matchesCriteria;
    }

    private Map<String,Object> performActualAPIRequest(String url,Map<String, String> params)
    {
        String apiUrl = url + "?" +
                params.entrySet().stream()
                        .map(entry -> entry.getKey() + "=" + entry.getValue())
                        .collect(Collectors.joining("&"));
        String apiUrl1=apiUrl;
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(apiUrl,Map.class);
    }
}
