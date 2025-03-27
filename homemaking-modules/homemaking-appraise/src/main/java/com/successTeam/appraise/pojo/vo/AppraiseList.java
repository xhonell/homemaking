package com.successTeam.appraise.pojo.vo;

import com.mybatisflex.annotation.Column;
import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * User: zhongjing
 * Date: 2025/3/27
 * Description:
 * Version: V1.0
 */
@Data
public class AppraiseList implements Serializable {

    private Long appraiseId;

    //评分
    private Long appraiseCore;

    //评价
    private String appraiseContent;

    //评价时间
    private Date appraiseTime;

    //评价回复
    private String appraiseReply;

    //回复时间
    private Date replyTime;

}
