package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.Postcode;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository

public interface PostcodeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Postcode record);

    int insertSelective(Postcode record);

    List<String> getCountryList();

    List<String> getStateList();

    int countBySuburbStatePostcodeCountry(String suburb, String state, String postcode, String country);
    List<String> findSuburbsByStateAndPostcodeCountry(String state, String postcode, String country);

    Postcode selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Postcode record);

    int updateByPrimaryKey(Postcode record);
}