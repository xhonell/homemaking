package com.successTeam.move.pojo.vo;

import com.mybatisflex.annotation.Column;
import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class MoveList implements Serializable {

  //搬家ID
  private Long moveId;

  //车型类型
  private String carType;

  //楼层类型
  private String floorType;

  //起始地址
  private String startPosition;

  //目标地址
  private String targetPosition;

  //里程数
  private Double moveDistance;

  //里程总价
  private Double distancePrice;

  //额外搬家人数
  private Integer personNumber;

  //额外人数总价
  private Double personPrice;

  //创建时间
  private Date createdTime;

  //修改时间
  private Date updatedTime;

  //搬家人员
  private String personContent;

}
