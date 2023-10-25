package com.hvlv.microservices.hvlveurekanamingserver.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);//访问eureka控制台和actuator控制台时能做安全控制
        //方法1：关闭csrf
        http.csrf().disable();
    //        //方法2：忽略/eureka/** 所有请求
    //        http.csrf().ignoringAntMatchers("/eureka/**");
    }

}