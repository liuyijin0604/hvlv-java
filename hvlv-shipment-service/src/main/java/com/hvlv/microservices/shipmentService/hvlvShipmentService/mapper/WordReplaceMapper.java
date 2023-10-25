package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.WordReplace;

public interface WordReplaceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WordReplace record);

    int insertSelective(WordReplace record);

    WordReplace selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WordReplace record);

    int updateByPrimaryKeyWithBLOBs(WordReplace record);

    int updateByPrimaryKey(WordReplace record);
}