package com.xyy.dao;

import com.xyy.model.Employee;

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
}
