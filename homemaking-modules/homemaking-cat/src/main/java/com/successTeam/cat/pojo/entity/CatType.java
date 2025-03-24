package com.successTeam.cat.pojo.entity;


import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@Table("tb_cat_type")
public class CatType implements Serializable {

  /*宠物类型*/
  @Id(keyType = KeyType.Auto)
  private Long typeId;
  /*宠物名称*/
  private String typeName;
  /*创建时间*/
  private Date created;
  /*修改时间*/
  private Date updated;


}
