package com.successTeam.cat.service;

import com.mybatisflex.core.service.IService;
import com.successTeam.cat.mapper.CatOperationMapper;
import com.successTeam.cat.pojo.entity.CatOperation;

import java.util.List;

/**
 * program: homemaking
 * ClassName CatOperationService
 * description:
 * author: xhonell
 * create: 2025年03月23日19时35分
 * Version 1.0
 **/
public interface CatOperationService extends IService<CatOperation> {
    /*查询所有的操作列表*/
    List<CatOperation> findOperationAll();
    /*删除操作列表的缓存*/
    boolean deleteOperationCache();
}
