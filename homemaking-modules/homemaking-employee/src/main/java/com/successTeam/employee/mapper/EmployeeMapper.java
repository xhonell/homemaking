package com.successTeam.nanny.mapper;

import com.mybatisflex.core.BaseMapper;
import com.successTeam.nanny.pojo.entity.Employee;

/**
 * com.successTeam.nanny.mapper
 * User: hdh
 * Date: 2025/03/25 16:52
 * motto:   百折不挠
 * Description:
 * Version: V1.0
 */
public interface EmployeeMapper extends BaseMapper<Employee>{
    public Employee findById(Long id);
//    public Employee findByPhone(String phone);
}
