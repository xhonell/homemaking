package com.successTeam.cat.pojo.entity;


import com.mybatisflex.annotation.Column;
import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.Table;
import lombok.Data;
import org.apache.ibatis.type.JdbcType;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Table("tb_cat_price")
public class CatPrice implements Serializable {

  /*宠物编号*/
  @Id
  private Long catId;
  /*操作的编号*/
  @Id
  private Long operationId;
  /*价格*/
  @Column(value = "price", jdbcType = JdbcType.DECIMAL)
  private BigDecimal price;
  /*创建时间*/
  private Date  created;
  /*修改时间*/
  private Date  updated;

}