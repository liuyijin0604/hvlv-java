//package com.hvlv.microservices.springcloudapigatewayservice.hvlvspringcloudapigatewayservice.config;
//
//import com.hvlv.microservices.springcloudapigatewayservice.hvlvspringcloudapigatewayservice.mapper.ApiMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.gateway.route.RouteLocator;
//import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class CloudRoutingConfig {
//    @Bean
//    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder)
//    {
//        return builder.routes().route(
//                r->r.path("/product-enquiry/**")
//                .uri("http://localhost:8700/")
//                .id("stock-enquiry")
//        ).build();
//    }
//
//}
