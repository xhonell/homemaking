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
 * Date: 2025/03/24 16:43
 * motto:   百折不挠
 * Description:
 * Version: V1.0
 */
@Data
@Table("nanny_detail")
public class NannyDetail implements Serializable {
    @Id(keyType = KeyType.Auto)
    @Column("nanny_id")
    private long nannyId;
    @Column("nanny_age")
    private String nannyAge;
    @Column("nanny_address")
    private String nannyAddress;
    @Column("nanny_clans")
    private String nannyClans;
    @Column("nanny_diploma")
    private String nannyDiploma;
    @Column("nanny_constellation")
    private String nannyConstellation;
    @Column("nanny_description")
    private String nannyDescription;
    @Column("nanny_certificate")
    private String nannyCertificate;
    @Column("nanny_appraise")
    private String nannyAppraise;
    @Column("nanny_employee_experience")
    private String nannyEmployeeExperience;
    @Column("create_time")
    private java.sql.Timestamp createTime;
    @Column("update_time")
    private java.sql.Timestamp updateTime;
}
