package com.successTeam.arrangement.pojo.dto;

import com.successTeam.core.pojo.dto.PageQueryDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Data
@ApiModel("查询调班信息")
public class ShiftArrangementQueryDto extends PageQueryDto {
    @ApiModelProperty("调度类型")

//    调度时间
    private Data arrangementTime;
//订单编号
    private String orderId;

}
