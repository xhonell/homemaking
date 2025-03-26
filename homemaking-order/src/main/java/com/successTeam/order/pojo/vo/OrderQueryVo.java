package com.successTeam.order.pojo.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mybatisflex.annotation.Column;
import lombok.Data;
import org.apache.ibatis.type.JdbcType;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * program: homemaking
 * ClassName OrderQueryVo
 * description:
 * author: xhonell
 * create: 2025年03月25日23时33分
 * Version 1.0
 **/
@Data
public class OrderQueryVo implements Serializable {
    /*订单编号*/
    private String orderId;
    /*订单状态*/
    private Long orderStatus;
    /*交易金额*/
    private BigDecimal orderPrice;
    /*员工编号*/
    private Long employeeId;
    /*员工名称*/
    private String employeeName;
    /*用户编号*/
    private Long userId;
    /*用户昵称*/
    private String userNickname;
    /*地址编号*/
    private Long addressId;
    /*地址详情*/
    private String addressInfo;
    /*订单状态*/
    private Long infoStatus;
    /*创建时间*/
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date created;
}
