package com.successTeam.move.pojo.entity;

import com.mybatisflex.annotation.Column;
import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@Table("tb_floor")
public class Floor implements Serializable {

  //楼层ID
  @Id(keyType=KeyType.Auto)
  @Column("floor_id")
  private Long floorId;

  //楼层类型
  @Column("floor_type")
  private String floorType;

  //楼层价格
  @Column("floor_price")
  private Double floorPrice;

  //创建时间
  @Column("created_time")
  private Date createdTime;

  //修改时间
  @Column("updated_time")
  private Date updatedTime;

}
