package com.successTeam.employee.service;

import com.mybatisflex.core.service.IService;
import com.successTeam.employee.pojo.dto.AuditDto;
import com.successTeam.employee.pojo.entity.Audit;

/**
 * com.successTeam.employee.service.impl
 * User: hdh
 * Date: 2025/03/27 16:41
 * motto:   百折不挠
 * Description:
 * Version: V1.0
 */
public interface AuditService extends IService<Audit> {
    void updateAudit(AuditDto auditDto);
}
