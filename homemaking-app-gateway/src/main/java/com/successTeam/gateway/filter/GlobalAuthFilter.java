package com.successTeam.gateway.filter;

import com.successTeam.auth.feign.AuthServiceFeign;
import com.successTeam.core.exception.BizException;
import com.successTeam.core.pojo.entity.UserRedis;
import com.successTeam.core.result.Result;
import com.successTeam.core.result.ResultEnum;
import io.lettuce.core.dynamic.annotation.CommandNaming;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * program: homemaking
 * ClassName GlobalAuthInterceptor
 * description:
 * author: xhonell
 * create: 2025年03月25日16时26分
 * Version 1.0
 **/
@Slf4j
@Component
public class GlobalAuthFilter implements GlobalFilter, Ordered {

    @Autowired
    private AuthServiceFeign  authServiceFeign;

    private static final String[]  IGNORE_PATH = new String[]{
            "/order-api/v2/api-docs",
            "/auth-api/v2/api-docs",
            "/auth-api/app-api/user/findUserByToken",
            "/auth-api/app-api/user/login",
            "/cat-api/v2/api-docs"
    };

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        // 获取是否是白名单
        ServerHttpRequest request = exchange.getRequest();
        String path = request.getURI().getPath();
        log.info("当前访问的路径是：{}",path);
        if (isIgnore(path))
            return chain.filter(exchange);
        // 判断是否携带token
        String token = request.getHeaders().getFirst("token");
        if (token == null)
            throw new BizException(ResultEnum.USER_NOT_LOGIN);
        Result<UserRedis> redisResult = authServiceFeign.findUserByToken(token);
        UserRedis userRedis = redisResult.getData();
        if (userRedis == null)
            throw new BizException(ResultEnum.USER_NOT_LOGIN);
        // 修改请求头，删除token请求头，添加为authToke请求头
        ServerHttpRequest newRequest = request.mutate()
                .headers(headers -> {
                    headers.remove("token");                 // 删除原 Token 头
                    headers.add("authToken", token); // 添加新认证 Token
                })
                .build();
        return chain.filter(exchange.mutate().request(newRequest).build());
    }

    /**
     * 判断是否白名单
     * @param path
     * @return
     */
    private boolean  isIgnore(String path) {
        for (String ignorePath : IGNORE_PATH) {
            if (path.startsWith(ignorePath))
                return true;
        }
        return false;
    }

    /**
     * 设置执行优先级
     * @return
     */
    @Override
    public int getOrder() {
        return 0;
    }
}
