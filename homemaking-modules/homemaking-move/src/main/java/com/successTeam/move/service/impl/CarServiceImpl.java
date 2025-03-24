package com.successTeam.move.service.impl;

import com.mybatisflex.spring.service.impl.ServiceImpl;
import com.successTeam.move.mapper.CarMapper;
import com.successTeam.move.pojo.entity.Car;
import com.successTeam.move.service.CarService;
import org.springframework.stereotype.Service;

/**
 * User: zhongjing
 * Date: 2025/3/24
 * Description:
 * Version: V1.0
 */
@Service
public class CarServiceImpl extends ServiceImpl<CarMapper, Car> implements CarService {
}
