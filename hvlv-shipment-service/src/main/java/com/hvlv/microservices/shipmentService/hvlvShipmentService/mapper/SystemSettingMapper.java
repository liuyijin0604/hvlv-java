package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.SystemSetting;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface SystemSettingMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SystemSetting record);

    int insertSelective(SystemSetting record);

    SystemSetting selectByPrimaryKey(Integer id);

    SystemSetting selectByKey(String key);

    int updateByPrimaryKeySelective(SystemSetting record);

    int updateByPrimaryKeyWithBLOBs(SystemSetting record);

    int updateByPrimaryKey(SystemSetting record);
}