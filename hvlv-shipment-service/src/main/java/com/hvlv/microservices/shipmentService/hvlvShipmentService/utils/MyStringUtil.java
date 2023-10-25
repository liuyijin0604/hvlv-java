package com.hvlv.microservices.shipmentService.hvlvShipmentService.utils;

public class MyStringUtil {

    public static String rtrim(String sString,String symbol){
        String ltrim = sString.replaceAll(symbol+"+$", "");

        return ltrim;
    }

    public static String ltrim(String sString,String symbol){

        String ltrim = sString.replaceAll("^"+symbol+"+", "");

        return ltrim;
    }
}
