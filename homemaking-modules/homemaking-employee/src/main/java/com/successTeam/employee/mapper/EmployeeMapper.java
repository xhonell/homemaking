package com.successTeam.employee.mapper;

import com.mybatisflex.core.BaseMapper;
import com.successTeam.employee.pojo.dto.EmployeeDto;
import com.successTeam.employee.pojo.dto.EmployeeRegisterDto;
import com.successTeam.employee.pojo.entity.Employee;
import com.successTeam.employee.pojo.vo.EmployeeRegisterVo;

import java.util.List;

/**
 * com.successTeam.nanny.mapper
 * User: hdh
 * Date: 2025/03/25 16:52
 * motto:   百折不挠
 * Description:
 * Version: V1.0
 */
public interface EmployeeMapper extends BaseMapper<Employee>{
     Employee findById(Long id);
//   Employee findByPhone(String phone);
     List<EmployeeRegisterVo> findByRegisterDto(EmployeeRegisterDto employeeRegisterDto);

     Integer addEmployee(EmployeeDto employeeDto);

     Long addEmployeeDetail(EmployeeRegisterDto employeeRegisterDto);
}
