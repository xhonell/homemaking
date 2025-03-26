package com.successTeam.move.mapper;

import com.mybatisflex.core.BaseMapper;
import com.successTeam.move.pojo.entity.Car;

import java.util.Map;

/**
 * User: zhongjing
 * Date: 2025/3/24
 * Description:
 * Version: V1.0
 */
public interface CarMapper extends BaseMapper<Car> {

    Map<String, Object> findCarById(Long carId);

}
