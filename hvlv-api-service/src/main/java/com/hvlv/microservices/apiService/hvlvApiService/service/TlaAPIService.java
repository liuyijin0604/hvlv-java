package com.hvlv.microservices.apiService.hvlvApiService.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.security.cert.X509Certificate;

@Service
public class TlaAPIService {
    protected String domain = "https://api.toplogistics.com.au";
    protected String api_user = "tla";
    protected String api_key = "d47bf1edad3c73d2748231e0bf2b891e1737cbde232009f488854b5f325a7c27";

    public TlaAPIService() {

    }
    public Map<String, Object> createShipment() {
        Map<String, Object> params = new HashMap<>();
        params.put("api_id", this.api_user);
        params.put("method", "create");
        return httpPost("shipment", params);
    }
    public Map<String, Object> createShipment(Map<String, Object> params) {
        params.put("api_id", this.api_user);
        params.put("method", "create");
        return httpPost("shipment", params);
    }
    public Map<String, Object> updateShipment(Map<String, Object> params) {
        params.put("api_id", this.api_user);
        params.put("method", "update");
        return httpPost("shipment", params);
    }
    public Map<String, Object> cancelShipment(Map<String, Object> params) {
        params.put("api_id", this.api_user);
        params.put("method", "cancel");
        return httpPost("shipment", params);
    }
    public Map<String, Object> updateShipmentCustomStatus(Map<String, Object> params) {
        params.put("api_id", this.api_user);
        params.put("method", "updateShipmentStatusForPCAE");
        return httpPost("shipment", params);
    }
    public Map<String, Object> doTNTRouting(Map<String, Object> params) {
        params.put("api_id", this.api_user);
        params.put("method", "doTNTRouting");
        return httpPost("shipment", params);
    }
    public String genLabelBase64(Map<String, Object> params) throws JsonProcessingException {
        params.put("api_id", this.api_user);
        params.put("method", "labelforJava");
        return httpPostBase64Label("shipment", params);
    }

    public byte[] genLabelPdf(Map<String, Object> params) throws IOException {
        params.put("api_id", this.api_user);
        params.put("method", "labelforJava");
        byte[] pdfContent = httpPostPdfLabel("shipment", params);
        return pdfContent;
    }

    protected String getRequestUrl(String endpoint, HashMap<String, String> params) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(domain)
                .path(endpoint);
        if (params != null && !params.isEmpty()) {
            for (Map.Entry<String, String> entry : params.entrySet()) {
                builder.queryParam(entry.getKey(), entry.getValue());
            }
        }

        return builder.build().toString();
    }

    protected String getRequestUrl(String endpoint) {

        StringBuilder urlBuilder = new StringBuilder(domain);
        return urlBuilder.append("/").append(endpoint).toString();
    }

    public Map<String, Object> httpPost(String endpoint, Map<String, Object> oParams) {
        Map<String, Object> params = this.genSign(oParams);

        try {
            // Create URL object
            URL url = new URL(getRequestUrl(endpoint));

            // Create connection object
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Set the request method to POST
            connection.setRequestMethod("POST");

            // Disable SSL verification (not recommended for production)
            try {
                // Create a TrustManager that trusts all certificates
                TrustManager[] trustAllCertificates = new TrustManager[]{
                        new X509TrustManager() {
                            public X509Certificate[] getAcceptedIssuers() {
                                return null;
                            }

                            public void checkClientTrusted(X509Certificate[] certs, String authType) {
                            }

                            public void checkServerTrusted(X509Certificate[] certs, String authType) {
                            }
                        }
                };

                // Set up an SSL context with the TrustManager
                SSLContext sslContext = SSLContext.getInstance("TLS");
                sslContext.init(null, trustAllCertificates, new java.security.SecureRandom());

                // Use the SSL context to disable SSL hostname verification
                HttpsURLConnection.setDefaultSSLSocketFactory(sslContext.getSocketFactory());
                HttpsURLConnection.setDefaultHostnameVerifier((hostname, session) -> true);
            } catch (Exception e) {
                e.printStackTrace();
            }

            // Prepare the parameters
            StringBuilder postData = new StringBuilder();
            for (Map.Entry<String, Object> entry : params.entrySet()) {
                if (postData.length() != 0) postData.append('&');
                postData.append(entry.getKey());
                postData.append('=');
                postData.append(entry.getValue());
            }

            // Enable input/output streams
            connection.setDoOutput(true);
            DataOutputStream outputStream = new DataOutputStream(connection.getOutputStream());
            outputStream.writeBytes(postData.toString());
            outputStream.flush();
            outputStream.close();

            // Get the HTTP response code
            int httpResponseCode = connection.getResponseCode();

            if (httpResponseCode != HttpURLConnection.HTTP_OK) {
                return new HashMap<String, Object>() {{
                    put("done", false);
                }};
            }

            // Read the response
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }

            in.close();
            connection.disconnect();

            // Extract the response details
            this.logToFile(params.toString());
//            log2file(response.toString());

            // Parse the JSON response
            // You may need to include a JSON parsing library like Gson or Jackson for this
            // Here, we assume you have a method to parse JSON into a Map
            HashMap<String, Object> httpParsedResponseAr = new HashMap<>(JSONObject.parseObject(response.toString()));

            if (httpParsedResponseAr.isEmpty()) {
                return new HashMap<String, Object>() {{
                    put("done", false);
                }};
            }

            httpParsedResponseAr.put("done", true);
            return httpParsedResponseAr;
        } catch (IOException e) {
            e.printStackTrace();
            return new HashMap<String, Object>() {{
                put("done", false);
            }};
        }
    }

    public String httpPostBase64Label(String endpoint, Map<String, Object> oParams) throws JsonProcessingException {
        Map<String, Object> params = this.genSign(oParams);
        ObjectMapper objectMapper = new ObjectMapper();
        String result;

        try {
            // Create URL object
            URL url = new URL(getRequestUrl(endpoint));

            // Create connection object
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Set the request method to POST
            connection.setRequestMethod("POST");

            // Disable SSL verification (not recommended for production)
            try {
                // Create a TrustManager that trusts all certificates
                TrustManager[] trustAllCertificates = new TrustManager[]{
                        new X509TrustManager() {
                            public X509Certificate[] getAcceptedIssuers() {
                                return null;
                            }

                            public void checkClientTrusted(X509Certificate[] certs, String authType) {
                            }

                            public void checkServerTrusted(X509Certificate[] certs, String authType) {
                            }
                        }
                };

                // Set up an SSL context with the TrustManager
                SSLContext sslContext = SSLContext.getInstance("TLS");
                sslContext.init(null, trustAllCertificates, new java.security.SecureRandom());

                // Use the SSL context to disable SSL hostname verification
                HttpsURLConnection.setDefaultSSLSocketFactory(sslContext.getSocketFactory());
                HttpsURLConnection.setDefaultHostnameVerifier((hostname, session) -> true);
            } catch (Exception e) {
                e.printStackTrace();
            }

            // Prepare the parameters
            StringBuilder postData = new StringBuilder();
            for (Map.Entry<String, Object> entry : params.entrySet()) {
                if (postData.length() != 0) postData.append('&');
                postData.append(entry.getKey());
                postData.append('=');
                postData.append(entry.getValue());
            }

            // Enable input/output streams
            connection.setDoOutput(true);
            DataOutputStream outputStream = new DataOutputStream(connection.getOutputStream());
            outputStream.writeBytes(postData.toString());
            outputStream.flush();
            outputStream.close();

            // Get the HTTP response code
            int httpResponseCode = connection.getResponseCode();

            if (httpResponseCode != HttpURLConnection.HTTP_OK) {
                result = "shipment not found";
                return result;

            }

            // Read the response
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }

            in.close();
            connection.disconnect();

            // Extract the response details
            this.logToFile(params.toString());
            this.logToFile(response.toString());

            // Parse the JSON response
            // You may need to include a JSON parsing library like Gson or Jackson for this
            // Here, we assume you have a method to parse JSON into a Map
            // HashMap<String, Object> httpParsedResponseAr = new HashMap<>(JSONObject.parseObject(response.toString()));

//            if (httpParsedResponseAr.isEmpty()) {
//                return "done:false";
//                return new HashMap<String, Object>() {{
//                    put("done", false);
//                }};
//            }
            if (!response.toString().isEmpty()){
                result = response.toString();
                return result;
            }
            else{
                result = "response empty.";
                return result;
            }

        } catch (IOException e) {
            e.printStackTrace();
            result =e.toString();
            return result;

        }
    }

    public byte[] httpPostPdfLabel(String endpoint, Map<String, Object> oParams) throws IOException {
        Map<String, Object> params = this.genSign(oParams);

        try {
            // Create URL object
            URL url = new URL(getRequestUrl(endpoint));

            // Create connection object
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Set the request method to POST
            connection.setRequestMethod("POST");

            // Disable SSL verification (not recommended for production)
            try {
                // Create a TrustManager that trusts all certificates
                TrustManager[] trustAllCertificates = new TrustManager[]{
                        new X509TrustManager() {
                            public X509Certificate[] getAcceptedIssuers() {
                                return null;
                            }

                            public void checkClientTrusted(X509Certificate[] certs, String authType) {
                            }

                            public void checkServerTrusted(X509Certificate[] certs, String authType) {
                            }
                        }
                };

                // Set up an SSL context with the TrustManager
                SSLContext sslContext = SSLContext.getInstance("TLS");
                sslContext.init(null, trustAllCertificates, new java.security.SecureRandom());

                // Use the SSL context to disable SSL hostname verification
                HttpsURLConnection.setDefaultSSLSocketFactory(sslContext.getSocketFactory());
                HttpsURLConnection.setDefaultHostnameVerifier((hostname, session) -> true);
            } catch (Exception e) {
                e.printStackTrace();
            }

            // Prepare the parameters
            StringBuilder postData = new StringBuilder();
            for (Map.Entry<String, Object> entry : params.entrySet()) {
                if (postData.length() != 0) postData.append('&');
                postData.append(entry.getKey());
                postData.append('=');
                postData.append(entry.getValue());
            }

            // Enable input/output streams
            connection.setDoOutput(true);
            DataOutputStream outputStream = new DataOutputStream(connection.getOutputStream());
            outputStream.writeBytes(postData.toString());
            outputStream.flush();
            outputStream.close();

            // Get the HTTP response code
            int httpResponseCode = connection.getResponseCode();

            if (httpResponseCode != HttpURLConnection.HTTP_OK) {
                return null;
//                return new HashMap<String, Object>() {{
//                    put("done", false);
//                }};
            }

//            // Read the response
//            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//            StringBuilder response = new StringBuilder();
//            String inputLine;
//
//            while ((inputLine = in.readLine()) != null) {
//                response.append(inputLine);
//            }
//
//            in.close();
//            connection.disconnect();

            // 获取输入流
            try (InputStream inputStream = new BufferedInputStream(connection.getInputStream())) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] buffer = new byte[4096];
                int bytesRead;

                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    byteArrayOutputStream.write(buffer, 0, bytesRead);
                }

                if (byteArrayOutputStream != null){
                    return byteArrayOutputStream.toByteArray();
                }
                else{
                    return new byte[0];
                }

            } finally {
                connection.disconnect();
            }

            // Extract the response details
//            this.logToFile(params.toString());
//            log2file(response.toString());

            // Parse the JSON response
            // You may need to include a JSON parsing library like Gson or Jackson for this
            // Here, we assume you have a method to parse JSON into a Map

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    protected Map<String, Object> httpPut(String endpoint, Map<String, Object> params) {
        // Call the genSign method
        params = genSign(params);

        Map<String, Object> result = new HashMap<>();

        try {
            // Construct the URL
            String url = getRequestUrl(endpoint);
            URL apiUrl = new URL(url);

            // Create a HttpURLConnection
            HttpURLConnection connection = (HttpURLConnection) apiUrl.openConnection();
            connection.setRequestMethod("PUT");
            connection.setDoOutput(true);

            StringBuilder requestBody = new StringBuilder();
            for (Map.Entry<String, Object> entry : params.entrySet()) {
                if (requestBody.length() > 0) {
                    requestBody.append("&");
                }
                requestBody.append(entry.getKey()).append("=").append(entry.getValue());
            }

            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = requestBody.toString().getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            int responseCode = connection.getResponseCode();
            StringBuilder response = null;
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                if (response != null && response.length()>0) {
                    result.put("done", true);
                    result.put("response", response.toString());
                    return result;
                }

                // return response.toString();
            }
            // Log the response and other actions as needed
            logToFile(JSON.toJSONString(params));
            logToFile(response.toString());
            JSONObject httpParsedResponseAr = JSON.parseObject(response.toString());

            if (httpParsedResponseAr == null || httpParsedResponseAr.isEmpty()) {
                Map<String, Object> nullResult = new HashMap<>();
                nullResult.put("done", false);
                nullResult.put("status", 0);

                return nullResult;
            }
            httpParsedResponseAr.put("done", true);
            return httpParsedResponseAr;

        } catch (Exception e) {
            e.printStackTrace();
            result.put("done", false);
            result.put("error", e.getMessage());
        }

        // Return the parsed response
        return result;
    }

    protected String getRequestUrl(String endpoint, Map<String, Object> params) {

        StringBuilder urlBuilder = new StringBuilder(endpoint);
        if (params != null && !params.isEmpty()) {
            urlBuilder.append("?");

            for (Map.Entry<String, Object> entry : params.entrySet()) {

                String key = entry.getKey();
                Object value = entry.getValue();

                urlBuilder.append(key).append("=").append(value).append("&");
            }
        }

        urlBuilder.append("/").append(endpoint);
        return urlBuilder.toString();
    }

    public Map<String, Object> genSign(Map<String, Object> params) {
        // 将 data 参数转换为 JSON 字符串
        params.put("data", params.get("data"));

        // 对参数按字典顺序排序
        Map<String, Object> sortedParams = new TreeMap<>(params);
        // 构建签名字符串
        StringBuilder signature = new StringBuilder(api_key);

        for (Map.Entry<String, Object> entry : sortedParams.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();

            if (!key.equals("sign") && value != null) {
                signature.append(key).append(value);
            }
        }

        signature.append(api_key);

        // 计算签名并设置到参数中
        String signatureMd5;
        String sign = DigestUtils.md5Hex(signature.toString()).toUpperCase();
        params.put("sign", sign);
        return params;
        // params.put("sign", md5UpperCase(signature.toString()));
    }

    protected void logToFile(String message) {
        // String logFilePath = "C:\\auspost_api_ErrorLog\\auspost_api_" + getCurrentDate() + ".log";
        String logFilePath = "C:\\xampp\\htdocs\\hvlv_branch\\protected\\runtime\\tla\\tla_" + getCurrentDate() + ".log";
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
