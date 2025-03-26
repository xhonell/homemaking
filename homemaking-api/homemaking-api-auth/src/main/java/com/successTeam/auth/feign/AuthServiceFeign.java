package com.successTeam.auth.feign;

import com.successTeam.auth.fallback.AuthServiceFeignFactory;
import com.successTeam.auth.pojo.dto.UserLoginDto;
import com.successTeam.core.pojo.entity.UserRedis;
import com.successTeam.core.result.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * program: homemaking
 * ClassName AuthServiceFeign
 * description:
 * author: xhonell
 * create: 2025年03月25日15时40分
 * Version 1.0
 **/
@FeignClient(contextId = "auth-feign", value = "auth-service", fallbackFactory = AuthServiceFeignFactory.class)
public interface AuthServiceFeign {

    /*登录*/
    @PostMapping("/app-api/user/login")
    Result<String> login(@RequestBody UserLoginDto userLoginDto);

    /*根据token查询用户信息*/
    @GetMapping("/app-api/user/findUserByToken/{token}")
    Result<UserRedis> findUserByToken(@PathVariable String token);
}
