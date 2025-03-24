package com.successTeam.cat.pojo.dto;

import com.successTeam.core.pojo.dto.PageQueryDto;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * program: homemaking
 * ClassName OperationQueryDto
 * description:
 * author: xhonell
 * create: 2025年03月24日10时49分
 * Version 1.0
 **/
@Data
public class OperationQueryDto extends PageQueryDto {
    /*操作名称*/
    private String operationName;
}
