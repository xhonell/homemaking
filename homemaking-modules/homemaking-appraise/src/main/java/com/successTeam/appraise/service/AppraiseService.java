package com.successTeam.appraise.service;

import com.mybatisflex.core.service.IService;
import com.successTeam.appraise.pojo.entity.Appraise;
import com.successTeam.appraise.pojo.vo.AppraiseList;

import java.util.List;

/**
 * User: zhongjing
 * Date: 2025/3/24
 * Description:
 * Version: V1.0
 */
public interface AppraiseService extends IService<Appraise> {

    /**
     * 查询月嫂的所有评价
     * @return
     */
    List<AppraiseList> findAppraiseByNanny(Long nannyId);

    /**
     * 查询保洁的所有评价
     * @return
     */
    List<AppraiseList> findAppraiseByClean();

    /**
     * 查询宠物的所有评价
     * @return
     */
    List<AppraiseList> findAppraiseByCat();

    /**
     * 查询搬家的所有评价
     * @return
     */
    List<AppraiseList> findAppraiseByMove();

    /**
     * 查询维修的所有评价
     * @return
     */
    List<AppraiseList> findAppraiseByRepair();

}
