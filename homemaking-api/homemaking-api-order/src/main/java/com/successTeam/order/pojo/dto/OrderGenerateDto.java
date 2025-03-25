package com.successTeam.order.pojo.dto;

import lombok.Data;

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
    private BigDecimal orderPrice;
    /*用户编号*/
    private Long userId;
    /*员工编号*/
    private Long employeeId;
    /*地址编号*/
    private Long addressId;
}
