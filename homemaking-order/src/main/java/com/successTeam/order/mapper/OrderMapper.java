package com.successTeam.order.mapper;

import com.successTeam.order.pojo.entity.Order;
import com.mybatisflex.core.BaseMapper;
import com.successTeam.order.pojo.vo.OrderQueryVo;

import java.util.List;

/**
 * program: homemaking
 * ClassName OrderMapper
 * description:
 * author: xhonell
 * create: 2025年03月24日20时11分
 * Version 1.0
 **/
public interface OrderMapper extends BaseMapper<Order> {
    List<OrderQueryVo> findOrderById(Long userId);
}
