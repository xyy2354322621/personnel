package com.xyy.biz.impl;

import com.xyy.biz.EmployeeService;
import com.xyy.dao.EmployeeMapper;
import com.xyy.model.Employee;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by xiyueyang on 2018/4/20 0020.
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Resource
    private EmployeeMapper employeeMapper;

    @Override
    public Employee getEmployee(Employee employee) {
        return employeeMapper.getEmployee(employee);
    }

    @Override
    public List<Employee> getEmployees() {
        return employeeMapper.getEmployees();
    }

    @Override
    public boolean addEmployee(Employee employee) {
        return employeeMapper.addEmployee( employee) ;
    }

    @Override
    public boolean updateChangeGrade(Employee employee) {
        return employeeMapper.updateChangeGrade( employee);
    }

    @Override
    public boolean updateChangePosition(Employee changePositionEmployee) {
        return employeeMapper.updateChangePosition(changePositionEmployee);
    }

    @Override
    public boolean updateDimission(Employee employee) {
        return employeeMapper.updateDimission( employee);
    }
}
