package com.hvlv.microservices.hvlveurekanamingserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class HvlvEurekaNamingServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(HvlvEurekaNamingServerApplication.class, args);
    }

}
