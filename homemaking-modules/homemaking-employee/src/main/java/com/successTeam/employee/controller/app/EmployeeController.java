package com.successTeam.nanny.controller.app;

import com.successTeam.nanny.service.EmployeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * com.successTeam.nanny.controller.app
 * User: hdh
 * Date: 2025/03/25 16:55
 * motto:   百折不挠
 * Description:
 * Version: V1.0
 */
@RestController
@RequestMapping("/app-api/employee")
@Api(tags = "员工档案接口")
public class EmployeeController {
    @Autowired
    public EmployeeService employeeService;

    @GetMapping("/findById")
    @ApiOperation("根据id查询员工")
    public Object findById(Long id) {
        return employeeService.findById(id);
    }
}
