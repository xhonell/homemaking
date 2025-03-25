package com.successTeam.nanny.pojo.entity;

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
    private Long id;
    private String name;
    private String password;
    private String type;
    private String grade;

    private String phone;
    private String sex;
    @Column("employee_experience_time")
    private String employeeExperienceTime;
    @Column("employee_experience")
    private String employeeExperience;
    @Column("create_time")
    private Date createTime;
    @Column("update_time")
    private Date updateTime;

}
