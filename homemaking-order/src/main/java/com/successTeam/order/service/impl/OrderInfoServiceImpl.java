package com.successTeam.order.service.impl;

import com.successTeam.order.mapper.OrderInfoMapper;
import com.successTeam.order.pojo.entity.OrderInfo;
import com.successTeam.order.service.OrderInfoService;
import com.mybatisflex.spring.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * program: homemaking
 * ClassName OrderInfoServiceImpl
 * description:
 * author: xhonell
 * create: 2025年03月24日20时15分
 * Version 1.0
 **/
@Service
@Slf4j
public class OrderInfoServiceImpl extends ServiceImpl<OrderInfoMapper, OrderInfo> implements OrderInfoService {
}
