package com.successTeam.cat.pojo.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * program: homemaking
 * ClassName CatQueryVo
 * description:
 * author: xhonell
 * create: 2025年03月23日21时27分
 * Version 1.0
 **/
@Data
public class CatQueryVo implements Serializable {
    /*宠物编号*/
    private Long catId;
    /*宠物类型，数字区分*/
    private Long typeId;
    /*类型名称*/
    private String typeName;
    /*宠物名称*/
    private String catName;
    /*创建时间*/
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date created;
    /*修改时间*/
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date updated;
}
