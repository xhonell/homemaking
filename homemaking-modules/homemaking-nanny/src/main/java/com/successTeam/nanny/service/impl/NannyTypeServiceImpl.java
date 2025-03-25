package com.successTeam.nanny.service.impl;

import com.mybatisflex.spring.service.impl.ServiceImpl;
import com.successTeam.nanny.mapper.NannyTypeMapper;
import com.successTeam.nanny.pojo.entity.NannyType;
import com.successTeam.nanny.service.NannyTypeService;
import com.successTeam.redis.service.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * com.successTeam.nanny.service.impl
 * User: hdh
 * Date: 2025/03/24 18:58
 * motto:   百折不挠
 * Description:
 * Version: V1.0
 */
@Service
@Slf4j
public class NannyTypeServiceImpl extends ServiceImpl<NannyTypeMapper, NannyType> implements NannyTypeService {


}
