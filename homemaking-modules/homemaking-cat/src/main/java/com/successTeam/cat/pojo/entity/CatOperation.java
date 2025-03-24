package com.successTeam.cat.pojo.entity;


import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.Table;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@Table("tb_cat_operation")
public class CatOperation implements Serializable {

  /*操作类型编号*/
  @Id
  private Long operationId;
  /*操作类型，数字表示*/
  private String operationName;
  /*创建时间*/
  private Date created;
  /*修改时间*/
  private Date updated;


}
