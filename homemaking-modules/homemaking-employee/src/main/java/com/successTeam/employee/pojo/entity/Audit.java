package com.successTeam.employee.pojo.entity;


import com.mybatisflex.annotation.Column;
import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@Table("tb_audit")
public class Audit implements Serializable {

  @Id(keyType = KeyType.Auto)
  @Column("audit_id")
  private Long auditId;

  @Column("employee_detail_id")
  private Long employeeDetailId;
  @Column("audit_status")
  private String auditStatus;
  @Column("audit_time")
  private Date auditTime;
  @Column("reject_reason")
  private String rejectReason;
  @Column("create_time")
  private Date createTime;
  @Column("update_time")
  private Date updateTime;

}
