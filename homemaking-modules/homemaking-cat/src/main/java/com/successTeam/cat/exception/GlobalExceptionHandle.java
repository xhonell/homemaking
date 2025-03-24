package com.successTeam.cat.exception;
import cn.hutool.core.exceptions.ValidateException;
import com.successTeam.core.exception.BizException;
import com.successTeam.core.result.Result;
import com.successTeam.core.result.ResultEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * program: homemaking
 * ClassName CatGlobleException
 * description:
 * author: xhonell
 * create: 2025年03月22日23时59分
 * Version 1.0
 **/


@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandle {

    /**
     * 捕获自定义异常
     * @param e
     * @return
     */
    @ExceptionHandler(BizException.class)
    public Result bizExceptionHandler(BizException e) {
        log.error("发生业务异常！原因是：{}", e.getResultEnum().getMessage());
        return Result.buildFail(e.getResultEnum());
    }

    /**
     * 捕获其他异常
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    public Result exceptionHandler(Exception e) {
        log.error("发生未知异常！原因是: {}", e.getMessage(),e);
        return Result.buildFail(ResultEnum.SYSTEM_BUSYNESS);
    }

    /**
     * 数据效验异常
     * @param e
     * @return
     */
    @ExceptionHandler(ValidateException.class)
    public Result validateExceptionHandler(ValidateException e) {
        log.error("发生验证异常！原因是: {}", e.getMessage());
        return Result.buildFail(20001, e.getMessage());
    }
}