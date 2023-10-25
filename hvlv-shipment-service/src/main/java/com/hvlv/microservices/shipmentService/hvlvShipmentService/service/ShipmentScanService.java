package com.hvlv.microservices.shipmentService.hvlvShipmentService.service;

import com.alibaba.fastjson.JSONObject;
import com.hvlv.microservices.shipmentService.hvlvShipmentService.beans.JsonResultBean;
import com.hvlv.microservices.shipmentService.hvlvShipmentService.beans.ShipmentScanBean;
import com.hvlv.microservices.shipmentService.hvlvShipmentService.config.Const;
import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.*;
import com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper.*;
import com.hvlv.microservices.shipmentService.hvlvShipmentService.utils.MyStringUtil;
import com.hvlv.microservices.shipmentService.hvlvShipmentService.utils.TntAPI;
import com.power.common.util.DateTimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class ShipmentScanService extends HvlvService{
    private List<String> pregMatchs;
    private Matcher m;

    @Autowired
    RedisService redisService;
    @Autowired
    ShipmentMapper shipmentMapper;
    @Autowired
    ImportBagMapper importBagMapper;
    @Autowired
    ParcelBarcodeMapper parcelBarcodeMapper;
    @Autowired
    TranshipMapper transhipMapper;
    @Autowired
    ShipmentScanMapper shipmentScanMapper;
    @Autowired
    UserService userService;

    public ShipmentScanService() {
        pregMatchs = new ArrayList<String>();
    }

    public JsonResultBean recognize(String barcode)
    {
        JsonResultBean result = new JsonResultBean();
        ShipmentScanBean shipmentScanBean = this.shipmentRecognition(barcode,false,0,"");
        if(shipmentScanBean.getCourierId()>0)
        {
            result.setData(shipmentScanBean);
            result.setSuccess();
        }else
        {
            result.setNotFound();
        }

        return result;
    }


    public JsonResultBean scanShipment(Integer userId,String barcode,Integer scanType,Integer warehouse)
    {
        JsonResultBean result = new JsonResultBean();
        User user = userService.select(userId);
//        String ref = barcode;
//        Map<String,Object> params = new HashMap<String,Object>();
//        params.put("ref",ref);
//        List<Shipment> p = shipmentMapper.selectByRef(params);
        ShipmentScanBean shipmentScanBean = this.shipmentRecognition(barcode,false,0,"");
        if(shipmentScanBean.getCourierId()>0)
        {
            this.insertShipmentScanRecord(shipmentScanBean,userId,barcode,scanType,warehouse);
            result.setData(shipmentScanBean);
            result.setSuccess();

            // now set cache
            int shipmentSize = shipmentScanBean.getShipments().size();
            for (int i = 0; i < shipmentSize; i++) {
                String shipmentIdKey = "scan:"+shipmentScanBean.getShipments().get(i).getId();
                shipmentScanBean.getShipments().get(i);
                JSONObject scanRecordCache = redisService.getObject(shipmentIdKey);
                if(scanRecordCache!=null)
                {
                    Map de= new HashMap<String, String>();
                    de.put("sno",shipmentScanBean.getSn());
                    de.put("time",DateTimeUtil.nowStrTime());
                    scanRecordCache.put(barcode,de);
                    redisService.setKey(shipmentIdKey, JSONObject.toJSONString(scanRecordCache),172800);
                }else {
                    Map de= new HashMap<String, String>();
                    de.put("sno",shipmentScanBean.getSn());
                    de.put("time",DateTimeUtil.nowStrTime());
                    Map shipmentScanCacheObj = new HashMap<String, Map<String,String>>();
                    shipmentScanCacheObj.put(barcode, de);
                    redisService.setKey(shipmentIdKey, JSONObject.toJSONString(shipmentScanCacheObj),172800);
                }
            }
        }else
        {
            result.setNotFound();
        }


        return result;
    }

    private boolean insertShipmentScanRecord(ShipmentScanBean shipmentScanBean,Integer userId,String barcode,Integer scanType,Integer warehouse)
    {
        for (Shipment shipment:shipmentScanBean.getShipments())
        {
            Date currentTime = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String scanTime = formatter.format(currentTime);
            ShipmentScanMqProcess obj = new ShipmentScanMqProcess(userId, barcode,shipment.getId(),shipmentScanBean.getSn(),warehouse,scanType, scanTime);
            Integer checkCount = shipmentScanMapper.checkCurrentShipmentScanRecord(shipmentScanBean.getShipments().get(0).getId(),shipmentScanBean.getSn());
            if(checkCount==0)
            {
                Boolean isInsertSuccess = shipmentScanMapper.insertShipmentScanProcessRecord(obj);
                if(isInsertSuccess)
                {
                    return true;
                }
            }
        }

        return false;
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

    public ShipmentScanBean shipmentBagScan(String barcode,String containerNo)
    {
        ShipmentScanBean shipmentRecognitionBean =null;
        ImportBag bag = importBagMapper.selecByBagTag(barcode);
        List<Shipment> shipmentArray = null;
        List<Shipment> bagTagRelationShipments = null;
        if(bag!=null)
        {
            shipmentArray = new ArrayList<Shipment>();
        }else
        {
            shipmentRecognitionBean= new ShipmentScanBean(1,new ArrayList<Shipment>());
            return shipmentRecognitionBean;
        }

        if(!StringUtils.isEmpty(containerNo)) {
            bagTagRelationShipments = importBagMapper.getBagTagShipmentsWithContainerNo(barcode,containerNo);
        }else
        {
            bagTagRelationShipments = importBagMapper.getBagTagShipments(barcode);
        }

        if(bagTagRelationShipments!=null)
        {
            shipmentArray = bagTagRelationShipments;
        }

        shipmentRecognitionBean= new ShipmentScanBean(1,shipmentArray);
        return shipmentRecognitionBean;
    }

    private Shipment findShipmentForShipmentRecognition(String ref,boolean noConsol,Integer agent_id,String containerNo)
    {
        Shipment p = null;
        if(!noConsol&&agent_id==0&&StringUtils.isEmpty(containerNo))
        {
            p = shipmentMapper.findShipmentForShipmentRecognition(ref);
        }else if(!noConsol&&agent_id==0&&!StringUtils.isEmpty(containerNo))
        {
            p = shipmentMapper.findShipmentForShipmentRecognitionWithContainerNo(ref,containerNo);
        }

        return p;
    }

    public ShipmentScanBean shipmentRecognition(String barcode,boolean noConsol,Integer agent_id,String containerNo)
    {
        ShipmentScanBean shipmentRecognitionBean =null;
        List<Shipment> pList = new ArrayList<Shipment>();
        Shipment p = null;
        String ref = "";
        Integer sn = 0;
        Integer courierId = 0;
        barcode = barcode.trim();
        boolean changedLabel = false;
        if(StringUtils.isEmpty(barcode)) return null;
        if (this.regrexBarcode("^64(\\d{4})(\\d{13})(\\d{3})$", barcode)){ //AUK TOLL
            ref = this.m.group(2);
            sn = Integer.parseInt(MyStringUtil.ltrim(this.m.group(3),"0"));
            p = this.findShipmentForShipmentRecognition(ref,noConsol,agent_id,containerNo);
            if (p != null)
            {
                courierId = Const.ORGID_COURIER_TLA;
            }
        }else if(this.regrexBarcode("^("+ Const.STARTRACK1 +"|"+Const.STARTRACK2+")\\d{8}"+Const.STARTRACK3+"\\d{5}/", barcode))
        {
            String ssBarcode = this.m.group(0);
            ref = ssBarcode.substring(0,12);
            sn = Integer.parseInt(ssBarcode.substring(15,5));
            p = this.findShipmentForShipmentRecognition(ref,noConsol,agent_id,containerNo);
            if (p != null)
            {
                courierId = Const.ORGID_COURIER_STARTRACK;
            }
        }else if(this.regrexBarcode("^99700160([A-Z]{3})(\\d{7})(\\d{11})/", barcode))
        {
            ref = this.m.group(1)+this.m.group(2);
            sn = Integer.parseInt(this.m.group(3).substring(0,2));
            p = this.findShipmentForShipmentRecognition(ref,noConsol,agent_id,containerNo);
            if (p != null)
            {
                courierId = Const.ORGID_COURIER_AUPOST;
            }
        }else if(this.regrexBarcode("^019931265099999891(((\\w{3,5})\\d{7})(\\d{11}))(\\d{23}|\\d{33})?$", barcode.replaceAll("[^\\dA-Z]+","")))
        {
            barcode = this.m.group(1);
            ref = this.m.group(2);
            sn = Integer.parseInt(this.m.group(4).substring(0,2));
            p = this.findShipmentForShipmentRecognition(ref,noConsol,agent_id,containerNo);
            if (p != null)
            {
                courierId = Const.ORGID_COURIER_AUPOST;
            }
        }else if(this.regrexBarcode("^(((\\w{3,5})\\d{7})(\\d{11}))(\\d{23}|\\d{33})?$", barcode.replaceAll("[^\\dA-Z]+","")))
        {
            barcode = this.m.group(1);
            ref = this.m.group(2);
            sn = Integer.parseInt(this.m.group(4).substring(0,2));
            p = this.findShipmentForShipmentRecognition(ref,noConsol,agent_id,containerNo);
            if (p != null)
            {
                courierId = Const.ORGID_COURIER_AUPOST;
            }
        }else if(this.regrexBarcode("^610412\\d{18}0\\d{4}0$", barcode))//TNT
        {
            String prefix= TntAPI.decodePrefix(m.group(0).substring(6, 12));
            ref = prefix+m.group(0).substring(12,21);
            sn = Integer.parseInt(this.m.group(0).substring(21,24));
            barcode = ref+this.m.group(0).substring(21,24);
            p = this.findShipmentForShipmentRecognition(ref,noConsol,agent_id,containerNo);
            if (p!=null) {
                courierId = Const.ORGID_COURIER_TNT_TOP;
            }
        }else if(this.regrexBarcode("^(CP[A-Z]{5}\\d{7})(\\d{3})$", barcode))//couriers please
        {
            ref = this.m.group(1);
            sn = Integer.parseInt(this.m.group(2));
            p = this.findShipmentForShipmentRecognition(ref,noConsol,agent_id,containerNo);
            if (p!=null) {
                courierId = Const.ORGID_COURIER_CP;
            }
        }else if(this.regrexBarcode("^(CP[A-Z]{3}\\d{10})(\\d{2})$", barcode))//couriers please 2
        {
            ref = this.m.group(1);
            sn = Integer.parseInt(this.m.group(2));
            p = this.findShipmentForShipmentRecognition(ref,noConsol,agent_id,containerNo);
            if (p!=null) {
                courierId = Const.ORGID_COURIER_CP;
            }
        }else if(this.regrexBarcode("^(SCAU\\d{8})(\\d{3})(\\d{3})$", barcode))//saicheng
        {
            ref = this.m.group(1);
            sn = Integer.parseInt(this.m.group(2));
            p = this.findShipmentForShipmentRecognition(ref,noConsol,agent_id,containerNo);
            if (p!=null) {
                courierId = Const.ORGID_COURIER_SAICHENG;
            }
        }else if(this.regrexBarcode("/^(("+Const.DFE_CONSIGNMENT_PREFIX+"|"+Const.DFE_CONSIGNMENT_PREFIX_TOP+"|"+Const.DFE_CONSIGNMENT_PREFIX_TOP_MEL+"|"+Const.DFE_CONSIGNMENT_PREFIX_TOP_BNE+")\\d{7})(\\d{3})(\\d{4})$", barcode))
        { //dfe
            ref = this.m.group(1);
            sn = Integer.parseInt(MyStringUtil.ltrim(this.m.group(3), "0"));
            p = this.findShipmentForShipmentRecognition(ref,noConsol,agent_id,containerNo);
            if (p!=null) {
                if(this.regrexBarcode("/"+Const.DFE_CONSIGNMENT_PREFIX_TOP+"|"+Const.DFE_CONSIGNMENT_PREFIX_TOP_MEL+"|"+Const.DFE_CONSIGNMENT_PREFIX_TOP_BNE, ref))
                {
                    courierId = Const.ORGID_COURIER_DFE_TOP;
                }else
                {
                    courierId = Const.ORGID_COURIER_DFE;
                }
            }
        }else if(this.regrexBarcode("^((24051)\\d{8})(\\d{3})(\\d{4})$", barcode))//4px dfe
        { //dfe
            ref = this.m.group(1);
            sn = Integer.parseInt(MyStringUtil.ltrim(this.m.group(3), "0"));
            p = this.findShipmentForShipmentRecognition(ref,noConsol,agent_id,containerNo);
            if (p!=null) {
                courierId = Const.ORGID_COURIER_4PX;
            }
        }else if(this.regrexBarcode("^(\\d{12})(\\d{3})$", barcode))//4px
        { //dfe
            ref = this.m.group(1);
            sn = Integer.parseInt(MyStringUtil.ltrim(this.m.group(2), "0"));
            p = this.findShipmentForShipmentRecognition(ref,noConsol,agent_id,containerNo);
            if (p!=null) {
                courierId = Const.ORGID_COURIER_4PX;
            }
        }else if(this.regrexBarcode("^((SHD|MHD|BHD)\\d{10})-(\\d{1,})$", barcode))//change label dfe
        {
            ref = this.m.group(1);
            sn = Integer.parseInt(MyStringUtil.ltrim(this.m.group(3), "0"));
            p = this.findShipmentForShipmentRecognition(ref,noConsol,agent_id,containerNo);
            if (p!=null) {
                courierId = Const.ORGID_COURIER_DFE_TOP;
            }
        }else if(this.regrexBarcode("^(TLDB)BX\\d{5}(\\d{6})(\\d{3})$", barcode))//change label border
        {
            ref = this.m.group(1)+this.m.group(2);
            sn = Integer.parseInt(MyStringUtil.ltrim(this.m.group(3), "0"));
            p = this.findShipmentForShipmentRecognition(ref,noConsol,agent_id,containerNo);
            if (p!=null) {
                courierId = Const.ORGID_COURIER_BORDER;
            }
        }else if(this.regrexBarcode("^((SKP|MKP|BKP|PKP|SKPX|MKPX|BKPX|PKPX)\\d{10})-(\\d{1,})$", barcode))//TLD
        {
            ref = this.m.group(1);
            sn = Integer.parseInt(MyStringUtil.ltrim(this.m.group(3), "0"));
            p = this.findShipmentForShipmentRecognition(ref,noConsol,agent_id,containerNo);
            if (p!=null) {
                courierId = Const.ORGID_COURIER_TLA;
            }
        }else if(this.regrexBarcode("^((?:ZV|PB|DQ)\\d{5,6}|UDW\\d{7})(\\d{3})(\\d{7})$", barcode))//hunter express
        {
            ref = this.m.group(1);
            sn = Integer.parseInt(MyStringUtil.ltrim(this.m.group(2), "0"));
            p = this.findShipmentForShipmentRecognition(ref,noConsol,agent_id,containerNo);
            if (p!=null) {
                courierId = Const.ORGID_COURIER_TLA;
            }
        }else if(this.regrexBarcode("^(FLL\\d{6})(\\d{3})\\d{7}$", barcode))//hunter express
        {
            ref = this.m.group(1);
            sn = Integer.parseInt(MyStringUtil.ltrim(this.m.group(2), "0"));
            p = this.findShipmentForShipmentRecognition(ref,noConsol,agent_id,containerNo);
            if (p!=null) {
                courierId = Const.ORGID_COURIER_FL_HUNTER;
            }
        }else if(this.regrexBarcode("^((AOE)(.*))-(\\d{1,})$", barcode))//allied
        {
            ref = this.m.group(1);
            sn = Integer.parseInt(MyStringUtil.ltrim(this.m.group(4), "0"));
            p = this.findShipmentForShipmentRecognition(ref,noConsol,agent_id,containerNo);
            if (p!=null) {
                courierId = Const.ORGID_COURIER_ALLIED;
            }
        }else if(this.regrexBarcode("^((CN)[a-zA-Z0-9]{9})(\\d{4})$", barcode))
        {
            ref = this.m.group(1);
            sn = Integer.parseInt(MyStringUtil.ltrim(this.m.group(3), "0"));
            p = this.findShipmentForShipmentRecognition(ref,noConsol,agent_id,containerNo);
            if (p!=null) {
                courierId = Const.ORGID_COURIER_TLA;
            }
        }else if(this.regrexBarcode("^((CN)[a-zA-Z0-9]{11})(\\d{4})$", barcode))
        {
            ref = this.m.group(1);
            sn = Integer.parseInt(MyStringUtil.ltrim(this.m.group(3), "0"));
            p = this.findShipmentForShipmentRecognition(ref,noConsol,agent_id,containerNo);
            if (p!=null) {
                courierId = Const.ORGID_COURIER_TLA;
            }
        }else if(this.regrexBarcode("^(.+)#(.*)@(\\d+)$", barcode))
        {
            Pattern r = Pattern.compile("(\\d{8}-\\d{4,5})(.*)");
            Matcher mm = r.matcher(this.m.group(2));
            if(mm.find( )) {
                ref = mm.group(1);
                String code = mm.group(2);
                code =  code.replaceAll("合","H");
                code =  code.replaceAll("拆","C");
                code =  code.replaceAll("问","W");
                code =  code.replaceAll("[^a-z0-9]","");
                ref = ref+code;
                if(ref.length()>30)
                {
                    ref = ref.substring(0,30);
                }
            }else
            {
                ref = this.m.group(2);
            }

            sn = Integer.parseInt(this.m.group(3));
            p = this.findShipmentForShipmentRecognition(ref,noConsol,agent_id,containerNo);
            if (p!=null) {
                courierId = Const.ORGID_COURIER_TLA;
            }
        }else if(this.regrexBarcode("^MIX-SEA-", barcode)||this.regrexBarcode("(\\d+)-(\\d+){11}$/", barcode))//For Bag
        {
            ImportBag bag = importBagMapper.selecByBagTag(barcode);
            List<Shipment> shipmentArray = null;
            List<Shipment> bagTagRelationShipments = null;
            if(bag!=null)
            {
                shipmentArray = new ArrayList<Shipment>();
            }else
            {
                shipmentRecognitionBean= new ShipmentScanBean(1,new ArrayList<Shipment>());
                return shipmentRecognitionBean;
            }

            if(!StringUtils.isEmpty(containerNo)) {
                bagTagRelationShipments = importBagMapper.getBagTagShipmentsWithContainerNo(barcode,containerNo);
            }else
            {
                bagTagRelationShipments = importBagMapper.getBagTagShipments(barcode);
            }

            if(bagTagRelationShipments!=null)
            {
                shipmentArray = bagTagRelationShipments;
            }

            shipmentRecognitionBean= new ShipmentScanBean(1,shipmentArray);
            shipmentRecognitionBean.setCourierId(Const.ORGID_COURIER_TLA);
            return shipmentRecognitionBean;
        }
      else
      {
          ImportBag bag = importBagMapper.selecByBagTag(barcode);
          if(bag!=null)
          {
              shipmentRecognitionBean = shipmentBagScan(barcode,containerNo);

              if(shipmentRecognitionBean.getShipments().size()==1 && barcode==shipmentRecognitionBean.getShipments().get(0).getHbn())
              {
                  shipmentRecognitionBean.setType(0);
              }
              shipmentRecognitionBean.setCourierId(Const.ORGID_COURIER_TLA);
              return shipmentRecognitionBean;
          }

        if(this.regrexBarcode("^(.+)-(\\d+){1,4}$", barcode)) {
            ref = this.m.group(1);
            sn = Integer.parseInt(this.m.group(2));
        } else {
            ref = barcode;
        }

        p = this.findShipmentForShipmentRecognition(ref,noConsol,agent_id,containerNo);
        if(p==null)
        {
            sn = 0;
            ref = barcode;
            p = this.findShipmentForShipmentRecognition(ref,false,0,"");
            if(p!=null)sn = 1;
        }
    }
        //for SF or other have barcode records
        if(p==null||(p!=null&&sn ==0))
        {
            ParcelBarcode pb = parcelBarcodeMapper.findByBarcode(barcode);
            if(pb!=null)
            {
                p = shipmentMapper.findImparcelById(Integer.parseInt(pb.getFid()));
                if(p!=null)
                {
                    if(p.getRef().equals(pb.getMainRef()))
                    {
                        Tranship tran = transhipMapper.getShipmentFinalTranship(p.getId());
                        if(tran!=null)
                        {
                            courierId = tran.getOrgId();
                        }else
                        {
                            courierId = Const.ORGID_COURIER_TLA;
                        }
                        sn = Integer.parseInt(pb.getSn());
                    }else
                    {
                        p=null;
                    }
                }
            }
        }

        if(p==null && changedLabel){
            Shipment csl = shipmentMapper.findChangeShipment(ref,ref+"-"+sn);//::model()->find('pref=:pref OR phbn = :pref or pref = :prefsn', [':pref'=>$ref,':prefsn'=>$ref."-".$sn]);
            if(csl!=null){
                p = csl;
                changedLabel = true;
            }
        }
        if(p!=null) {
            Tranship tran = transhipMapper.getShipmentFinalTranship(p.getId());
            if (courierId==0)
            {
                if(!StringUtils.isEmpty(tran))
                {
                    courierId = tran.getOrgId();
                }else
                {
                    courierId = Const.ORGID_COURIER_TLA;
                }
            }
            pList.add(p);
        }
        shipmentRecognitionBean = new ShipmentScanBean(0,pList);
        shipmentRecognitionBean.setCourierId(courierId);
        shipmentRecognitionBean.setChangeLabel(changedLabel);
        shipmentRecognitionBean.setSn(sn);
        return shipmentRecognitionBean;
    }
}
