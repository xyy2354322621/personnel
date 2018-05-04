package com.xyy.biz;

import com.xyy.model.Apply;
import com.xyy.model.Department;
import com.xyy.model.Employee;

import java.util.List;

/**
 * Created by xiyueyang on 2018/4/20 0020.
 */
public interface DepartmentService {
    Department getDepartment(Department department);

    boolean addDepartment(Department department);

    List<Department> getDepartments();

    boolean updateDepartment(Department alterDepartment);

    List<Department> getDepartmentsAndPosition();

    Department havingEmpDepart(Department department);

    boolean deleteDepartment(Department department);

    boolean updateDissolveDepartment(Department department);

    boolean updateRecoverDepartment(Department department);

    List<Department> getManageDepartments();

    Department getMyDepartPos(Employee employee);
}
