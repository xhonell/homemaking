package com.successTeam.cat.controller.admin;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.query.QueryWrapper;
import com.successTeam.cat.pojo.dto.OperationInsertDto;
import com.successTeam.cat.pojo.dto.OperationQueryDto;
import com.successTeam.cat.pojo.dto.OperationUpdateDto;
import com.successTeam.cat.pojo.entity.Cat;
import com.successTeam.cat.pojo.entity.CatOperation;
import com.successTeam.cat.pojo.vo.CatOperationQueryVo;
import com.successTeam.cat.service.CatOperationService;
import com.successTeam.core.result.Result;
import com.successTeam.core.utils.ValidateUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * program: homemaking
 * ClassName CatOperationController
 * description:
 * author: xhonell
 * create: 2025年03月23日19时37分
 * Version 1.0
 **/
@RestController
@RequestMapping("/admin-api/cat_operation")
@Api(tags = "管理端宠物操作相关的接口")
public class CatOperationAdminController {
    @Autowired
    private CatOperationService catOperationService;

    /**
     * 分页查询宠物操作
     * @param operationQueryDto 查询条件
     * @return 响应体
     */
    @ApiOperation("分页查询宠物操作")
    @PostMapping("/findOperationByPage")
    public Result findOperationByPage(@RequestBody OperationQueryDto  operationQueryDto){
        Page<CatOperation> page = Page.of(operationQueryDto.getPage(), operationQueryDto.getLimit());
        QueryWrapper queryWrapper = QueryWrapper.create().select().from(CatOperation.class).orderBy(CatOperation::getCreated).desc();
        if (operationQueryDto.getOperationName() != null && !operationQueryDto.getOperationName().isEmpty())
            queryWrapper.where(CatOperation::getOperationName).like(operationQueryDto.getOperationName());
        Page<CatOperation> catOperationPage = catOperationService.page(page, queryWrapper);
        List<CatOperation> catOperations = catOperationPage.getRecords();
        List<CatOperationQueryVo> collect = catOperations.stream().map(this::convertToVo).collect(Collectors.toList());
        return Result.buildSuccess(catOperationPage.getTotalRow(), collect);
    }

    /**
     * 将实体类转化为vo
     * @param catOperation 转化的实体
     * @return 转化的结果
     */
    private CatOperationQueryVo convertToVo(CatOperation catOperation){
        CatOperationQueryVo catOperationQueryVo = new CatOperationQueryVo();
        BeanUtils.copyProperties(catOperation,catOperationQueryVo);
        return catOperationQueryVo;
    }

    /**
     * 新增宠物操作
     * @param operationInsertDto 新增的条件
     * @return 响应体
     */
    @ApiOperation(("新增宠物操作"))
    @PostMapping("/insertCatOperation")
    public Result insertCatOperation(@RequestBody @Validated OperationInsertDto operationInsertDto, BindingResult bindingResult){
        ValidateUtils.getFirstErrorMsg(bindingResult);
        CatOperation catOperation = new CatOperation();
        BeanUtils.copyProperties(operationInsertDto,catOperation);
        catOperation.setCreated(new Date());
        boolean isSuccess = catOperationService.save(catOperation);
        return Result.judge(isSuccess);
    }

    /**
     * 修改宠物操作
     * @param operationUpdateDto 修改条件
     * @param bindingResult 效验的错误消息
     * @return 响应体
     */
    @ApiOperation("修改操作名称")
    @PostMapping("/updateCatOperation")
    public Result updateCatOperation(@RequestBody @Valid OperationUpdateDto operationUpdateDto, BindingResult bindingResult){
        ValidateUtils.getFirstErrorMsg(bindingResult);
        CatOperation catOperation = new CatOperation();
        BeanUtils.copyProperties(operationUpdateDto,catOperation);
        catOperation.setUpdated(new Date());
        boolean isSuccess = catOperationService.updateById(catOperation);
        return Result.judge(isSuccess);
    }

    /**
     * 删除宠物操作
     * @param operationId 操作编号
     * @return 响应体
     */
    @ApiOperation(("删除操作"))
    @DeleteMapping("/deleteCatOperationById/{operationId}")
    public Result deleteCatOperationById(@PathVariable Long operationId){
        boolean isSuccess = catOperationService.removeById(operationId);
        return Result.judge(isSuccess);
    }
}
