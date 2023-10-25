package com.hvlv.microservices.apiService.hvlvApiService.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hvlv.microservices.apiService.hvlvApiService.beans.JsonResultBean;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.hvlv.microservices.apiService.hvlvApiService.utils.ZmRequest;
@Service
public class StorageService extends HvlvService{
    private List<String> pregMatchs;
    private Matcher m;


    public StorageService() {
        pregMatchs = new ArrayList<String>();
    }

    public JsonResultBean orderAochenStorage(JSONObject jsonData)
    {
        JsonResultBean result = new JsonResultBean();
        result = new JsonResultBean();
        String url = "http://ois.intelink.net:8003/ois-web";
        String appKey = "TLA_ACECN";
        String appSecret = "4cbac3c95bbd4b309326b7c00f742972";
        String nonce = "slnkda";
        String version = "1.0";
        HashMap requestBody = new HashMap<String,Object>();
        ArrayList oisInvoices = new ArrayList<HashMap<String,Object>>();
        requestBody.put("platformType","ZYXT");
        requestBody.put("referenceno",jsonData.getString("tlano"));
        requestBody.put("refno","");
        requestBody.put("hubInCode",jsonData.getString("hubInCode"));
        requestBody.put("pcs",jsonData.getString("pkg"));
        requestBody.put("weig",jsonData.getString("weight"));
        requestBody.put("remark",jsonData.getString("remark"));
        requestBody.put("reName",jsonData.getString("consignee_name"));
        requestBody.put("reTel",jsonData.getString("consignee_tel"));
        requestBody.put("reTel2","");
        requestBody.put("reAddr",jsonData.getString("consignee_address"));
        requestBody.put("reAddr2","");
        requestBody.put("reCountryCode",jsonData.getString("consignee_country"));
        requestBody.put("reState",jsonData.getString("consignee_state"));
        requestBody.put("reCity",jsonData.getString("consignee_suburb"));
        requestBody.put("reZip",jsonData.getString("consignee_postcode"));
        requestBody.put("reCode","");
        requestBody.put("decValueCur","USD");

        JSONArray items = jsonData.getJSONArray("items");
        Iterator<Object> it   = items.iterator();
        while (it.hasNext()) {
            JSONObject item = (JSONObject) it.next();
            HashMap oisInvoice = new HashMap<String,Object>();
            oisInvoice.put("descrName",item.getString("g_zh"));
            oisInvoice.put("eDescrNamee",item.getString("g"));
            oisInvoice.put("qty",item.getString("q"));
            oisInvoice.put("price",item.getString("v"));
            oisInvoice.put("hsCode",item.getString("hs"));
            oisInvoice.put("sku",item.getString("sku"));
            oisInvoices.add(oisInvoice);
        }

        requestBody.put("oisInvoices",oisInvoices);

//        ArrayList pieces = new ArrayList<HashMap<String,Object>>();
//        HashMap piece = new HashMap<String,Object>();
//        piece.put("actual",12);
//        piece.put("length",99);
//        piece.put("width",99);
//        piece.put("height",4);
//        piece.put("remark","备注");
//        pieces.add(piece);
//
//        requestBody.put("pieces",pieces);

        requestBody.put("sdName","TLAtesting");
        requestBody.put("sdTel","42353546465467");
        requestBody.put("sdAddr","XXX街道");
        requestBody.put("sdCountry","CN");
        requestBody.put("sdState","广东");
        requestBody.put("sdCity","深圳");
        requestBody.put("sdZip","46465");
        requestBody.put("isReturnsign","N");
        requestBody.put("ccPayment","PP");
        requestBody.put("codCharge",0);
        requestBody.put("codChargeCur","USD");

//        ArrayList taxNoList = new ArrayList<HashMap<String,Object>>();
//        HashMap taxNo = new HashMap<String,Object>();
//        taxNo.put("no","001");
//        taxNo.put("owner","re");
//        taxNo.put("source","print");
//        taxNo.put("type","DAN");
//        taxNoList.add(taxNo);
//        requestBody.put("taxNoList",taxNoList);
        JSONObject json = new JSONObject(requestBody);
        String body = json.toJSONString();
        System.out.println(body);
        ZmRequest client = new ZmRequest(appKey, appSecret, nonce, version);
        String token = client.getToken(url + "/ois/order/getAuth");
        client.setToken(token);
        Map<String, Object> params = new HashMap();
        params.put("body1", body);
        client.setDatas(params);
        String resultStr = client.request(url + "/ois/order/createOrder", "post");
        //System.out.println("打单返回:" + resultStr);
        result.setSuccess();
        result.setData(resultStr);
        return result;
    }

    public JsonResultBean checkAochenOrder(JSONObject jsonData) {
        JsonResultBean result = new JsonResultBean();
        String url = "http://ois.intelink.net:8003/ois-web";
        String appKey = "TLA_ACECN";
        String appSecret = "4cbac3c95bbd4b309326b7c00f742972";
        String nonce = "slnkda";
        String version = "1.0";
        HashMap requestBody = new HashMap<String, Object>();
        ArrayList oisInvoices = new ArrayList<HashMap<String, Object>>();
        requestBody.put("jobno", jsonData.getString("putcode"));
        requestBody.put("codeType", "1");

        JSONObject json = new JSONObject(requestBody);
        String body = json.toJSONString();
        System.out.println(body);
        ZmRequest client = new ZmRequest(appKey, appSecret, nonce, version);
        String token = client.getToken(url + "/ois/order/getAuth");
        client.setToken(token);
        Map<String, Object> params = new HashMap();
        params.put("body1", body);
        client.setDatas(params);
        String resultStr = client.request(url + "/tms/expose/queryPcsData", "post");
        System.out.println("打单返回:" + resultStr);
        result.setSuccess();
        result.setData(resultStr);
        return result;
    }


    private boolean regrexBarcode(String pattern,String barcode)
    {
        Pattern r = Pattern.compile(pattern,Pattern.CASE_INSENSITIVE);
        Matcher m = r.matcher(barcode);
        if(m.find( )) {
           this.m = m;
           return true;
        }
        this.m = null;
        return false;
    }
    private boolean regrexBarcode(String pattern,String barcode,Integer nonM)
    {
        Pattern r = Pattern.compile(pattern,Pattern.CASE_INSENSITIVE);
        Matcher m = r.matcher(barcode);
        if(m.find( )) {
            return true;
        }
        return false;
    }

}
