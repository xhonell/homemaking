package com.successTeam.core.utils;

import com.successTeam.common.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import java.util.List;

/**
 * program: saas
 * ClassName WebUtils
 * description:
 * author: xhonell
 * create: 2025年01月22日15时20分
 * Version 1.0
 **/
@Slf4j
public class WebUtils {
    public static Result getResult(BindingResult bindingResult) {
        //获取所有的错误信息
        List<ObjectError> errors = bindingResult.getAllErrors();
        StringBuilder sb=new StringBuilder();
        errors.forEach(objectError -> {
            String message = objectError.getDefaultMessage();
            sb.append(message+",");
        });
        log.error("校验不通过...失败原因:{}",sb.toString());
        return Result.fail(50000, sb.toString().substring(0, sb.toString().length() - 1));
    }
}
