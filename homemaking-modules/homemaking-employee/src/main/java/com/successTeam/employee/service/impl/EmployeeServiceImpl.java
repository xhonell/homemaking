package com.successTeam.employee.service.impl;

import com.mybatisflex.spring.service.impl.ServiceImpl;

import com.successTeam.core.result.Result;
import com.successTeam.employee.mapper.AuditMapper;
import com.successTeam.employee.mapper.EmployeeMapper;
import com.successTeam.employee.pojo.dto.EmployeeDto;
import com.successTeam.employee.pojo.dto.EmployeeRegisterDto;
import com.successTeam.employee.pojo.entity.Audit;
import com.successTeam.employee.pojo.entity.Employee;
import com.successTeam.employee.pojo.vo.EmployeeRegisterVo;
import com.successTeam.employee.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * com.successTeam.nanny.service.impl
 * User: hdh
 * Date: 2025/03/25 16:54
 * motto:   百折不挠
 * Description:
 * Version: V1.0
 */
@Service
@Slf4j
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private AuditMapper auditMapper;

    @Override
    public Employee findById(Long id) {
        return getMapper().findById(id);
    }

    @Override
    public List<EmployeeRegisterVo> findByRegisterDto(EmployeeRegisterDto employeeRegisterDto) {
        return employeeMapper.findByRegisterDto(employeeRegisterDto);
    }

    @Override
    public void addEmployee(EmployeeDto employeeDto) {
        Employee employee=new Employee();

        employee.setEmployeeName(employeeDto.getEmployeeName());
        employee.setEmployeeType(employeeDto.getEmployeeType());
        employee.setEmployeeGrade(employeeDto.getEmployeeGrade());
        employee.setEmployeePhone(employeeDto.getEmployeePhone());
        employee.setEmployeeSex(employeeDto.getEmployeeSex());
        employee.setEmployeeExperienceTime(employeeDto.getEmployeeExperienceTime());
        employee.setEmployeeExperience(employeeDto.getEmployeeExperience());
        employee.setPassword(employeeDto.getPassword());

        employeeMapper.insert(employee);

    }



    @Override
    public void addEmployeeDetail(EmployeeRegisterDto employeeRegisterDto) {
        Long employeeDetailId = employeeMapper.addEmployeeDetail(employeeRegisterDto);

        auditMapper.insertAudit(employeeDetailId);
    }
}
