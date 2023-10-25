package com.hvlv.microservices.shipmentService.hvlvShipmentService.utils;

public class TntAPI {
    public static String decodePrefix(String number)
    {
        String prefix = "";
        for (int i = 0; i < number.length(); i=i + 2) {
            prefix+=Character.toString((char)(Integer.parseInt(number.substring(i, i+2)) + 55));
        }
        return prefix;
    }
}
