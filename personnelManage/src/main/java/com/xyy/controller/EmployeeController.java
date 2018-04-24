package com.xyy.controller;

import com.xyy.biz.*;
import com.xyy.model.*;
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
public class EmployeeController {

    @Resource
    private EmployeeService employeeService;

    @Resource
    private TouristService touristService;

    @Resource
    private ResumeService resumeService;

    @Resource
    private DepartmentService departmentService;

    @Resource
    private PositionService positionService;

    @RequestMapping("/gotoEmployeeLogin")
    public String gotoEmployeeLogin()throws Exception{
        return "employeeLogin";
    }

    @RequestMapping("/gotoEmployeeHome")
    public String gotoEmployeeHome()throws Exception{
        return "employeeHome";
    }

    @RequestMapping("/employeeLogin")
    public void employeeLogin(Tourist tourist, HttpSession session, HttpServletResponse response)throws Exception{
        Employee employee = new Employee();
        employee.setE_id(tourist.getTourist_no());
        employee = employeeService.getEmployee(employee);
        response.setContentType("text/html;charset=utf-8");
        if(employee==null){
            response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('账号不存在'));" +
                    "window.location.href='gotoEmployeeLogin';</script>");
        }else {
            Tourist existTourist = touristService.getLoginTourist(tourist);
            if(existTourist!=null){
                session.setAttribute("employee",employee);
                response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('登录成功'));" +
                        "window.location.href='gotoEmployeeHome';</script>");
                response.sendRedirect("gotoEmployeeHome");
            }else {
                response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('账号或密码错误'));" +
                        "window.location.href='gotoEmployeeLogin';</script>");
            }
        }
    }

    @RequestMapping("/manageEmployee")
    public String manageEmployee(HttpSession session)throws Exception{
        List<Department> departmentPosition = departmentService.getDepartmentsAndPosition();
        session.setAttribute("departmentPosition",departmentPosition);
        /*List<Position>  positionEmployee = positionService.getPositionEmployee();
        session.setAttribute("positionEmployee",positionEmployee);*/
        List<Employee> employees = employeeService.getEmployees();
        session.setAttribute("employees",employees);
        for (Employee emp :employees) {
            System.out.println(emp);
        }
        return "manageEmployee";
    }

    @RequestMapping("/hireEmployee")
    public void hireEmployee(Position position,HttpSession session,HttpServletResponse response)throws Exception{
        response.setContentType("text/html;charset=utf-8");
        Apply hireApply = (Apply) session.getAttribute("hireApply");
        Resume resume = new Resume();
        resume.setResume_no(hireApply.getResume_no());
        resume = resumeService.getResume(resume);
        Employee employee = new Employee();
        employee.setE_name(resume.getTourist_name());
        employee.setBirthday(resume.getBirthday());
        employee.setGender(resume.getGender());
        employee.setPhone(resume.getPhone());
        employee.setEmail(resume.getEmail());
        employee.setPos_no(position.getPos_no());
        employee.setGrade("0");
        SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
        employee.setEntry_time(format.format(new Date()));
        employee.setId_no(resume.getId_no());
        employee.setEducation(resume.getEducation());
        employee.setState("试用期");
        System.out.println(employee);
        if(employeeService.addEmployee(employee)){
            response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('录用入职成功'));" +
                    "window.location.href='browseApplyResume?recruit_no="+hireApply.getRecruit_no()+"';</script>");
        }else {
            response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('录用入职失败，请重试'));" +
                    "window.location.href='browseApplyResume?recruit_no="+hireApply.getRecruit_no()+"';</script>");

        }
    }

    @RequestMapping("/changeGrade")
    public void changeGrade(Employee employee,HttpServletResponse response)throws Exception{
        response.setContentType("text/html;charset=utf-8");
        if (employeeService.updateChangeGrade(employee)){
            response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('调级成功'));" +
                    "window.location.href='manageEmployee?';</script>");
        }else {
            response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('调级失败，请重试'));" +
                    "window.location.href='manageEmployee?';</script>");

        }
    }

    @RequestMapping("/changePosition")
    public String changePosition(Employee employee ,HttpSession session)throws Exception{
        session.setAttribute("changePositionEmployee",employee);
        return "changePosition";
    }

    @RequestMapping("/confirmPosition")
    public void confirmPosition(Position position ,HttpSession session,HttpServletResponse response)throws Exception{
        response.setContentType("text/html;charset=utf-8");
        Employee changePositionEmployee = (Employee) session.getAttribute("changePositionEmployee");
        changePositionEmployee.setPos_no(position.getPos_no());
        if(employeeService.updateChangePosition(changePositionEmployee)){
            response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('调职成功'));" +
                    "window.location.href='manageEmployee?';</script>");
        }else {
            response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('调职失败，请重试'));" +
                    "window.location.href='manageEmployee?';</script>");
        }
    }

    @RequestMapping("/dimission")
    public void dimission(Employee employee ,HttpSession session,HttpServletResponse response)throws Exception{
        response.setContentType("text/html;charset=utf-8");
        SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
        employee.setDimission_time(format.format(new Date()));
        if(employeeService.updateDimission(employee)){
            response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('离职操作成功'));" +
                    "window.location.href='manageEmployee';</script>");
        }else {
            response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('离职操作失败，请重试'));" +
                    "window.location.href='manageEmployee';</script>");
        }
    }
}
