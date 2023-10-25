package com.hvlv.microservices.apiService.hvlvApiService.service;

import com.alibaba.fastjson.JSONArray;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hvlv.microservices.apiService.hvlvApiService.beans.JsonResultBean;
import com.hvlv.microservices.apiService.hvlvApiService.entity.ParcelBarcode;
import com.hvlv.microservices.apiService.hvlvApiService.myToll.Shipment;
import com.alibaba.fastjson.JSONObject;
import com.hvlv.microservices.apiService.hvlvApiService.client.LabelClient;
import com.hvlv.microservices.apiService.hvlvApiService.entity.OrgRate;

import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static org.apache.tomcat.util.http.FastHttpDateFormat.getCurrentDate;
import com.fasterxml.jackson.core.type.TypeReference;



public class MyTollAPIService {

    public LabelClient labelClient;
    private static final Map<String, String> MURL = new HashMap<>();
    private static final Map<String, String> TURL = new HashMap<>();
    private static final String API_USERNAME = "michelle@toplogistics.com";
    private static final Map<String, String>  API_PASSWORD= new HashMap<>();
    private static final Map<String, String>  CER= new HashMap<>();
    private static final List<String> holidays = Arrays.asList(
            "01-01", "01-28", "04-19", "04-20", "04-21", "04-22", "04-25", "06-10", "10-07", "12-25", "12-26"
    );

    private static final Map<String, String> holidayNames = new HashMap<>();


    private String serviceCode;
    private String shippingMethodCode;
    private boolean testing;
    private String manifestUrl;
    private String trackingUrl;
    private String apiUsername;
    private String apiPassword;
    private String cer;
    private String sscc;
    private String consignmentId;
    private String accountCode;
    private Map<String, String> fromInfo;
    private OrgRate orgRate;

    public static final Map<String, String> RATE_TYPE = new HashMap<>();

    static {
        MURL.put("testing", "https://api-uat.teamglobalexp.com:6930/gateway/TollMessageManifestRestService/1.0/tom/receiveManifest");
        MURL.put("production", "https://api.teamglobalexp.com:6930/gateway/TollMessageManifestRestService/1.0/tom/receiveManifest");

        TURL.put("production", "https://api.teamglobalexp.com:6930/gateway/TollMessageTrackAndTraceRestService/1.0/tom/enquireTrackTrace");
        TURL.put("testing", "https://api-uat.teamglobalexp.com:6930/gateway/TollMessageTrackAndTraceRestService/1.0/tom/enquireTrackTrace");

        API_PASSWORD.put("production", "QT9aF8wk6B");
        API_PASSWORD.put("testing", "qu5HpqcKCE");

        CER.put("production", "ssl_certificate.crt");
        CER.put("testing", "api-uat_tollgroup_com.crt");

        RATE_TYPE.put("MYTOLL_SYD","syd");
        RATE_TYPE.put("MYTOLL_MEL","mel");
        RATE_TYPE.put("MYTOLL_BNE","bne");
        RATE_TYPE.put("MYTOLL_PER","per");
    }
    public MyTollAPIService(LabelClient labelClient)
    {
        this.labelClient = labelClient;
    }
    public MyTollAPIService(String type,boolean testing,String serviceCode,LabelClient labelClient) {
        this.labelClient = labelClient;
        this.accountCode = "80691368";
        this.shippingMethodCode = " Express Parcels - Road";

        if (serviceCode != null) {

            this.serviceCode = serviceCode;
        }

        if (testing) {
            this.manifestUrl = MURL.get("testing");
            this.trackingUrl = TURL.get("testing");
            this.apiUsername = API_USERNAME;
            this.apiPassword = API_PASSWORD.get("testing");
            this.cer = CER.get("testing");
        } else {
            this.manifestUrl = MURL.get("production");
            this.trackingUrl = TURL.get("production");
            this.apiUsername = API_USERNAME;
            this.apiPassword = API_PASSWORD.get("production");
            this.cer = CER.get("production");
        }

        this.testing = testing;

        if (type == null || type.equals("syd")) {
            this.fromInfo = new HashMap<>();
            this.fromInfo.put("suburb", "BANKSTOWN AERODROME");
            this.fromInfo.put("postcode", "2200");
            this.fromInfo.put("address", "1/233 Milperra Rd");
            this.fromInfo.put("state", "NSW");
            this.sscc = "9327510";
            this.consignmentId = "8865980";
        } else if (type.equals("mel")) {
            this.fromInfo = new HashMap<>();
            this.fromInfo.put("suburb", "Sunshine");
            this.fromInfo.put("postcode", "3020");
            this.fromInfo.put("address", "3B/8 Judge St");
            this.fromInfo.put("state", "VIC");
            this.sscc = "9327510";
            this.consignmentId = "8865981";
        } else if (type.equals("bne")) {
            this.fromInfo = new HashMap<>();
            this.fromInfo.put("suburb", "Coopers Plains");
            this.fromInfo.put("postcode", "4108");
            this.fromInfo.put("address", "6/55 Musgrave Rd");
            this.fromInfo.put("state", "QLD");
            this.sscc = "9327510";
            this.consignmentId = "8865982";
        } else if (type.equals("per")) {
            this.fromInfo = new HashMap<>();
            this.fromInfo.put("suburb", "Welshpool");
            this.fromInfo.put("postcode", "6106");
            this.fromInfo.put("address", "Warehouse, 8 Glenferrie Road");
            this.fromInfo.put("state", "WA");
            this.sscc = "9327510";
            this.consignmentId = "8865983";
        }
    }
    public MyTollAPIService getAPIInstance(Integer courierId) {
        OrgRate orgRate= labelClient.getOrgRate(courierId);
        String code = orgRate.getCode();
        String rateType = RATE_TYPE.get(code);
        String jsonString = orgRate.getMeta();
        JSONObject jsonObject = JSONObject.parseObject(jsonString);
        String serviceCode = jsonObject.getString("service_code");
        MyTollAPIService myTollAPIService = new MyTollAPIService(rateType,false,serviceCode,labelClient);
        return myTollAPIService;
    }

    public JSONObject createShipment(Shipment shipment) {
        String myRef = getConsignmentId();
        JSONArray barcodes = new JSONArray();
        int pkg = shipment.getPkg();

        for (int i = 0; i < pkg; i++) {
            barcodes.add(getBarcode());
        }

        JSONObject result = new JSONObject();
        result.put("myRef", myRef);
        result.put("barcodes", barcodes);

        return result;
    }

    private String getConsignmentId() {
        String consignmentId = this.consignmentId;
        JsonResultBean labelResult = labelClient.generateRefByPrefix("{\"prefix\":\""+consignmentId+"\",\"orgId\":3752}");
        LinkedHashMap data = (LinkedHashMap) labelResult.getData();
        String consignemntNumber = data.get("ref").toString();
        return consignemntNumber;
    }

    private String getBarcode() {
        String sscc =this.sscc;
        JsonResultBean labelResult = labelClient.generateRefByPrefix("{\"prefix\":\""+sscc+"\",\"orgId\":3752}");
        LinkedHashMap data = (LinkedHashMap) labelResult.getData();
        String barcode = data.get("ref").toString();
        barcode = "0"+barcode;
        int number1 = 0;
        int number2 = 0;

        for (int i = barcode.length() - 1; i >= 0; i -= 2) {
            number1 += Character.getNumericValue(barcode.charAt(i));
        }

        number1 *= 3;

        for (int i = barcode.length() - 2; i >= 0; i -= 2) {
            number2 += Character.getNumericValue(barcode.charAt(i));
        }

        int number3 = number1 + number2;
        String number3Str = String.valueOf(number3);
        char lastDigit = number3Str.charAt(number3Str.length() - 1);
        int checkDigit = 10 - Character.getNumericValue(lastDigit);

        if (checkDigit == 10) {
            checkDigit = 0;
        }
        barcode = "00"+barcode+checkDigit;
        return barcode;
    }

    public String manifestShipment(List<Shipment> shipments) throws ParseException, JsonProcessingException {
        JSONObject data = new JSONObject();
        JSONObject tollMessage = new JSONObject();
        JSONObject header = getHeader();
        JSONObject manifest = getManifest(shipments);
        tollMessage.put("Header", header);
        tollMessage.put("Manifest", manifest);
        data.put("TollMessage", tollMessage);

        try {
            return request(data.toString(), "POST", manifestUrl);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public JSONObject getHeader()  {

        String guid =  generateGuid();

        LocalDateTime currentTime = LocalDateTime.now(ZoneOffset.UTC);
        String dateStr = currentTime.toString();

        JSONObject header = new JSONObject();
        header.put("MessageVersion", "1.0");
        header.put("MessageIdentifier", guid);
        header.put("CreateTimestamp", dateStr);
        header.put("DocumentType", "Manifest");
        header.put("Environment", this.testing ? "MYT_PS" : "PRD");
        header.put("SourceSystemCode", "XA98");
        header.put("MessageSender", "TOPLOGISTICS");
        header.put("MessageReceiver", "TOLL");
        return header;
    }
    public JSONObject getManifest(List<Shipment> shipments) throws ParseException, JsonProcessingException {
        JSONObject manifestBody = new JSONObject();
        ZoneId melbourneZone = ZoneId.of("Australia/Melbourne");
        ZonedDateTime currentTime = ZonedDateTime.now(melbourneZone);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssXXX");
        String dateStr = currentTime.format(formatter);
        if (checkDateIsHoliday(dateStr)) {
            dateStr = getNextWeekday(dateStr);
        }

        manifestBody.put("BusinessID", "IPEC");
        manifestBody.put("CreateDateTime", dateStr);

        JSONObject datePeriodCollection = new JSONObject();
        JSONArray datePeriodArray = new JSONArray(); // Create a JSONArray
        JSONObject datePeriod = new JSONObject();
         datePeriod.put("DateType", "DespatchDate");
        datePeriod.put("DateTime", dateStr);
        datePeriodArray.add(datePeriod); // Add datePeriod to the JSONArray
        datePeriodCollection.put("DatePeriod", datePeriodArray); // Put the JSONArray in datePeriodCollection
        manifestBody.put("DatePeriodCollection", datePeriodCollection);

        JSONObject consignorParty = new JSONObject();
        consignorParty.put("PartyName","Top Logistics");

        JSONObject physicalAddress = new JSONObject();
        physicalAddress.put("AddressLine1", fromInfo.get("address"));
        physicalAddress.put("Suburb", fromInfo.get("suburb"));
        physicalAddress.put("PostalCode", fromInfo.get("postcode"));
        physicalAddress.put("StateCode", fromInfo.get("state"));
        physicalAddress.put("CountryCode", "AU");

        consignorParty.put("PhysicalAddress", physicalAddress);

        JSONObject contact = new JSONObject();
        contact.put("Name", "Top Logistics");

        JSONObject phone = new JSONObject();
        phone.put("Number", "02-90668200");

        contact.put("Phone", phone);
        consignorParty.put("Contact", contact);

        manifestBody.put("ConsignorParty", consignorParty);

        JSONObject shipmentCollection = new JSONObject();
        shipmentCollection.put("Shipment", new ArrayList<>());

        for (Shipment p : shipments) {
            // Handle each shipment
            JSONObject shipment = new JSONObject();
            shipment.put("ShipmentID", p.getRef());
            shipment.put("CreateDateTime", dateStr);

            JSONObject consigneeParty = new JSONObject();
            consigneeParty.put("PartyName", (!p.getCnee().getCompany().isEmpty()) ? p.getCnee().getCompany() : p.getCnee().getName());

            JSONObject consigneePhysicalAddress = new JSONObject();
            String consigneeAddress = p.getCnee().getAddress().replace('\u00a0', ' ');
            consigneePhysicalAddress.put("AddressLine1", consigneeAddress.substring(0, Math.min(40, consigneeAddress.length())));
            if (consigneeAddress.length() > 40) {
                consigneePhysicalAddress.put("AddressLine2", consigneeAddress.substring(40, Math.min(80, consigneeAddress.length())));
            }
            consigneePhysicalAddress.put("Suburb", p.getCnee().getSuburb());
            consigneePhysicalAddress.put("PostalCode", p.getCnee().getPostcode());
            consigneePhysicalAddress.put("StateCode", p.getCnee().getState());
            consigneePhysicalAddress.put("CountryCode", "AU");

            consigneeParty.put("PhysicalAddress", consigneePhysicalAddress);

            JSONObject consigneeContact = new JSONObject();
            consigneeContact.put("Name", (!p.getCnee().getCompany().isEmpty()) ? p.getCnee().getCompany() : p.getCnee().getName());

            JSONObject consigneePhone = new JSONObject();
            consigneePhone.put("Number", auTelValid(p.getCnee().getTel()));

            consigneeContact.put("Phone", consigneePhone);
            consigneeParty.put("Contact", consigneeContact);

            shipment.put("ConsigneeParty", consigneeParty);

            // ShipmentTotals  BillToParty
            JSONObject shipmentTotals = new JSONObject();
            JSONObject volume = new JSONObject();
            BigDecimal volumeValue = p.getCbm().multiply(BigDecimal.valueOf(p.getPkg()));
            volume.put("Value", volumeValue.doubleValue());// Assuming this is the correct calculation
            shipmentTotals.put("Volume", volume);

            JSONObject weight = new JSONObject();
            weight.put("Value", p.getWeight().setScale(2, BigDecimal.ROUND_HALF_UP)); // Assuming this is the correct formatting
            shipmentTotals.put("Weight", weight);

            shipment.put("ShipmentTotals", shipmentTotals);

            JSONObject billToParty = new JSONObject();
            billToParty.put("PartyName", "Top Logistics");
            billToParty.put("AccountCode", "80691368");

            JSONObject billToPhysicalAddress = new JSONObject();
            billToPhysicalAddress.put("AddressLine1", this.fromInfo.get("address"));
            billToPhysicalAddress.put("Suburb", this.fromInfo.get("suburb"));
            billToPhysicalAddress.put("PostalCode", this.fromInfo.get("postcode"));
            billToPhysicalAddress.put("StateCode", this.fromInfo.get("state"));
            billToPhysicalAddress.put("CountryCode", "AU");

            billToParty.put("PhysicalAddress", billToPhysicalAddress);

            JSONObject billToContact = new JSONObject();
            billToContact.put("Name",  "Top Logistics");

            JSONObject billToPhone = new JSONObject();
            billToPhone.put("Number", "02-90668200");

            billToContact.put("Phone", billToPhone);
            billToParty.put("Contact", billToContact);

            shipment.put("BillToParty", billToParty);
            //ShipmentItemCollection
            JSONObject shipmentItemCollection = new JSONObject();
            JSONArray shipmentItemArray = new JSONArray();

            List<Map<String, Object>> consignmentDatas = getDimensions(p);
            String barcodeStr =p.getMeta();
            JSONObject jsonObject = JSONObject.parseObject(barcodeStr);
            String barcodeValue = jsonObject.getString("barcode");
            String[] barcodes = barcodeValue.split(",");

            int all = 0;

            for (Map<String, Object> consignmentData : consignmentDatas) {
                Integer qty = (Integer) consignmentData.get("qty");
                for (int i = 0; i < qty; i++) {
                    JSONObject shipmentItem = new JSONObject();
                    // IDs
//                    List<JSONObject> idArray = new ArrayList<>(com.alibaba.fastjson.JSONObject)
                    JSONArray idArray = new JSONArray();

                    JSONObject id = new JSONObject();
                    id.put("Value", barcodes[all]);
                    id.put("SchemeName", "SSCC");
                    idArray.add(id);

                    JSONObject ids = new JSONObject();
                    ids.put("ID", idArray);
                    shipmentItem.put("IDs", ids);
                    JSONObject test= shipmentItem;

                    // ShipmentItemTotals
                    JSONObject shipmentItemTotals = new JSONObject();
                    shipmentItemTotals.put("ShipmentItemCount", "1");
                    shipmentItem.put("ShipmentItemTotals", shipmentItemTotals);

                    // ShipmentService
                    JSONObject shipmentService = new JSONObject();
                    shipmentService.put("ServiceCode", "X");
                    shipmentService.put("ServiceDescription", "ROAD EXPRESS");
                    shipmentService.put("ShipmentProductCode", "1");
                    shipmentItem.put("ShipmentService", shipmentService);

                    shipmentItem.put("Description", "Carton");

                    // Dimensions
                    JSONObject dimensions = new JSONObject();
                    dimensions.put("Length", consignmentData.get("length"));
                    dimensions.put("Width", consignmentData.get("Width"));
                    dimensions.put("Height", consignmentData.get("Height"));

                    BigDecimal length = (BigDecimal) consignmentData.get("length");
                    BigDecimal width = (BigDecimal) consignmentData.get("width");
                    BigDecimal height = (BigDecimal) consignmentData.get("height");


                    BigDecimal dimvolume = length.multiply(width).multiply(height).divide(BigDecimal.valueOf(1000000), 3, RoundingMode.HALF_UP);

                    dimensions.put("Volume",dimvolume);

                    BigDecimal dimWeight = (BigDecimal) consignmentData.get("weight");
                    dimensions.put("Weight", dimWeight.setScale(2, RoundingMode.HALF_UP).doubleValue());
                    shipmentItem.put("Dimensions", dimensions);

                    shipmentItemArray.add(shipmentItem);
                    all++;
                }
            }

            shipmentItemCollection.put("ShipmentItem", shipmentItemArray);

            // Add the shipmentItemCollection to the shipment
            shipment.put("ShipmentItemCollection", shipmentItemCollection);
            JSONArray shipmentArray = new JSONArray();
            shipmentArray.add(shipment);
            shipmentCollection.put("Shipment", shipmentArray);
        }

        manifestBody.put("ShipmentCollection", shipmentCollection);

        return manifestBody;
    }

    public JSONObject trackingShipment(String ps) throws Exception {


       JSONObject jsonObject = JSONObject.parseObject(ps);
       String barcodeValue = jsonObject.getString("barcode");
       String[] barcodeArray = barcodeValue.split(",");

       JSONObject data = new JSONObject();
       JSONObject tollMassage = new JSONObject();
       JSONObject header = getTrackingHeader();
       tollMassage.put("Header",header);
       JSONObject TrackAndTrace = getTrackAndTrace(barcodeArray);
       tollMassage.put("TrackAndTrace",TrackAndTrace);
       data.put("TollMessage",tollMassage);

       String trackingStr = request(data.toJSONString(),"POST",trackingUrl);
       JSONObject trackingData = JSONObject.parseObject(trackingStr);
       JSONObject tollMessageResponse = trackingData.getJSONObject("TollMessage");
       JSONObject trackAndTraceResponse = tollMessageResponse.getJSONObject("TrackAndTrace");
       JSONObject shipmentObject =  trackAndTraceResponse.getJSONObject("Response").getJSONObject("Shipments");
       JSONArray shipmentsObject = shipmentObject.getJSONArray("Shipment");
       JSONObject finalDataObject = new JSONObject();

        for (int i = 0; i < shipmentsObject.size(); i++) {
            JSONObject shipment = shipmentsObject.getJSONObject(i);
            JSONArray eventArray = shipment.getJSONObject("Events").getJSONArray("Event");

            for (int j = 0; j < eventArray.size(); j++) {
                JSONObject event = eventArray.getJSONObject(j);
                JSONArray references = event.getJSONObject("References").getJSONArray("Reference");
                String barcode = references.getJSONObject(0).getString("ReferenceValue");
                ParcelBarcode parcelBarcode = labelClient.getParcelBarcode(barcode);
                if (parcelBarcode==null){
                    continue;
                }
                JSONArray dateTimeArray= event.getJSONObject("DatePeriodCollection").getJSONArray("DatePeriod");
                JSONObject dateTimeObject = dateTimeArray.getJSONObject(0);
                String dateTime = dateTimeObject.getString("DateTime");
                dateTime = dateTime.split(" ")[0].replace("T", "").replace(".000", "");
                JSONArray codes = event.getJSONObject("Codes").getJSONArray("Code");
                String category = codes.getJSONObject(0).getString("Category");
                String description = codes.getJSONObject(0).getString("Description");

                String key = category + description + dateTime;
                JSONArray eventObj = new JSONArray();
                eventObj.add(category);
                eventObj.add(description);
                eventObj.add(dateTime);

                finalDataObject.put(key, eventObj);
            }
        }
        JSONObject finalData = new JSONObject();
        finalData.put("finalData", finalDataObject);
        return finalData;

    }

    public JSONObject getTrackingHeader() {

        String guid = generateGuid();
        ZoneId melbourneZone = ZoneId.of("Australia/Melbourne");
        ZonedDateTime currentTime = ZonedDateTime.now(melbourneZone);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssXXX");
        String dateStr = currentTime.format(formatter);

        JSONObject header = new JSONObject();
        header.put("MessageVersion", "1.0");
        header.put("MessageIdentifier", guid);
        header.put("CreateTimestamp", dateStr);
        header.put("DocumentType", "TrackAndTrace");
        header.put("Environment", "MYT_SIT1");
        header.put("SourceSystemCode", "TE79");
        header.put("MessageSender", "TOPLOGISTICS");
        header.put("MessageReceiver", "TOLL");

        return header;
    }
    public JSONObject getTrackAndTrace(String[] ps){
        JSONObject traceBody  = new JSONObject();
        JSONObject request = new JSONObject();
        JSONObject searchTexts = new JSONObject();
        JSONArray searchTextArray = new JSONArray();

        for(int i=0; i<ps.length;i++){
            JSONObject SearchText = new JSONObject();
            SearchText.put("Value",ps[i]);
            SearchText.put("BusinessID","IPEC");
            searchTextArray.add(SearchText);
        }
        searchTexts.put("SearchText", searchTextArray);
        request.put("SearchTexts", searchTexts);
        traceBody.put("Request", request);

        return traceBody;
    }
    private List<Map<String, Object>> getDimensions(Shipment shipment) throws JsonProcessingException {
        List<Map<String, Object>> consignmentDatas = new ArrayList<>();

        if (shipment.getPackages() != null && !shipment.getPackages().isEmpty()) {
            ObjectMapper objectMapper = new ObjectMapper();
            List<Map<String, Object>> packsList = objectMapper.readValue(shipment.getPackages(), new TypeReference<List<Map<String, Object>>>(){});

            for (Map<String, Object> packageData : packsList) {
                Map<String, Object> consignmentData = new HashMap<>();
                consignmentData.put("qty", 1);
                consignmentData.put("weight", BigDecimal.valueOf((Double) packageData.get("weight")).setScale(2, RoundingMode.HALF_UP));
                consignmentData.put("length", BigDecimal.valueOf((Double) packageData.get("length")).setScale(0, RoundingMode.HALF_UP));
                consignmentData.put("width", BigDecimal.valueOf((Double) packageData.get("width")).setScale(0, RoundingMode.HALF_UP));
                consignmentData.put("height", BigDecimal.valueOf((Double) packageData.get("height")).setScale(0, RoundingMode.HALF_UP));
                consignmentDatas.add(consignmentData);
            }
        } else {
            if (shipment.getCbm() != null && shipment.getPkg() != null && shipment.getPkg() > 0) {
                double thisCBM = ((shipment.getWeight().doubleValue() / shipment.getPkg()) / Math.random() * (280 - 251 + 1) + 251);
                BigDecimal cbm = BigDecimal.valueOf(thisCBM * 1000000);
                double x = Math.cbrt(cbm.doubleValue() / (3 * 3 * 4));
                Map<String, Object> consignmentData = new HashMap<>();
                consignmentData.put("qty", shipment.getPkg());
                consignmentData.put("weight", shipment.getWeight().divide(BigDecimal.valueOf(shipment.getPkg()), 2, RoundingMode.HALF_UP));

                if (4 * x >= 120) {
                    x = Math.cbrt(thisCBM / (3 * 3 * 3));
                    consignmentData.put("length", BigDecimal.valueOf(3 * x).setScale(0, RoundingMode.HALF_UP));
                    consignmentData.put("width", BigDecimal.valueOf(3 * x).setScale(0, RoundingMode.HALF_UP));
                    consignmentData.put("height", BigDecimal.valueOf(3 * x).setScale(0, RoundingMode.HALF_UP));
                } else {
                    consignmentData.put("length", BigDecimal.valueOf(3 * x).setScale(0, RoundingMode.HALF_UP));
                    consignmentData.put("width", BigDecimal.valueOf(3 * x).setScale(0, RoundingMode.HALF_UP));
                    consignmentData.put("height", BigDecimal.valueOf(4 * x).setScale(0, RoundingMode.HALF_UP));
                }
                consignmentDatas.add(consignmentData);
            }
        }

        return consignmentDatas;
    }
    public static String auTelValid(String no) {
        // Remove all non-digit characters
        String tel = no.replaceAll("[^\\d]+", "").trim();
        String realTel = tel;

        if (tel.matches("^1300(\\d{6})$")) {
            // Do nothing, already in the desired format
            realTel = tel;
        } else if (tel.matches("^61(\\d{10})$")) {
            // Handle numbers in the format +61 04 3274 3955
            realTel = tel.substring(2);
        } else if (tel.matches("^61(\\d{9})$")) {
            // Handle numbers in the format 61432743955
            realTel = "0" + tel.substring(2);
        } else if (tel.matches("^0\\d{9}$")) {
            // Numbers starting with 0
            realTel = tel;
        } else if (tel.matches("^\\d{9}$")) {
            // Numbers without the leading 0
            realTel = "0" + tel;
        } else {
            return "";
        }

        // Ensure the final number is at most 10 digits
        if (realTel.length() > 10) {
            realTel = realTel.substring(0, 10);
        }

        return realTel;
    }
    // Check if a given date is a holiday
    public boolean checkDateIsHoliday(String dateStr) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = dateFormat.parse(dateStr);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        int month = calendar.get(Calendar.MONTH) + 1; // Month is 0-based
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        String formattedDate = String.format("%02d-%02d", month, day);
        for (String holiday : holidays) {
            if (holiday.equals(formattedDate)) {
                return true;
            }
        }

        // Check if it's a weekend (Saturday or Sunday)
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        return dayOfWeek == Calendar.SATURDAY || dayOfWeek == Calendar.SUNDAY;
    }

    // Find the next weekday (non-holiday) given a date
    public String getNextWeekday(String dateStr) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = dateFormat.parse(dateStr);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        // Move to the next day until a non-holiday weekday is found
        while (true) {
            calendar.add(Calendar.DAY_OF_MONTH, 1);
            Date nextDate = calendar.getTime();
            String nextDateStr = dateFormat.format(nextDate);

            if (!checkDateIsHoliday(nextDateStr)) {
                return nextDateStr;
            }
        }
    }


    public String request(String data, String method, String url) throws Exception{

            String result = null;

            URL apiUrl = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) apiUrl.openConnection();

            connection.setRequestMethod(method);
            connection.setDoOutput(true);
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Accept", "application/json");

            String userInfo = this.apiUsername + ":" + this.apiPassword;
            String encodedUserInfo = java.util.Base64.getEncoder().encodeToString(userInfo.getBytes());
            connection.setRequestProperty("Authorization", "Basic " + encodedUserInfo);

            connection.setConnectTimeout(600);
            if (!data.isEmpty()) {
                DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
                wr.writeBytes(data);
                wr.flush();
                wr.close();
            }

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
                            "\nResponse Code: " + responseCode + "\nResponse: " + errorResponse + "\n\n");
                   JSONObject jsonData = JSONObject.parseObject(String.valueOf(errorResponse));
                    System.out.println("HTTP Error Code: " + responseCode);
                    System.out.println("Error Response: " + errorResponse);
                    throw new Exception("HTTP Error: " + responseCode +"ErrorMessage: "+ jsonData.getJSONObject("TollMessage")
                            .getJSONObject("ErrorMessages")
                            .getJSONArray("ErrorMessage")
                            .getJSONObject(0)
                            .getString("ErrorMessage"));
                }
            }

        return result;
    }

    private void logToFile(String message) {
        String logFilePath = "E:\\myToll_api_ErrorLog\\mytoll_api"+ getCurrentDate() + ".log";
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(logFilePath, true));
            writer.write(message);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static String generateGuid() {
        UUID uuid = UUID.randomUUID();
        String uuidString = uuid.toString();
        String formattedUuid = uuidString.replace("-", "");
        // 格式化UUID字符串，添加连字符 -
         formattedUuid = formattedUuid.substring(0, 8) + "-" +
                 formattedUuid.substring(8, 12) + "-" +
                 formattedUuid.substring(12, 16) + "-" +
                 formattedUuid.substring(16, 20) + "-" +
                 formattedUuid.substring(20);
        return formattedUuid.toUpperCase();
    }

}
