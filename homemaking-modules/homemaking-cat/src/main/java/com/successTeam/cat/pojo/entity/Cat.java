package com.successTeam.cat.pojo.entity;

import com.mybatisflex.annotation.Column;
import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * 宠物表
 */
@Data
@Table("tb_cat")
public class Cat implements Serializable {

  /*宠物编号*/
  @Id(keyType = KeyType.Auto)
  @Column("cat_id")
  private Long catId;
  /*宠物类型，数字区分*/
  @Column("type_id")
  private Long typeId;
  /*宠物名称*/
  @Column("cat_name")
  private String catName;
  /*创建时间*/
  private Date created;
  /*修改时间*/
  private Date updated;


}
