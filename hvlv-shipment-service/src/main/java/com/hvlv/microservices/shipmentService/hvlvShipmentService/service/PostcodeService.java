package com.hvlv.microservices.shipmentService.hvlvShipmentService.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hvlv.microservices.shipmentService.hvlvShipmentService.beans.JsonResultBean;
import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.Postcode;
import com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper.PostcodeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class PostcodeService extends HvlvService{

    @Autowired
    RedisService redisService;
    @Autowired
    PostcodeMapper postcodeMapper;

    public JsonResultBean countryList()
    {
        JsonResultBean result = new JsonResultBean();
        List<String> countryList = postcodeMapper.getCountryList();
        result.setData(countryList);
        result.setSuccess();
        return result;
    }

    public JsonResultBean stateList()
    {
        JsonResultBean result = new JsonResultBean();
        List<String> stateList = postcodeMapper.getStateList();
        result.setData(stateList);
        result.setSuccess();
        return result;
    }

    public JsonResultBean getStateByPostcode(int postcode){
        JsonResultBean result = new JsonResultBean();
        Map<String, int[]> ranges =new HashMap<>();
        ranges.put("NSW",new int[]{
                1000, 1999,
                2000, 2599,
                2619, 2898,
                2921, 2999
        });
        ranges.put("ACT",new int[]{
                200, 299,
                2600, 2618,
                2900, 2920
        });
        ranges.put("VIC", new int[]{
                3000, 3999,
                8000, 8999
        });
        ranges.put("QLD", new int[]{
                4000, 4999,
                9000, 9999
        });
        ranges.put("SA", new int[]{
                5000, 5999
        });
        ranges.put("WA", new int[]{
                6000, 6797,
                6800, 6999
        });
        ranges.put("TAS", new int[]{
                7000, 7999
        });
        ranges.put("NT", new int[]{
                800, 999
        });
        Map<Integer,String> exceptions =new HashMap<>();
        exceptions.put(4825,"QLD");
        exceptions.put(872, "NT");
        exceptions.put(2406, "NSW");
        exceptions.put(2540, "NSW");
        exceptions.put(2611, "ACT");
        exceptions.put(2620, "NSW");
        exceptions.put(3585, "VIC");
        exceptions.put(3586, "VIC");
        exceptions.put(3644, "VIC");
        exceptions.put(3691, "VIC");
        exceptions.put(3707, "VIC");
        exceptions.put(4380, "QLD");
        exceptions.put(4377, "QLD");
        exceptions.put(4383, "QLD");
        exceptions.put(4385, "QLD");
        if (exceptions.containsKey(postcode)) {
            String state = exceptions.get(postcode);
            result.setData(state);
            result.setSuccess();
            return result;
        }
        for(Map.Entry<String,int[]> entry: ranges.entrySet()){
            int[] range =entry.getValue();
            for(int i=0;i<range.length;i+=2){
                int min =range[i];
                int max =range[i+1];
                if(postcode>= min && postcode<=max){
                    String state = entry.getKey();
                    result.setData(state);
                    result.setSuccess();
                    return result;
                }
            }
        }
        result.setData("");
        result.setSuccess();
        return result;
    }

    public JsonResultBean validateAddress(String suburb, String state, String postcode, String country)
    {
        JsonResultBean result = new JsonResultBean();
        suburb =suburb.replaceAll("\\bMT\\b\\.*", "MOUNT")
                .replaceAll("\\bNTH\\b\\.*", "NORTH")
                .replaceAll("\\bSTH\\b\\.*", "SOUTH")
                .replaceAll("^PT\\b\\.*", "PORT")
                .replaceAll("^(SAINT\\b|ST\\.)", "ST");
        int c = postcodeMapper.countBySuburbStatePostcodeCountry(suburb, state, postcode, country);
        if (c > 0)
        {
            result.setData("true");
            result.setSuccess();
            return result;
        }
        result.setData("false");
        result.setSuccess();
        return result;
    }

    public JsonResultBean autoSuburbByPostcode(String suburb, String state, String postcode, String country) {
        JsonResultBean result = new JsonResultBean();
        suburb = suburb.replaceAll("\\bMT\\b\\.*", "MOUNT")
                .replaceAll("\\bNTH\\b\\.*", "NORTH")
                .replaceAll("\\bSTH\\b\\.*", "SOUTH")
                .replaceAll("^PT\\b\\.*", "PORT")
                .replaceAll("^(SAINT\\b|ST\\.)", "ST");
        int c = postcodeMapper.countBySuburbStatePostcodeCountry(suburb, state, postcode, country);
        if(c>0){
          result.setData(createResultString(suburb, state, postcode, country));
          result.setSuccess();
          return result;
        }else {

            List<String> suburbList = postcodeMapper.findSuburbsByStateAndPostcodeCountry(state, postcode, country);

            if (suburbList.isEmpty()) {

                result.setData(createResultString(suburb, state, postcode, country));
                result.setSuccess();
                return result;
            } else {

                if (suburb.matches("^(SOUTH|NORTH|EAST|WEST) .+$")) {
                    String swappedSuburb = swapWords(suburb);
                    if (suburbList.contains(swappedSuburb)) {
                        result.setData(createResultString(swappedSuburb, state, postcode, country));
                        result.setSuccess();
                        return result;
                    }
                }


                for (String word : suburb.split(" ")) {
                    if (!word.matches("^(SOUTH|NORTH|EAST|WEST)$")) {
                        for (String matchSuburb : suburbList) {
                            if (matchSuburb.contains(word)) {
                                result.setData(createResultString(matchSuburb, state, postcode, country));
                                result.setSuccess();
                                return result;
                            }
                        }
                    }
                }

                String randomSuburb = suburbList.get(new Random().nextInt(suburbList.size()));
                result.setData(createResultString(randomSuburb, state, postcode, country));
                result.setSuccess();
                return result;
            }
        }
    }

    private String createResultString(String suburb, String state, String postcode, String country) {
        return "postcode : " + postcode + ","+" " +
                "suburb: " + suburb + ","+" " +
                "state: " + state + ","+" " +
                "country: " + country;
    }

    private String swapWords(String input) {
        Pattern pattern = Pattern.compile("^(SOUTH|NORTH|EAST|WEST) (.+)$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()) {
            return matcher.group(2).toUpperCase() + " " + matcher.group(1).toUpperCase();
        }
        return input.toUpperCase();
    }

}