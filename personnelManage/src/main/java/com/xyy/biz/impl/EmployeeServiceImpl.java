package com.xyy.biz.impl;

import com.xyy.biz.EmployeeService;
import com.xyy.dao.EmployeeMapper;
import com.xyy.model.Employee;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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
}
