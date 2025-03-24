package com.successTeam.cat.mapper;

import com.mybatisflex.core.BaseMapper;
import com.successTeam.cat.pojo.dto.CatQueryDto;
import com.successTeam.cat.pojo.entity.Cat;
import com.successTeam.cat.pojo.vo.CatQueryVo;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * program: homemaking
 * ClassName CatMapper
 * description:
 * author: xhonell
 * create: 2025年03月23日15时40分
 * Version 1.0
 **/
@Repository
public interface CatMapper extends BaseMapper<Cat> {

    List<CatQueryVo> findCatByPage(CatQueryDto catQueryDto);

}