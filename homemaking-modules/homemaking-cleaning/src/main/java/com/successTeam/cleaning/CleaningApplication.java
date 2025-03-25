package com.successTeam.cleaning;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.successTeam.cleaning.mapper")
public class CleaningApplication {
    public static void main(String[] args) {
        SpringApplication.run(CleaningApplication.class, args);
    }

}
