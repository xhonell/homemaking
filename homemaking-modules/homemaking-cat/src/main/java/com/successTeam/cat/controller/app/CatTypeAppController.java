package com.successTeam.cat.controller.app;

import com.successTeam.cat.pojo.entity.Cat;
import com.successTeam.cat.pojo.entity.CatType;
import com.successTeam.cat.service.CatTypeService;
import com.successTeam.core.result.Result;
import com.successTeam.redis.service.RedisService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * program: homemaking
 * ClassName CatTypeController
 * description:
 * author: xhonell
 * create: 2025年03月23日16时26分
 * Version 1.0
 **/
@RestController
@RequestMapping("/app-api/cat_type")
@Api(tags = "用户端宠物类别相关的接口")
public class CatTypeAppController {

    @Autowired
    private CatTypeService catTypeService;

    /**
     * 查询所有的宠物分类
     * @return 待宠物列表的响应消息
     */
    @ApiOperation("查询宠物所有分类")
    @GetMapping("/findTypeAll")
    public Result findTypeAll(){
        List<CatType> catTypes = catTypeService.findTypeAll();
        return Result.buildSuccess(catTypes);
    }

    /**
     * 删除所有的分类缓存
     * @return 响应消息
     */
    @ApiOperation("删除分类列表缓存")
    @DeleteMapping("/deleteCatTypeCache")
    public  Result deleteCatTypeCache(){
        boolean isSuccess = catTypeService.deleteCatTypeCache();
        return Result.judge(isSuccess);
    }
}
