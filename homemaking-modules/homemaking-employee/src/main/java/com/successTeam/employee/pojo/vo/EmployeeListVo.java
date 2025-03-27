package com.successTeam.employee.pojo.vo;

import com.mybatisflex.annotation.Column;
import lombok.Data;

/**
 * com.successTeam.nanny.pojo.vo
 * User: hdh
 * Date: 2025/03/25 17:02
 * motto:   百折不挠
 * Description:
 * Version: V1.0
 */
@Data
public class EmployeeListVo {

    @Column("employee_id")
    private Long employeeId;
    @Column("employee_name")
    private String employeeName;
    private String password;
    @Column("employee_type")
    private String employeeType;
    @Column("employee_grade")
    private String employeeGrade;

    @Column("employee_phone")
    private String employeePhone;
    @Column("employee_sex")
    private String employeeSex;

    @Column("employee_experience_time")
    private String employeeExperienceTime;
    @Column("employee_experience")
    private String employeeExperience;

}
