package com.xyy.biz;

import com.xyy.model.Department;
import com.xyy.model.Position;

import java.util.List;

/**
 * Created by xiyueyang on 2018/4/20 0020.
 */
public interface PositionService {
    Position getPosition(Position position);

    boolean addPosition(Position position);

    List<Position> getPositions();

    boolean updatePosition(Position alterPosition);

    Position getUsingPosition(Position position);

    boolean updateDiscardPosition(Position position);

    boolean updateRecoverPosition(Position position);

    boolean deletePosition(Position position);

    List<Position> getPositionEmployee();

    List<Position> getDepartPositions(Department department);

    Position getRecoverPosition(Position position);
}
