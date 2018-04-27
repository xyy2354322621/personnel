package com.xyy.controller;

import com.xyy.biz.AttendanceService;
import com.xyy.biz.EmployeeService;
import com.xyy.model.Attendance;
import com.xyy.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by xiyueyang on 2018/4/27 0027.
 */
@Controller
public class AttendanceController {
    @Resource
    private AttendanceService attendanceService;

    @Resource
    private EmployeeService employeeService;

    @RequestMapping("/manageAttendance")
    public String manageAttendance(Model model)throws Exception{
        List<Attendance> attendances = attendanceService.getTodayAttendance();
        model.addAttribute(attendances);
        return "manageAttendance";
    }

    @RequestMapping("/createTodayAttendance")
    public void createTodayAttendance(HttpServletResponse response)throws Exception{
        List<Attendance> attendances = attendanceService.getTodayAttendance();
        List<Employee> employees = employeeService.getNormalEmployees();
        List<Employee> attendEmployees = new ArrayList<>();
        for (Attendance ad : attendances) {
            for (Employee emp: employees) {
                if (ad.getE_id().equals(emp.getE_id())){
                    attendEmployees.add(emp);
                    break;
                }
            }
        }
        employees.removeAll(attendEmployees);
        if (employees.size()>0){
            if(attendanceService.addTodayAttendance(employees)){
                response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('今日考勤生成成功'));" +
                        "window.location.href='manageAttendance';</script>");
            }else {
                response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('部分今日考勤生成失败，请重试'));" +
                        "window.location.href='manageAttendance';</script>");
            }
        }else {
            response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('所有在职员工的今日考勤都已生成，无需再生成'));" +
                    "window.location.href='manageAttendance';</script>");
        }

    }

    @RequestMapping("/createTomorrowAttendance")
    public void createTomorrowAttendance(HttpServletResponse response)throws Exception{
        List<Attendance> attendances = attendanceService.getTomorrowAttendance();
        List<Employee> employees = employeeService.getNormalEmployees();
        List<Employee> attendEmployees = new ArrayList<>();
        for (Attendance ad : attendances) {
            for (Employee emp: employees) {
                if (ad.getE_id().equals(emp.getE_id())){
                    attendEmployees.add(emp);
                    break;
                }
            }
        }
        employees.removeAll(attendEmployees);
        if (employees.size()>0){
            if(attendanceService.addTomorrowAttendance(employees)){
                response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('明日考勤生成成功'));" +
                        "window.location.href='manageAttendance';</script>");
            }else {
                response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('部分明日考勤生成失败，请重试'));" +
                        "window.location.href='manageAttendance';</script>");
            }
        }else {
            response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('所有在职员工的明日考勤都已生成，无需再生成'));" +
                    "window.location.href='manageAttendance';</script>");
        }

    }
}
