package com.hvlv.microservices.shipmentService.hvlvShipmentService;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@MapperScan("com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper")
@SpringBootApplication
@EnableFeignClients("com.hvlv.microservices.shipmentService.hvlvShipmentService")
public class HvlvShipmentServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(HvlvShipmentServiceApplication.class, args);
    }

}
