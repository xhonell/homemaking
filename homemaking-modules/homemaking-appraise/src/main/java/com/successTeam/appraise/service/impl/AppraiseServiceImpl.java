package com.successTeam.appraise.service.impl;

import com.mybatisflex.spring.service.impl.ServiceImpl;
import com.successTeam.appraise.mapper.AppraiseMapper;
import com.successTeam.appraise.pojo.entity.Appraise;
import com.successTeam.appraise.pojo.vo.AppraiseList;
import com.successTeam.appraise.service.AppraiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * User: zhongjing
 * Date: 2025/3/24
 * Description:
 * Version: V1.0
 */
@Service
public class AppraiseServiceImpl extends ServiceImpl<AppraiseMapper, Appraise> implements AppraiseService {

    @Autowired
    private AppraiseMapper appraiseMapper;

    @Override
    public List<AppraiseList> findAppraiseByNanny(Long nannyId) {
        return appraiseMapper.findAppraiseByNanny(nannyId);
    }

    @Override
    public List<AppraiseList> findAppraiseByClean() {
        return appraiseMapper.findAppraiseByClean();
    }

    @Override
    public List<AppraiseList> findAppraiseByCat() {
        return appraiseMapper.findAppraiseByCat();
    }

    @Override
    public List<AppraiseList> findAppraiseByMove() {
        return appraiseMapper.findAppraiseByMove();
    }

    @Override
    public List<AppraiseList> findAppraiseByRepair() {
        return appraiseMapper.findAppraiseByRepair();
    }
}
