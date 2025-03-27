package com.successTeam.nanny.service;

import com.mybatisflex.core.service.IService;

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
}
