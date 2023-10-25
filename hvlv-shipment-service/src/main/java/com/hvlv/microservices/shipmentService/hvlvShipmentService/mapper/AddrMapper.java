package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.Addr;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface AddrMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Addr record);

    int insertSelective(Addr record);

    Addr selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Addr record);

    int updateByPrimaryKeyWithBLOBs(Addr record);

    int updateByPrimaryKey(Addr record);
}