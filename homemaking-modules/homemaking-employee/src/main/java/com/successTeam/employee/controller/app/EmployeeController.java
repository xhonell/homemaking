package com.successTeam.employee.controller.app;


import com.successTeam.core.result.Result;
import com.successTeam.employee.pojo.dto.EmployeeDto;
import com.successTeam.employee.pojo.dto.EmployeeRegisterDto;
import com.successTeam.employee.pojo.entity.Employee;
import com.successTeam.employee.service.EmployeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

    @PostMapping("/findByRegisterDto")
    @ApiOperation("根据注册信息查询员工")
    public Object findByRegisterDto(EmployeeRegisterDto employeeRegisterDto) {
        return employeeService.findByRegisterDto(employeeRegisterDto);
    }

    @PostMapping("/addEmployee")
    @ApiOperation("添加员工")
    public Result addEmployee(EmployeeDto employeeDto) {
        employeeService.addEmployee(employeeDto);
        return Result.buildSuccess();
    }

    @PostMapping("/addEmployeeDetail")
    @ApiOperation("员工申请注册档案")
    public Result addEmployeeDetail(EmployeeRegisterDto employeeRegisterDto) {
        employeeService.addEmployeeDetail(employeeRegisterDto);
        return Result.buildSuccess();
    }
}
