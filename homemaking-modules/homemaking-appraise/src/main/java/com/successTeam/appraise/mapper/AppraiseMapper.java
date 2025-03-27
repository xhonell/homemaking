package com.successTeam.appraise.mapper;

import com.mybatisflex.core.BaseMapper;
import com.successTeam.appraise.pojo.entity.Appraise;
import com.successTeam.appraise.pojo.vo.AppraiseList;

import java.util.List;

/**
 * User: zhongjing
 * Date: 2025/3/24
 * Description:
 * Version: V1.0
 */
public interface AppraiseMapper extends BaseMapper<Appraise> {

    //查询月嫂的所有评价
    List<AppraiseList> findAppraiseByNanny(Long nannyId);

    //查询保洁的所有评价
    List<AppraiseList> findAppraiseByClean();

    //查询宠物的所有评价
    List<AppraiseList> findAppraiseByCat();

    //查询搬家的所有评价
    List<AppraiseList> findAppraiseByMove();

    //查询维修的所有评价
    List<AppraiseList> findAppraiseByRepair();

}
