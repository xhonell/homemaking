package com.successTeam.auth.fallback;

import com.successTeam.auth.feign.AuthServiceFeign;
import com.successTeam.auth.pojo.dto.UserLoginDto;
import com.successTeam.core.result.Result;
import com.successTeam.core.service.UserLocalThread;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;

/**
 * program: homemaking
 * ClassName AuthServiceFactory
 * description:
 * author: xhonell
 * create: 2025年03月25日15时53分
 * Version 1.0
 **/
@Slf4j
public class AuthServiceFeignFactory implements FallbackFactory<AuthServiceFeign> {
    @Override
    public AuthServiceFeign create(Throwable throwable) {
        log.error("认证微服务调用失败：{}",throwable.getMessage(), throwable);
        return new AuthServiceFeign() {
            @Override
            public Result login(UserLoginDto userLoginDto) {
                return Result.buildFail();
            }

            @Override
            public Result findUserByToken(String token) {
                return Result.buildFail();
            }
        };
    }
}
