package com.xyy.dao;

import com.xyy.model.Employee;
import com.xyy.model.Salary;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by xiyueyang on 2018/4/29 0029.
 */
public interface SalaryMapper {
    List<Salary> getThisMonthSalary(String month);

    Salary getEmpThisMonthSalary(@Param("employee") Employee employee,@Param("month") String month);

    boolean addSalary(Salary salary);

    boolean updateSalary(Salary salary);

    Salary getSalary(Salary salary);

    List<Salary> getMySalaries(Employee employee);
}
