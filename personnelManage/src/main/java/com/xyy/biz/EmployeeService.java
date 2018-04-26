package com.xyy.biz;

import com.xyy.model.Department;
import com.xyy.model.Employee;
import com.xyy.model.Position;
import com.xyy.model.Train;

import java.util.List;

/**
 * Created by xiyueyang on 2018/4/20 0020.
 */
public interface EmployeeService {
    Employee getEmployee(Employee employee);

    List<Employee> getEmployees();

    boolean addEmployee(Employee employee);

    boolean updateChangeGrade(Employee employee);

    boolean updateChangePosition(Employee changePositionEmployee);

    boolean updateDimission(Employee employee);

    List<Employee> getPositionEmployees(Position position);

    List<Employee> getDepartEmployees(Department department);

    List<Employee> getJoinTrainEmployees(Train train);
}
