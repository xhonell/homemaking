package com.successTeam.order.fallback;

import com.successTeam.core.result.Result;
import com.successTeam.order.feign.OrderServiceFeign;
import com.successTeam.order.pojo.dto.OrderGenerateDto;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;

/**
 * program: homemaking
 * ClassName OrderServiceFeignFactory
 * description:
 * author: xhonell
 * create: 2025年03月25日10时28分
 * Version 1.0
 **/
@Slf4j
public class OrderServiceFeignFactory implements FallbackFactory<OrderServiceFeign> {
    @Override
    public OrderServiceFeign create(Throwable throwable) {
        log.error("服务调用失败：{}",throwable.getMessage(), throwable);
        return new OrderServiceFeign() {

            @Override
            public Result generateOrder(OrderGenerateDto orderGenerateDto) {
                return Result.buildFail();
            }
        };
    }
}
