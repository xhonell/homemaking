package com.successTeam.core.service.impl;

import com.successTeam.core.pojo.entity.UserRedis;
import com.successTeam.core.service.UserLocalThread;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

/**
 * program: homemaking
 * ClassName UserLocalThread
 * description:
 * author: xhonell
 * create: 2025年03月25日15时46分
 * Version 1.0
 **/
@Slf4j
public class UserLocalThreadImpl implements UserLocalThread {
    private static final ThreadLocal<UserRedis> threadLocal = new ThreadLocal<>();

    /**
     * 绑定到当前线程
     *
     * @param userRedis 用户信息
     */
    public static void set(UserRedis userRedis) {
        log.info("用户{}信息已完成当前线程绑定", userRedis.getUserId());
        threadLocal.set(userRedis);
    }

    /**
     * 获取当前线程绑定的用户信息
     */
    public static UserRedis get() {
        if (threadLocal.get() == null)
            return null;
        return threadLocal.get();
    }

    /**
     * 删除当前线程的用户信息
     */
    public static void remove() {
        if (get() != null) {
            log.info("删除当前线程的用户信息：{}", get().getUserId());
            threadLocal.remove();
        }
    }
}
