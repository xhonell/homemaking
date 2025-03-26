package com.successTeam.auth.controller.app;

import com.successTeam.auth.pojo.dto.UserLoginDto;
import com.successTeam.auth.service.UserService;
import com.successTeam.core.pojo.entity.UserRedis;
import com.successTeam.core.result.Result;
import com.successTeam.core.utils.ValidateUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * program: homemaking
 * ClassName UserController
 * description:
 * author: xhonell
 * create: 2025年03月25日14时33分
 * Version 1.0
 **/
@RestController
@RequestMapping("/app-api/user")
@Api(tags = "用户端用户登录的接口")
public class UserController {
    @Autowired
    private UserService userService;


    /**
     * 用户登录
     * @param userLoginDto 登录条件
     * @param bindingResult 效验的错误信息
     * @return token
     */
    @ApiOperation("用户登录")
    @PostMapping("login")
    public Result<String> login(@RequestBody @Validated UserLoginDto userLoginDto, BindingResult bindingResult) {
        ValidateUtils.getFirstErrorMsg(bindingResult);
        String token = userService.login(userLoginDto);
        return Result.buildSuccess(token);
    }

    /**
     * 根据token获取用户信息
     * @param token token
     * @return 用户信息的响应体
     */
    @ApiOperation("根据token获取用户信息")
    @GetMapping("/findUserByToken/{token}")
    public Result<UserRedis> findUserByToken(@PathVariable String token){
        UserRedis userByToken = userService.findUserByToken(token);
        return Result.buildSuccess(userByToken);

    }
}
