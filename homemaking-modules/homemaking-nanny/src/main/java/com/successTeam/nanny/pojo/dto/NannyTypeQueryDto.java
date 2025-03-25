package com.successTeam.nanny.pojo.dto;

import com.successTeam.core.pojo.dto.PageQueryDto;
import lombok.Data;

/**
 * com.successTeam.nanny.pojo.dto
 * User: hdh
 * Date: 2025/03/25 14:15
 * motto:   百折不挠
 * Description:
 * Version: V1.0
 */
@Data
public class NannyTypeQueryDto extends PageQueryDto {
    private String type;
}
