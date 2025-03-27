package com.successTeam.employee;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * com.successTeam.employee
 * User: hdh
 * Date: 2025/03/25 19:33
 * motto:   百折不挠
 * Description:
 * Version: V1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.successTeam.employee.mapper")
public class EmployeeApplication {
    public static void main(String[] args) {
        SpringApplication.run(EmployeeApplication.class, args);
    }
}
