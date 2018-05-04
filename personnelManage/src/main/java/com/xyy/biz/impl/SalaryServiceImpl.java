package com.xyy.biz.impl;

import com.xyy.biz.SalaryService;
import com.xyy.dao.SalaryMapper;
import com.xyy.model.Employee;
import com.xyy.model.Salary;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by xiyueyang on 2018/4/29 0029.
 */
@Service
public class SalaryServiceImpl implements SalaryService {

    @Resource
    private SalaryMapper salaryMapper;

    @Override
    public List<Salary> getThisMonthSalary(String month) {
        return salaryMapper.getThisMonthSalary(month);
    }

    @Override
    public Salary getEmpThisMonthSalary(Employee employee, String month) {
        return salaryMapper.getEmpThisMonthSalary(employee,month);
    }

    @Override
    public boolean addSalary(Salary salary) {
        return salaryMapper.addSalary( salary);
    }

    @Override
    public boolean updateSalary(Salary salary) {
        return salaryMapper.updateSalary(salary);
    }

    @Override
    public Salary getSalary(Salary salary) {
        return salaryMapper.getSalary(salary);
    }

    @Override
    public List<Salary> getMySalaries(Employee employee) {
        return salaryMapper.getMySalaries(employee);
    }
}
