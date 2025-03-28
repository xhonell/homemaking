package com.successTeam.employee.pojo.vo;

import com.mybatisflex.annotation.Column;
import lombok.Data;

/**
 * com.successTeam.nanny.pojo.vo
 * User: hdh
 * Date: 2025/03/25 19:13
 * motto:   百折不挠
 * Description:
 * Version: V1.0
 */
@Data
public class EmployeeRegisterVo {

    @Column("employee_id")
    private Long employeeId;
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
