package com.xyy.dao;

import com.xyy.model.Department;

import java.util.List;

/**
 * Created by xiyueyang on 2018/4/20 0020.
 */
public interface DepartmentMapper {
    Department getDepartment(Department department);

    boolean addDepartment(Department department);

    List<Department> getDepartments();

    boolean updateDepartment(Department alterDepartment);

    List<Department> getDepartmentsAndPosition();

}
