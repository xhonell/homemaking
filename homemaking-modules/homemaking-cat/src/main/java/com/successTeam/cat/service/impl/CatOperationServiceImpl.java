package com.successTeam.cat.service.impl;

import com.mybatisflex.spring.service.impl.ServiceImpl;
import com.successTeam.cat.mapper.CatOperationMapper;
import com.successTeam.cat.pojo.entity.CatOperation;
import com.successTeam.cat.service.CatOperationService;
import com.successTeam.redis.service.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * program: homemaking
 * ClassName CatOperationServiceImpl
 * description:
 * author: xhonell
 * create: 2025年03月23日19时36分
 * Version 1.0
 **/
@Service
@Slf4j
public class CatOperationServiceImpl extends ServiceImpl<CatOperationMapper,CatOperation> implements CatOperationService {

    @Autowired
    private RedisService redisService;

    public static final String CACHE_OPERATION = "cache:cat:operation:";
    @Autowired
    private CatOperationMapper catOperationMapper;

    /**
     * 查询所有的操作列表
     * @return 操作列表
     */
    @Override
    public List<CatOperation> findOperationAll() {
        String cacheName = CACHE_OPERATION + "all";
        long expireTime = CatTypeServiceImpl.EXPIRE_TIME + new Random(CatTypeServiceImpl.RANDOM_TIME).nextInt();
        List<CatOperation> catOperations = redisService.getCacheObject(cacheName);
        if (catOperations == null || catOperations.isEmpty()){
            log.info("缓存中未查询到操作列表，即将从数据库中查询");
            catOperations = getMapper().selectAll();
            redisService.setCacheObject(cacheName,catOperations);
            redisService.expire(cacheName,expireTime, TimeUnit.SECONDS);
        }
        return catOperations;
    }

    /**
     * 删除操作列表的缓存
     * @return 状态
     */
    @Override
    public boolean deleteOperationCache() {
        log.info("删除操作列表的缓存");
        return redisService.deleteObject(CACHE_OPERATION + "all");
    }


}
