package com.successTeam.employee.controller.admin;

import com.successTeam.core.result.Result;
import com.successTeam.employee.pojo.dto.AuditDto;
import com.successTeam.employee.service.AuditService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * com.successTeam.employee.controller.admin
 * User: hdh
 * Date: 2025/03/27 19:25
 * motto:   百折不挠
 * Description:
 * Version: V1.0
 */
@RestController
@RequestMapping("/admin-api/audit")
@Api(tags = "员工档案审核接口")
public class AuditAdminController {
    @Autowired
    private AuditService auditService;

    @PostMapping("/updateAudit")
    @ApiOperation("员工档案审核")
    public Result AuditAdminController(AuditDto auditDto) {

        auditService.updateAudit(auditDto);
        return Result.buildSuccess();

    }


}
