package com.successTeam.core.utils;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

/**
 * program: saas
 * ClassName JsonUtils
 * description:
 * author: xhonell
 * create: 2025年01月20日16时06分
 * Version 1.0
 **/
public class JsonUtils {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    /**
     * 将Object类型转化为Json类型的字符串
     * @param object 要转化的对象
     * @return  Json字符串
     */
    public static String objectToJson(Object object) {
        try {
            return OBJECT_MAPPER.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 将Json语句转化为实力类型
     * @param json 传输的Json字符串
     * @param clazz 要转化的字节码对象
     * @return 字节码对应的实体类行
     * @param <T> 泛型
     */
    public static <T> T jsonToObject(String json, Class<T> clazz) {
        try {
            return OBJECT_MAPPER.readValue(json,clazz);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 将Json语句转化为List集合
     * @param json
     * @param clazz
     * @return
     * @param <T>
     */
    public static <T> List<T> jsonToList(String json, Class<T> clazz) {
        try {
            return OBJECT_MAPPER.readValue(json,OBJECT_MAPPER.getTypeFactory().constructCollectionType(List.class,clazz));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
