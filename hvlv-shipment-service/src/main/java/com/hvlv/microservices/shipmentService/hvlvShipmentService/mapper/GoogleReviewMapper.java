package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.GoogleReview;

public interface GoogleReviewMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GoogleReview record);

    int insertSelective(GoogleReview record);

    GoogleReview selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GoogleReview record);

    int updateByPrimaryKey(GoogleReview record);
}