package com.successTeam.cleaning.pojo.entity;

import com.mybatisflex.annotation.Column;
import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Table("tb_cleaning_prices")
public class CleaningPrices {

    @Id(keyType = KeyType.Auto)
    @Column("price_id")
    private Integer priceId;

    @Column("service_id")
    private Integer serviceId;

    @Column("price")
    private BigDecimal price;

    @Column("service_time")
    private Integer serviceTime;

    @Column("service_count")
    private Integer serviceCount;

    @Column("created_at")
    private Date createdAt;

    @Column("updated_at")
    private Date updatedAt;
}
