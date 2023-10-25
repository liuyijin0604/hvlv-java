package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.Shipment;
import io.lettuce.core.dynamic.annotation.Param;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
@Mapper
@Repository
public interface ShipmentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Shipment record);

    int insertSelective(Shipment record);

    Shipment selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Shipment record);

    int updateByPrimaryKeyWithBLOBs(Shipment record);

    int updateByPrimaryKey(Shipment record);

    int countShipmentByHbnAndAgentId(@Param("hbn") String hbn, @Param("agentId") int agentId);

    int countShipmentByRef(@Param("ref") String ref);

    Shipment findImparcelById(Integer id);

    Shipment select(int id);

    List<Shipment> selectByRef(Map<String,Object> map);

    Shipment findShipmentForShipmentRecognition(String ref);

    Shipment findShipmentForShipmentRecognitionWithContainerNo(String ref,String containerNo);

    Shipment findChangeShipment(String ref1,String ref2);
}