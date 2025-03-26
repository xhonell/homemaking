package com.successTeam.appraise;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * User: zhongjing
 * Date: 2025/3/24
 * Description:
 * Version: V1.0
 */
@SpringBootApplication
@EnableDiscoveryClient //注册中心注册
@MapperScan("com.successTeam.appraise.mapper")
public class AppraiseApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppraiseApplication.class,args);
    }

}
