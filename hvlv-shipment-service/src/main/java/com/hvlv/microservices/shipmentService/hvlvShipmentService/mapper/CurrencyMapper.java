package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.Currency;
import io.lettuce.core.dynamic.annotation.Param;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository

public interface CurrencyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Currency record);

    int insertSelective(Currency record);

    Currency selectByPrimaryKey(Integer id);

    Currency getExrate(@Param("date") String date, @Param("type") int type);

    int updateByPrimaryKeySelective(Currency record);

    int updateByPrimaryKeyWithBLOBs(Currency record);

    int updateByPrimaryKey(Currency record);
}