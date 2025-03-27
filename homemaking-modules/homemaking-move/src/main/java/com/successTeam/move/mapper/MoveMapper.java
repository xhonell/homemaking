package com.successTeam.move.mapper;

import com.mybatisflex.core.BaseMapper;
import com.successTeam.move.pojo.dto.MoveQueryDto;
import com.successTeam.move.pojo.entity.Move;
import com.successTeam.move.pojo.vo.MoveList;

import java.util.List;

/**
 * User: zhongjing
 * Date: 2025/3/24
 * Description:
 * Version: V1.0
 */
public interface MoveMapper extends BaseMapper<Move> {

    //根据查询条件查询搬家行程
    List<MoveList> findAllMove(MoveQueryDto moveQueryDto);

    //查询所有搬家里程数列表
    List<Double> findAllMoveDistance();

    //查询所有搬家额外人数列表
    List<Integer> findAllPersonNumber();

}
