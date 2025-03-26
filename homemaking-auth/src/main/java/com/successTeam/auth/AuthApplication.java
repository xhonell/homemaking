package com.successTeam.auth;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.successTeam.auth.mapper")
public class AuthApplication {
    public static void main(String[] args) {
        org.springframework.boot.SpringApplication.run(AuthApplication.class, args);
    }
}
