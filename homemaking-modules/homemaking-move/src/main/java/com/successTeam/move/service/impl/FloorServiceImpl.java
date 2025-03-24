package com.successTeam.move.service.impl;

import com.mybatisflex.spring.service.impl.ServiceImpl;
import com.successTeam.move.mapper.FloorMapper;
import com.successTeam.move.pojo.entity.Floor;
import com.successTeam.move.service.FloorService;
import org.springframework.stereotype.Service;

/**
 * User: zhongjing
 * Date: 2025/3/24
 * Description:
 * Version: V1.0
 */
@Service
public class FloorServiceImpl extends ServiceImpl<FloorMapper, Floor> implements FloorService {
}
