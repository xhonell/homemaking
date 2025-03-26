package com.successTeam.move.pojo.entity;

import com.mybatisflex.annotation.Column;
import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@Table("tb_car")
public class Car implements Serializable {

  //车型ID
  @Id(keyType = KeyType.Auto)
  @Column("car_id")
  private Long carId;

  //车型类型
  @Column("car_type")
  private String carType;

  //车型大小
  @Column("car_size")
  private String carSize;

  //车型详情
  @Column("car_detail")
  private String carDetail;

  //车型底价
  @Column("base_price")
  private Double basePrice;

  //基础里程
  @Column("base_distance")
  private Double baseDistance;

  //里程单价
  @Column("single_price")
  private Double singlePrice;

  //搬家人数
  @Column("car_person")
  private Long carPerson;

  //额外人数单价
  @Column("extra_price")
  private Double extraPrice;

  //创建时间
  @Column("created_time")
  private Date createdTime;

  //修改时间
  @Column("updated_time")
  private Date updatedTime;

}
