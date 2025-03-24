package com.successTeam.cat.service.impl;

import com.mybatisflex.core.service.IService;
import com.mybatisflex.spring.service.impl.ServiceImpl;
import com.successTeam.cat.mapper.CatMapper;
import com.successTeam.cat.pojo.dto.CatQueryDto;
import com.successTeam.cat.pojo.entity.Cat;
import com.successTeam.cat.pojo.vo.CatQueryVo;
import com.successTeam.cat.service.CatService;
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
 * ClassName CatServiceImpl
 * description:
 * author: xhonell
 * create: 2025年03月23日15时57分
 * Version 1.0
 **/
@Service
@Slf4j
public class CatServiceImpl extends ServiceImpl<CatMapper, Cat> implements CatService {
    @Autowired
    private RedisService redisService;

    @Autowired
    private CatMapper catMapper;

    public static final String CACHE_CAT = "cache:cat:catId:";

    /**
     * 查询指定类型下的宠物
     * @param typeId 类型编号
     * @return 宠物列表
     */
    @Override
    public List<Cat> findCatAll(Long typeId) {
        String cacheName = CACHE_CAT + typeId;
        long expireTime = CatTypeServiceImpl.EXPIRE_TIME + new Random(CatTypeServiceImpl.RANDOM_TIME).nextInt();
        List<Cat> cats = redisService.getCacheObject(cacheName);
        if (cats == null || cats.isEmpty()){
            log.info("缓存中未查询到该编号下的宠物信息，即将查询数据库");
            cats = getMapper().selectAll();
            redisService.setCacheObject(cacheName, cats);
            redisService.expire(cacheName,expireTime, TimeUnit.SECONDS);
        }
        return cats;
    }

    /**
     * 删除指定指定类型下的宠物列表缓存
     * @param typeId 类型编号
     * @return 状态
     */
    @Override
    public boolean deleteCatCacheByTypeId(Long typeId) {
        log.info("删除类型编号为{}的宠物列表", typeId);
        return redisService.deleteObject(CACHE_CAT + typeId);
    }

    /**
     * 分页查询宠物列表
     * @param catQueryDto 查询条件
     * @return 宠物列表
     */
    @Override
    public List<CatQueryVo> findCatByPage(CatQueryDto catQueryDto) {
        return catMapper.findCatByPage(catQueryDto);
    }
}
