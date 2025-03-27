package com.successTeam.move.controller.app;

import com.successTeam.core.result.Result;
import com.successTeam.move.pojo.entity.Car;
import com.successTeam.move.pojo.entity.MoveQuestion;
import com.successTeam.move.service.CarService;
import com.successTeam.move.service.MoveQuestionService;
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
@RequestMapping("/app-api/move-question")
@Api(tags = "APP端搬家问题相关接口")
public class MoveQuestionAppController {

    @Autowired
    private MoveQuestionService moveQuestionService;

    @PostMapping("/findAllMoveQuestion")
    @ApiOperation("查询所有搬家问题")
    public Result findAllMoveQuestion(){
        List<MoveQuestion> moveQuestionList= moveQuestionService.list();
        return Result.buildSuccess(moveQuestionList);
    }

}
