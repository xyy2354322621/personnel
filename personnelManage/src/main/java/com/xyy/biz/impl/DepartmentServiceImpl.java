package com.xyy.biz.impl;

import com.xyy.biz.DepartmentService;
import com.xyy.dao.DepartmentMapper;
import com.xyy.model.Department;
import com.xyy.model.Employee;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by xiyueyang on 2018/4/20 0020.
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Resource
    private DepartmentMapper departmentMapper;

    @Override
    public Department getDepartment(Department department) {
        return departmentMapper.getDepartment(department) ;
    }

    @Override
    public boolean addDepartment(Department department) {
        return departmentMapper.addDepartment(department) ;
    }

    @Override
    public List<Department> getDepartments() {
        return departmentMapper.getDepartments();
    }

    @Override
    public boolean updateDepartment(Department alterDepartment) {
        return departmentMapper.updateDepartment( alterDepartment);
    }

    @Override
    public List<Department> getDepartmentsAndPosition() {
        return departmentMapper.getDepartmentsAndPosition() ;
    }

    @Override
    public Department havingEmpDepart(Department department) {
        return departmentMapper.havingEmpDepart(department);
    }

    @Override
    public boolean deleteDepartment(Department department) {
        return departmentMapper.deleteDepartment(department);
    }

    @Override
    public boolean updateDissolveDepartment(Department department) {
        return departmentMapper.updateDissolveDepartment(department);
    }

    @Override
    public boolean updateRecoverDepartment(Department department) {
        return departmentMapper.updateRecoverDepartment( department);
    }

    @Override
    public List<Department> getManageDepartments() {
        return departmentMapper.getManageDepartments() ;
    }

    @Override
    public Department getMyDepartPos(Employee employee) {
        return departmentMapper.getMyDepartPos(employee);
    }


}
