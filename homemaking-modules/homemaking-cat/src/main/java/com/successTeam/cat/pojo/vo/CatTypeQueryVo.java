package com.successTeam.cat.pojo.vo;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class CatTypeQueryVo implements Serializable {

  /*宠物类型*/
  private Long typeId;
  /*宠物名称*/
  private String typeName;
  /*创建时间*/
  @JsonFormat(pattern = "yyyy-MM-dd")
  private Date created;
  /*修改时间*/
  @JsonFormat(pattern = "yyyy-MM-dd")
  private Date updated;


}
