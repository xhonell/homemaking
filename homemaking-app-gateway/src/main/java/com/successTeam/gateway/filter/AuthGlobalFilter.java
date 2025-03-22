package com.successTeam.gateway.filter;

import cn.hutool.core.util.StrUtil;
import com.successTeam.core.exception.BizException;
import com.successTeam.core.result.ResultEnum;
import com.successTeam.redis.service.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * program: homemaking
 * ClassName AuthGolbalFilter
 * description:
 * author: xhonell
 * create: 2025年03月22日21时07分
 * Version 1.0
 **/
@Slf4j
//@Component
public class AuthGlobalFilter implements GlobalFilter, Ordered {
    @Autowired
    private RedisService redisService;

    public static final String USER_TOKEN = "user:token:";
    public static final Long EXPIRE_TOKEN = 2*60*60L;
    /**
     * 全局过滤器，判断是否登录
     * @param exchange
     * @param chain
     * @return
     */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        // 获取请求体
        ServerHttpRequest request = exchange.getRequest();
        // 从请求体中获取请求头
        HttpHeaders headers = request.getHeaders();
        // 从请求头中获取自定义token头
        String token = headers.getFirst("token");
        // 判断token是否存在
        if (StrUtil.isEmpty(token)) {
            throw new BizException(ResultEnum.TOKEN_IS_NULL);
        }
        // 判断token是否合法
        String cacheObject = redisService.getCacheObject(USER_TOKEN + token);
        if (StrUtil.isEmpty(cacheObject)) {
            throw new BizException(ResultEnum.TOKEN_IS_NULL);
        }
        // 刷新redis
        redisService.expire(USER_TOKEN + token, EXPIRE_TOKEN);
        // 想下游转发
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
