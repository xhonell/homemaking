package com.successTeam.cat.service;

import com.mybatisflex.core.service.IService;
import com.successTeam.cat.pojo.entity.CatPrice;

/**
 * program: homemaking
 * ClassName CatPriceService
 * description:
 * author: xhonell
 * create: 2025年03月24日16时14分
 * Version 1.0
 **/
public interface CatPriceService extends IService<CatPrice> {

    /*查询指定操作的价格*/
    CatPrice findPriceById(Long catId, Long operationId);

    /*删除指定价格的缓存*/
    boolean deleteCatPriceCacheById(Long catId,Long operationId);
}
