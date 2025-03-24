package com.successTeam.cat.pojo.vo;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.Table;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class CatOperationQueryVo implements Serializable {

  /*操作类型编号*/
  @Id
  private Long operationId;
  /*操作类型，数字表示*/
  private String operationName;
  /*创建时间*/
  @JsonFormat(pattern = "yyyy-MM-dd")
  private Date created;
  /*修改时间*/
  @JsonFormat(pattern = "yyyy-MM-dd")
  private Date updated;


}
