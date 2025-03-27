package com.successTeam.nanny.pojo.entity;

import com.mybatisflex.annotation.Column;
import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import lombok.Data;

import java.io.Serializable;

/**
 * com.successTeam.nanny.pojo.entity
 * User: hdh
 * Date: 2025/03/25 15:04
 * motto:   百折不挠
 * Description:
 * Version: V1.0
 */
@Data
@Table("tb_nanny")
public class Nanny implements Serializable {
    @Id(keyType = KeyType.Auto)
    @Column("nanny_id")
    private long nannyId;
    @Column("nanny_name")
    private String nannyName;
    @Column("nanny_age")
    private String nannyAge;
    private String type;
    @Column("employee_experience_time")
    private String employeeExperienceTime;
}
