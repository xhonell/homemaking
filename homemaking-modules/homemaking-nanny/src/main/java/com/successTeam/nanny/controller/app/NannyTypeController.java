package com.successTeam.nanny.controller.app;

import com.successTeam.core.result.Result;
import com.successTeam.nanny.pojo.entity.NannyType;
import com.successTeam.nanny.service.NannyTypeService;
import com.successTeam.nanny.service.impl.NannyTypeServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * com.successTeam.nanny.controller.app
 * User: hdh
 * Date: 2025/03/24 19:11
 * motto:   百折不挠
 * Description:
 * Version: V1.0
 */
@RestController
@RequestMapping("/app-api/nanny_type")
@Api(tags = "用户端保姆类别相关的接口")
public class NannyTypeController {

    @Autowired
    private NannyTypeService nannyTypeService;

    @GetMapping("/findTypeAll")
    @ApiOperation("查询保姆所有分类")
    public Result getNannyTypeList(){
        List<NannyType> nannyTypeList = nannyTypeService.list();
        return Result.buildSuccess(nannyTypeList);
    }
}
