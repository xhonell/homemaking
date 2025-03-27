package com.successTeam.employee.pojo.dto;

import com.successTeam.core.pojo.dto.PageQueryDto;
import lombok.Data;

/**
 * com.successTeam.employee.pojo.dto
 * User: hdh
 * Date: 2025/03/26 19:50
 * motto:   百折不挠
 * Description:
 * Version: V1.0
 */
@Data
public class EmployeeDto extends PageQueryDto {
    private String employeeName;

    private String password;

    private String employeeType;
    private String employeeGrade;

    private String employeePhone;
    private String employeeSex;
    private String employeeExperienceTime;
    private String employeeExperience;
}
