package com.successTeam.core.utils;

import cn.hutool.core.exceptions.ValidateException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

/**
 * program: supply-chain
 * ClassName ValidateUtils
 * description: 处理效验错误的工具类
 * author: xhonell
 * create: 2025年02月15日15时48分
 * Version 1.0
 **/
public class ValidateUtils {

    /**
     * 获取所有的消息
     * @param bindingResult
     * @return
     */
    public static void getAllErrorMsg(BindingResult bindingResult) {
        StringBuilder errorMsg = new StringBuilder();

        // 判断是否有错误
        int errorCount = bindingResult.getErrorCount();
        if (errorCount == 0) {
            return ;
        }

        // 遍历所有错误
        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            errorMsg.append(fieldError.getDefaultMessage()).append(",");
        }

        // 去掉最后一个逗号
        String errorMsgString = errorMsg.toString();
        String substring = errorMsgString.substring(0, errorMsgString.length() - 1);

        throw new ValidateException(substring);
    }

    /**
     * 获取第一个错误
     * @param bindingResult
     */
    public static void getFirstErrorMsg(BindingResult bindingResult) {
        // 判断是否有错误
        int errorCount = bindingResult.getErrorCount();
        if (errorCount == 0) {
            return ;
        }
        // 获取第一个错误
        FieldError fieldError = bindingResult.getFieldError();
        throw new ValidateException(fieldError.getDefaultMessage());
    }
}
