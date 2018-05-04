package com.xyy.biz.impl;

import com.xyy.biz.ReconsiderSalaryService;
import com.xyy.dao.ReconsiderSalaryMapper;
import com.xyy.model.Employee;
import com.xyy.model.ReconsiderSalary;
import com.xyy.model.Salary;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by xiyueyang on 2018/5/2 0002.
 */
@Service
public class ReconsiderSalaryServiceImpl implements ReconsiderSalaryService {

    @Resource
    private ReconsiderSalaryMapper reconsiderSalaryMapper;

    @Override
    public boolean addReconsiderSalary(ReconsiderSalary reconsiderSalary) {
        return reconsiderSalaryMapper.addReconsiderSalary(reconsiderSalary);
    }

    @Override
    public List<ReconsiderSalary> getMyReconsiderSalary(Employee employee) {
        return reconsiderSalaryMapper.getMyReconsiderSalary(employee);
    }

    @Override
    public ReconsiderSalary getReconsiderSalary(ReconsiderSalary reconsiderSalary) {
        return reconsiderSalaryMapper.getReconsiderSalary(reconsiderSalary);
    }

    @Override
    public boolean updateReconsiderSalary(ReconsiderSalary alterReconsiderSalary) {
        return reconsiderSalaryMapper.updateReconsiderSalary(alterReconsiderSalary);
    }

    @Override
    public boolean deleteReconsiderSalary(ReconsiderSalary reconsiderSalary) {
        return reconsiderSalaryMapper.deleteReconsiderSalary(reconsiderSalary);
    }

    @Override
    public ReconsiderSalary getThisReconsiderSalary(Salary salary) {
        return reconsiderSalaryMapper.getThisReconsiderSalary(salary);
    }

    @Override
    public List<ReconsiderSalary> getThisMonthReconsider(String month) {
        return reconsiderSalaryMapper.getThisMonthReconsider(month);
    }
}
