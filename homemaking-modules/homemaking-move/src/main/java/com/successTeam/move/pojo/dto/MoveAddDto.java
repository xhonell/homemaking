package com.successTeam.move.pojo.dto;

import com.mybatisflex.annotation.Column;
import lombok.Data;

import java.io.Serializable;

/**
 * User: zhongjing
 * Date: 2025/3/25
 * Description:
 * Version: V1.0
 */
@Data
public class MoveAddDto implements Serializable {

    private Long carId;

    private Long floorId;

    private String startPosition;

    private String targetPosition;

    private Integer personNumber;

}
