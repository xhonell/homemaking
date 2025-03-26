package com.successTeam.core.pojo.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * program: homemaking
 * ClassName UserRedisVo
 * description:
 * author: xhonell
 * create: 2025年03月25日15时02分
 * Version 1.0
 **/
@Data
public class UserRedis implements Serializable {
    private Long userId;
    private String userNickname;
    private String userAvatar;
    private String userPhone;
}
