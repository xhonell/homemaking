package com.successTeam.cat.controller.app;

import com.successTeam.cat.pojo.entity.Cat;
import com.successTeam.cat.service.CatService;
import com.successTeam.core.result.Result;
import com.successTeam.redis.service.RedisService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * program: homemaking
 * ClassName CatController
 * description: 向用户端提供的宠物分类接口
 * author: xhonell
 * create: 2025年03月23日15时58分
 * Version 1.0
 **/
@RestController
@RequestMapping("/app-api/cat")
@Api(tags = "用户端宠物相关的接口")
public class CatAppController {

    @Autowired
    private CatService catService;


    /**
     * 查询指定分类下的所有宠物
     * @param typeId 分类编号
     * @return 待宠物列表的响应消息
     */
    @ApiOperation("查询指定分类下的所有宠物")
    @GetMapping("/findCatByTypeId/{typeId}")
    public Result findCatAll(@PathVariable Long typeId){
        List<Cat> cats = catService.findCatAll(typeId);
        return Result.buildSuccess(cats);
    }

    /**
     * 删除指定类型下的宠物列表缓存
     * @param typeId 类型编号
     * @return 响应消息
     */
    @ApiOperation("删除指定类型下的宠物列表缓存")
    @DeleteMapping("/deleteCatCacheByTypeId/{typeId}")
    public Result deleteCatCacheByTypeId(@PathVariable Long typeId){
        boolean isSuccess = catService.deleteCatCacheByTypeId(typeId);
        return Result.judge(isSuccess);
    }
}
