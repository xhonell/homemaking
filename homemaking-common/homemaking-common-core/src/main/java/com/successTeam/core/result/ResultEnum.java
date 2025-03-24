package com.successTeam.core.result;


import lombok.Data;
import lombok.Getter;


@Getter
public enum ResultEnum {
    OPERATION_SUCCESS(0,"操作成功"),
    SYSTEM_BUSYNESS(20001, "系统繁忙，请稍后再试"),
    TOKEN_IS_NULL(20002, "Token不存在" ),
    OPERATION_FAIL(20003,"操作失败" );

    private final Integer code;
    private final String message;


    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
