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
public class Result<T> implements Serializable {
    private Integer code;
    private String message;
    private T data;
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
    private static <T> Result<T> build(ResultEnum resultEnum, T data) {
        Result<T> result = new Result<>(resultEnum);
        result.setData(data);
        return result;
    }

    /**
     * 响应一个带数据的成功消息
     * @param Data 数据
     * @return Result
     */
    public static <T> Result<T> buildSuccess(T Data){
        return build(ResultEnum.OPERATION_SUCCESS, Data);
    }

    /**
     * 响应一个默认的成功消息
     * @return Result
     */
    public static <T> Result<T> buildSuccess(){
        return build(ResultEnum.OPERATION_SUCCESS, null);
    }

    /**
     * 响应一个带条目数的成功消息
     * @param total 条目式
     * @param Data 数据
     * @return Result
     */
    public static <T> Result<T>  buildSuccess(Long total,T Data){
        Result<T> result = new Result<>(ResultEnum.OPERATION_SUCCESS);
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
    public static <T> Result<T>  buildFail(ResultEnum resultEnum, T Data){
        return build(resultEnum, Data);
    }

    /**
     * 响应一个不带数据的错误信息
     * @param resultEnum 错误类型
     * @return Result
     */
    public static <T> Result<T>  buildFail(ResultEnum resultEnum){
        return build(resultEnum, null);
    }

    /**
     * 响应一个系统繁忙的错误信息
     * @return Result
     */
    public static <T> Result<T>  buildFail(){
        return build(ResultEnum.SYSTEM_BUSYNESS, null);
    }

    /**
     * 响应一个自定义状态码的错误
     */
    public static <T> Result<T>  buildFail(Integer code,String message){
        Result<T> result = new Result<>();
        result.setCode(code);
        result.setMessage(message);
        return result;
    }

    /**
     * 判断时候响应成功
     * @param isSuccess 条件
     */
    public static <T> Result<T>  judge(boolean isSuccess) {
        return isSuccess?buildSuccess():buildFail(ResultEnum.OPERATION_FAIL);
    }
}