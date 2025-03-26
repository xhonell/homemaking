package com.successTeam.order.service.impl;

import com.successTeam.core.pojo.entity.UserRedis;
import com.successTeam.core.service.impl.UserLocalThreadImpl;
import com.successTeam.order.mapper.OrderMapper;
import com.successTeam.order.pojo.dto.OrderGenerateDto;
import com.successTeam.order.pojo.entity.Order;
import com.successTeam.order.pojo.entity.OrderInfo;
import com.successTeam.order.pojo.vo.OrderQueryVo;
import com.successTeam.order.service.OrderInfoService;
import com.successTeam.order.service.OrderService;
import com.mybatisflex.spring.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * program: homemaking
 * ClassName OrderServiceImpl
 * description:
 * author: xhonell
 * create: 2025年03月24日20时16分
 * Version 1.0
 **/
@Service
@Slf4j
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {
    @Autowired
    private OrderInfoService orderInfoService;

    /**
     * 生成订单编号
     * @param orderGenerateDto 生成添加
     * @return 状态
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public String generateOrder(OrderGenerateDto orderGenerateDto) {
        // 从redis中或者当前线程中取出用户编号 TODO
        int userId = new Random().nextInt(10000);
        String strUserId = String.valueOf(userId);
        StringBuilder bufUserId = new StringBuilder(strUserId);
        int length = bufUserId.length();
        if (length < 6)
            for (int i = 0; i <= 6 - length; i++) {
                bufUserId.append(new Random().nextInt(10));
            }
        userId = Integer.parseInt(bufUserId.toString());
        // 生成订单
        Order order = new Order();
        BeanUtils.copyProperties(orderGenerateDto, order);
        String orderId = System.currentTimeMillis() + "" + userId;
        log.info("本次订单号为：{}", orderId);
        order.setOrderId(orderId);
        order.setOrderStatus(1L);
        order.setCreated(new Date());
        getMapper().insert(order);
        // 生成订单详情
        OrderInfo orderInfo = new OrderInfo();
        BeanUtils.copyProperties(orderGenerateDto, orderInfo);
        orderInfo.setOrderId(orderId);
        orderInfo.setCreated(new Date());
        orderInfo.setInfoStatus(1L);
        orderInfoService.save(orderInfo);
        return  orderId;
    }

    /**
     * 根据编号查询订单详情
     * @return
     */
    @Override
    public List<OrderQueryVo> findOrderById() {
        // 从当前线程中获取编号
        UserRedis userRedis = UserLocalThreadImpl.get();
        Long userId = userRedis.getUserId();
        return getMapper().findOrderById(userId);
    }
}
