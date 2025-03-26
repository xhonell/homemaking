package com.successTeam.nanny.pojo.dto;

import com.mybatisflex.annotation.Column;
import com.successTeam.core.pojo.dto.PageQueryDto;
import lombok.Data;

import java.util.Date;

/**
 * com.successTeam.nanny.pojo.dto
 * User: hdh
 * Date: 2025/03/25 14:36
 * motto:   百折不挠
 * Description:
 * Version: V1.0
 */
@Data
public class NannyDto extends PageQueryDto {
    private String name;
    private String type;
    private String grade;

    private String phone;
    private String sex;
    @Column("employee_experience_time")
    private String employeeExperienceTime;
    @Column("employee_experience")
    private String employeeExperience;

}
