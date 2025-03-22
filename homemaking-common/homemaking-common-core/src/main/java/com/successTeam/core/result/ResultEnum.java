package com.successTeam.core.result;


import lombok.Data;


public enum ResultEnum {
    OPERATION_SUCCESS(0,"操作成功"),
    SYSTEM_BUSYNESS(20001, "系统繁忙，请稍后再试"),
    TOKEN_IS_NULL(20002, "Token不存在" );

    private Integer code;
    private String message;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
