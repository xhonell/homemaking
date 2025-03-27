package com.successTeam.nanny.mapper;

import com.mybatisflex.core.BaseMapper;
import com.successTeam.nanny.pojo.dto.NannyDto;
import com.successTeam.nanny.pojo.dto.NannyTypeQueryDto;
import com.successTeam.nanny.pojo.entity.Nanny;
import com.successTeam.nanny.pojo.vo.NannyListVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * com.successTeam.nanny.mapper
 * User: hdh
 * Date: 2025/03/25 14:53
 * motto:   百折不挠
 * Description:
 * Version: V1.0
 */
public interface NannyMapper extends BaseMapper<Nanny> {
    List<NannyListVo> findNannyByType(NannyTypeQueryDto nannyTypeQueryDto);

//    Nanny addNanny(NannyDto nannyDto);
}
