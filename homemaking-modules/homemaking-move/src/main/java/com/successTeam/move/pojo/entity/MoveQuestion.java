package com.successTeam.move.pojo.entity;

import com.mybatisflex.annotation.Column;
import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import lombok.Data;

import java.io.Serializable;

@Data
@Table("tb_move_question")
public class MoveQuestion implements Serializable {

  //搬家问题ID
  @Id(keyType = KeyType.Auto)
  @Column("question_id")
  private Long questionId;

  //搬家问题内容
  @Column("question_content")
  private String questionContent;

  //搬家问题方法
  @Column("question_idea")
  private String questionIdea;

}
