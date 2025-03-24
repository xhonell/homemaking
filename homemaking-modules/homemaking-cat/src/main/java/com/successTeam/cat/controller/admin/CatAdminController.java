package com.successTeam.cat.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mybatisflex.core.update.UpdateWrapper;
import com.successTeam.cat.pojo.dto.CatInsertDto;
import com.successTeam.cat.pojo.dto.CatQueryDto;
import com.successTeam.cat.pojo.dto.CatUpdateDto;
import com.successTeam.cat.pojo.entity.Cat;
import com.successTeam.cat.pojo.vo.CatQueryVo;
import com.successTeam.cat.service.CatService;
import com.successTeam.core.pojo.dto.PageQueryDto;
import com.successTeam.core.result.Result;
import com.successTeam.core.utils.ValidateUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * program: homemaking
 * ClassName CatController
 * description: 向用户端提供的宠物分类接口
 * author: xhonell
 * create: 2025年03月23日15时58分
 * Version 1.0
 **/
@RestController
@RequestMapping("/admin-api/cat")
@Api(tags = "管理端宠物相关的接口")
public class CatAdminController {

    @Autowired
    private CatService catService;

    @ApiOperation("分页查询宠物列表")
    @PostMapping("/findCatByPage")
    public Result findCatByPage(@RequestBody CatQueryDto catQueryDto) {
        PageHelper.startPage(catQueryDto.getPage(),catQueryDto.getLimit());
        List<CatQueryVo> catByPage = catService.findCatByPage(catQueryDto);
        PageInfo<CatQueryVo> pageInfo = new PageInfo<>(catByPage);
        return Result.buildSuccess(pageInfo.getTotal(),pageInfo.getList());
    }

    /**
     * 新增宠物
     * @param catInsertDto 接收的参数
     * @param bindingResult 效验的错误消息
     * @return 响应体
     */
    @ApiOperation("新增宠物")
    @PostMapping("/insertCat")
    public Result insertCat(@RequestBody @Validated CatInsertDto catInsertDto, BindingResult bindingResult) {
        // 获取第一个效验错误
        ValidateUtils.getAllErrorMsg(bindingResult);
        Cat cat = new Cat();
        BeanUtils.copyProperties(catInsertDto, cat);
        cat.setCreated(new Date());
        boolean isSuccess = catService.save(cat);
        return Result.judge(isSuccess);
    }

    /**
     * 修改宠物
     * @param catUpdateDto 接收的参数
     * @param bindingResult 效验的错误信息
     * @return 响应体
     */
    @ApiOperation("修改宠物")
    @PostMapping("/updateCat")
    public Result updateCat(@RequestBody @Validated CatUpdateDto catUpdateDto, BindingResult bindingResult) {
        ValidateUtils.getFirstErrorMsg(bindingResult);
        Cat cat = new Cat();
        BeanUtils.copyProperties(catUpdateDto, cat);
        cat.setUpdated(new Date());
        boolean isSuccess = catService.updateById(cat);
        return Result.judge(isSuccess);
    }

    /**
     * 删除宠物
     * @param catId 宠物编号
     * @return 响应体
     */
    @ApiOperation("删除宠物")
    @DeleteMapping("deleteCat/{catId}")
    public Result deleteCat(@PathVariable Long catId){
        boolean isSuccess = catService.removeById(catId);
        return Result.judge(isSuccess);
    }
}
