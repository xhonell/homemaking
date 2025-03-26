package com.successTeam.move.service.impl;

import com.mybatisflex.spring.service.impl.ServiceImpl;
import com.successTeam.move.mapper.CarMapper;
import com.successTeam.move.mapper.MoveMapper;
import com.successTeam.move.pojo.dto.MoveAddDto;
import com.successTeam.move.pojo.entity.Move;
import com.successTeam.move.service.MoveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Objects;

/**
 * User: zhongjing
 * Date: 2025/3/24
 * Description:
 * Version: V1.0
 */
@Service
public class MoveServiceImpl extends ServiceImpl<MoveMapper, Move> implements MoveService {

    @Autowired
    private MoveMapper moveMapper;

    @Autowired
    private CarMapper carMapper;

    @Override
    public void addMove(MoveAddDto moveAddDto) {
        Long carId = moveAddDto.getCarId();
        Long floorId = moveAddDto.getFloorId();
        Double moveDistance = moveAddDto.getMoveDistance();
        Integer personNumber = moveAddDto.getPersonNumber();

        //获取基础里程、里程单价
        Map<String, Object> carMap= carMapper.findCarById(carId);
        Double baseDistance = (Double) carMap.get("base_distance");
        Double singlePrice = (Double) carMap.get("single_price");
        Double extraPrice = (Double) carMap.get("extra_price");

        //计算里程总价、额外人数总价
        Double distancePrice=(moveDistance-baseDistance)*singlePrice;
        Double personPrice=personNumber*extraPrice;

        Move move=new Move();
        move.setCarId(carId);
        move.setFloorId(floorId);
        move.setMoveDistance(moveDistance);
        move.setDistancePrice(distancePrice);
        move.setPersonNumber(personNumber);
        move.setPersonPrice(personPrice);

        moveMapper.insert(move);
    }
}
