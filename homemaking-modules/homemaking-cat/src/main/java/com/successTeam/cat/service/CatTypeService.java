package com.successTeam.cat.service;

import com.mybatisflex.core.service.IService;
import com.successTeam.cat.pojo.entity.CatType;

import java.util.List;

/**
 * program: homemaking
 * ClassName CatTypeService
 * description:
 * author: xhonell
 * create: 2025年03月23日16时24分
 * Version 1.0
 **/
public interface CatTypeService extends IService<CatType> {
    List<CatType> findTypeAll();

    boolean deleteCatTypeCache();
}
