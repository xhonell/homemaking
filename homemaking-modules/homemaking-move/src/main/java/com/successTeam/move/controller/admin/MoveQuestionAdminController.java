package com.successTeam.move.controller.admin;

import com.successTeam.core.result.Result;
import com.successTeam.move.pojo.entity.MoveQuestion;
import com.successTeam.move.service.MoveQuestionService;
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
@RequestMapping("/admin-api/move-question")
@Api(tags = "管理端搬家问题相关接口")
public class MoveQuestionAdminController {

    @Autowired
    private MoveQuestionService moveQuestionService;

    @PostMapping("/addMoveQuestion")
    @ApiOperation("添加搬家问题")
    public Result addMoveQuestion(@RequestBody MoveQuestion moveQuestion){
        moveQuestionService.save(moveQuestion);
        return Result.buildSuccess();
    }

    @PostMapping("/updateMoveQuestion")
    @ApiOperation("修改搬家问题")
    public Result updateMoveQuestion(@RequestBody MoveQuestion moveQuestion){
        moveQuestionService.updateById(moveQuestion);
        return Result.buildSuccess();
    }

    @GetMapping("/deleteMoveQuestion")
    @ApiOperation("删除搬家问题")
    public Result deleteMoveQuestion(@RequestParam Long id){
        moveQuestionService.removeById(id);
        return Result.buildSuccess();
    }

}
