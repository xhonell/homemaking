package com.successTeam.nanny.service;

import com.mybatisflex.core.service.IService;
import com.successTeam.nanny.pojo.dto.NannyTypeQueryDto;
import com.successTeam.nanny.pojo.entity.Nanny;
import com.successTeam.nanny.pojo.vo.NannyListVo;

import java.util.List;

/**
 * com.successTeam.nanny.service
 * User: hdh
 * Date: 2025/03/25 15:12
 * motto:   百折不挠
 * Description:
 * Version: V1.0
 */
public interface NannyService extends IService<Nanny> {
    public List<NannyListVo> findNannyByType(NannyTypeQueryDto nannyTypeQueryDto);
}
