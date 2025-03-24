package com.successTeam.cat.service.impl;

import com.mybatisflex.spring.service.impl.ServiceImpl;
import com.successTeam.cat.mapper.CatTypeMapper;
import com.successTeam.cat.pojo.entity.CatType;
import com.successTeam.cat.service.CatTypeService;
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
 * ClassName CatTypeServiceImpl
 * description:
 * author: xhonell
 * create: 2025年03月23日16时25分
 * Version 1.0
 **/
@Service
@Slf4j
public class CatTypeServiceImpl extends ServiceImpl<CatTypeMapper, CatType> implements CatTypeService {
    @Autowired
    private RedisService redisService;

    public static final String CAT_TYPE_ALL = "cache:cat:type:";

    public static final Long EXPIRE_TIME = 24*60*60L;

    public static final Integer RANDOM_TIME = 2*60*60;

    /**
     * 查询所有的宠物分类列表
     * @return 宠物分类列表
     */
    @Override
    public List<CatType> findTypeAll() {
        // 从缓存中获取宠物分类
        List<CatType> catTypes = redisService.getCacheObject(CAT_TYPE_ALL + "all");
        String cacheName = CAT_TYPE_ALL + "all";
        long expireTime = EXPIRE_TIME + new Random().nextInt(RANDOM_TIME);
        if(catTypes == null || catTypes.isEmpty()){
            log.info("缓存中未查询到分类列表，即将访问数据库");
            catTypes = getMapper().selectAll();
            redisService.setCacheObject(cacheName,catTypes);
            redisService.expire(cacheName,expireTime, TimeUnit.SECONDS);
        }
        return catTypes;
    }

    /**
     * 删除宠物分类的缓存
     * @return 删除状态
     */
    @Override
    public boolean deleteCatTypeCache() {
        log.info("删除所有宠物分类信息");
        return redisService.deleteObject(CAT_TYPE_ALL + "all");
    }


}
