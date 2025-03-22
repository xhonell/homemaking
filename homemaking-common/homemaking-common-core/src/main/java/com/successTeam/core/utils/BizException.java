package com.successTeam.core.utils;


import com.successTeam.common.result.ResultEnum;
import lombok.Getter;
import lombok.Setter;

/**
 * program: saas
 * ClassName BizException
 * description:
 * author: xhonell
 * create: 2025年01月16日18时21分
 * Version 1.0
 **/
@Setter
@Getter
public class BizException extends RuntimeException{
    private ResultEnum resultEnum;

    public BizException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.resultEnum = resultEnum;
    }

}
