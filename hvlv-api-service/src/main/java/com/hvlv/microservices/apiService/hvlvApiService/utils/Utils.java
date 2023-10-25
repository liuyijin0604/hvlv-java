package com.hvlv.microservices.apiService.hvlvApiService.utils;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import com.alibaba.fastjson.JSON;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.*;
import java.util.Map.Entry;
import org.apache.commons.codec.binary.Base64;

public class Utils {
    private static final char[] DIGITS_LOWER = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static final char[] DIGITS_UPPER = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private static Map<String, String> charMap = new HashMap<String, String>();
    public Utils() {
    }

    public static Integer getInteger(Map map, Object key) {
        Number answer = getNumber(map, key);
        if (answer == null) {
            return null;
        } else {
            return answer instanceof Integer ? (Integer)answer : new Integer(answer.intValue());
        }
    }

    private static Number getNumber(Map map, Object key) {
        if (map != null) {
            Object answer = map.get(key);
            if (answer != null) {
                if (answer instanceof Number) {
                    return (Number)answer;
                }

                if (answer instanceof String) {
                    try {
                        String text = (String)answer;
                        return NumberFormat.getInstance().parse(text);
                    } catch (ParseException var4) {
                    }
                }
            }
        }

        return null;
    }

    public static String getString(Map map, Object key) {
        if (map != null) {
            Object answer = map.get(key);
            if (answer != null) {
                return answer.toString();
            }
        }

        return null;
    }

    public static Boolean isNotBlank(String str) {
        if (str == null) {
            return false;
        } else {
            return str.trim().length() == 0 ? false : true;
        }
    }

    public static Boolean isBlank(String str) {
        return !isNotBlank(str);
    }

    public static <T> String toJson(T t) {
        if (t == null) {
            return "";
        } else {
            return JSON.toJSON(t) != null ? JSON.toJSON(t).toString() : "";
        }
    }

    public static <T> T json2Object(String json, Class<T> clazz) {
        return JSON.parseObject(json, clazz);
    }

    public static String sign(Map<String, Object> params, String secret) {
        if (params != null && !params.isEmpty()) {
            Set<String> keysSet = params.keySet();
            Object[] keys = keysSet.toArray();
            Arrays.sort(keys);
            StringBuffer stringBuffer = new StringBuffer();
            Object[] var5 = keys;
            int var6 = keys.length;

            for(int var7 = 0; var7 < var6; ++var7) {
                Object key = var5[var7];
                System.out.println("参与计算的key:" + key);
                Object value = params.get(key);
                if (value != null && value.toString().length() > 0) {
                    stringBuffer.append("&").append(key).append("=").append(value);
                }
            }

            if (stringBuffer.length() > 0) {
                return cal(secret, stringBuffer);
            } else {
                return "";
            }
        } else {
            throw new RuntimeException("参数错误.");
        }
    }

    private static String cal(String secret, StringBuffer stringBuffer) {
        if (isNotBlank(secret)) {
            String ss = stringBuffer.toString().substring(1);
            byte[] bs = null;

            try {
                System.out.println("签名计算字符串" + ss);
                bs = Base64.encodeBase64(ss.getBytes("UTF-8"));
            } catch (UnsupportedEncodingException var6) {
                var6.printStackTrace();
            }

            String text = new String(bs);
            System.out.println("签名计算base64字符串" + text);
            String sign = md5Hex(text + secret).toUpperCase();
            System.out.println(sign);
            return sign;
        } else {
            return "";
        }
    }

    public static String encodeMixChar(String source) {
        String encodeStr = null;

        try {
            encodeStr = Base64.encodeBase64String(source.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException var4) {
            var4.printStackTrace();
        }

        Entry entry;
        for(Iterator var2 = charMap.entrySet().iterator(); var2.hasNext(); encodeStr = encodeStr.replace((CharSequence)entry.getKey(), (CharSequence)entry.getValue())) {
            entry = (Entry)var2.next();
        }

        return encodeStr;
    }

    public static String md5Hex(String data) {
        byte[] hex = getBytes(data, Charset.forName("UTF-8"));
        return encodeHexString(getDigest("MD5").digest(hex));
    }

    public static MessageDigest getDigest(String algorithm) {
        try {
            return MessageDigest.getInstance(algorithm);
        } catch (NoSuchAlgorithmException var2) {
            throw new IllegalArgumentException(var2);
        }
    }

    private static byte[] getBytes(String string, Charset charset) {
        return string == null ? null : string.getBytes(charset);
    }

    public static String encodeHexString(byte[] data) {
        return new String(encodeHex(data));
    }

    public static char[] encodeHex(byte[] data) {
        return encodeHex(data, true);
    }

    public static char[] encodeHex(byte[] data, boolean toLowerCase) {
        return encodeHex(data, toLowerCase ? DIGITS_LOWER : DIGITS_UPPER);
    }

    public static char[] encodeHex(byte[] data, char[] toDigits) {
        int l = data.length;
        char[] out = new char[l << 1];
        int i = 0;

        for(int var5 = 0; i < l; ++i) {
            out[var5++] = toDigits[(240 & data[i]) >>> 4];
            out[var5++] = toDigits[15 & data[i]];
        }

        return out;
    }
}

