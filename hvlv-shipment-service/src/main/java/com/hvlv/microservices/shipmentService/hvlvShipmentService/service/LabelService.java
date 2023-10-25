package com.hvlv.microservices.shipmentService.hvlvShipmentService.service;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.beans.JsonResultBean;
import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.ConnoteRange;
import com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper.ConnoteRangeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.regex.Matcher;
import java.util.zip.CRC32;

@Service
public class LabelService extends HvlvService{
    private List<String> pregMatchs;
    private Matcher m;

    @Autowired
    RedisService redisService;
    @Autowired
    ConnoteRangeMapper connoteRangeMapper;

    public LabelService() {
        pregMatchs = new ArrayList<String>();
    }

    public JsonResultBean generateRefByPrefix(String prefix,Integer orgId)
    {
        JsonResultBean result = new JsonResultBean();
        String n = "";
        List<ConnoteRange> ranges = connoteRangeMapper.findRanges("org",orgId,prefix);
        for (int i = 0; i < ranges.size(); i++) {
            n = this.getNextNumber(ranges.get(i));
            if(!StringUtils.isEmpty(n))
            {
                break;
            }
        }

        if(!StringUtils.isEmpty(n))
        {
            HashMap<String,String> map = new HashMap();
            map.put("ref",n);
            result.setData(map);
            result.setSuccess();
        }else
        {
            result.setNotFound();
        }
        return result;
    }

    private String getNextNumber(ConnoteRange range)
    {
        CRC32 crc = new CRC32();
        Random rand = new Random();
        int randomNum = rand.nextInt((999999 - 0) + 1) + 0;
        String ranTime = String.valueOf(System.currentTimeMillis())+ randomNum;
        crc.update(ranTime.getBytes());
        String enc = Long.toHexString(crc.getValue());
        String n = "";
        if(range.getStatus() > 10) return "";
        String v = "@nln_"+enc;
        connoteRangeMapper.updateCache(v,range.getId());
        Integer number = connoteRangeMapper.selectCacheV(v);
        connoteRangeMapper.updateCacheV(v);

        if(number >= range.getFinish()) range.setStatus(ConnoteRange.FINISH_STATUS);
        return range.getPrefix()+this.prepNumber(range,number)+range.getSuffix();
    }

    private String prepNumber(ConnoteRange range,Integer number){
        return range.getDigits()>0? String.format("%0"+range.getDigits()+"d", number) : number+"";
    }

}
