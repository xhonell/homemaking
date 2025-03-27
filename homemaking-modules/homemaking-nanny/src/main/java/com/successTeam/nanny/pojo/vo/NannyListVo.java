package com.successTeam.nanny.pojo.vo;

import com.mybatisflex.annotation.Column;
import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import lombok.Data;

/**
 * com.successTeam.nanny.pojo.vo
 * User: hdh
 * Date: 2025/03/25 16:36
 * motto:   百折不挠
 * Description:
 * Version: V1.0
 */
@Data
public class NannyListVo {

    @Column("nanny_id")
    private long nannyId;
    @Column("nanny_name")
    private String nannyName;
    @Column("nanny_age")
    private String nannyAge;
    private String type;
    @Column("employee_experience_time")
    private String employeeExperienceTime;
    @Column("nanny_appraise")
    private String nannyAppraise;
}
