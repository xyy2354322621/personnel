package com.xyy.dao;

import com.xyy.model.Employee;
import com.xyy.model.ReconsiderSalary;
import com.xyy.model.Salary;

import java.util.List;

/**
 * Created by xiyueyang on 2018/5/2 0002.
 */
public interface ReconsiderSalaryMapper {
    boolean addReconsiderSalary(ReconsiderSalary reconsiderSalary);

    List<ReconsiderSalary> getMyReconsiderSalary(Employee employee);

    ReconsiderSalary getReconsiderSalary(ReconsiderSalary reconsiderSalary);

    boolean updateReconsiderSalary(ReconsiderSalary alterReconsiderSalary);

    boolean deleteReconsiderSalary(ReconsiderSalary reconsiderSalary);

    ReconsiderSalary getThisReconsiderSalary(Salary salary);

    List<ReconsiderSalary> getThisMonthReconsider(String month);
}
