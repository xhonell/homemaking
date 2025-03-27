package com.successTeam.employee.service;

import com.mybatisflex.core.service.IService;
import com.successTeam.core.result.Result;
import com.successTeam.employee.pojo.dto.EmployeeDto;
import com.successTeam.employee.pojo.dto.EmployeeRegisterDto;
import com.successTeam.employee.pojo.entity.Employee;
import com.successTeam.employee.pojo.vo.EmployeeRegisterVo;

import java.util.List;


/**
 * com.successTeam.nanny.service
 * User: hdh
 * Date: 2025/03/25 16:53
 * motto:   百折不挠
 * Description:
 * Version: V1.0
 */
public interface EmployeeService extends IService<Employee> {
    Employee findById(Long id);

    List<EmployeeRegisterVo> findByRegisterDto(EmployeeRegisterDto employeeRegisterDto);

    void addEmployee(EmployeeDto employeeDto);

    void addEmployeeDetail(EmployeeRegisterDto employeeRegisterDto);
}
