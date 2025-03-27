package com.successTeam.move.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mybatisflex.core.query.QueryWrapper;
import com.successTeam.core.pojo.dto.PageQueryDto;
import com.successTeam.core.result.Result;
import com.successTeam.move.pojo.dto.MoveQueryDto;
import com.successTeam.move.pojo.entity.Move;
import com.successTeam.move.pojo.vo.MoveList;
import com.successTeam.move.service.MoveService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * User: zhongjing
 * Date: 2025/3/26
 * Description:
 * Version: V1.0
 */
@RestController
@RequestMapping("/admin-api/move")
@Api(tags = "管理端搬家相关接口")
public class MoveAdminController {

    @Autowired
    private MoveService moveService;

    @GetMapping("/findAllMove")
    @ApiOperation("根据查询条件查询搬家行程")
    public Result findAllMove(@RequestBody MoveQueryDto moveQueryDto){
        PageHelper.startPage(moveQueryDto.getPage(),moveQueryDto.getLimit());

        List<MoveList> moveList=moveService.findAllMove(moveQueryDto);

        PageInfo<MoveList> moveListPageInfo = new PageInfo<>(moveList);
        return Result.buildSuccess(moveListPageInfo.getTotal(),moveListPageInfo);
    }

    @GetMapping("/findAllMoveDistance")
    @ApiOperation("查询所有里程数列表")
    public Result findAllMoveDistance(){
        List<Double> moveDistanceList = moveService.findAllMoveDistance();
        return Result.buildSuccess(moveDistanceList);
    }

    @GetMapping("/findAllPersonNumber")
    @ApiOperation("查询所有搬家额外人数列表")
    public Result findAllPersonNumber(){
        List<Integer> personNumberList = moveService.findAllPersonNumber();
        return Result.buildSuccess(personNumberList);
    }

}
