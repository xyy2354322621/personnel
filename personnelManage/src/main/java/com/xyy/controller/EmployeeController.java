package com.xyy.controller;

import com.xyy.biz.EmployeeService;
import com.xyy.biz.ResumeService;
import com.xyy.biz.TouristService;
import com.xyy.model.Employee;
import com.xyy.model.Position;
import com.xyy.model.Resume;
import com.xyy.model.Tourist;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
        List<Employee> employees = employeeService.getEmployees();
        session.setAttribute("employees",employees);
        return "manageEmployee";
    }

    @RequestMapping("/hireEmployee")
    public void hireEmployee(Position position,HttpServletResponse response)throws Exception{
//        Resume resume =
    }
}
