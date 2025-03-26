package com.successTeam.move.pojo.dto;

import com.mybatisflex.annotation.Column;
import com.successTeam.core.pojo.dto.PageQueryDto;
import lombok.Data;

/**
 * User: zhongjing
 * Date: 2025/3/26
 * Description:
 * Version: V1.0
 */
@Data
public class MoveQueryDto extends PageQueryDto {

    //车型ID
    private Long carId;

    //楼层ID
    private Long floorId;

    //里程数
    private Double moveDistance;

    //额外搬家人数
    private Integer personNumber;

}
