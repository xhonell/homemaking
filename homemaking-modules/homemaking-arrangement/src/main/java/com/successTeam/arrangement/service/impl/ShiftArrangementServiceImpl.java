package com.successTeam.arrangement.service.impl;


import com.mybatisflex.spring.service.impl.ServiceImpl;
import com.successTeam.arrangement.Mapper.ShiftArrangementMapper;
import com.successTeam.arrangement.pojo.dto.ShiftArrangementQueryDto;
import com.successTeam.arrangement.pojo.entity.ShiftArrangement;
import com.successTeam.arrangement.pojo.vo.ShiftArrangementVo;
import com.successTeam.arrangement.service.ShiftArrangementService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShiftArrangementServiceImpl extends ServiceImpl<ShiftArrangementMapper, ShiftArrangement> implements ShiftArrangementService {

    @Override
    public List<ShiftArrangementVo> findShiftArrangementAll(ShiftArrangementQueryDto shiftArrangementQueryDto) {
        return getMapper().findShiftArrangementAll(shiftArrangementQueryDto);
    }
}
