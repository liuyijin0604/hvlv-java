package com.hvlv.microservices.shipmentService.hvlvShipmentService.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hvlv.microservices.shipmentService.hvlvShipmentService.beans.*;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.ImportChargeCode;
import com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper.ImportChargeCodeMapper;
import com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper.AddrMapper;
import com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper.OrgRateMapper;
import com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper.ZoneRateMapper;
import com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper.ZoneMapMapper;
import com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper.CurrencyMapper;
import com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper.ShipmentMapper;
import com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper.ConnoteRangeMapper;
import com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper.PriceEnquiryMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class ChooseShipmentService {
    @Autowired
    RedisService redisService;
    @Autowired
    ImportChargeCodeMapper importChargeCodeMapper;
    @Autowired
    OrgRateMapper orgRateMapper;
    @Autowired
    AddrMapper addrMapper;
    @Autowired
    SystemSettingService systemSettingService;
    @Autowired
    ZoneRateMapper zoneRateMapper;
    @Autowired
    ZoneMapMapper zoneMapMapper;
    @Autowired
    CurrencyMapper currencyMapper;
    @Autowired
    AddrService addrService;
    @Autowired
    ShipmentMapper shipmentMapper;
    @Autowired
    ConnoteRangeMapper connoteRangeMapper;
    @Autowired
    PriceEnquiryMapper priceEnquiryMapper;

    //
    public JsonResultBean packagesCheck(ShipmentBean shipment) {
        JsonResultBean result = new JsonResultBean();
        DataBean dataBean = new DataBean();
        result.setData(dataBean);
        result.setSuccess();

        JSONArray packagesArray = shipment.getPackages();
        int packs = shipment.getPacks();

        if (packagesArray != null && !packagesArray.isEmpty()) {
            if (packagesArray.size() != packs) {
                dataBean.appendMsg("[90006] - Shipment " + shipment.getCref() + " numbers of packages not match the packs");
                dataBean.setMsg(dataBean.getMsg());
            } else {
                double totalWeight = 0;
                double cbm = 0;
                double calculateCbm = 0;
                JSONArray packsArray = new JSONArray();

                for (int index = 0; index < packagesArray.size(); index++) {
                    JSONObject packJson = packagesArray.getJSONObject(index);

                    String weightStr = packJson.getString("weight");
                    Double weight = parseDouble(weightStr);

                    if (weight == null) {
                        dataBean.appendMsg("[90006] - Shipment " + shipment.getCref() + " weight of package No." + (index+1) + " are mandatory");
                        dataBean.setMsg(dataBean.getMsg());
                    } else {
                        Double length = packJson.getDouble("depth");
                        if (length == null) {
                            length = packJson.getDouble("length");
                        }
                        Double height = packJson.getDouble("height");
                        Double width = packJson.getDouble("width");

                        if (height == null || width == null || length == null || length == 0) {
                            dataBean.appendMsg("[90006] - Shipment " + shipment.getCref() + " length(depth), width and height of package No." + (index+1) + " are mandatory");
                            dataBean.setMsg(dataBean.getMsg());
                            continue;
                        }

                        if (!isNumeric(height) || !isNumeric(width) || !isNumeric(length)) {
                            dataBean.appendMsg("[90006] - Shipment " + shipment.getCref() + " length(depth), width and height of package No." + (index+1) + " can only be numbers");
                            dataBean.setMsg(dataBean.getMsg());
                            continue;
                        }

                        if (height < 1 || width < 1 || length < 1) {
                            dataBean.appendMsg("[90006] - Shipment " + shipment.getCref() + " length(depth), width and height of package No." + (index+1) + " is invalid");
                            dataBean.setMsg(dataBean.getMsg());
                            continue;
                        }

                        JSONObject pack = new JSONObject();
                        pack.put("weight", weight);;
                        pack.put("length", length);
                        if (height == null) {
                            height = 0.0;
                        }
                        pack.put("height", height);
                        if (width == null) {
                            width = 0.0;
                        }
                        pack.put("width", width);
                        if (packJson.containsKey("reference")) {
                            pack.put("reference", packJson.get("reference"));
                        } else {
                            pack.put("reference", 0);
                        }
                        // Handle cbm calculation
                        if (!packJson.getString("cbm").isEmpty()) {
                            pack.put("cbm", packJson.getString("cbm"));
                        } else if (length * width * height > 0) {
                            double calculatedCbm = length * width * height / 1000000;
                            pack.put("cbm", String.format("%.6f", calculatedCbm));
                        } else {
                            pack.put("cbm", "0");
                        }
                        // Add the pack JSONObject to the packsArray
                        packsArray.add(pack);
                    }
                    if (weight == null) {
                        weight = 0.0;
                    }
                    totalWeight+=weight;
                    cbm += parseDouble(packsArray.getJSONObject(index).getString("cbm"));

                    double length = parseDouble(packsArray.getJSONObject(index).getString("length"));
                    double width = parseDouble(packsArray.getJSONObject(index).getString("width"));
                    double height = parseDouble(packsArray.getJSONObject(index).getString("height"));
                    double cbmForIndex = (length * width * height) / 1000000;

                    calculateCbm += cbmForIndex;
                    String formattedCbm = String.format("%.6f", cbmForIndex);
                    if (parseDouble(packsArray.getJSONObject(index).getString("cbm")) > 0 && (weight / parseDouble(packsArray.getJSONObject(index).getString("cbm"))) > 19320) {
                        dataBean.appendMsg("[90006] - Shipment " + shipment.getCref() + " invalid length(depth), width and height of package No." + (index+1));
                        dataBean.setMsg(dataBean.getMsg());
                    }
                }
                cbm = Math.max(cbm, calculateCbm) / shipment.getPkg();
                shipment.setCbm(Math.max(shipment.getCbm(), cbm));
                if (shipment.getWeight() != 0 && totalWeight != 0) {
                    if (Math.abs(Math.floor(totalWeight) - Math.floor(shipment.getWeight())) > 1) {
                        dataBean.appendMsg("[90007] - Shipment " + shipment.getCref() + " total " + Math.floor(totalWeight) + " KG of packages not match the weight " + Math.floor(shipment.getWeight()) + " KG of this parcel");
                        dataBean.setMsg(dataBean.getMsg());
                        return result;
                    }
                } else {
                    shipment.setWeight(Math.max(shipment.getWeight(), Math.max(Math.round(totalWeight * 100) / 100, 0.01)));
                }
                if (shipment.getWeight() < 0.01) {
                    dataBean.appendMsg("[90006] - Shipment " + shipment.getCref() + " weight are mandatory");
                    dataBean.setMsg(dataBean.getMsg());
                    return result;
                }
            }
        }else {
            dataBean.appendMsg("[90006] - Packages are empty");
            dataBean.setMsg(dataBean.getMsg());
            return result;
        }
        dataBean.setStatus(1);
        return result;
    }

    private Double parseDouble(String str) {
        try {
            return Double.parseDouble(str);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    private boolean isNumeric(Double value) {
        return value != null && !Double.isNaN(value);
    }

    public JsonResultBean addressesCheck(AddrBean cnee1,AddrBean cnee2,AddrBean cnee3,String chargeCode) {
        JsonResultBean result = new JsonResultBean();
        DataBean dataBean = new DataBean();
        result.setData(dataBean);
        result.setSuccess();
        dataBean.setStatus(1);
        ImportChargeCode importChargeCode = importChargeCodeMapper.findByChargeCode(chargeCode);
        if (importChargeCode == null)
        {
            dataBean.setMsg("[60005] - "+ "Invalid charge code : " + chargeCode);
            dataBean.setStatus(0);
            return result;
        }
        if (cnee1.getSuburb() == null && cnee1.getCity() != null) {
            cnee1.setSuburb(cnee1.getCity());
        }
        JsonResultBean checkResult = addrService.checkAuState(cnee1.getState());
        if (checkResult.getCode()=="1") {
            String checkedState = (String) checkResult.getData();
            cnee1.setState(checkedState);
        }
        Map<String, Boolean> addressTypes = new HashMap<>();
        addressTypes.put("consignee", true);
        addressTypes.put("receiver", false);
        addressTypes.put("shipper", false);

        for (Map.Entry<String, Boolean> entry : addressTypes.entrySet()) {
           String addressType = entry.getKey();
           Boolean req =entry.getValue();

            if (!req && addressType.equals("consignee") && cnee1==null) {
                continue;
            }
            AddrBean addrBean = null;
            if (addressType.equals("consignee")) {
                addrBean = cnee1;
            } else if (addressType.equals("receiver")) {
                addrBean = cnee2;
            } else if (addressType.equals("shipper")) {
                addrBean = cnee3;
            }
            if (!req && addrBean == null) {
                continue;
            }
            if (addrBean != null) {
                String email = addrBean.getEmail();
                if (!email.isEmpty()) {
                    String[] emailArray = email.split(";");
                    for (String trimmedEmail : emailArray) {
                        trimmedEmail = trimmedEmail.trim();
                        if (!isValidEmail(trimmedEmail)) {
                            dataBean.appendMsg("[20006] - Shipment " + addrBean.getCref() + addressType+ " email is not valid");
                            dataBean.setMsg(dataBean.getMsg());
                            dataBean.setStatus(0);
                        }
                    }
                }
                addrBean.setEmail(semiAngle(email));
            } else {
                dataBean.appendMsg("[20016] - Shipment " + addrBean.getCref() + addressType+ " is not valid");
                dataBean.setMsg(dataBean.getMsg());
                dataBean.setStatus(0);
            }
            if(addressType.equals("shipper")){
                String[] requiredFields = {"name", "address"};
                for (String k2 : requiredFields) {
                    String fieldValue = "";
                    if (k2.equals("name")) {
                        fieldValue = addrBean.getName();
                    } else if (k2.equals("address")) {
                        fieldValue = addrBean.getAddress();
                    }

                    if (fieldValue == null) {
                        fieldValue = "";
                    }
                    if (fieldValue.isEmpty()) {
                        dataBean.appendMsg("[20006] - Shipment " + addrBean.getCref() + "." + "shipper" + " is empty");
                        dataBean.setMsg(dataBean.getMsg());
                        dataBean.setStatus(0);
                    } else {
                        if (hasUniChinese(fieldValue)) {
                            dataBean.appendMsg("[20006] - Shipment " + addrBean.getCref() + " shipper "+ k2+" contains non-english character");
                            dataBean.setMsg(dataBean.getMsg());
                            dataBean.setStatus(0);
                        }
                        if (!fieldValue.matches("[A-Za-z]+")) {
                            dataBean.appendMsg("[20006] - Shipment " + addrBean.getCref() + " shipper " + k2+" is not valid");
                            dataBean.setMsg(dataBean.getMsg());
                            dataBean.setStatus(0);
                        }
                    }
                }
                String[] optionalFields = {"suburb", "state", "postcode", "company"};
                for (int i = 0; i < optionalFields.length; i++) {
                    String k2 = optionalFields[i];
                    String fieldValue = "";
                    if (k2.equals("suburb")) {
                        fieldValue = addrBean.getSuburb();
                    } else if (k2.equals("state")) {
                        fieldValue = addrBean.getState();
                    }else if (k2.equals("postcode")) {
                        fieldValue = addrBean.getPostcode();
                    }else if (k2.equals("company")) {
                    fieldValue = addrBean.getCompany();
                   }

                    if (fieldValue!=null) {
                        if (hasUniChinese(fieldValue)) {
                            dataBean.appendMsg("[2000" + (i+1) + "] - Shipment " + addrBean.getCref() + addressType + "." + k2 + " contains non-english character");
                            dataBean.setMsg(dataBean.getMsg());
                            dataBean.setStatus(0);
                        }
                    }
                }
            }
            String[] fieldsToCheck = {"name", "address", "suburb", "state", "postcode", "company"};
            for (int i = 0; i < fieldsToCheck.length; i++) {
                String k2 = fieldsToCheck[i];
                String fieldValue = "";
                if (k2.equals("name")) {
                    fieldValue = addrBean.getName();
                } else if (k2.equals("address")) {
                    fieldValue = addrBean.getAddress();
                } else if (k2.equals("suburb")) {
                    fieldValue = addrBean.getSuburb();
                } else if (k2.equals("state")) {
                    fieldValue = addrBean.getState();
                } else if (k2.equals("postcode")) {
                    fieldValue = addrBean.getPostcode();
                }else if (k2.equals("company")) {
                    fieldValue = addrBean.getCompany();
                }
                if (fieldValue==null) {
                    if (!k2.equals("company")) {
                        dataBean.appendMsg("[2000" + (i+1) + "] - Shipment " + addrBean.getCref() + "." + k2 + " is empty");
                        dataBean.setMsg(dataBean.getMsg());
                        dataBean.setStatus(0);
                    }
                } else if (hasUniChinese(fieldValue)) {
                    dataBean.appendMsg("[2000" + (i+1) + "] - Shipment " + addrBean.getCref() + "." + k2 + " contains non-english character");
                    dataBean.setMsg(dataBean.getMsg());
                    dataBean.setStatus(0);
                }
            }
            if(addressType.equals("consignee")){
              if(importChargeCode.getMeta().contains("cm_address")){
                  if (auTelValid(addrBean.getTel()).isEmpty()) {
                      dataBean.appendMsg("[20006] - Shipment " + addrBean.getCref() + " consignee telephone is not valid");
                      dataBean.setMsg(dataBean.getMsg());
                      dataBean.setStatus(0);
                  }
                  if (!Pattern.matches("[A-z]+", addrBean.getName())) {
                      dataBean.appendMsg("[20001] - Shipment " + addrBean.getCref() + " consignee name is not valid");
                      dataBean.setMsg(dataBean.getMsg());
                      dataBean.setStatus(0);
                  }
                  if (addrBean.getCountry().isEmpty() && !addrBean.getIs3PL()) {
                      dataBean.appendMsg("[20002] - Shipment " + addrBean.getCref() + " country is not valid");
                      dataBean.setMsg(dataBean.getMsg());
                      dataBean.setStatus(0);
                  }
              }
            }
        }
        if (cnee1.getEmail().isEmpty() && cnee1.getTel().isEmpty()) {
            dataBean.appendMsg("[20333] - Shipment " + cnee1.getCref() + " email or phone number is required");
            dataBean.setMsg(dataBean.getMsg());
            dataBean.setStatus(0);
        }
        int hasCountry = 0;
        if (cnee1.getCountry() != null) {
            hasCountry = 1;
            Map<String, String> countryRegexMap = new HashMap<>();
            countryRegexMap.put("AU", "^australia$|^Au$|^AUS$");
            countryRegexMap.put("NZ", "New Zealand|^NZ$|^New");

            for (Map.Entry<String, String> entry : countryRegexMap.entrySet()) {
                String key = entry.getKey();
                String regex = entry.getValue();

                if (cnee1.getCountry().matches(regex)) {
                    hasCountry = 2;
                    break;
                }
            }
        }
        if(hasCountry ==1){
            JsonResultBean intzonejson = systemSettingService.getKeySetting("Countrys");
            DataBean regionDataBean = (DataBean) intzonejson.getData();
            JSONArray regionDataArray = (JSONArray) regionDataBean.getData();

            boolean countrySupported = false;
            String consigneeCountry = cnee1.getCountry().toUpperCase();

            for (int i = 0; i < regionDataArray.size(); i++) {
                JSONObject countryData = regionDataArray.getJSONObject(i);
                String countryCode = countryData.getString("code");

                if (consigneeCountry.equals(countryCode)) {
                    countrySupported = true;
                    break;
                }
            }

            if (!countrySupported) {
                dataBean.appendMsg("[20006] - Shipment " + cnee1.getCref() + " country " + consigneeCountry + " is not supported. Please contact TLA");
                dataBean.setMsg(dataBean.getMsg());
                dataBean.setStatus(0);
            }
        }
        return result;
    }
    private String auTelValid(String no) {
        String tel = no.replaceAll("[^\\d]+", "");
        tel = tel.trim();
        String realTel = tel;

        Matcher matcher;

        matcher = Pattern.compile("^1300(\\d{6})$").matcher(tel);
        if (matcher.matches()) {
            realTel = tel;
        } else {
            matcher = Pattern.compile("61(\\d{10})$").matcher(tel);
            if (matcher.matches()) {
                realTel = matcher.group(1);
            } else {
                matcher = Pattern.compile("61(\\d{9})$").matcher(tel);
                if (matcher.matches()) {
                    realTel = '0' + matcher.group(1);
                } else if (Pattern.matches("^0\\d{9}$", tel)) {
                    realTel = tel;
                } else if (Pattern.matches("^\\d{9}$", tel)) {
                    realTel = '0' + tel;
                } else {
                    return "";
                }
            }
        }

        if (realTel.length() > 10) {
            realTel = realTel.substring(0, 10);
        }

        return realTel;
    }

    private boolean isValidEmail(String email) {
        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    private String semiAngle(String str) {
        Map<Character, Character> charMap = new HashMap<>();
        charMap.put('０', '0');
        charMap.put('１', '1');
        charMap.put('２', '2');
        charMap.put('３', '3');
        charMap.put('４', '4');
        charMap.put('５', '5');
        charMap.put('６', '6');
        charMap.put('７', '7');
        charMap.put('８', '8');
        charMap.put('９', '9');
        charMap.put('Ａ', 'A');
        charMap.put('Ｂ', 'B');
        charMap.put('Ｃ', 'C');
        charMap.put('Ｄ', 'D');
        charMap.put('Ｅ', 'E');
        charMap.put('Ｆ', 'F');
        charMap.put('Ｇ', 'G');
        charMap.put('Ｈ', 'H');
        charMap.put('Ｉ', 'I');
        charMap.put('Ｊ', 'J');
        charMap.put('Ｋ', 'K');
        charMap.put('Ｌ', 'L');
        charMap.put('Ｍ', 'M');
        charMap.put('Ｎ', 'N');
        charMap.put('Ｏ', 'O');
        charMap.put('Ｐ', 'P');
        charMap.put('Ｑ', 'Q');
        charMap.put('Ｒ', 'R');
        charMap.put('Ｓ', 'S');
        charMap.put('Ｔ', 'T');
        charMap.put('Ｕ', 'U');
        charMap.put('Ｖ', 'V');
        charMap.put('Ｗ', 'W');
        charMap.put('Ｘ', 'X');
        charMap.put('Ｙ', 'Y');
        charMap.put('Ｚ', 'Z');
        charMap.put('ａ', 'a');
        charMap.put('ｂ', 'b');
        charMap.put('ｃ', 'c');
        charMap.put('ｄ', 'd');
        charMap.put('ｅ', 'e');
        charMap.put('ｆ', 'f');
        charMap.put('ｇ', 'g');
        charMap.put('ｈ', 'h');
        charMap.put('ｉ', 'i');
        charMap.put('ｊ', 'j');
        charMap.put('ｋ', 'k');
        charMap.put('ｌ', 'l');
        charMap.put('ｍ', 'm');
        charMap.put('ｎ', 'n');
        charMap.put('ｏ', 'o');
        charMap.put('ｐ', 'p');
        charMap.put('ｑ', 'q');
        charMap.put('ｒ', 'r');
        charMap.put('ｓ', 's');
        charMap.put('ｔ', 't');
        charMap.put('ｕ', 'u');
        charMap.put('ｖ', 'v');
        charMap.put('ｗ', 'w');
        charMap.put('ｘ', 'x');
        charMap.put('ｙ', 'y');
        charMap.put('ｚ', 'z');
        charMap.put('（', '(');
        charMap.put('）', ')');
        charMap.put('〔', '[');
        charMap.put('〕', ']');
        charMap.put('【', '[');
        charMap.put('】', ']');
        charMap.put('〖', '[');
        charMap.put('〗', ']');
        charMap.put('”', '"');
        charMap.put('“', '"');
        charMap.put('｛', '{');
        charMap.put('｝', '}');
        charMap.put('《', '<');
        charMap.put('》', '>');
        charMap.put('％', '%');
        charMap.put('＋', '+');
        charMap.put('—', '-');
        charMap.put('－', '-');
        charMap.put('～', '-');
        charMap.put('：', ':');
        charMap.put('。', '.');
        charMap.put('、', ',');
        charMap.put('，', ',');
        charMap.put('、', '.');
        charMap.put('；', ';');
        charMap.put('？', '?');
        charMap.put('！', '!');
        charMap.put('…', '-');
        charMap.put('‖', '|');
        charMap.put('`', '\'');
        charMap.put('｜', '|');
        charMap.put('〃', '"');
        charMap.put('　', ' ');

        StringBuilder result = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (charMap.containsKey(c)) {
                result.append(charMap.get(c));
            } else {
                result.append(c);
            }
        }

        return result.toString();
    }

    private boolean hasUniChinese(String str) {
        Pattern pattern = Pattern.compile("[\\x{4e00}-\\x{9fa5}]+");
        Matcher matcher = pattern.matcher(str);
        return matcher.find();
    }

    public JsonResultBean itemCheck(List<Map<String, Object>> items) {
        JsonResultBean result = new JsonResultBean();
        DataBean dataBean = new DataBean();
        result.setData(dataBean);
        result.setSuccess();
        dataBean.setStatus(1);

        for (int i = 0; i < items.size(); i++) {
            Map<String, Object> itm = items.get(i);

            if (itm.containsKey("name") && itm.containsKey("qty") && itm.containsKey("price")) {
                String itemName = itm.get("name").toString();
                String itemQty = itm.get("qty").toString();
                String itemPrice = itm.get("price").toString();

                if (itemName.length() < 3) {
                    dataBean.appendMsg("[90003] - Goods description must be at least 3 characters in length");
                    dataBean.setStatus(0);
                }

                if (itemName.matches(".*[’].*")) {
                    dataBean.appendMsg("[90003] - item name should only contain english characters");
                    dataBean.setStatus(0);
                }

                if (itemName.isEmpty() || itemQty.isEmpty() || itemPrice.isEmpty() || Double.parseDouble(itemPrice) == 0) {
                    dataBean.appendMsg("[90003] - Shipment items(name, quantity, value) are mandatory");
                    dataBean.setStatus(0);
                }
            }
        }
        return result;
    }

}
