package com.successTeam.cleaning.pojo.entity;

import com.mybatisflex.annotation.Column;
import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import lombok.Data;

import java.util.Date;

@Data
@Table("tb_cleaning_staff")
public class CleaningStaff {
    @Id(keyType = KeyType.Auto)
    @Column("staff_id")
    private Integer staffId;

    @Column("service_id")
    private Integer serviceId;

    @Column("experience_years")
    private Integer experienceYears;

    @Column("skills")
    private String skills;

    @Column("is_available")
    private Boolean isAvailable;

    @Column("created_at")
    private Date createdAt;

    @Column("updated_at")
    private Date updatedAt;

    @Column("employee_id")
    private Long employeeId;
}
