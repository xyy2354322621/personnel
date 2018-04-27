package com.xyy.biz.impl;

import com.xyy.biz.EmployeeService;
import com.xyy.dao.EmployeeMapper;
import com.xyy.model.Department;
import com.xyy.model.Employee;
import com.xyy.model.Position;
import com.xyy.model.Train;
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

    @Override
    public List<Employee> getPositionEmployees(Position position) {
        return employeeMapper.getPositionEmployees(position);
    }

    @Override
    public List<Employee> getDepartEmployees(Department department) {
        return employeeMapper.getDepartEmployees( department);
    }

    @Override
    public List<Employee> getJoinTrainEmployees(Train train) {
        return employeeMapper.getJoinTrainEmployees( train) ;
    }

    @Override
    public boolean updateChangeToNormal(Employee employee) {
        return employeeMapper.updateChangeToNormal(employee);
    }

    @Override
    public List<Employee> getNormalEmployees() {
        return employeeMapper.getNormalEmployees();
    }
}
