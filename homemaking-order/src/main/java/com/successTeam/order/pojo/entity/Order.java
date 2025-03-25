package com.successTeam.order.pojo.entity;


import com.mybatisflex.annotation.Column;
import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import lombok.Data;
import org.apache.ibatis.type.JdbcType;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Table("tb_order")
public class Order {
  @Id
  /*订单编号*/
  private String orderId;
  /*订单状态*/
  private Long orderStatus;
  /*交易金额*/
  @Column(value = "order_price", jdbcType = JdbcType.DECIMAL)
  private BigDecimal orderPrice;
  /*创建时间*/
  private Date created;
  /*修改时间*/
  private Date updated;


}
