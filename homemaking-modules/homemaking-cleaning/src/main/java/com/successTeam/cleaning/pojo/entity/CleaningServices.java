package com.successTeam.cleaning.pojo.entity;

import com.mybatisflex.annotation.Column;
import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import lombok.Data;
import java.util.Date;

import java.io.Serializable;

@Data
@Table("tb_cleaning_services")
public class CleaningServices implements Serializable {

    @Id(keyType = KeyType.Auto)
    @Column("service_id")
    private Integer serviceId;

    @Column("service_name")
    private String serviceName;

    @Column("description")
    private String description;

    @Column("is_available")
    private Boolean isAvailable;

    @Column("created_at")
    private Date created;

    @Column("updated_at")
    private Date updated;

}
