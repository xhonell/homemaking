package com.successTeam.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * program: homemaking
 * ClassName OrderApplication
 * description:
 * author: xhonell
 * create: 2025年03月24日19时34分
 * Version 1.0
 **/
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.successTeam.order.mapper")
public class OrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }
}
