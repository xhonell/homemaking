package com.successTeam.auth;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AuthApplication {
    public static void main(String[] args) {
        org.springframework.boot.SpringApplication.run(AuthApplication.class, args);
    }
}
