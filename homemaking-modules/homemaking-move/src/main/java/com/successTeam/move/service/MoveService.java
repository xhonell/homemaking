package com.successTeam.move.service;

import com.mybatisflex.core.service.IService;
import com.successTeam.move.pojo.dto.MoveAddDto;
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
public interface MoveService extends IService<Move> {

    /**
     * 根据查询条件查询搬家行程
     * @param moveQueryDto
     * @return
     */
    List<MoveList> findAllMove(MoveQueryDto moveQueryDto);

    /**
     * 添加搬家行程
     * @param moveAddDto
     */
    void addMove(MoveAddDto moveAddDto);

    /**
     * 查询所有搬家里程数列表
     * @return
     */
    List<Double> findAllMoveDistance();

    /**
     * 查询所有搬家额外人数列表
     * @return
     */
    List<Integer> findAllPersonNumber();

}
