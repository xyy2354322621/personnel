package com.xyy.biz;

import com.xyy.model.Employee;

import java.util.List;

/**
 * Created by xiyueyang on 2018/4/20 0020.
 */
public interface EmployeeService {
    Employee getEmployee(Employee employee);

    List<Employee> getEmployees();
}
