package com.hvlv.microservices.shipmentClusterService.hvlvShipmentClusterService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.hvlv.microservices.shipmentClusterService.hvlvShipmentClusterService")
public class HvlvShipmentClusterServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(HvlvShipmentClusterServiceApplication.class, args);
    }

//    @Bean
//    @LoadBalanced
//    public RestTemplate restTemplate() {
//        return new RestTemplate();
//    }

}
