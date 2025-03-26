package com.successTeam.move.pojo.entity;

import com.mybatisflex.annotation.Column;
import com.mybatisflex.annotation.Table;
import lombok.Data;

import java.io.Serializable;

@Data
@Table("tb_move_employee")
public class MoveEmployee implements Serializable {

  @Column("move_id")
  private Long moveId;

  @Column("employee_id")
  private Long employeeId;

}
