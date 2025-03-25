package com.successTeam.nanny;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * com.successTeam.nanny
 * User: hdh
 * Date: 2025/03/24 16:41
 * motto:   百折不挠
 * Description:
 * Version: V1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.successTeam.nanny.mapper")
public class NannyApplication {
    public static void main(String[] args) {
        SpringApplication.run(NannyApplication.class, args);
    }
}
