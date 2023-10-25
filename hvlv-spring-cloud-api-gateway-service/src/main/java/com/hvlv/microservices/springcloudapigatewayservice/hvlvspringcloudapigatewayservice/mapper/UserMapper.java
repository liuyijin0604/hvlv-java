package com.hvlv.microservices.springcloudapigatewayservice.hvlvspringcloudapigatewayservice.mapper;

import com.hvlv.microservices.springcloudapigatewayservice.hvlvspringcloudapigatewayservice.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    User select(int id);
}
