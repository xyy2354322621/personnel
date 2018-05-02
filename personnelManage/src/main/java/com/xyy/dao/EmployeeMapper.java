package com.xyy.dao;

import com.xyy.model.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by xiyueyang on 2018/4/20 0020.
 */
public interface EmployeeMapper {
    Employee getEmployee(Employee employee);

    List<Employee> getEmployees();

    boolean addEmployee(Employee employee);

    boolean updateChangeGrade(Employee employee);

    boolean updateChangePosition(Employee changePositionEmployee);

    boolean updateDimission(Employee employee);

    List<Employee> getPositionEmployees(Position position);

    List<Employee> getDepartEmployees(Department department);

    List<Employee> getJoinTrainEmployees(Train train);

    boolean updateChangeToNormal(Employee employee);

    List<Employee> getNormalEmployees();

    boolean addChangePos(ChangePos changePos);

    List<Employee> getThisMonthOnJobEmployees(String month);

    List<ChangePos> getThisMonthChangePos(@Param("employee") Employee employee,@Param("month")  String month);
}
