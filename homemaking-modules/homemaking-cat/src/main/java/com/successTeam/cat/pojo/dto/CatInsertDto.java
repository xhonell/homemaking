package com.successTeam.cat.pojo.dto;

import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

/**
 * 宠物表
 */
@Data
public class CatInsertDto implements Serializable {
  /*宠物类型，数字区分*/
  @Min(message = "分类编号不能小于1", value = 1)
  private Long typeId;
  /*宠物名称*/
  @NotBlank(message = "宠物名称不能为空")
  private String catName;
}
