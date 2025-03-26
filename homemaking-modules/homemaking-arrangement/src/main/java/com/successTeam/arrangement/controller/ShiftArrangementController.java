package com.successTeam.arrangement.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.successTeam.arrangement.pojo.dto.ShiftArrangementQueryDto;
import com.successTeam.arrangement.pojo.vo.ShiftArrangementVo;
import com.successTeam.arrangement.service.ShiftArrangementService;
import com.successTeam.core.result.Result;
import com.successTeam.core.utils.ValidateUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/shift-arrangement")
@Api(tags = "调度管理")
public class ShiftArrangementController {
    @Autowired
    private ShiftArrangementService shiftArrangementService;
    @ApiOperation("/分页查询")
    @PostMapping("find")
    public Result getShiftArrangementAll(@RequestBody  @Validated ShiftArrangementQueryDto shiftArrangementQueryDto, BindingResult bindingResult){
        ValidateUtils.getFirstErrorMsg(bindingResult);
        PageHelper.startPage(shiftArrangementQueryDto.getPage(),shiftArrangementQueryDto.getLimit());
        List<ShiftArrangementVo> shiftArrangementAll = shiftArrangementService.findShiftArrangementAll(shiftArrangementQueryDto);
        PageInfo<ShiftArrangementVo> pageInfo = new PageInfo<>(shiftArrangementAll);
        return Result.buildSuccess(pageInfo.getTotal(),pageInfo.getList());
    }
}
