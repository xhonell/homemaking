package com.successTeam.employee.pojo.entity;

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
@Table("tb_employee_detail")
public class EmployeeDetail implements Serializable {

    @Id(keyType = KeyType.Auto)
    @Column("employee_detail_id")
    private long employeeDetailId;
    @Column("employee_id")
    private long employeeId;

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

    @Column("create_time")
    private java.sql.Timestamp createTime;
    @Column("update_time")
    private java.sql.Timestamp updateTime;
}
