package com.xyy.biz;

import com.xyy.model.Employee;
import com.xyy.model.Salary;

import java.util.List;

/**
 * Created by xiyueyang on 2018/4/29 0029.
 */
public interface SalaryService {
    List<Salary> getThisMonthSalary(String month);

    Salary getEmpThisMonthSalary(Employee employee, String curMonth);

    boolean addSalary(Salary salary);

    boolean updateSalary(Salary salary);

    Salary getSalary(Salary salary);

    List<Salary> getMySalaries(Employee employee);
}
