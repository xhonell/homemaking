package com.successTeam.move.controller.admin;

import com.mybatisflex.core.query.QueryWrapper;
import com.successTeam.core.pojo.dto.PageQueryDto;
import com.successTeam.core.result.Result;
import com.successTeam.move.pojo.dto.MoveQueryDto;
import com.successTeam.move.pojo.entity.Move;
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
    @ApiOperation("查询所有搬家行程")
    public Result findAllMove(@RequestBody MoveQueryDto moveQueryDto){
        PageRequest pageRequest = PageRequest.of(moveQueryDto.getPage(), moveQueryDto.getLimit());

        QueryWrapper queryWrapper = QueryWrapper.create(pageRequest).eq(Move::getCarId,moveQueryDto.getCarId())
                .eq(Move::getFloorId,moveQueryDto.getFloorId()).eq(Move::getMoveDistance,moveQueryDto.getMoveDistance())
                .eq(Move::getPersonNumber,moveQueryDto.getPersonNumber());

        List<Move> moveList = moveService.list(queryWrapper);
        return Result.buildSuccess(moveList);
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
