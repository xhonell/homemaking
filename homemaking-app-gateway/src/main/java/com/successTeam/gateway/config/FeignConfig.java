package com.successTeam.gateway.config;

import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

/**
 * program: homemaking
 * ClassName FeignConfig
 * description:
 * author: xhonell
 * create: 2025年03月25日21时56分
 * Version 1.0
 **/
@Configuration
public class FeignConfig {
    @Bean
    public HttpMessageConverters httpMessageConverters() {
        return new HttpMessageConverters(new MappingJackson2HttpMessageConverter());
    }
}
