package com.successTeam.core.result;

import lombok.Data;

import java.io.Serializable;

/**
 * program: homemaking
 * ClassName Result
 * description:
 * author: xhonell
 * create: 2025年03月22日13时21分
 * Version 1.0
 **/
@Data
public class Result<T> implements Serializable {
    private Integer code;
    private String message;
    private T data;

    public Result(ResultEnum resultEnum) {
        this.code = resultEnum.getCode();
        this.message = resultEnum.getMessage();
    }


    public Result() {}

    /**
     *  返回一个待返回值的消息
     * @param data 返回数据
     * @return 返回结果
     */
    private Result<T> build(ResultEnum resultEnum, T data) {
        Result<T> result = new Result<>(resultEnum);
        result.setData(data);
        return result;
    }

    /**
     * 响应一个带数据的成功消息
     * @param Data 数据
     * @return Result
     */
    public Result<T> buildSuccess(T Data){
        return build(ResultEnum.OPERATION_SUCCESS, Data);
    }

    /**
     * 响应一个默认的成功消息
     * @return Result
     */
    public Result<T> buildSuccess(){
        return build(ResultEnum.OPERATION_SUCCESS, null);
    }

    /**
     * 响应一个带数据的错误信息
     * @param resultEnum 错误类型
     * @param Data 数据
     * @return Result
     */
    public Result<T> buildFail(ResultEnum resultEnum, T Data){
        return build(resultEnum, Data);
    }

    /**
     * 响应一个不带数据的错误信息
     * @param resultEnum 错误类型
     * @return Result
     */
    public Result<T> buildFail(ResultEnum resultEnum){
        return build(resultEnum, null);
    }

    /**
     * 响应一个系统繁忙的错误信息
     * @return Result
     */
    public Result<T> buildFail(){
        return build(ResultEnum.SYSTEM_BUSYNESS, null);
    }
}