package com.successTeam.arrangement.pojo.vo;


import com.successTeam.arrangement.pojo.entity.ShiftArrangement;
import lombok.Data;

import java.io.Serializable;

@Data
public class ShiftArrangementVo implements Serializable {
    //订单编号
    private String orderId;
//调度时间
    private Data arrangementTime;
}
