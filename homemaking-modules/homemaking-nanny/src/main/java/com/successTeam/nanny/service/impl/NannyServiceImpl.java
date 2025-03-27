package com.successTeam.nanny.service.impl;

import com.mybatisflex.spring.service.impl.ServiceImpl;
import com.successTeam.nanny.mapper.NannyMapper;
import com.successTeam.nanny.pojo.dto.NannyTypeQueryDto;
import com.successTeam.nanny.pojo.entity.Nanny;
import com.successTeam.nanny.pojo.vo.NannyListVo;
import com.successTeam.nanny.service.NannyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * com.successTeam.nanny.service.impl
 * User: hdh
 * Date: 2025/03/25 15:13
 * motto:   百折不挠
 * Description:
 * Version: V1.0
 */
@Service
@Slf4j
public class NannyServiceImpl extends ServiceImpl<NannyMapper, Nanny> implements NannyService {

    @Autowired
    private NannyMapper nannyMapper;

    @Override
    public List<NannyListVo> findNannyByType(NannyTypeQueryDto nannyTypeQueryDto) {
        return nannyMapper.findNannyByType(nannyTypeQueryDto);
    }
}
