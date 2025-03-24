package com.successTeam.cat.controller.admin;

import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.query.QueryWrapper;
import com.successTeam.cat.pojo.dto.TypeQueryDto;
import com.successTeam.cat.pojo.entity.CatType;
import com.successTeam.cat.pojo.vo.CatTypeQueryVo;
import com.successTeam.cat.service.CatTypeService;
import com.successTeam.core.result.Result;
import com.successTeam.core.utils.ValidateUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * program: homemaking
 * ClassName CatTypeController
 * description:
 * author: xhonell
 * create: 2025年03月23日16时26分
 * Version 1.0
 **/
@RestController
@RequestMapping("/admin-api/cat_type")
@Api(tags = "管理端宠物类别相关的接口")
public class CatTypeAdminController {

    @Autowired
    private CatTypeService catTypeService;

    /**
     * 分页查询宠物类型列表
     * @param typeQueryDto 查询条件
     * @param bindingResult 响应的错误信息
     * @return 响应结果
     */
    @PostMapping("/findCatTypeByPage")
    @ApiOperation("分页查询宠物类型列表")
    public Result findCatTypeByPage(@RequestBody @Validated TypeQueryDto typeQueryDto, BindingResult bindingResult){
        ValidateUtils.getFirstErrorMsg(bindingResult);
        Page<CatType> page = Page.of(typeQueryDto.getPage(), typeQueryDto.getLimit());
        QueryWrapper queryWrapper = QueryWrapper.create().from(CatType.class).orderBy(CatType::getCreated).desc();
        if (typeQueryDto.getTypeName() != null && !typeQueryDto.getTypeName().isEmpty())
            queryWrapper.where(CatType::getTypeName).like(typeQueryDto.getTypeName());
        Page<CatType> catTypePage = catTypeService.page(page, queryWrapper);
        List<CatType> catTypes = catTypePage.getRecords();
        List<CatTypeQueryVo> catTypeVos = catTypes.stream().map(this::convertToVo).collect(Collectors.toList());
        return Result.buildSuccess(catTypePage.getTotalRow(), catTypeVos);
    }

    /**
     * 将实体类转为vo
     * @param catType 实体类
     * @return vo
     */
    public CatTypeQueryVo convertToVo(CatType catType){
        CatTypeQueryVo catTypeQueryVo = new CatTypeQueryVo();
        BeanUtils.copyProperties(catType, catTypeQueryVo);
        return catTypeQueryVo;
    }
}
