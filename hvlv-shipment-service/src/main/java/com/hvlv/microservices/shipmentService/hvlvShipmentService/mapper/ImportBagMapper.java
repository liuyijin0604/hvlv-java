package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.ImportBag;
import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.Shipment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ImportBagMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ImportBag record);

    int insertSelective(ImportBag record);

    ImportBag selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ImportBag record);

    int updateByPrimaryKeyWithBLOBs(ImportBag record);

    int updateByPrimaryKey(ImportBag record);

    ImportBag selecByBagTag(String bagTag);

    List<Shipment> getBagTagShipmentsWithContainerNo(String bagTag, String containerNo);

    List<Shipment> getBagTagShipments(String bagTag);
}