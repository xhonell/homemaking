package com.successTeam.move.pojo.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * User: zhongjing
 * Date: 2025/3/27
 * Description:
 * Version: V1.0
 */
@Data
public class MoveEmployeeAddDto implements Serializable {

    private Long moveId;

    private List<Long> employeeIds;

}
