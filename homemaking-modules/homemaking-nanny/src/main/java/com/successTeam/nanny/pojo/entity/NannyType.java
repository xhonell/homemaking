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
 * Date: 2025/03/24 18:40
 * motto:   百折不挠
 * Description:
 * Version: V1.0
 */
@Data
@Table("tb_nanny_type")
public class NannyType implements Serializable {
    @Id(keyType = KeyType.Auto)
    @Column("nanny_type_id")
    private long nannyTypeId;
    private String type;
    @Column("create_time")
    private java.sql.Timestamp createTime;
    @Column("update_time")
    private java.sql.Timestamp updateTime;

}
