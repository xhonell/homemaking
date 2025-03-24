package com.successTeam.cat.controller.admin;

import com.successTeam.cat.pojo.dto.PriceInsertDto;
import com.successTeam.cat.pojo.dto.PriceUpdateDto;
import com.successTeam.cat.pojo.entity.CatPrice;
import com.successTeam.cat.service.CatPriceService;
import com.successTeam.core.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * program: homemaking
 * ClassName CatPriceAppController
 * description:
 * author: xhonell
 * create: 2025年03月24日16时40分
 * Version 1.0
 **/
@RestController
@RequestMapping("/admin-api/cat_price")
@Api(tags = "管理端宠物价格的接口")
public class CatPriceAdminController {
    @Autowired
    private CatPriceService catPriceService;

    @ApiOperation("新增宠物价格")
    @PostMapping("/insertCatPrice")
    public Result insertCatPrice(@RequestBody PriceInsertDto priceInsertDto){
        CatPrice catPrice = new CatPrice();
        BeanUtils.copyProperties(priceInsertDto,catPrice);
        catPrice.setCreated(new Date());
        boolean isSuccess = catPriceService.save(catPrice);
        return Result.judge(isSuccess);
    }

    @ApiOperation("修改宠物操作价格")
    @PostMapping("/updateCatPrice")
    public Result updateCatPrice(@RequestBody PriceUpdateDto priceUpdateDto){
        CatPrice catPrice = new CatPrice();
        BeanUtils.copyProperties(priceUpdateDto,catPrice);
        catPrice.setUpdated(new Date());
        boolean isSuccess = catPriceService.updateById(catPrice);
        return Result.judge(isSuccess);
    }
}
