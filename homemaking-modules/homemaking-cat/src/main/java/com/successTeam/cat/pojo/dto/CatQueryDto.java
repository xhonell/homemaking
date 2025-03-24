package com.successTeam.cat.pojo.dto;

import com.successTeam.core.pojo.dto.PageQueryDto;
import lombok.Data;

import java.io.Serializable;

/**
 * program: homemaking
 * ClassName CatQueryDto
 * description:
 * author: xhonell
 * create: 2025年03月23日21时25分
 * Version 1.0
 **/
@Data
public class CatQueryDto extends PageQueryDto {
    private String catName;
    private Long typeId;
}
