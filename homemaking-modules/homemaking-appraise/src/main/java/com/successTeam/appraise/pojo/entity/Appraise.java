package com.successTeam.appraise.pojo.entity;

import com.mybatisflex.annotation.Column;
import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import lombok.Data;

import java.util.Date;

@Data
@Table("tb_appraise")
public class Appraise {

  //评价ID
  @Id(keyType = KeyType.Auto)
  @Column("appraise_id")
  private Long appraiseId;

  //评分
  @Column("appraise_core")
  private Long appraiseCore;

  //评价
  @Column("appraise_content")
  private String appraiseContent;

  //评价时间
  @Column("appraise_time")
  private Date appraiseTime;

  //评价回复
  @Column("appraise_reply")
  private String appraiseReply;

  //回复时间
  @Column("reply_time")
  private Date replyTime;

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
