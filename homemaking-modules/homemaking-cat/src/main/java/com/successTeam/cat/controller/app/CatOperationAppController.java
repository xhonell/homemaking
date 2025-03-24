package com.successTeam.cat.controller.app;

import com.successTeam.cat.pojo.entity.CatOperation;
import com.successTeam.cat.service.CatOperationService;
import com.successTeam.core.result.Result;
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
 * ClassName CatOperationController
 * description:
 * author: xhonell
 * create: 2025年03月23日19时37分
 * Version 1.0
 **/
@RestController
@RequestMapping("/app-api/cat_operation")
@Api(tags = "用户端宠物操作相关的接口")
public class CatOperationAppController {
    @Autowired
    private CatOperationService catOperationService;


    /**
     * 查询所有的操作
     * @return 待操作列表的响应体
     */
    @GetMapping("/findOperationAll")
    @ApiOperation("查询所有的操作")
    public Result findOperationAll(){
        List<CatOperation> operationAll = catOperationService.findOperationAll();
        return Result.buildSuccess(operationAll);
    }

    @DeleteMapping("/deleteOperationCache")
    @ApiOperation("删除操作列表的缓存")
    public Result deleteOperationCache(){
        boolean isSuccess = catOperationService.deleteOperationCache();
        return  Result.judge(isSuccess);
    }
}
