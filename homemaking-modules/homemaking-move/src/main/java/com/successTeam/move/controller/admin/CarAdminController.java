package com.successTeam.move.controller.admin;

import com.successTeam.core.result.Result;
import com.successTeam.move.pojo.entity.Car;
import com.successTeam.move.service.CarService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * User: zhongjing
 * Date: 2025/3/25
 * Description:
 * Version: V1.0
 */
@RestController
@RequestMapping("/admin-api/car")
@Api(tags = "管理端车型相关接口")
public class CarAdminController {

    @Autowired
    private CarService carService;

    @PostMapping("/addCar")
    @ApiOperation("添加车型类型")
    public Result addCar(@RequestBody Car car){
        carService.save(car);
        return Result.buildSuccess();
    }

    @PostMapping("/updateCar")
    @ApiOperation("修改车型类型")
    public Result updateCar(@RequestBody Car car){
        carService.updateById(car);
        return Result.buildSuccess();
    }

    @GetMapping("/deleteCar")
    @ApiOperation("删除车型类型")
    public Result deleteCar(@RequestParam Long id){
        carService.removeById(id);
        return Result.buildSuccess();
    }

}
