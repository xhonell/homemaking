package com.successTeam.employee.pojo.dto;

import com.mybatisflex.annotation.Column;
import com.successTeam.core.pojo.dto.PageQueryDto;
import lombok.Data;

/**
 * com.successTeam.nanny.pojo.dto
 * User: hdh
 * Date: 2025/03/25 19:12
 * motto:   百折不挠
 * Description:
 * Version: V1.0
 */
@Data
public class EmployeeRegisterDto extends PageQueryDto {

    @Column("employee_id")
    private Long employeeId;
    @Column("employee_detail_id")
    private Long employeeDetailId;
    @Column("employee_address")
    private String employeeAddress;
    @Column("employee_clans")
    private String employeeClans;
    @Column("employee_diploma")
    private String employeeDiploma;
    @Column("employee_constellation")
    private String employeeConstellation;
    @Column("employee_description")
    private String employeeDescription;
    @Column("employee_certificate")
    private String employeeCertificate;
    @Column("employee_appraise")
    private String employeeAppraise;


}
