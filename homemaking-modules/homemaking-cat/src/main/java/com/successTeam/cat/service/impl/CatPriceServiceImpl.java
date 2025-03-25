package com.successTeam.cat.service.impl;

import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.spring.service.impl.ServiceImpl;
import com.successTeam.cat.mapper.CatPriceMapper;
import com.successTeam.cat.pojo.entity.CatPrice;
import com.successTeam.cat.service.CatPriceService;
import com.successTeam.redis.service.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * program: homemaking
 * ClassName CatPriceServiceImpl
 * description:
 * author: xhonell
 * create: 2025年03月24日16时15分
 * Version 1.0
 **/
@Service
@Slf4j
public class CatPriceServiceImpl extends ServiceImpl<CatPriceMapper,CatPrice> implements CatPriceService {

    @Autowired
    private RedisService redisService;

    public static final String CACHE_PRICE_PREFIX= "cache:cat:price:catId:";
    public static final String CACHE_PRICE_SUFFIX = ":operationId:";

    /**
     * 查询指定操作的价格
     * @param catId       宠物编号
     * @param operationId 价格编号
     * @return 价格
     */
    @Override
    public CatPrice findPriceById(Long catId, Long operationId) {
        String cacheName = CACHE_PRICE_PREFIX + catId + CACHE_PRICE_SUFFIX + operationId;
        CatPrice catPrice = redisService.getCacheObject(cacheName);
        if (catPrice==null){
            log.info("数据库未查询到缓存，即将查询数据库");
            QueryWrapper queryWrapper = QueryWrapper.create().from(CatPrice.class);
            queryWrapper.where(CatPrice::getCatId).eq(catId)
                    .where(CatPrice::getOperationId).eq(operationId);
            catPrice = getMapper().selectOneByQuery(queryWrapper);
            redisService.setCacheObject(cacheName,catPrice);
            redisService.expire(cacheName,CatTypeServiceImpl.EXPIRE_TIME, TimeUnit.SECONDS);
        }

        return catPrice;
    }

    /**
     * 删除价格的缓存
     * @param catId 宠物编号
     * @param operationId 操作编号
     * @return 状态
     */
    @Override
    public boolean deleteCatPriceCacheById(Long catId, Long operationId) {
        log.info("删除宠物编号为{}, 操作编号为{}的价格缓存", catId, operationId);
         return redisService.deleteObject(CACHE_PRICE_PREFIX+catId+CACHE_PRICE_SUFFIX+operationId);
    }
}
