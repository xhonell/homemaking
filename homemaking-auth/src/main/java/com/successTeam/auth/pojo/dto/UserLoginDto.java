package com.successTeam.auth.pojo.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * program: homemaking
 * ClassName UserLoginDto
 * description:
 * author: xhonell
 * create: 2025年03月25日14时38分
 * Version 1.0
 **/
@Data
public class UserLoginDto implements Serializable {
    @NotBlank(message = "用户手机号不能为空")
    private String userPhone;
    @NotBlank(message = "用户密码不能为空")
    private String userPassword;
}
