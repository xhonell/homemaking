package com.successTeam.cat.pojo.dto;

import com.successTeam.core.pojo.dto.PageQueryDto;
import lombok.Data;

import java.io.Serializable;

/**
 * program: homemaking
 * ClassName TypeQueryDto
 * description:
 * author: xhonell
 * create: 2025年03月24日12时49分
 * Version 1.0
 **/
@Data
public class TypeQueryDto extends PageQueryDto {
    /*宠物名称*/
    private String typeName;
}
