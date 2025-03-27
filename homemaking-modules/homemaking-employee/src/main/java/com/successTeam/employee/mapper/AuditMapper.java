package com.successTeam.employee.mapper;

import com.mybatisflex.core.BaseMapper;
import com.successTeam.employee.pojo.dto.AuditDto;
import com.successTeam.employee.pojo.entity.Audit;

/**
 * com.successTeam.employee.mapper
 * User: hdh
 * Date: 2025/03/26 20:22
 * motto:   百折不挠
 * Description:
 * Version: V1.0
 */
public interface AuditMapper extends BaseMapper<Audit> {

    void insertAudit(Long employeeDetailId);

    void updateAudit(AuditDto auditDto);

}
