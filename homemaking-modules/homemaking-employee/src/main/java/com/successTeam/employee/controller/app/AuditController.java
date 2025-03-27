package com.successTeam.employee.controller.app;

import com.successTeam.core.result.Result;
import com.successTeam.employee.pojo.dto.AuditDto;
import com.successTeam.employee.service.AuditService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * com.successTeam.employee.controller.app
 * User: hdh
 * Date: 2025/03/27 16:48
 * motto:   百折不挠
 * Description:
 * Version: V1.0
 */

@RestController
@RequestMapping("/app-api/audit")
@Api(tags = "员工档案审核接口")
public class AuditController {

    @Autowired
    private AuditService auditService;

    @PostMapping("/updateAudit")
    @ApiOperation("员工档案审核")
    public Result updateAudit(AuditDto auditDto) {
        auditService.updateAudit(auditDto);
        return Result.buildSuccess();
    }
}
