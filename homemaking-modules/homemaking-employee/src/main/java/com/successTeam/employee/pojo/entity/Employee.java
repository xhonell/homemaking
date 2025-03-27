package com.successTeam.employee.pojo.entity;

import com.mybatisflex.annotation.Column;
import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * com.successTeam.nanny.pojo.entity
 * User: hdh
 * Date: 2025/03/24 16:45
 * motto:   百折不挠
 * Description:
 * Version: V1.0
 */
@Data
@Table("tb_employee")
public class Employee implements Serializable {
    @Id(keyType = KeyType.Auto)
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

    private String salt;
    @Column("create_time")
    private Date createTime;
    @Column("update_time")
    private Date updateTime;

}
