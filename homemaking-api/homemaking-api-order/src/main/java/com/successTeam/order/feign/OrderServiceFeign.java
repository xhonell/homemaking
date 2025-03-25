package com.successTeam.order.feign;

import com.successTeam.core.result.Result;
import com.successTeam.order.fallback.OrderServiceFeignFactory;
import com.successTeam.order.pojo.dto.OrderGenerateDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * program: homemaking
 * ClassName OrderServiceFrign
 * description:
 * author: xhonell
 * create: 2025年03月25日10时19分
 * Version 1.0
 **/
@FeignClient(contextId = "order-feign", value = "order-service", fallbackFactory = OrderServiceFeignFactory.class)
public interface OrderServiceFeign {

    /*生成订单，返回订单编号*/
    @PostMapping("/app-api/order/generateOrder")
    Result generateOrder(@RequestBody OrderGenerateDto orderGenerateDto);
}
