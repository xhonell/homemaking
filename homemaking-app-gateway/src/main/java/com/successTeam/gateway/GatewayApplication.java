package com.successTeam.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * program: homemaking
 * ClassName GatewayApplication
 * description:
 * author: xhonell
 * create: 2025年03月22日20时00分
 * Version 1.0
 **/
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients("com.successTeam.auth.feign")
public class GatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }
}
