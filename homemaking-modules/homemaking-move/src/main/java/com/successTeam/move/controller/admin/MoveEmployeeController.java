package com.successTeam.move.controller.admin;

import com.successTeam.core.result.Result;
import com.successTeam.move.pojo.dto.MoveEmployeeAddDto;
import com.successTeam.move.pojo.entity.MoveEmployee;
import com.successTeam.move.service.MoveEmployeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * User: zhongjing
 * Date: 2025/3/27
 * Description:
 * Version: V1.0
 */
@RestController
@RequestMapping("/admin-api/move-employee")
@Api(tags = "管理端搬家人员相关接口")
public class MoveEmployeeController {

    @Autowired
    private MoveEmployeeService moveEmployeeService;

    @PostMapping("/addMoveEmpolyee")
    @ApiOperation("添加搬家人员")
    public Result addMoveEmployee(@RequestBody MoveEmployeeAddDto moveEmployeeAddDto){
        List<Long> employeeIds = moveEmployeeAddDto.getEmployeeIds();
        Long moveId = moveEmployeeAddDto.getMoveId();

        for (int i=0;i<employeeIds.size();i++){
            MoveEmployee moveEmployee=new MoveEmployee();
            moveEmployee.setMoveId(moveId);
            moveEmployee.setEmployeeId(employeeIds.get(i));
            moveEmployeeService.save(moveEmployee);
        }

        return Result.buildSuccess();
    }

}
