package com.successTeam.cat;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * program: homemaking
 * ClassName CatApplication
 * description:
 * author: xhonell
 * create: 2025年03月22日23时35分
 * Version 1.0
 **/
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.successTeam.cat.mapper")
public class CatApplication {
    public static void main(String[] args) {
        SpringApplication.run(CatApplication.class, args);
    }
}
