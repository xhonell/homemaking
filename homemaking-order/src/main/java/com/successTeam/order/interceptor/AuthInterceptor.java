package com.successTeam.order.interceptor;

import com.successTeam.auth.feign.AuthServiceFeign;
import com.successTeam.core.exception.BizException;
import com.successTeam.core.pojo.entity.UserRedis;
import com.successTeam.core.result.Result;
import com.successTeam.core.result.ResultEnum;
import com.successTeam.core.service.UserLocalThread;
import com.successTeam.core.service.impl.UserLocalThreadImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * program: homemaking
 * ClassName AuthInterceptor
 * description:
 * author: xhonell
 * create: 2025年03月25日20时40分
 * Version 1.0
 **/
@Slf4j
public class AuthInterceptor implements HandlerInterceptor {
    /*白名单*/
    private static final String[]  IGNORE_PATH = new String[]{
            "/v2/api-docs"
    };
    @Autowired
    private AuthServiceFeign  authServiceFeign;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (isIgnore(request.getRequestURI()))
            return true;
        // 获取请求头中的token
        String authToken = request.getHeader("authToken");
        log.info("当前访问的：{}", request.getRequestURI());
        if (authToken == null)
            throw new BizException(ResultEnum.ILLEGAL_ACCESS);
        // 读取token请求数据
        Result<UserRedis> result = authServiceFeign.findUserByToken(authToken);
        UserRedis userRedis = result.getData();
        UserLocalThreadImpl.set(userRedis);
        return true;
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

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        UserLocalThreadImpl.remove();
    }
}
