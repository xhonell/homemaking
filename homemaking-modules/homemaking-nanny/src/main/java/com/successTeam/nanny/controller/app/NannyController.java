package com.successTeam.nanny.controller.app;

import com.successTeam.nanny.pojo.dto.NannyTypeQueryDto;
import com.successTeam.nanny.service.NannyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * com.successTeam.nanny.controller.app
 * User: hdh
 * Date: 2025/03/25 15:18
 * motto:   百折不挠
 * Description:
 * Version: V1.0
 */
@RestController
@RequestMapping("/app-api/nanny")
@Api(tags = "用户端月嫂相关的接口")
public class NannyController {
    @Autowired
    private NannyService nannyService;

    @PostMapping("/findNannyByType")
    @ApiOperation("根据类型查询月嫂")
    public Object findNannyByType(NannyTypeQueryDto nannyTypeQueryDto) {
        return nannyService.findNannyByType(nannyTypeQueryDto);
    }
}
