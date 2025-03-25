package com.successTeam.move.service.impl;

import com.mybatisflex.spring.service.impl.ServiceImpl;
import com.successTeam.move.mapper.MoveEmployeeMapper;
import com.successTeam.move.pojo.entity.MoveEmployee;
import com.successTeam.move.service.MoveEmployeeService;
import org.springframework.stereotype.Service;

/**
 * User: zhongjing
 * Date: 2025/3/24
 * Description:
 * Version: V1.0
 */
@Service
public class MoveEmployeeServiceImpl extends ServiceImpl<MoveEmployeeMapper, MoveEmployee> implements MoveEmployeeService {
}
