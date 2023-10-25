package com.hvlv.microservices.apiService.hvlvApiService;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@MapperScan("com.hvlv.microservices.apiService.hvlvApiService.mapper")
@SpringBootApplication
@EnableFeignClients("com.hvlv.microservices.apiService.hvlvApiService")
public class HvlvApiServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(HvlvApiServiceApplication.class, args);
    }

}
