package com.successTeam.nanny.pojo.vo;

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
    private Long employeeId;
    private String employeeName;

    private String employeeType;
    private String employeePhone;
    private String employeeSex;
    private String employeeExperienceTime;
    private String employeeExperience;

}
