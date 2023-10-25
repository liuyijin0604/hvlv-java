package com.hvlv.microservices.springcloudapigatewayservice.hvlvspringcloudapigatewayservice.mapper;

import com.hvlv.microservices.springcloudapigatewayservice.hvlvspringcloudapigatewayservice.entity.Api;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface ApiMapper {
    Api select(String user);
}
