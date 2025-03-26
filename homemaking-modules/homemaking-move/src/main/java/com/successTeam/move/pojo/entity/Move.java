package com.successTeam.move.pojo.entity;

import com.mybatisflex.annotation.Column;
import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@Table("tb_move")
public class Move implements Serializable {

  //搬家ID
  @Id(keyType = KeyType.Auto)
  @Column("move_id")
  private Long moveId;

  //车型ID
  @Column("car_id")
  private Long carId;

  //楼层ID
  @Column("floor_id")
  private Long floorId;

  //里程数
  @Column("move_distance")
  private Double moveDistance;

  //里程总价
  @Column("distance_price")
  private Double distancePrice;

  //额外搬家人数
  @Column("person_number")
  private Integer personNumber;

  //额外人数总价
  @Column("person_price")
  private Double personPrice;

  //创建时间
  @Column("created_time")
  private Date createdTime;

  //修改时间
  @Column("updated_time")
  private Date updatedTime;

  //订单ID
  @Column("order_id")
  private Long orderId;

}
