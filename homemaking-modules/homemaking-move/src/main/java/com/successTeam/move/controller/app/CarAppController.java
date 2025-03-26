package com.successTeam.move.controller.app;

import com.successTeam.core.result.Result;
import com.successTeam.move.pojo.entity.Car;
import com.successTeam.move.service.CarService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * User: zhongjing
 * Date: 2025/3/25
 * Description:
 * Version: V1.0
 */
@RestController
@RequestMapping("/app-api/car")
@Api(tags = "APP端车型相关接口")
public class CarAppController {

    @Autowired
    private CarService carService;

    @PostMapping("/findAllCar")
    @ApiOperation("查询所有车型")
    public Result findAllCar(){
        List<Car> carList = carService.list();
        return Result.buildSuccess(carList);
    }

}
