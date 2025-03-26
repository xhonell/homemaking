package com.successTeam.nanny.pojo.dto;

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
public class EmployeeRegisterDto {
    private String employeeName;
    private String password;
    private String employeeType;

    private String employeePhone;
    private String employeeSex;

}
