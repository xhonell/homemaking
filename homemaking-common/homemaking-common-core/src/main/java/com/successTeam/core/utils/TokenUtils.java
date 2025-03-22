package com.successTeam.core.utils;

import cn.hutool.jwt.JWTUtil;

import java.util.Map;

/**
 * program: saas
 * ClassName TokenUtils
 * description:
 * author: xhonell
 * create: 2025年01月21日20时29分
 * Version 1.0
 **/
public class TokenUtils {

    public static final String KEY = "055f20cc27e3f307fd9ccd392cc791f07042e45ce64bASDASDSAFDSXSW98c053b950ce82eebb44";

    /**
     * 常见token
     * @param payload token要存放的参数
     * @return token值
     */
    public static String createToken(Map<String,Object> payload){
        return JWTUtil.createToken(payload, KEY.getBytes());
    }
}
