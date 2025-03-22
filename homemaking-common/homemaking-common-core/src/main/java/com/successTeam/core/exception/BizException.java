package com.successTeam.core.exception;

import com.successTeam.core.result.ResultEnum;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * program: homemaking
 * ClassName BizException
 * description:
 * author: xhonell
 * create: 2025年03月22日13时21分
 * Version 1.0
 **/
@Getter
@Setter
public class BizException extends RuntimeException{
    private ResultEnum resultEnum;

    public BizException(ResultEnum resultEnum){
        super(resultEnum.getMessage());
        this.resultEnum = resultEnum;
    }

}
