package com.xyy.biz.impl;

import com.xyy.biz.PositionService;
import com.xyy.dao.PositionMapper;
import com.xyy.model.Department;
import com.xyy.model.Employee;
import com.xyy.model.Position;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by xiyueyang on 2018/4/20 0020.
 */
@Service
public class PositionServiceImpl implements PositionService {

    @Resource
    private PositionMapper positionMapper;

    @Override
    public Position getPosition(Position position) {
        return positionMapper.getPosition(position);
    }

    @Override
    public boolean addPosition(Position position) {
        return positionMapper.addPosition(position);
    }

    @Override
    public List<Position> getPositions() {
        return positionMapper.getPositions();
    }

    @Override
    public boolean updatePosition(Position alterPosition) {
        return positionMapper.updatePosition(alterPosition);
    }

    @Override
    public Position getUsingPosition(Position position) {
        return positionMapper.getUsingPosition(position) ;
    }

    @Override
    public boolean updateDiscardPosition(Position position) {
        return positionMapper.updateDiscardPosition( position);
    }

    @Override
    public boolean updateRecoverPosition(Position position) {
        return positionMapper.updateRecoverPosition( position);
    }

    @Override
    public boolean deletePosition(Position position) {
        return positionMapper.deletePosition( position) ;
    }

    @Override
    public List<Position> getPositionEmployee() {
        return positionMapper.getPositionEmployee();
    }

    @Override
    public List<Position> getDepartPositions(Department department) {
        return positionMapper.getDepartPositions(department) ;
    }

    @Override
    public Position getRecoverPosition(Position position) {
        return positionMapper.getRecoverPosition( position) ;
    }

    @Override
    public Position getEmpPosition(Employee employee) {
        return positionMapper.getEmpPosition(employee);
    }

    @Override
    public Position getPositionByPosNo(Position originPosition) {
        return positionMapper.getPositionByPosNo(originPosition);
    }
}
