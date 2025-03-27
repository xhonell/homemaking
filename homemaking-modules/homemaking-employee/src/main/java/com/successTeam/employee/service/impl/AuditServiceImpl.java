package com.successTeam.employee.service.impl;

import com.mybatisflex.spring.service.impl.ServiceImpl;
import com.successTeam.employee.mapper.AuditMapper;
import com.successTeam.employee.pojo.dto.AuditDto;
import com.successTeam.employee.pojo.entity.Audit;
import com.successTeam.employee.service.AuditService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * com.successTeam.employee.service.impl
 * User: hdh
 * Date: 2025/03/27 16:44
 * motto:   百折不挠
 * Description:
 * Version: V1.0
 */
@Service
@Slf4j
public class AuditServiceImpl extends ServiceImpl<AuditMapper, Audit> implements AuditService {
    @Override
    public void updateAudit(AuditDto auditDto) {
        this.getMapper().updateAudit(auditDto);
    }
}
