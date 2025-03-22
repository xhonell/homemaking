package com.successTeam.core.utils;

import cn.hutool.core.lang.UUID;
import cn.hutool.crypto.digest.DigestAlgorithm;
import cn.hutool.crypto.digest.Digester;

/**
 * program: saas
 * ClassName DigesterUtils
 * description:
 * author: xhonell
 * create: 2025年01月21日19时43分
 * Version 1.0
 **/
public class DigesterUtils {

    /**
     * 创建随机盐
     * @return 盐的字符串
     */
    public static String createSalt(){
        String uuid = UUID.randomUUID().toString();
        Digester digester = new Digester(DigestAlgorithm.MD5);
        return digester.digestHex(uuid);
    }

    /**
     * 创建加盐后的密码
     * @param password 密码
     * @param salt 盐值
     * @return 加盐后的密码
     */
    public static String digesterPassword(String password, String salt){
        Digester digester = new Digester(DigestAlgorithm.MD5);
        String saltPass = digester.digestHex(password);
        Digester digesterSha256 = new Digester(DigestAlgorithm.SHA256);
        return digesterSha256.digestHex(saltPass + salt);
    }
}
