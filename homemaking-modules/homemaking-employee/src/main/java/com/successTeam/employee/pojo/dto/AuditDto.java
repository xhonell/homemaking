package com.successTeam.employee.pojo.dto;

import com.mybatisflex.annotation.Column;
import com.successTeam.core.pojo.dto.PageQueryDto;
import lombok.Data;

import java.util.Date;

/**
 * com.successTeam.employee.pojo.dto
 * User: hdh
 * Date: 2025/03/27 16:43
 * motto:   百折不挠
 * Description:
 * Version: V1.0
 */
@Data
public class AuditDto extends PageQueryDto {

    private Long auditId;
    private String auditStatus;

    private Date auditTime;

    private String rejectReason;
}
