package com.successTeam.cleaning.service.impl;

import com.mybatisflex.spring.service.impl.ServiceImpl;
import com.successTeam.cleaning.mapper.CleaningPricesMapper;
import com.successTeam.cleaning.pojo.entity.CleaningPrices;
import com.successTeam.cleaning.service.CleaningPricesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CleaningPricesServiceImpl extends ServiceImpl<CleaningPricesMapper, CleaningPrices> implements CleaningPricesService {
}
