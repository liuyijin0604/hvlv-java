package com.hvlv.microservices.shipmentService.hvlvShipmentService.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hvlv.microservices.shipmentService.hvlvShipmentService.beans.*;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.*;

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

import java.util.*;

@Service
public class ConnoteRangeService {

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

    public static final int ORGID_COURIER_TLA = 114;
    public static final int ORGID_COURIER_PICKUP = 199;
    public static final int ORGID_COURIER_TOLL_IPEC = 3752;

    public JsonResultBean checkReserved(ShipmentBean shipment)
    {
        JsonResultBean result = new JsonResultBean();
        DataBean dataBean = new DataBean();
        result.setData(dataBean);
        result.setSuccess();

        if (shipment.getNo().length() < 6) {
            dataBean.setMsg("[20000] - Shipment " + shipment.getNo() + " Connote No. at least 6 characters");
            dataBean.setStatus(0);
            return result;
        }
        if(shipmentMapper.countShipmentByHbnAndAgentId(shipment.getHbn(),shipment.getAgent_id())>0){
            dataBean.setMsg("[20000] - Shipment " + shipment.getNo() + " already exist!");
            dataBean.setStatus(0);
            return result;
        }
        int agt_id;
        if (shipment.getAgent_id()==4564){
            agt_id = 2716;
        }else {
            agt_id = shipment.getAgent_id();
        }

        int checkReservedResult = checkReserved(agt_id, shipment.getNo());
        switch (checkReservedResult) {
            case 1:
                if (shipmentMapper.countShipmentByRef(shipment.getNo()) > 0) {
                    dataBean.setMsg("[20000] - Shipment " + shipment.getNo() + " already exist!");
                    dataBean.setStatus(0);
                    return result;
                }
            case -9:
                dataBean.setMsg("[20000] - Shipment " + shipment.getNo() + " out of allowed number range!");
                dataBean.setStatus(0);
                return result;
        }
        dataBean.setStatus(1);
        return result;
    }

    private int checkReserved(int agt,String no){
        List<ConnoteRange> connoteRangeList = connoteRangeMapper.findAllByTypeAndStatusAndModelAndFid(agt);
        int rt = 0;
        for (ConnoteRange r : connoteRangeList) {
            if (no.matches("^" + r.getPrefix() + "(\\d+)$")) {
                String[] m = no.split(r.getPrefix());
                int n = Integer.parseInt(m[1]);
                if (n >= r.getStart() && n <= r.getFinish()) {
                    return 1;
                } else {
                    rt = -9;
                }
            }
        }
        return rt;
    }

    public JsonResultBean checkPENumberCanUse(ShipmentBean shipment,int courier)
    {
        JsonResultBean result = new JsonResultBean();
        DataBean dataBean = new DataBean();
        result.setData(dataBean);
        result.setSuccess();
        if(shipment.getMeta()!=null&&!shipment.getMeta().containsKey("pe_number"))
        {
            dataBean.setStatus(0);
            dataBean.setMsg("require pe number");
            return result;
        }else {
            if (courier != ORGID_COURIER_TLA && courier != ORGID_COURIER_PICKUP &&
                    courier != ORGID_COURIER_TOLL_IPEC) {
                dataBean.setStatus(0);
                dataBean.setMsg("Only Top Logistics Delivery(TLD) Service and Toll can use PE number.");
                return result;
            }
            String code = shipment.getMeta().getString("pe_number");
            PriceEnquiry pe = priceEnquiryMapper.findByCodeAndOrgIdAndStatus(code, courier, 20);
            if(pe==null){
                dataBean.setStatus(0);
                dataBean.setMsg("PE number can not be used.");
                return result;
            }

            String normalizedShipmentAddress = shipment.getAddress().trim().replaceAll("\\s+", " ");
            String normalizedPEAddress = pe.getAddress().trim().replaceAll("\\s+", " ");
            double shipmentWeight = shipment.getWeight();
            double peWeight = pe.getWeight();

            boolean addressesEqual = normalizedShipmentAddress.equalsIgnoreCase(normalizedPEAddress);
            boolean weightsClose = Math.abs(shipmentWeight - peWeight) < 1;
            if(addressesEqual && weightsClose)
            {
                String metaJSONString = pe.getMeta();
                JSONObject metaJsonObject = JSON.parseObject(metaJSONString);
                JSONArray listItemArray = metaJsonObject.getJSONArray("listItem");
                List<JSONObject> objItems = new ArrayList<>();
                for (int i = 0; i < listItemArray.size(); i++) {
                    JSONObject objItem = listItemArray.getJSONObject(i);
                    objItems.add(objItem);
                }
                List<JSONObject> packs = itemsToPacks(objItems);
                JSONArray checkPacks = shipment.getPackages();
                for (int i = 0; i < packs.size(); i++) {
                    JSONObject pack = packs.get(i);
                    boolean shouldRemove = false;
                    for (int j = 0; j < checkPacks.size(); j++) {
                        JSONObject checkPack = checkPacks.getJSONObject(j);
                        if (Math.abs(pack.getDoubleValue("width") - checkPack.getDoubleValue("width")) < 1 &&
                                Math.abs(pack.getDoubleValue("height") - checkPack.getDoubleValue("height")) < 1 &&
                                Math.abs(pack.getDoubleValue("length") - checkPack.getDoubleValue("length")) < 1 &&
                                Math.abs(pack.getDoubleValue("weight") - checkPack.getDoubleValue("weight")) < 1)
                        {
                            shouldRemove = true;
                            break;
                        }
                    }
                    if (shouldRemove) {
                        packs.remove(i);
                        i--;
                    }
                }
                if (!packs.isEmpty())
                {
                    dataBean.setStatus(0);
                    dataBean.setMsg("The info of PE number can not match this parcel.");
                } else {
                    dataBean.setStatus(1);
                }
            }else {
                dataBean.setStatus(0);
                dataBean.setMsg("The info of PE number can not match this parcel.");
            }
        }
        return result;
    }

    private List<JSONObject> itemsToPacks(List<JSONObject> objItems) {
        List<JSONObject> packs = new ArrayList<>();
        for (JSONObject objItem : objItems) {
            int quantity = objItem.getIntValue("quantity");
            for (int i = 0; i < quantity; i++) {
                JSONObject thisPack = new JSONObject();
                thisPack.put("length", objItem.getDoubleValue("length"));
                thisPack.put("width", objItem.getDoubleValue("width"));
                thisPack.put("height", objItem.getDoubleValue("height"));
                thisPack.put("weight", objItem.getDoubleValue("weight"));
                packs.add(thisPack);
            }
        }
        return packs;
    }

}
