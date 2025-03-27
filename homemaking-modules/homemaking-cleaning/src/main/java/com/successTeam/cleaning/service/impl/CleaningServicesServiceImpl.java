package com.successTeam.cleaning.service.impl;

import com.mybatisflex.spring.service.impl.ServiceImpl;
import com.successTeam.cleaning.mapper.CleaningServicesMapper;
import com.successTeam.cleaning.pojo.entity.CleaningServices;
import com.successTeam.cleaning.service.CleaningServicesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CleaningServicesServiceImpl extends ServiceImpl<CleaningServicesMapper, CleaningServices> implements CleaningServicesService {
}
