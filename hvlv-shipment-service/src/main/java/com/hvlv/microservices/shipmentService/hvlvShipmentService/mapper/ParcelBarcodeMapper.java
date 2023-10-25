package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.ParcelBarcode;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ParcelBarcodeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ParcelBarcode record);

    int insertSelective(ParcelBarcode record);

    ParcelBarcode selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ParcelBarcode record);

    int updateByPrimaryKey(ParcelBarcode record);

    ParcelBarcode findByBarcode(String barcode);
}