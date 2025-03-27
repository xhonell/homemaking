package com.successTeam.nanny.controller.admin;

import com.successTeam.nanny.pojo.dto.NannyDto;
import com.successTeam.nanny.pojo.dto.NannyTypeQueryDto;
import com.successTeam.nanny.service.NannyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * com.successTeam.nanny.controller.admin
 * User: hdh
 * Date: 2025/03/25 16:22
 * motto:   百折不挠
 * Description:
 * Version: V1.0
 */
@RestController
@RequestMapping("/app-api/admin/nanny")
@Api(tags = "管理端月嫂相关的接口")
public class NannyAdminController {
    @Autowired
    private NannyService nannyService;

    @PostMapping("/findNannyByType")
    @ApiOperation("根据类型查询月嫂")
    public Object findNannyByType(NannyTypeQueryDto nannyTypeQueryDto) {
        return nannyService.findNannyByType(nannyTypeQueryDto);
    }

//    @PostMapping("addNanny")
//    @ApiOperation("添加月嫂")
//    public Object addNanny(NannyDto nannyDto) {
//        return nannyService.addNanny(nannyDto);
//    }

}
