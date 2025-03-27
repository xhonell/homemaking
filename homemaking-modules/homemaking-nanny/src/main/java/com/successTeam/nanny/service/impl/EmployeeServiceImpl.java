package com.successTeam.nanny.service.impl;

import com.mybatisflex.spring.service.impl.ServiceImpl;
import com.successTeam.nanny.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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
    @Override
    public Employee findById(Long id) {
        return getMapper().findById(id);
    }
}
