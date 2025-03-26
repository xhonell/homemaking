package com.successTeam.move.mapper;

import com.mybatisflex.core.BaseMapper;
import com.successTeam.move.pojo.entity.Move;

import java.util.List;

/**
 * User: zhongjing
 * Date: 2025/3/24
 * Description:
 * Version: V1.0
 */
public interface MoveMapper extends BaseMapper<Move> {

    //查询所有搬家里程数列表
    List<Double> findAllMoveDistance();

    //查询所有搬家额外人数列表
    List<Integer> findAllPersonNumber();

}
