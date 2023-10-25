package com.hvlv.microservices.apiService.hvlvApiService.service;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.client.core.SoapActionCallback;
import org.springframework.ws.soap.saaj.SaajSoapMessageFactory;
import org.springframework.ws.transport.http.HttpComponentsMessageSender;

import javax.xml.soap.MessageFactory;

public class TNTService {

    /************************Service Type***********/
    public static final String SERVICE_SYD = "TNT_SYDNEY";
    public static final String SERVICE_MEL = "TNT_MELBOURNE";
    public static final String SERVICE_BNE = "TNT_BRISBANE";
    public static final String SERVICE_SYD_TOP = "TNT_SYDNEY_TOP";
    public static final String SERVICE_MEL_TOP = "TNT_MELBOURNE_TOP";
    public static final String SERVICE_BNE_TOP = "TNT_BRISBANE_TOP";
    public static final String SERVICE_PER_TOP = "TNT_PERTH_TOP";

    public static final String SERVICE_TEST = "TNT_TEST";
    /*************************************************/
    public static final String API_USER_ID = "CIT00000000000110801";
    public static final String API_USER_PASSWORD = "pcatnt2018";

    public static final String ITEM_UNIQUE_NUMBER = "12"; //assigned by TNT for own system

    public static final int ROAD_SERVICE_CODE = 76;
    public static final int OVERNIGHT_EXPRESS_CODE = 75;

    public static final String PRODUCTION_URL = "https://www.tntexpress.com.au/webservices/conservice/ConsignmentService.svc?wsdl"; //web API production
    public static final String TEST_URL = "https://tntuat.pca168.com/Webservices/Conservice/ConsignmentService.svc?wsdl";    //Web API Test API
    public static final String TRACKING_URL = "http://www.tntexpress.com.au/link/Cnmhx2.asp?";   //Tracking API
    public static final String ROUTING_URL = "http://www.tntexpress.com.au/routing/routingservice.svc?wsdl";   //GET ROUTING INFORMATION for SELF OWN SYSTEM;
    public static final String GET_SERVICE_URL = "https://www.tntexpress.com.au/Rtt/inputRequest.asp";   //RTT
    private static final String USERNAME = "routingservice";
    private static final String PASSWORD = "gfMHJS*f";
    private static final String SOAP_ACTION = "GetRoutingInformation";

    /********************* SYDNEY SERVICE INFORMATION *********/
    public static final String ACCOUNT_NUMBER = "30031521";
    public static final String SENDER_CODE = "PCTLS";
    public static final String LABEL_PREFIX = "TLS";
    public static final String SYDNEY_SUBURB = "BANKSTOWN AERODROME";
    public static final String SYDNEY_POSTCODE = "2200";
    public static final String SYDNEY_ADDRESS = "1/233 Milperra Rd";
    public static final String SYDNEY_STATE = "NSW";
    /********************************************************/

    /****************** MELBOURNE SERVICE INFORMATION *******/
    public static final String MEL_ACCOUNT_NUMBER = "30031520";
    public static final String MEL_SENDER_CODE = "PCTLM";
    public static final String MEL_LABEL_PREFIX = "LMA";
    public static final String MEL_SUBURB = "SUNSHINE";
    public static final String MEL_POSTCODE = "3020";
    public static final String MEL_ADDRESS = "3B/8 Judge St";
    public static final String MEL_STATE = "VIC";
    /********************************************************/
    public static final String API_TEST_USER_ID = "CIT00000000000100794";
    public static final String API_TEST_PASSWORD = "uatTNT123";
    public static final String TEST_ACCOUNT_NUMBER = "30024461";

    public static final Map<String, Map<String, String>> api_accounts = new HashMap<>();

    static {
        System.setProperty("javax.xml.soap.MessageFactory", "com.sun.xml.internal.messaging.saaj.soap.ver1_2.SOAPMessageFactory1_2Impl");
        Map<String, String> sydTop = new HashMap<>();
        sydTop.put("account_number", "30031521");
        sydTop.put("sender_code", "PCTLS");
        sydTop.put("label_prefix", "TLS");
        sydTop.put("suburb", "BANKSTOWN AERODROME");
        sydTop.put("postcode", "2200");
        sydTop.put("address", "1/233 Milperra Rd");
        sydTop.put("state", "NSW");
        api_accounts.put(SERVICE_SYD_TOP, sydTop);

        Map<String, String> melTop = new HashMap<>();
        melTop.put("account_number", "30031520");
        melTop.put("sender_code", "PCTLM");
        melTop.put("label_prefix", "LMA");
        melTop.put("suburb", "SUNSHINE");
        melTop.put("postcode", "3020");
        melTop.put("address", "3B/8 Judge St");
        melTop.put("state", "VIC");
        api_accounts.put(SERVICE_MEL_TOP, melTop);

        Map<String, String> bneTop = new HashMap<>();
        bneTop.put("account_number", "30031800");
        bneTop.put("sender_code", "PCTLB");
        bneTop.put("label_prefix", "TBC");
        bneTop.put("suburb", "Coopers Plains");
        bneTop.put("postcode", "4108");
        bneTop.put("address", "6/55 Musgrave Rd");
        bneTop.put("state", "QLD");
        api_accounts.put(SERVICE_BNE_TOP, bneTop);

        Map<String, String> perTop = new HashMap<>();
        perTop.put("account_number", "30032250");
        perTop.put("sender_code", "PCTLP");
        perTop.put("label_prefix", "LPC");
        perTop.put("suburb", "HIGH WYCOMBE");
        perTop.put("postcode", "6057");
        perTop.put("address", "151 Milner Rd");
        perTop.put("state", "WA");
        api_accounts.put(SERVICE_PER_TOP, perTop);
    }

    private boolean is_test = true;
    private String user_id;
    private String user_passwd;
    private String select_service_code = "76";
    private String collection_suburb = "Bankstown Aerodrome";
    private String collection_postcode = "2200";
    private String collection_address = "1/233 Milperra Rd";
    private String collection_state = "NSW";
    private String select_service = SERVICE_SYD;
    private String select_sender_code = SENDER_CODE;
    private String select_account_number = ACCOUNT_NUMBER;

    public static final String CONSIGNMENT_FINAL_YES = "Y";
    public static final String CONSIGNMENT_FINAL_NO = "N";
    public static final String str_syd_top = "syd_top";
    public static final String str_mel_top = "mel_top";
    public static final String str_bne_top = "bne_top";
    public static final String str_per_top = "per_top";

    private TNTService(String user_id, String user_passwd, String service, boolean is_test) {
        this.user_id = user_id;
        this.user_passwd = user_passwd;
        this.is_test = is_test;
        if (api_accounts.containsKey(service)) {
            Map<String, String> selectedAccount = api_accounts.get(service);
            this.select_account_number = selectedAccount.get("account_number");
            this.select_sender_code = selectedAccount.get("sender_code");
            this.select_service = service;
            this.collection_address = selectedAccount.get("address");
            this.collection_suburb = selectedAccount.get("suburb");
            this.collection_postcode = selectedAccount.get("postcode");
            this.collection_state = selectedAccount.get("state");
        }
    }

    public static TNTService getTntInterface(String o) {
        String service;
        switch (o) {
            case "mel":
                service = SERVICE_MEL;
                break;
            case "bne":
                service = SERVICE_BNE;
                break;
            case "test":
                service = SERVICE_TEST;
                break;
            case str_syd_top:
                service = SERVICE_SYD_TOP;
                break;
            case str_mel_top:
                service = SERVICE_MEL_TOP;
                break;
            case str_bne_top:
                service = SERVICE_BNE_TOP;
                break;
            case str_per_top:
                service = SERVICE_PER_TOP;
                break;
            default:
                service = SERVICE_SYD;
                break;
        }
        return new TNTService(API_USER_ID, API_USER_PASSWORD, service, true);
    }

    public Map<String, String> doRoutingRequest(Map<String, String> data) {
        data.put("DSuburb", data.getOrDefault("DSuburb", "").replace("'", "&apos;"));
        String key = data.getOrDefault("CSurburb", "") +
                data.getOrDefault("CPostcode", "") +
                data.getOrDefault("DSuburb", "") +
                data.getOrDefault("DPostcode", "") +
                data.getOrDefault("ServiceCode", "");

        Map<String, String> reply = new HashMap<>();
        reply.put("status", "true");
        reply.put("error", "");
        // Add other default values to the reply map as needed

        WebServiceTemplate webServiceTemplate = new WebServiceTemplate();
        webServiceTemplate.setDefaultUri(ROUTING_URL);
        webServiceTemplate.setMessageFactory(messageFactory());
        webServiceTemplate.setMessageSender(httpComponentsMessageSender());

        int i = 0;
        while (i < 6) {
            try {
                @SuppressWarnings("unchecked")
                Map<String, String> result = (Map<String, String>) webServiceTemplate.marshalSendAndReceive(data, new SoapActionCallback(SOAP_ACTION));
                return result;
            } catch (Exception e) {
                i++;
            }
        }
        return reply;
    }


    private SaajSoapMessageFactory messageFactory() {
        return new SaajSoapMessageFactory();
    }

    private HttpComponentsMessageSender httpComponentsMessageSender() {
        HttpComponentsMessageSender httpComponentsMessageSender = new HttpComponentsMessageSender();

        // Create and set credentials
        UsernamePasswordCredentials credentials = new UsernamePasswordCredentials(USERNAME, PASSWORD);
        BasicCredentialsProvider credentialsProvider = new BasicCredentialsProvider();
        credentialsProvider.setCredentials(AuthScope.ANY, credentials);

        CloseableHttpClient httpClient = HttpClients.custom()
                .setDefaultCredentialsProvider(credentialsProvider)
                .build();

        httpComponentsMessageSender.setHttpClient(httpClient);
        httpComponentsMessageSender.setConnectionTimeout(10000); // 10 seconds
        httpComponentsMessageSender.setReadTimeout(10000); // 10 seconds

        return httpComponentsMessageSender;
    }


}

