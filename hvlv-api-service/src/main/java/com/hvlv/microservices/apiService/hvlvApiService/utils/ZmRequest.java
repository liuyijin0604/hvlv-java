package com.hvlv.microservices.apiService.hvlvApiService.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class ZmRequest {
    private String appKey;
    private String appSecret;
    private String nonce;
    private String version;
    private String token;
    private String ts;
    private Integer timeOut = 18000;
    Map<String, Object> datas;

    public ZmRequest(String appKey, String appSecret, String nonce, String version) {
        this.appKey = appKey;
        this.appSecret = appSecret;
        this.ts = this.getTimeStamp();
        this.nonce = nonce;
        this.version = version;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setDatas(Map<String, Object> datas) {
        this.datas = datas;
    }

    public String getToken(String url) {
        Map<String, Object> params = new HashMap();
        params.put("appKey", this.appKey);
        params.put("appSecret", this.appSecret);
        String result = this.http(url, params, (Map)null, "POST");
        if (Utils.isNotBlank(result)) {
            Map<String, Object> resultMap = (Map)Utils.json2Object(result, Map.class);
            Integer code = Utils.getInteger(resultMap, "result_code");
            if (code != null && code == 0) {
                String token = Utils.getString(resultMap, "body");
                Map<String, Object> tokenMap = (Map)Utils.json2Object(token, Map.class);
                token = Utils.getString(tokenMap, "token");
                return token;
            } else {
                System.out.println(result);
                throw new RuntimeException(Utils.getString(resultMap, "message"));
            }
        } else {
            throw new RuntimeException("返回空数据");
        }
    }

    public Map<String, String> getHeaders() {
        System.out.println("时间戳:" + this.ts);
        System.out.println("原始token:" + this.token);
        String newToken = this.camouflageToken();
        System.out.println("伪装后的token:" + newToken);
        String sign = this.genSign(this.datas);
        System.out.println("计算后的签名:" + sign);
        Map<String, String> headers = new HashMap();
        headers.put("token", newToken);
        headers.put("version", this.version);
        headers.put("sign", sign);
        return headers;
    }

    public String getTimeStamp() {
        return String.valueOf(System.currentTimeMillis());
    }

    public String getMd5(String str) {
        return null;
    }

    public String camouflageToken() {
        System.out.println("从pos获取的原始token：{}" + this.token);
        if (Utils.isBlank(this.token)) {
            throw new RuntimeException("获取token异常");
        } else {
            Map<String, Object> map = new HashMap();
            map.put("timestamp", this.ts);
            map.put("nonce", this.nonce);
            map.put("token", this.token);
            System.out.println("待生成新token的参数 ：{}" + map.toString());
            String newTokenJson = Utils.toJson(map);
            String newToken = Utils.encodeMixChar(newTokenJson);
            System.out.println("最终生成的新token：{}" + newToken);
            return newToken;
        }
    }

    public String genSign(Map<String, Object> pds) {
        Map<String, Object> signMap = new HashMap();
        if (pds != null && pds.size() > 0) {
            Iterator var4 = pds.entrySet().iterator();

            while(var4.hasNext()) {
                Entry<String, Object> entry = (Entry)var4.next();
                signMap.put((String)entry.getKey(), entry.getValue());
            }
        }

        signMap.put("version", this.version);
        signMap.put("nonce", this.nonce);
        signMap.put("timestamp", this.ts);
        signMap.put("token", this.token);
        String sign = Utils.sign(signMap, this.appSecret);
        return sign;
    }

    public String request(String url, String method) {
        Map<String, String> headers = this.getHeaders();
        String result = "";
        result = this.http(url, this.datas, headers, method);
        return result;
    }

    private String http(String requestUrl, Map<String, Object> params, Map<String, String> headers, String method) {
        String param = "";
        if (params != null) {
            param = this.convertParams(params);
            System.out.println("path:" + requestUrl + "?" + param);
        }

        HttpURLConnection connection = null;
        InputStream is = null;
        OutputStream os = null;
        BufferedReader br = null;
        String result = null;

        try {
            URL url = new URL(requestUrl);
            connection = (HttpURLConnection)url.openConnection();
            connection.setRequestMethod(method.toUpperCase());
            connection.setConnectTimeout(this.timeOut);
            connection.setReadTimeout(this.timeOut);
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            String line;
            if (headers != null) {
                Set<String> set = headers.keySet();
                if (set != null && set.size() > 0) {
                    Iterator var14 = set.iterator();

                    while(var14.hasNext()) {
                        line = (String)var14.next();
                        String value = (String)headers.get(line);
                        connection.setRequestProperty(line, value);
                    }
                }
            }

            os = connection.getOutputStream();
            if (param != null && param.length() > 0) {
                os.write(param.getBytes());
            }

            if (connection.getResponseCode() == 200) {
                is = connection.getInputStream();
                br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
                StringBuffer sbf = new StringBuffer();
                line = null;

                while((line = br.readLine()) != null) {
                    sbf.append(line);
                    sbf.append("\r\n");
                }

                result = sbf.toString();
            }
        } catch (Exception var24) {
            var24.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }

                if (is != null) {
                    is.close();
                }

                if (os != null) {
                    os.close();
                }
            } catch (Exception var23) {
                var23.printStackTrace();
            }

            connection.disconnect();
        }

        return result;
    }

    private String convertParams(Map<String, Object> params) {
        try {
            String queryString = "";
            if (params != null) {
                Set<Entry<String, Object>> entrySet = params.entrySet();

                Entry entry;
                for(Iterator var5 = entrySet.iterator(); var5.hasNext(); queryString = queryString + (String)entry.getKey() + "=" + URLEncoder.encode(entry.getValue().toString(), "utf-8")) {
                    entry = (Entry)var5.next();
                    if (queryString.length() > 0) {
                        queryString = queryString + "&";
                    }
                }
            }

            return queryString;
        } catch (UnsupportedEncodingException var6) {
            var6.printStackTrace();
            throw new RuntimeException(var6);
        }
    }
}

