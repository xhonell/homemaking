package com.successTeam.cleaning.service.impl;

import com.mybatisflex.spring.service.impl.ServiceImpl;
import com.successTeam.cleaning.mapper.CleaningStaffMapper;
import com.successTeam.cleaning.pojo.entity.CleaningStaff;
import com.successTeam.cleaning.service.CleaningStaffService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CleaningStaffServiceImpl extends ServiceImpl<CleaningStaffMapper, CleaningStaff> implements CleaningStaffService {
}
