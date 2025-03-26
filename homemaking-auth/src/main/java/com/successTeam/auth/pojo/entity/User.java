package com.successTeam.auth.pojo.entity;

import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@Table("tb_user")
public class User implements Serializable {

  /*用户编号*/
  @Id(keyType = KeyType.Auto)
  private Long userId;
  private String userNickname;
  private String userPassword;
  private String salt;
  private String userAvatar;
  private String userPhone;
  private String appToken;
  private String webToken;
  private String refreshToken;
  private String expire;
  private Date created;
  private Date updated;

}
