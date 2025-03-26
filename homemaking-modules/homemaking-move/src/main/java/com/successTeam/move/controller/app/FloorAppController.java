package com.successTeam.move.controller.app;

import com.successTeam.core.result.Result;
import com.successTeam.move.pojo.entity.Floor;
import com.successTeam.move.service.FloorService;
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
@RequestMapping("/app-api/floor")
@Api(tags = "APP端楼层相关接口")
public class FloorAppController {

    @Autowired
    private FloorService floorService;

    @PostMapping("/findAllFloor")
    @ApiOperation("查询所有楼层")
    public Result findAllFloor(){
        List<Floor> floorList = floorService.list();
        return Result.buildSuccess(floorList);
    }

}
