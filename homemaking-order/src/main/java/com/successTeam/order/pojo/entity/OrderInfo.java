package com.successTeam.order.pojo.entity;

import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import lombok.Data;
import org.apache.http.auth.AUTH;

import java.util.Date;

@Data
@Table("tb_order_info")
public class OrderInfo {

  @Id(keyType = KeyType.Auto)
  /*详情编号*/
  private Long infoId;
  /*用户编号*/
  private Long userId;
  /*员工编号*/
  private Long employeeId;
  /*地址编号*/
  private Long addressId;
  /*订单状态*/
  private Long infoStatus;
  /*订单编号*/
  private String orderId;
  /*创建时间*/
  private Date created;
  /*修改时间*/
  private Date updated;

}
