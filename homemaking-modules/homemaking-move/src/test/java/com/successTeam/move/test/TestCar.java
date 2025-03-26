package com.successTeam.move.test;

import com.successTeam.move.mapper.CarMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

/**
 * User: zhongjing
 * Date: 2025/3/25
 * Description:
 * Version: V1.0
 */
@SpringBootTest
public class TestCar {

    @Autowired
    private CarMapper carMapper;

    @Test
    public void testFindCarById(){
        //获取基础里程、里程单价
        Map<String, Object> carMap= carMapper.findCarById(1L);
        Double baseDistance = (Double) carMap.get("base_distance");
        Double singlePrice = (Double) carMap.get("single_price");
        Double extraPrice = (Double) carMap.get("extra_price");

        System.out.println(baseDistance);
        System.out.println(singlePrice);
        System.out.println(extraPrice);
    }

}
