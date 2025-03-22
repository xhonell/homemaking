package com.successTeam.core.pojo.dto;

import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.Min;
import java.io.Serializable;

/**
 * program: homemaking
 * ClassName PageQueryDto
 * description:
 * author: xhonell
 * create: 2025年03月22日13时10分
 * Version 1.0
 **/
@Data
public class PageQueryDto implements Serializable {
    @Min(message = "页面最小值为1", value = 1L)
    private Long page;
    @Min(message = "分页最小值为1", value = 1L)
    private Long limit;
}
