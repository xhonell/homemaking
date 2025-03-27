package com.successTeam.appraise.controller.admin;

import cn.hutool.core.date.DateTime;
import com.successTeam.appraise.pojo.entity.Appraise;
import com.successTeam.appraise.pojo.vo.AppraiseList;
import com.successTeam.appraise.service.AppraiseService;
import com.successTeam.core.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * User: zhongjing
 * Date: 2025/3/27
 * Description:
 * Version: V1.0
 */
@RestController
@RequestMapping("/admin-api/appraise")
@Api(tags = "管理端评价相关接口")
public class AppraiseAdminController {

    @Autowired
    private AppraiseService appraiseService;

    @PostMapping("/updateAppraise")
    @ApiOperation("回复用户评价")
    public Result updateAppraise(@RequestBody Appraise appraise){
        appraise.setReplyTime(new DateTime());
        appraiseService.updateById(appraise);
        return Result.buildSuccess();
    }

    @GetMapping("/findAppraiseByNanny")
    @ApiOperation("查询月嫂的所有评价")
    public Result findAppraiseByNanny(@RequestParam Long nannyId){
        List<AppraiseList> appraiseList=appraiseService.findAppraiseByNanny(nannyId);
        return Result.buildSuccess(appraiseList);
    }

    @GetMapping("/findAppraiseByClean")
    @ApiOperation("查询保洁的所有评价")
    public Result findAppraiseByClean(){
        List<AppraiseList> appraiseList=appraiseService.findAppraiseByClean();
        return Result.buildSuccess(appraiseList);
    }

    @GetMapping("/findAppraiseByCat")
    @ApiOperation("查询宠物的所有评价")
    public Result findAppraiseByCat(){
        List<AppraiseList> appraiseList=appraiseService.findAppraiseByCat();
        return Result.buildSuccess(appraiseList);
    }

    @GetMapping("/findAppraiseByMove")
    @ApiOperation("查询搬家的所有评价")
    public Result findAppraiseByMove(){
        List<AppraiseList> appraiseList=appraiseService.findAppraiseByMove();
        return Result.buildSuccess(appraiseList);
    }

    @GetMapping("/findAppraiseByRepair")
    @ApiOperation("查询维修的所有评价")
    public Result findAppraiseByRepair(){
        List<AppraiseList> appraiseList=appraiseService.findAppraiseByRepair();
        return Result.buildSuccess(appraiseList);
    }

}
