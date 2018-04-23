package com.xyy.controller;

import com.xyy.biz.DepartmentService;
import com.xyy.model.Department;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by xiyueyang on 2018/4/20 0020.
 */
@Controller
public class DepartmentController {

    @Resource
    private DepartmentService departmentService;

    @RequestMapping("/gotoManageDepartment")
    public String gotoManageDepartment()throws Exception{
        return "manageDepartment";
    }

    @RequestMapping("/manageDepartment")
    public String manageDepartment(HttpSession session)throws Exception{
        List<Department> departments = departmentService.getDepartments();
        session.setAttribute("departments",departments);
        return "manageDepartment";
    }

    @RequestMapping("/createDepartment")
    public String createDepartment()throws Exception{
        return "createDepartment";
    }


    @RequestMapping("/saveDepartment")
    public void saveDepartment(Department department, HttpServletResponse response)throws Exception{
        response.setContentType("text/html;charset=utf-8");
        department.setExist(1);
        SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
        department.setCreate_time(format.format(new Date()));
        Department existDepart = departmentService.getDepartment(department);
        if(existDepart==null){
            if(departmentService.addDepartment(department)){
                response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('部门创建成功'));" +
                        "window.location.href='createDepartment';</script>");
            }else {
                response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('部门创建失败'));" +
                        "window.location.href='createDepartment';</script>");
            }
        }else {
            response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('该部门已存在'));" +
                    "window.location.href='createDepartment';</script>");
        }
    }

    @RequestMapping("/alterDepartment")
    public String alterDepartment(Department department,HttpSession session,HttpServletResponse response)throws Exception{
        response.setContentType("text/html;charset=utf-8");
        List<Department> departments = (List<Department>) session.getAttribute("departments");
        for (Department dept :departments) {
            if(department.getDepart_no()==dept.getDepart_no()){
                department = dept;
                break;
            }
        }
        session.setAttribute("alterDepartment",department);
        return "alterDepartment";
    }
    @RequestMapping("/updateDepartment")
    public void updateDepartment(Department department,HttpSession session, HttpServletResponse response)throws Exception{
        response.setContentType("text/html;charset=utf-8");
        Department existDepart = departmentService.getDepartment(department);
        Department alterDepartment = (Department) session.getAttribute("alterDepartment");
        alterDepartment.setDepart_name(department.getDepart_name());
        alterDepartment.setDepart_location(department.getDepart_location());
        if(existDepart==null){
            if(departmentService.updateDepartment(alterDepartment)){
                response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('部门修改成功'));" +
                        "window.location.href='manageDepartment';</script>");
            }else {
                session.setAttribute("alterDepartment",alterDepartment);
                response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('部门修改失败'));" +
                        "window.location.href='gotoAlterDepartment';</script>");
            }
        }else {
            session.setAttribute("alterDepartment",alterDepartment);
            response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('同名部门已存在，请更改为其他部门名称'));" +
                    "window.location.href='gotoAlterDepartment';</script>");
        }
    }

    @RequestMapping("/gotoAlterDepartment")
    public String gotoAlterDepartment()throws Exception{
        return "alterDepartment";
    }
}
