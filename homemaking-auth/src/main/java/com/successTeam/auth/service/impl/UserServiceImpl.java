package com.successTeam.auth.service.impl;

import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.spring.service.impl.ServiceImpl;
import com.successTeam.auth.mapper.UserMapper;
import com.successTeam.auth.pojo.dto.UserLoginDto;
import com.successTeam.auth.pojo.entity.User;
import com.successTeam.auth.service.UserService;
import com.successTeam.core.exception.BizException;
import com.successTeam.core.pojo.entity.UserRedis;
import com.successTeam.core.result.ResultEnum;
import com.successTeam.core.utils.DigesterUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * program: homemaking
 * ClassName UserServiceImpl
 * description:
 * author: xhonell
 * create: 2025年03月25日14时32分
 * Version 1.0
 **/
@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    private RedisTemplate<String,UserRedis> redisTemplate;
    private static final String CACHE_USER_TOKEN = "cache:user:login:";
    private static final Long CACHE_EXPIRE = 60 * 60 * 2L;
    /**
     * 用户登录
     * @param userLoginDto 账号密码
     * @return token
     */
    @Override
    public String login(UserLoginDto userLoginDto) {
        // 根据手机号查询用户信息
        QueryWrapper queryWrapper = QueryWrapper.create().from(User.class);
        queryWrapper.where(User::getUserPhone).eq(userLoginDto.getUserPhone());
        User user = getMapper().selectOneByQuery(queryWrapper);
        // 判断用户是否存在
        if (user == null)
            throw new BizException(ResultEnum.PHONE_PASSWORD_ERROR);
        // 生成密码判断是否正确
        String password = DigesterUtils.digesterPassword(userLoginDto.getUserPassword(), user.getSalt());
        // 判断密码是否正确
        if (!password.equals(user.getUserPassword()))
            throw new BizException(ResultEnum.PHONE_PASSWORD_ERROR);
        // 存储登录信息
        String token = UUID.randomUUID().toString().replaceAll("-", "");
        UserRedis userRedis = new UserRedis();
        BeanUtils.copyProperties(user, userRedis);
        BoundValueOperations<String, UserRedis> stringUserRedisBoundValueOperations = redisTemplate.boundValueOps(CACHE_USER_TOKEN + token);
        stringUserRedisBoundValueOperations.set(userRedis);
        stringUserRedisBoundValueOperations.expire(CACHE_EXPIRE, TimeUnit.MINUTES);
        return token;
    }

    /**
     * 根据token获取信息
     * @param token token
     * @return 个人信息
     */
    @Override
    public UserRedis findUserByToken(String token) {
        UserRedis userRedis = redisTemplate.boundValueOps(CACHE_USER_TOKEN + token).get();
        if (userRedis == null)
            throw new BizException(ResultEnum.USER_NOT_LOGIN);
        log.info("用户{}正在获取信息",userRedis.getUserId());
        return userRedis;
    }

}
