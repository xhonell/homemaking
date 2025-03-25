package com.successTeam.arrangement.pojo.entity;

import com.mybatisflex.annotation.Column;
import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.Table;
import lombok.Data;

import java.util.Date;

@Data
@Table("tb_shift_arrangement")
public class ShiftArrangement {

  @Id
  @Column("arrangement_id")
  private Long arrangementId;
  //  调度时间
  @Column("arrangement_time")
  private Date arrangementTime;
  //  员工编号
  @Column("employee_id")
  private Long employeeId;
  //  订单编号
  @Column("order_id")
  private String orderId;
//创建时间
  private Date created;
//修改时间
  private Date updated;
  
}
