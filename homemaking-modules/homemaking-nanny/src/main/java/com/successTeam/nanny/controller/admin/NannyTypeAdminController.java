package com.successTeam.nanny.controller.admin;

import com.successTeam.core.result.Result;
import com.successTeam.nanny.pojo.entity.NannyType;
import com.successTeam.nanny.service.NannyTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * com.successTeam.nanny.controller.admin
 * User: hdh
 * Date: 2025/03/24 19:55
 * motto:   百折不挠
 * Description:
 * Version: V1.0
 */
@RestController
@RequestMapping("/app-api/admin/nanny_type")
@Api(tags = "管理端月嫂类别相关的接口")
public class NannyTypeAdminController {
    @Autowired
    private NannyTypeService nannyTypeService;

    @GetMapping("/findTypeAll")
    @ApiOperation("查询月嫂所有分类")
    public Result getNannyTypeList(){
        List<NannyType> nannyTypeList = nannyTypeService.list();
        return Result.buildSuccess(nannyTypeList);
    }

    @PostMapping("/addNannyType")
    @ApiOperation("添加月嫂类别")
    public Result addNannyType(@RequestBody NannyType nannyType){
        Boolean result = nannyTypeService.save(nannyType);
        //nannyTypeService.addNannyType(nannyType);
        return Result.judge(result);
    }

    @PostMapping("/updateNannyType")
    @ApiOperation("修改月嫂类别")
    public Result updateNannyType(@RequestBody NannyType nannyType){
        Boolean result = nannyTypeService.updateById(nannyType);
        return Result.judge(result);
    }

    @PostMapping("/deleteNannyType")
    @ApiOperation("删除月嫂类别")
    public Result deleteNannyType(@RequestParam Long id){
        Boolean result = nannyTypeService.removeById(id);
        return Result.judge(result);
    }
}
