package com.successTeam.move.controller.admin;

import com.successTeam.core.result.Result;
import com.successTeam.move.pojo.entity.Floor;
import com.successTeam.move.service.FloorService;
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
@RequestMapping("/admin-api/floor")
@Api(tags = "管理端楼层相关接口")
public class FloorAdminController {

    @Autowired
    private FloorService floorService;

    @PostMapping("/addFloor")
    @ApiOperation("添加楼层类型")
    public Result addFloor(@RequestBody Floor floor){
        floorService.save(floor);
        return Result.buildSuccess();
    }

    @PostMapping("/updateFloor")
    @ApiOperation("修改楼层类型")
    public Result updateFloor(@RequestBody Floor floor){
        floorService.updateById(floor);
        return Result.buildSuccess();
    }

    @GetMapping("/deleteFloor")
    @ApiOperation("删除楼层类型")
    public Result deleteFloor(@RequestParam Long id){
        floorService.removeById(id);
        return Result.buildSuccess();
    }

}
