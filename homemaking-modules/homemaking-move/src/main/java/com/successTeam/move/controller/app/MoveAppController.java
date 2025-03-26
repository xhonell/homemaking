package com.successTeam.move.controller.app;

import com.successTeam.core.result.Result;
import com.successTeam.move.pojo.dto.MoveAddDto;
import com.successTeam.move.pojo.entity.Move;
import com.successTeam.move.service.MoveService;
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
@RequestMapping("/app-api/move")
@Api(tags = "APP端搬家相关接口")
public class MoveAppController {

    @Autowired
    private MoveService moveService;

    @PostMapping("/addMove")
    @ApiOperation("添加搬家行程")
    public Result addMove(@RequestBody MoveAddDto moveAddDto){
        moveService.addMove(moveAddDto);
        return Result.buildSuccess();
    }

    @PostMapping("/updateMove")
    @ApiOperation("修改搬家行程")
    public Result updateMove(@RequestBody Move move){
        moveService.updateById(move);
        return Result.buildSuccess();
    }

    @GetMapping("/deleteMove")
    @ApiOperation("删除搬家行程")
    public Result deleteMove(@RequestParam Long moveId){
        moveService.removeById(moveId);
        return Result.buildSuccess();
    }

    //TODO 根据用户ID查询用户的搬家行程列表

}
