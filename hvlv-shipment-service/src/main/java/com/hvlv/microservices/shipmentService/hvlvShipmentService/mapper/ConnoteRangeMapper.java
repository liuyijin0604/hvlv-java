package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.ConnoteRange;
import io.lettuce.core.dynamic.annotation.Param;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ConnoteRangeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ConnoteRange record);

    int insertSelective(ConnoteRange record);

    ConnoteRange selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ConnoteRange record);

    int updateByPrimaryKeyWithBLOBs(ConnoteRange record);

    int updateByPrimaryKey(ConnoteRange record);

    List<ConnoteRange> findAllByTypeAndStatusAndModelAndFid(@Param("oid") int oid);

    List<ConnoteRange> findRanges(String model, Integer fid, String pfx);

    void updateCache(String v, Integer id);

    Integer selectCacheV(String v);

    void updateCacheV(String v);
}