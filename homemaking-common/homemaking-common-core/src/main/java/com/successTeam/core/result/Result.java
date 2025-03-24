package com.successTeam.core.result;

import com.successTeam.core.result.ResultEnum;
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
public class Result implements Serializable {
    private Integer code;
    private String message;
    private Object data;
    private Long total;

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
    private static Result build(ResultEnum resultEnum, Object data) {
        Result result = new Result(resultEnum);
        result.setData(data);
        return result;
    }

    /**
     * 响应一个带数据的成功消息
     * @param Data 数据
     * @return Result
     */
    public static Result buildSuccess(Object Data){
        return build(ResultEnum.OPERATION_SUCCESS, Data);
    }

    /**
     * 响应一个默认的成功消息
     * @return Result
     */
    public static Result buildSuccess(){
        return build(ResultEnum.OPERATION_SUCCESS, null);
    }

    /**
     * 响应一个带条目数的成功消息
     * @param total 条目式
     * @param Data 数据
     * @return Result
     */
    public static Result buildSuccess(Long total,Object Data){
        Result result = new Result(ResultEnum.OPERATION_SUCCESS);
        result.setData(Data);
        result.setTotal(total);
        return result;
    }

    /**
     * 响应一个带数据的错误信息
     * @param resultEnum 错误类型
     * @param Data 数据
     * @return Result
     */
    public static Result buildFail(ResultEnum resultEnum, Object Data){
        return build(resultEnum, Data);
    }

    /**
     * 响应一个不带数据的错误信息
     * @param resultEnum 错误类型
     * @return Result
     */
    public static Result buildFail(ResultEnum resultEnum){
        return build(resultEnum, null);
    }

    /**
     * 响应一个系统繁忙的错误信息
     * @return Result
     */
    public static Result buildFail(){
        return build(ResultEnum.SYSTEM_BUSYNESS, null);
    }

    /**
     * 响应一个自定义状态码的错误
     */
    public static Result buildFail(Integer code,String message){
        Result result = new Result();
        result.setCode(code);
        result.setMessage(message);
        return result;
    }

    /**
     * 判断时候响应成功
     * @param isSuccess 条件
     */
    public static Result judge(boolean isSuccess) {
        return isSuccess?buildSuccess():buildFail(ResultEnum.OPERATION_FAIL);
    }
}