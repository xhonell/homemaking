package com.successTeam.cat.pojo.dto;

import com.mybatisflex.annotation.Id;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * program: homemaking
 * ClassName CatOperationInsertDto
 * description:
 * author: xhonell
 * create: 2025年03月24日12时34分
 * Version 1.0
 **/
@Data
public class OperationUpdateDto implements Serializable {
    /*操作类型编号*/
    @Min(message = "操作编号最小为1", value = 1)
    private Long operationId;
    /*操作类型，数字表示*/
    @NotBlank(message = "操作名称不能为空")
    private String operationName;
}
