package com.successTeam.auth.service;

import com.mybatisflex.core.service.IService;
import com.successTeam.auth.pojo.dto.UserLoginDto;
import com.successTeam.auth.pojo.entity.User;
import com.successTeam.core.pojo.entity.UserRedis;

/**
 * program: homemaking
 * ClassName UserService
 * description:
 * author: xhonell
 * create: 2025年03月25日14时32分
 * Version 1.0
 **/
public interface UserService extends IService<User> {
    /*用户注册*/
    String login(UserLoginDto userLoginDto);

    /*根据token获取信息*/
    UserRedis findUserByToken(String token);
}
