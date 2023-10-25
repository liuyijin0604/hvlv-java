package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.ImportChargeCode;
import io.lettuce.core.dynamic.annotation.Param;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository

public interface ImportChargeCodeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ImportChargeCode record);

    int insertSelective(ImportChargeCode record);

    ImportChargeCode selectByPrimaryKey(Integer id);

    ImportChargeCode findByChargeCode(String chargeCode);

    int updateByPrimaryKeySelective(ImportChargeCode record);

    int updateByPrimaryKeyWithBLOBs(ImportChargeCode record);

    int updateByPrimaryKey(ImportChargeCode record);

    ImportChargeCode findByChargecode(@Param("chargecode") String chargecode);
}