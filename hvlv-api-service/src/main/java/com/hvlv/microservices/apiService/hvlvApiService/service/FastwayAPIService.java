package com.hvlv.microservices.apiService.hvlvApiService.service;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.hvlv.microservices.apiService.hvlvApiService.beans.JsonResultBean;
import com.hvlv.microservices.apiService.hvlvApiService.beans.ShipmentBean;
import com.hvlv.microservices.apiService.hvlvApiService.client.LabelClient;

import com.hvlv.microservices.apiService.hvlvApiService.entity.ManiMap;
import com.hvlv.microservices.apiService.hvlvApiService.entity.Manifest;
import com.hvlv.microservices.apiService.hvlvApiService.entity.Tranship;
import org.springframework.integration.sftp.session.DefaultSftpSessionFactory;

import org.springframework.integration.sftp.session.SftpSession;

import java.io.*;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.*;

import com.google.gson.reflect.TypeToken;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import static org.apache.commons.lang.StringUtils.upperCase;

public class FastwayAPIService {

    public static final String TRACKING_DIRECT_URL = "https://www.fastway.com.au/courier-services/track-your-parcel?l=";

    private static final Map<String, Map<String, Object>> apiAccounts = new HashMap<>();
    public LabelClient labelClient;
    public RedisService redisService;
    static {
        Map<String, Object> sydAccount = new HashMap<>();
        sydAccount.put("id", "fw-fl2-SYD0160059-19a58ea694c6");
        sydAccount.put("secret", "d91ddeeb-be55-400c-833d-d40cea0fb964");
        Map<String, String> senderInfoSyd = new HashMap<>();
        senderInfoSyd.put("SenderName", "Top Logistics");
        senderInfoSyd.put("SenderCompany", "");
        senderInfoSyd.put("SenderAddr1", "1/233 Milperra Rd");
        senderInfoSyd.put("SenderAddr2", "");
        senderInfoSyd.put("SenderSuburb", "Bankstown Aerodrome");
        senderInfoSyd.put("SenderPostcode", "2200");
        senderInfoSyd.put("SenderPhone", "0290668200");
        senderInfoSyd.put("SenderEmail", "donotreply@toplogistics.com.au");
        sydAccount.put("senderInfo", senderInfoSyd);

        Map<String, Object> melAccount = new HashMap<>();
        melAccount.put("id", "fw-fl2-MEL0004661-874c367b9ea8");
        melAccount.put("secret", "58c8bec3-3f1f-4594-a593-91d09dde4a45");
        Map<String, String> senderInfoMel = new HashMap<>();
        senderInfoMel.put("SenderName", "Top Logistics");
        senderInfoMel.put("SenderCompany", "");
        senderInfoMel.put("SenderAddr1", "3B/8 Judge St");
        senderInfoMel.put("SenderAddr2", "");
        senderInfoMel.put("SenderSuburb", "Sunshine");
        senderInfoMel.put("SenderPostcode", "3020");
        senderInfoMel.put("SenderPhone", "0290668200");
        senderInfoMel.put("SenderEmail", "donotreply@toplogistics.com.au");
        melAccount.put("senderInfo", senderInfoMel);

        apiAccounts.put("syd", sydAccount);
        apiAccounts.put("mel", melAccount);
    }

    public String result;
    public String rescode;
    public String err;
    public boolean isTest;
    private String uid = "";
    private String secret = "";
    // Old API compatibility
    private String userID = "46424";
    private String apikey = "c17c64585c67180170dd504b75ca44ad";
    public String origin = "SYD";
    public Map<String, String> senderInfo = new HashMap<>();

    private static final String apiURL = "https://au.api.fastway.org/v4/";

    private static final String scope = "fw-fl2-api-au";
    private static final String url = "https://api.myfastway.com.au";
    private static final String tokenURL = "https://identity.fastway.org/connect/token";

    private static final String testURL = "https://uat.api.myfastway.com.au";
    private static final String testTokenURL = "https://uat.identity.fastway.org/connect/token";

    private String token;
    private boolean isDebug;

    public FastwayAPIService(boolean debug, boolean test, String type, LabelClient labelClient,RedisService redisService){
        this.labelClient = labelClient;
        this.redisService = redisService;
        if (apiAccounts.containsKey(type)){
            Map<String, Object> account = apiAccounts.get(type);
            uid = (String) account.get("id");
            secret = (String) account.get("secret");
        }
        isTest = test;
        isDebug =debug;
    }

    public boolean ftpManifest(List<ShipmentBean> ss) {
        try {
            // Create an SFTP session using the injected SftpRemoteFileTemplate
            DefaultSftpSessionFactory factory = new DefaultSftpSessionFactory();
            factory.setHost("103.230.159.64");
            factory.setPort(22);
            factory.setUser("ewe");
            factory.setPassword("sd123^*&j!");

            // Disable host key checking
            Properties prop = new Properties();
            prop.put("StrictHostKeyChecking", "no");
            factory.setSessionConfig(prop);

            try (SftpSession session = factory.getSession()) {
                // Ensure that session is open
                if (session == null || !session.isOpen()) {
                    throw new IllegalStateException("Failed to open SFTP session.");
                }

                String xml = xmlManifest(ss);
                byte[] xmlBytes = xml.getBytes();
                InputStream inputStream = new ByteArrayInputStream(xmlBytes);
                if (!session.exists("/home/ewe/testing")) {
                    session.mkdir("/home/ewe/testing");
                }
                String manifestNumber = generateManifestNumber();
                String manifestFileName = "TLA_Fastway_" + manifestNumber + ".xml";
                String remoteFilePath = "/home/ewe/testing/" + manifestFileName;
                // Upload the XML to the SFTP server
                session.write(inputStream, remoteFilePath);
                for(ShipmentBean s:ss){
                    List<Tranship> tranships = labelClient.getTranshipByShipmentId(s.getId());
                    for (Tranship tranship : tranships) {
                        if (tranship.getStatus() == 10) {
                            tranship.setStatus((byte) 19);
                        }
                        String originalMeta = tranship.getMeta();
                        String updatedMeta = originalMeta.substring(0, originalMeta.length() - 2) + ";\"" +" oid" + ":\"" + manifestNumber + "\";}";
                        tranship.setMeta(updatedMeta);
                        labelClient.updateByPrimaryKeySelective(tranship);
                    }
                }

                Manifest mani = new Manifest();
                mani.setType(90);
                mani.setFwdId(115);
                mani.setRef(manifestNumber);
                labelClient.createManifest(mani);

                for (ShipmentBean s : ss) {
                    ManiMap mm = new ManiMap();

                    mm.setManiId(mani.getId());
                    mm.setFid(s.getId());
                    mm.setModel("ImParcel");
                    labelClient.insertManiMap(mm);
                }

                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }



    public static String generateManifestNumber() {
        // 获取当前日期和时间部分
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String dateTimePart = dateFormat.format(new Date());

        // 生成唯一的标识符部分
        UUID uuid = UUID.randomUUID();
        // 只取前8位，并转为大写
        String uuidPart = uuid.toString().substring(0, 8).toUpperCase();

        // 组合日期时间部分和唯一标识符部分
        String manifestNumber = dateTimePart + uuidPart;

        return manifestNumber;
    }


    public String xmlManifest(List<ShipmentBean> ss) {
        String origin = "syd";
        Map<String, Object> selectedAccount = apiAccounts.get(origin);
        try {
            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
            Document document = documentFactory.newDocumentBuilder().newDocument();

            Element manifestElement = document.createElement("Manifest");
            document.appendChild(manifestElement);

            for (int i = 0; i < ss.size(); i++) {
                ShipmentBean s = ss.get(i);

                List<String> addr = prepAddrLines(s.getCnee().getAddress(), true);
                double wt = roundWeight(s.getWeight());

                // Check if QX label has weight > 0.3kg
                if (wt > 0.3 && s.getRef().matches("^QX\\d+")) {
                    wt = 0.3;
                }

                String ve = s.getCnee().getEmail().trim();

                Element labelElement = document.createElement("Label");
                manifestElement.appendChild(labelElement);

                Element pickupFranchiseCodeElement = document.createElement("PickupFranchiseCode");
                Text pickupFranchiseCodeText = document.createTextNode(upperCase(origin));
                pickupFranchiseCodeElement.appendChild(pickupFranchiseCodeText);
                labelElement.appendChild(pickupFranchiseCodeElement);

                Element labelNumberElement = document.createElement("LabelNumber");
                Text labelNumberText = document.createTextNode(s.getRef());
                labelNumberElement.appendChild(labelNumberText);
                labelElement.appendChild(labelNumberElement);

                Element referenceElement = document.createElement("Reference");
                Text referenceText = document.createTextNode(s.getHbn());
                referenceElement.appendChild(referenceText);
                labelElement.appendChild(referenceElement);

                Element itemElement = document.createElement("Item");
                labelElement.appendChild(itemElement);

                Element weightElement = document.createElement("Weight");
                Text weightText = document.createTextNode(String.valueOf(wt));
                weightElement.appendChild(weightText);
                itemElement.appendChild(weightElement);

                Element widthElement = document.createElement("Width");
                Text widthText = document.createTextNode("1");
                widthElement.appendChild(widthText);
                itemElement.appendChild(widthElement);

                Element lengthElement = document.createElement("Length");
                Text lengthText = document.createTextNode("1");
                lengthElement.appendChild(lengthText);
                itemElement.appendChild(lengthElement);

                Element heightElement = document.createElement("Height");
                Text heightText = document.createTextNode("1");
                heightElement.appendChild(heightText);
                itemElement.appendChild(heightElement);


                Map<String, String> senderInfo = (Map<String, String>) selectedAccount.get("senderInfo");

                Element senderElement = document.createElement("Sender");
                labelElement.appendChild(senderElement);

                Element senderNameElement = document.createElement("SenderName");
                String senderName = senderInfo.get("SenderName");
                Text senderNameText = document.createTextNode(senderName);
                senderNameElement.appendChild(senderNameText);
                senderElement.appendChild(senderNameElement);

                Element senderCompanyElement = document.createElement("SenderCompany");
                String senderCompany = senderInfo.get("SenderCompany");
                Text senderCompanyText = document.createTextNode(senderCompany);
                senderCompanyElement.appendChild(senderCompanyText);
                senderElement.appendChild(senderCompanyElement);

                Element senderAddr1Element = document.createElement("SenderAddr1");
                String senderAddr1 = senderInfo.get("SenderAddr1");
                Text senderAddr1Text = document.createTextNode(senderAddr1);
                senderAddr1Element.appendChild(senderAddr1Text);
                senderElement.appendChild(senderAddr1Element);

                Element senderAddr2Element = document.createElement("SenderAddr2");
                String senderAddr2 = senderInfo.get("SenderAddr2");
                Text senderAddr2Text = document.createTextNode(senderAddr2);
                senderAddr2Element.appendChild(senderAddr2Text);
                senderElement.appendChild(senderAddr2Element);

                Element senderSuburbElement = document.createElement("SenderSuburb");
                String senderSuburb = senderInfo.get("SenderSuburb");
                Text senderSuburbText = document.createTextNode(senderSuburb);
                senderSuburbElement.appendChild(senderSuburbText);
                senderElement.appendChild(senderSuburbElement);

                Element senderPostcodeElement = document.createElement("SenderPostcode");
                String senderPostcode = senderInfo.get("SenderPostcode");
                Text senderPostcodeText = document.createTextNode(senderPostcode);
                senderPostcodeElement.appendChild(senderPostcodeText);
                senderElement.appendChild(senderPostcodeElement);

                Element senderPhoneElement = document.createElement("SenderPhone");
                String senderPhone = senderInfo.get("SenderPhone");
                Text senderPhoneText = document.createTextNode(senderPhone);
                senderPhoneElement.appendChild(senderPhoneText);
                senderElement.appendChild(senderPhoneElement);

                Element senderEmailElement = document.createElement("SenderEmail");
                String senderEmail = senderInfo.get("SenderEmail");
                Text senderEmailText = document.createTextNode(senderEmail);
                senderEmailElement.appendChild(senderEmailText);
                senderElement.appendChild(senderEmailElement);


                Element receiverElement = document.createElement("Receiver");
                labelElement.appendChild(receiverElement);

                Element receiverNameElement = document.createElement("ReceiverName");
                String receiverName = s.getCnee().getName().substring(0, Math.min(40, s.getCnee().getName().length()));
                Text receiverNameText = document.createTextNode(receiverName);
                receiverNameElement.appendChild(receiverNameText);
                receiverElement.appendChild(receiverNameElement);

                Element receiverCompanyElement = document.createElement("ReceiverCompany");
                String receiverCompany = s.getCnee().getCompany().substring(0, Math.min(40, s.getCnee().getCompany().length()));
                Text receiverCompanyText = document.createTextNode(receiverCompany);
                receiverCompanyElement.appendChild(receiverCompanyText);
                receiverElement.appendChild(receiverCompanyElement);

                List<String> addr2 = prepAddrLines(s.getCnee().getAddress(), true);
                for (int i2 = 0; i2 < addr.size(); i2++) {
                    Element receiverAddrElement = document.createElement("ReceiverAddr" + (i + 1));
                    String addressLine = addr2.get(i2);
                    Text receiverAddrText = document.createTextNode(addressLine);
                    receiverAddrElement.appendChild(receiverAddrText);
                    receiverElement.appendChild(receiverAddrElement);
                }

                Element receiverSuburbElement = document.createElement("ReceiverSuburb");
                Text receiverSuburbText = document.createTextNode(s.getCnee().getSuburb());
                receiverSuburbElement.appendChild(receiverSuburbText);
                receiverElement.appendChild(receiverSuburbElement);

                Element receiverPostcodeElement = document.createElement("ReceiverPostcode");
                Text receiverPostcodeText = document.createTextNode(s.getCnee().getPostcode());
                receiverPostcodeElement.appendChild(receiverPostcodeText);
                receiverElement.appendChild(receiverPostcodeElement);

                Element receiverPhoneElement = document.createElement("ReceiverPhone");
                String receiverPhone = s.getCnee().getTel().isEmpty() ? "0299257100" : s.getCnee().getTel();
                Text receiverPhoneText = document.createTextNode(receiverPhone);
                receiverPhoneElement.appendChild(receiverPhoneText);
                receiverElement.appendChild(receiverPhoneElement);

                Element receiverEmailElement = document.createElement("ReceiverEmail");
                String ve2 = s.getCnee().getEmail().trim();
                String receiverEmail = ve.isEmpty() ? "donotreply@toplogistics.com.au" : ve2;
                receiverEmail = receiverEmail.substring(0, Math.min(40, receiverEmail.length()));
                Text receiverEmailText = document.createTextNode(receiverEmail);
                receiverEmailElement.appendChild(receiverEmailText);
                receiverElement.appendChild(receiverEmailElement);

            }

            // Convert the DOM document to XML string
            javax.xml.transform.TransformerFactory transformerFactory = javax.xml.transform.TransformerFactory.newInstance();
            javax.xml.transform.Transformer transformer = transformerFactory.newTransformer();
            javax.xml.transform.dom.DOMSource domSource = new javax.xml.transform.dom.DOMSource(document);
            java.io.StringWriter writer = new java.io.StringWriter();
            javax.xml.transform.stream.StreamResult result = new javax.xml.transform.stream.StreamResult(writer);
            transformer.transform(domSource, result);

            return writer.toString();
        } catch (ParserConfigurationException | javax.xml.transform.TransformerException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static List<String> prepAddrLines(String addr, boolean split) {
        addr = addr
                .replace("&#xd", "\n")
                .replace("&#xa", "\n")
                .replace("&#39", "'")
                .replace(" ", " ")
                .replace("–", "-")
                .replace("\"", "");

        if (!split) {
            List<String> result = new ArrayList<>();
            result.add(addr);
            return result;
        }

        String[] lines = addr.split("[\n\r;]+");
        if (lines.length == 1 && addr.length() > 40) {
            return mbstrSplit(addr, 40);
        }

        List<String> result = new ArrayList<>();
        for (String line : lines) {
            result.add(line);
        }
        return result;
    }

    // 定义 mbstrSplit 方法来分割字符串
    private static List<String> mbstrSplit(String input, int chunkSize) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < input.length(); i += chunkSize) {
            int endIndex = Math.min(i + chunkSize, input.length());
            result.add(input.substring(i, endIndex));
        }
        return result;
    }


    public boolean weCanDelivery(ShipmentBean shipment) {
        boolean isInDeliveryArea = isInDeliveryArea(shipment.getCnee().getPostcode(), shipment.getCnee().getSuburb());
        boolean hasProductCode = getProductCode(shipment.getCnee().getPostcode(), shipment.getWeight()) > 0;
        return isInDeliveryArea && hasProductCode;
    }

    public String addConsignment(ShipmentBean shipment){
        if(!isInDeliveryArea(shipment.getCnee().getPostcode(),shipment.getCnee().getSuburb())){
            log2file("shipment : " + shipment.getHbn() + " not in delivery area");
            return "shipment : " + shipment.getHbn() + " not in delivery area";
        }
        Integer packaging = getProductCode(shipment.getCnee().getPostcode(),roundWeight(shipment.getWeight()));

        if ("3451".equals(shipment.getCnee().getPostcode()) && "CAMPBELLS CREEK".equalsIgnoreCase(shipment.getCnee().getSuburb())) {
            if (roundWeight(shipment.getWeight()) <= 5) {
                packaging = 16; // Small Flat Rate Box
            }
        }
        if ("4751".equals(shipment.getCnee().getPostcode()) && "GREENMOUNT".equalsIgnoreCase(shipment.getCnee().getSuburb())) {
            if (roundWeight(shipment.getWeight()) <= 5) {
                packaging = 16; // Small Flat Rate Box
            }
        }
        if ("4510".equals(shipment.getCnee().getPostcode()) && shipment.getCnee().getSuburb().matches("(?i)^BELLMERE$|^BEACHMERE$")) {
            if (roundWeight(shipment.getWeight()) <= 5) {
                packaging = 16; // Small Flat Rate Box
            }
        }
        if(packaging<0){
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String currentTime = dateFormat.format(new Date());
            String shipmentMessage = "shipment : " + shipment.getHbn() + " product code not found\n\n";
            String logMessage = "Time: " + currentTime + "\n" + shipmentMessage;
            log2file(logMessage);
            return logMessage;
        }
        String action = "fastlabel/addconsignment";
        String data = "UserID=" + this.userID;
        // Commented out line in PHP: $data .= '&ContactName='. $shipment->cnee->name;
        data += "&ContactMobile=" + shipment.getCnee().getTel();
        data += "&CompanyName=" + shipment.getCnee().getName();
        data += "&Address1=" + shipment.getCnee().getAddress();
        data += "&Suburb=" + shipment.getCnee().getSuburb();
        data += "&Postcode=" + shipment.getCnee().getPostcode();

        data += "&Items[0].Weight=" + roundWeight(shipment.getWeight());
        // Commented out line in PHP: $data .= '&Items[0].Quantity='. $shipment->pkg;
        data += "&Items[0].Quantity=1";
        data += "&Items[0].Packaging=" + packaging;
        data += "&api_key=" + this.apikey;

        String result = request(action, "POST", data);
        if (result != null) {
            return result;
        }
        return "shipment : " + shipment.getHbn() + " not in delivery area";
    }

    public double roundWeight(double w) {
        if (w <= 0.3) {
            return w;
        } else if (w <= 0.5) {
            return Math.round(w * 12 * 100) / 20.0 / 100.0;
        } else if (w <= 1) {
            return 0.35 + Math.round(Math.random() * 100 / 100.0 * 0.15 * 100) / 100.0;
        } else if (w <= 2) {
            return 0.45 + Math.round(Math.random() * 100 / 100.0 * 0.05 * 100) / 100.0;
        } else if (w <= 3) {
            return 0.85 + Math.round(Math.random() * 100 / 100.0 * 0.14 * 100) / 100.0;
        } else if (w <= 4) {
            return 1.85 + Math.round(Math.random() * 100 / 100.0 * 0.14 * 100) / 100.0;
        } else if (w <= 5) {
            return 2.85 + Math.round(Math.random() * 100 / 100.0 * 0.14 * 100) / 100.0;
        } else if (w > 5 && w <= 9) {
            return 5.0;
        } else if (w <= 12.5) {
            return 9.0;
        } else {
            return w - 3.5;
        }
    }

    public boolean isInDeliveryArea(String postcode, String suburb) {
        Map<String, Map<String,Object>> fad = loadFastwayAreaData();
        suburb = suburb.toUpperCase();
        return fad.containsKey(postcode) && (suburb.isEmpty() || fad.get(postcode).containsKey(suburb));
    }

    public int getProductCode(String postcode,Double weight){
        int postcodeInt = Integer.parseInt(postcode);
        int count = labelClient.getZoneMapFw(postcodeInt);
        if (count>0){
          return 1;
        }else {
            double[][] weightsCode = {
                    {0, 0.5, 7},
                    {0.5, 1, 6},
                    {1, 2, 16},
                    {2, 3, 5},
                    {3, 5, 4},
                    {5, 10, 17},
                    {10, 20, 18}
            };

            for (double[] code : weightsCode) {
                if (weight > code[0] && weight <= code[1]) {
                    return (int) code[2];
                }
            }
        }
        if(isDebug==true){
            log2file("Cannot find Product Type for postcode: "+ postcode + " , weight : " + weight.toString());
        }
        return -1;
    }

    public String sortingCode(String postcode, String suburb) {
        Map<String, Map<String, Object>> fad = loadFastwayAreaData();
        suburb = suburb.toUpperCase();
        if (fad.containsKey(postcode) && fad.get(postcode).containsKey(suburb)) {
            Object result = fad.get(postcode).get(suburb);
            if (result instanceof ArrayList) {
                return ((ArrayList) result).toString();
            }
            return result.toString();
        } else {
            return null;
        }
    }

    public Map<String, Map<String, Object>> loadFastwayAreaData() {
        String redisKey = "fastwayArea";
        JSONObject jsonObject = redisService.getObject(redisKey);
        if (jsonObject != null) {
            Type type = new TypeToken<Map<String, Map<String,Object>>>() {}.getType();
            Map<String, Map<String, Object>> fad = new Gson().fromJson(jsonObject.toString(), type);
            return fad;
        } else {
            String filePath = "E:\\fastway_area\\fastway_area.json";
            HashMap fad;
            try {
                byte[] jsonData = Files.readAllBytes(Paths.get(filePath));
                String jsonString = new String(jsonData, "UTF-8");
                Gson gson = new Gson();
                fad = gson.fromJson(jsonString, new HashMap<String, Map<String, String>>().getClass());
                String fadString = gson.toJson(fad);
                redisService.setKey(redisKey, fadString, 864000);
            } catch (IOException e) {
                e.printStackTrace();
                return new HashMap<>();
            }
            return fad;
        }
    }

    public String genNumber(){
        JsonResultBean labelResult = labelClient.generateRefByPrefix("{\"prefix\":\""+"2X"+"\",\"orgId\":115}");
        LinkedHashMap data = (LinkedHashMap) labelResult.getData();
        String consignemntNumber = data.get("ref").toString();
        return consignemntNumber;
    }

    protected String request(String action, String method, String data) {
        this.result = null;
        String url = apiURL + action;

        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setRequestMethod(method);
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setReadTimeout(60000);

            if (data != null) {
                try (OutputStream os = connection.getOutputStream()) {
                    byte[] postData = data.getBytes("UTF-8");
                    os.write(postData);
                }
            }

            int responseCode = connection.getResponseCode();
            String responseMessage = connection.getResponseMessage();
            this.rescode = Integer.toString(responseCode);

            if (responseCode == 200) {
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                    StringBuilder response = new StringBuilder();
                    String line;
                    while ((line = reader.readLine()) != null) {
                        response.append(line);
                    }
                    this.result = response.toString();
                }
            } else {
                if (isDebug) {
                    log2file(responseMessage);
                }
                throw new Exception("HTTP Error: " + responseCode);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this.result;
    }

    protected boolean log2file(String message) {
        String logFilePath = "E:\\fastway_api_ErrorLog\\fastway_api" + java.time.LocalDate.now() + ".log";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(logFilePath, true))) {
            writer.write(message);
            writer.newLine();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
