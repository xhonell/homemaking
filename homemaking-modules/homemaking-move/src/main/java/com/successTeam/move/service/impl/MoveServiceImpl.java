package com.successTeam.move.service.impl;

import com.mybatisflex.spring.service.impl.ServiceImpl;
import com.successTeam.move.mapper.MoveMapper;
import com.successTeam.move.pojo.entity.Move;
import com.successTeam.move.service.MoveService;
import org.springframework.stereotype.Service;

/**
 * User: zhongjing
 * Date: 2025/3/24
 * Description:
 * Version: V1.0
 */
@Service
public class MoveServiceImpl extends ServiceImpl<MoveMapper, Move> implements MoveService {
}
