package com.successTeam.cat.pojo.dto;

import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 宠物表
 */
@Data
public class CatUpdateDto implements Serializable {

  /*宠物编号*/
  private Long catId;
  /*宠物类型，数字区分*/
  private Long typeId;
  /*宠物名称*/
  private String catName;


}
