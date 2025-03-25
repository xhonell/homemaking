package com.successTeam.cat.pojo.dto;

import com.successTeam.core.pojo.dto.PageQueryDto;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
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
public class TypeUpdateDto implements Serializable {
    /*宠物类型编号*/
    @Min(message = "类型编号的最小值为1", value = 1)
    private Long typeId;
    /*宠物名称*/
    @NotBlank(message = "类型名称不能为空")
    private String typeName;
}
