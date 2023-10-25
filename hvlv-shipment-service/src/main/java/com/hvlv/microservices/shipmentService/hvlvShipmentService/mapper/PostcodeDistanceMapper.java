package com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.PostcodeDistance;
import io.lettuce.core.dynamic.annotation.Param;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface PostcodeDistanceMapper {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(PostcodeDistance record);

    PostcodeDistance selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PostcodeDistance record);

    int updateByPrimaryKey(PostcodeDistance record);

    PostcodeDistance findByOriginDestinationSuburbState(
            @Param("origin") int origin,
            @Param("destination") String destination,
            @Param("suburb") String suburb,
            @Param("state") String state
    );

    int insertFromGoogleAPI(PostcodeDistance postcodeDistance);
}