package com.successTeam.cat.pojo.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * program: homemaking
 * ClassName PriceInsertDto
 * description:
 * author: xhonell
 * create: 2025年03月24日18时58分
 * Version 1.0
 **/
@Data
public class PriceUpdateDto implements Serializable {
    private Long catId;
    private Long operationId;
    private BigDecimal price;
}
