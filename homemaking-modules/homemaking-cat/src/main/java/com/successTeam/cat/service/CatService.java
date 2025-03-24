package com.successTeam.cat.service;

import com.mybatisflex.core.BaseMapper;
import com.mybatisflex.core.service.IService;
import com.successTeam.cat.pojo.dto.CatQueryDto;
import com.successTeam.cat.pojo.entity.Cat;
import com.successTeam.cat.pojo.vo.CatQueryVo;

import java.util.List;

/**
 * program: homemaking
 * ClassName CatService
 * description:
 * author: xhonell
 * create: 2025年03月23日15时56分
 * Version 1.0
 **/
public interface CatService extends IService<Cat> {
    /*查询指定类型下的宠物列表*/
    List<Cat> findCatAll(Long typeId);
    /*删除指定类型下的宠物列表*/
    boolean deleteCatCacheByTypeId(Long typeId);
    /*分页查询宠物列表*/
    List<CatQueryVo>  findCatByPage(CatQueryDto catQueryDto);
}
