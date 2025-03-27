package com.successTeam.employee.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.successTeam.core.result.Result;
import com.successTeam.employee.pojo.dto.EmployeeRegisterDto;
import com.successTeam.employee.pojo.entity.Employee;
import com.successTeam.employee.pojo.vo.EmployeeRegisterVo;
import com.successTeam.employee.service.EmployeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * com.successTeam.employee.controller.admin
 * User: hdh
 * Date: 2025/03/25 20:04
 * motto:   百折不挠
 * Description:
 * Version: V1.0
 */
@RequestMapping("/app-api/admin/employee")
@RestController
@Api(tags = "管理端员工相关的接口")
public class EmployeeAdminController {

    @Autowired
    private EmployeeService employeeService;
    @PostMapping(  "/list")
    @ApiOperation("员工列表")
    public Result list(@RequestBody EmployeeRegisterDto employee){
        //1.准备分页条件
        PageHelper.startPage(employee.getPage(),employee.getLimit());

        //2.查询
        List<EmployeeRegisterVo> list = employeeService.findByRegisterDto(employee);

        //3.获取分页结果
        PageInfo<EmployeeRegisterVo> pageInfo = new PageInfo<>(list);

        return Result.buildSuccess(pageInfo.getTotal(),pageInfo.getList());

    }
}
