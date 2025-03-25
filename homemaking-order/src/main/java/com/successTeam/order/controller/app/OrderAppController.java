package com.successTeam.order.controller.app;

import com.successTeam.order.pojo.dto.OrderGenerateDto;
import com.successTeam.order.service.OrderService;
import com.successTeam.core.result.Result;
import com.successTeam.core.utils.ValidateUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * program: homemaking
 * ClassName OrderAppController
 * description:
 * author: xhonell
 * create: 2025年03月24日20时17分
 * Version 1.0
 **/
@RestController
@RequestMapping("/app-api/order")
@Api(tags = "用户端订单的接口")
public class OrderAppController {

    @Autowired
    private OrderService orderService;

    /**
     * 生成订单的接口
     * @param orderGenerateDto 生成条件
     * @param bindingResult 效验失败的结果
     * @return 订单编号的响应体
     */
    @PostMapping("/generateOrder")
    @ApiOperation("生成订单")
    public Result generateOrder(@RequestBody @Validated OrderGenerateDto orderGenerateDto, BindingResult bindingResult) {
        ValidateUtils.getFirstErrorMsg(bindingResult);
        String orderId = orderService.generateOrder(orderGenerateDto);
        return Result.buildSuccess(orderId);
    }
}
