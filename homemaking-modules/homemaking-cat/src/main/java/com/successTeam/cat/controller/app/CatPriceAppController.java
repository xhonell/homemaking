package com.successTeam.cat.controller.app;

import com.successTeam.cat.pojo.entity.CatPrice;
import com.successTeam.cat.service.CatPriceService;
import com.successTeam.core.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * program: homemaking
 * ClassName CatPriceAppController
 * description:
 * author: xhonell
 * create: 2025年03月24日16时40分
 * Version 1.0
 **/
@RestController
@RequestMapping("/app-api/cat_price")
@Api(tags = "用户端宠物价格的接口")
public class CatPriceAppController {
    @Autowired
    private CatPriceService catPriceService;

    /**
     * 查询宠物指定操作的价格
     * @param catId 宠物编号
     * @param operationId 操作编号
     * @return 响应体
     */
    @ApiOperation("查询宠物指定操作的价格")
    @PostMapping("/findPriceById/{catId}/{operationId}")
    public Result findPriceById(@PathVariable Long catId, Long operationId) {
        CatPrice catPrice = catPriceService.findPriceById(catId, operationId);
        return Result.buildSuccess(catPrice);
    }

    /**
     * 删除宠物价格的缓存
     * @param catId 宠物编号
     * @param operationId 操作编号
     * @return 相应体
     */
    @ApiOperation("删除用户缓存的接口")
    @DeleteMapping("/deleteCatPriceCacheById/{catId}/{operationId")
    public Result deleteCatPriceCacheById(@PathVariable Long catId,Long operationId){
        boolean isSuccess = catPriceService.deleteCatPriceCacheById(catId, operationId);
        return Result.buildSuccess(isSuccess);
    }

}
