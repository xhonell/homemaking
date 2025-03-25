package com.successTeam.order.pojo.dto;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * program: homemaking
 * ClassName OrderGenerateDto
 * description:
 * author: xhonell
 * create: 2025年03月24日20时22分
 * Version 1.0
 **/
@Data
public class OrderGenerateDto implements Serializable {
    /*订单价格*/
    @Min(message = "订单价格不能低于0",value = 0)
    private BigDecimal orderPrice;
    @NotNull(message = "用户编号不能为空")
    /*用户编号*/
    private Long userId;
    @NotNull(message = "员工编号不能为空")
    /*员工编号*/
    private Long employeeId;
    /*地址编号*/
    @NotNull(message = "地址编号不能为空")
    private Long addressId;
}
