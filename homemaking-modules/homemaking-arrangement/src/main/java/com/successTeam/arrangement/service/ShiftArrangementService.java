package com.successTeam.arrangement.service;

import com.mybatisflex.core.service.IService;
import com.successTeam.arrangement.pojo.dto.ShiftArrangementQueryDto;
import com.successTeam.arrangement.pojo.entity.ShiftArrangement;
import com.successTeam.arrangement.pojo.vo.ShiftArrangementVo;

import java.util.List;

public interface ShiftArrangementService extends IService<ShiftArrangement> {
List<ShiftArrangementVo> findShiftArrangementAll(ShiftArrangementQueryDto shiftArrangementQueryDto);
}
