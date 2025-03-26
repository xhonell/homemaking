package com.successTeam.arrangement.Mapper;

import com.mybatisflex.core.BaseMapper;
import com.successTeam.arrangement.pojo.dto.ShiftArrangementQueryDto;
import com.successTeam.arrangement.pojo.entity.ShiftArrangement;
import com.successTeam.arrangement.pojo.vo.ShiftArrangementVo;

import java.util.List;

public interface ShiftArrangementMapper extends BaseMapper<ShiftArrangement> {
    List<ShiftArrangementVo> findShiftArrangementAll(ShiftArrangementQueryDto shiftArrangementQueryDto);
}
