package com.successTeam.order.service;

import com.successTeam.order.pojo.dto.OrderGenerateDto;
import com.successTeam.order.pojo.entity.Order;
import com.mybatisflex.core.service.IService;

/**
 * program: homemaking
 * ClassName OrderService
 * description:
 * author: xhonell
 * create: 2025年03月24日20时14分
 * Version 1.0
 **/
public interface OrderService extends IService<Order> {
    /*生成订单编号*/
    String generateOrder(OrderGenerateDto orderGenerateDto);
}
