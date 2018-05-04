package com.xyy.controller;

import com.xyy.biz.*;
import com.xyy.model.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
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

    @Resource
    private ApplyService applyService;

    @Resource
    private RecruitService recruitService;

    @Resource
    private AttendanceService attendanceService;

    @Resource
    private BasicParamService basicParamService;

    @Resource
    private TrainRecordService trainRecordService;

    @RequestMapping("/gotoEmployeeLogin")
    public String gotoEmployeeLogin()throws Exception{
        return "employeeLogin";
    }

    @RequestMapping("/gotoEmployeeHome")
    public String gotoEmployeeHome(HttpSession session)throws Exception{
        Employee employee = (Employee) session.getAttribute("employee");
        Attendance myAttendance = attendanceService.getMyAttendance(employee);
        BasicParam basicParam = basicParamService.getBasicParam();
        int clockIn;
        int clockOut;
        if (myAttendance==null || myAttendance.getAttend_time()==null){
            clockIn=0;
        }else{
            clockIn=1;
        }
        if (myAttendance==null || myAttendance.getLeave_time()==null){
            clockOut=0;
        }else{
            clockOut=1;
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat timeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date now = new Date();
        String today = dateFormat.format(now);
        Date leaveTime = timeFormat.parse(today+" 12:00");
        long leaveTimeGap = now.getTime()-leaveTime.getTime();
        List<TrainRecord> trainRecords = trainRecordService.getEmpTrainRecord(employee);
        int train = 1;
        if (trainRecords.size()>0){
            for (TrainRecord trainRecord:trainRecords){
                if (trainRecord.getScan()==0){
                    train=0;
                    break;
                }
            }
        }
        session.setAttribute("train",train);
        session.setAttribute("leaveTimeGap",leaveTimeGap);
        session.setAttribute("clockIn",clockIn);
        session.setAttribute("clockOut",clockOut);
        return "employeeHome";
    }

    @RequestMapping("/employeeLogin")
    public void employeeLogin(Tourist tourist, HttpSession session, HttpServletResponse response)throws Exception{
        Employee employee = new Employee();
        employee.setE_id(tourist.getTourist_no());
        employee = employeeService.getEmployee(employee);
        response.setContentType("text/html;charset=utf-8");
        GregorianCalendar ca = new GregorianCalendar();
        int am_pm = ca.get(GregorianCalendar.AM_PM);
        session.setAttribute("am_pm",am_pm);
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
        List<Employee> employees = employeeService.getEmployees();
        session.setAttribute("employees",employees);
        return "manageEmployee";
    }

    @RequestMapping("/hireApply")
    public String hireApply(Apply apply, HttpSession session)throws Exception{
        applyService.updateSetHireApply(apply);
        apply = applyService.getApply(apply);
        session.setAttribute("hireApply",apply);
        List<Department> departmentPosition = departmentService.getDepartmentsAndPosition();
        session.setAttribute("departmentPosition",departmentPosition);
        return "assignPosition";
    }

    @RequestMapping("/hireEmployee")
    public void hireEmployee(Apply hireApply,HttpSession session,HttpServletResponse response)throws Exception{
        response.setContentType("text/html;charset=utf-8");
        applyService.updateSetHireApply(hireApply);
        Resume resume = new Resume();
        resume.setResume_no(hireApply.getResume_no());
        resume = resumeService.getResume(resume);
        Recruit recruit = new Recruit();
        recruit.setRecruit_no(hireApply.getRecruit_no());
        recruit =recruitService.getRecruit(recruit);
        Employee employee = new Employee();
        employee.setE_name(resume.getTourist_name());
        employee.setBirthday(resume.getBirthday());
        employee.setGender(resume.getGender());
        employee.setPhone(resume.getPhone());
        employee.setEmail(resume.getEmail());
        employee.setPos_no(recruit.getPos_no());
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

    @RequestMapping("/changeToNormal")
    public void changeToNormal(Employee employee,HttpServletResponse response)throws Exception{
        response.setContentType("text/html;charset=utf-8");
        if (employeeService.updateChangeToNormal(employee)){
            response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('转正成功'));" +
                    "window.location.href='manageEmployee?';</script>");
        }else {
            response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('转正失败，请重试'));" +
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
        changePositionEmployee = employeeService.getEmployee(changePositionEmployee);
        ChangePos changePos = new ChangePos();
        changePos.setE_id(changePositionEmployee.getE_id());
        changePos.setOrigin_pos(changePositionEmployee.getPos_no());
        changePos.setNew_pos(position.getPos_no());
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        changePos.setChange_date(format.format(new Date()));
        changePositionEmployee.setPos_no(position.getPos_no());
        if (employeeService.addChangePos(changePos)) {
            if (employeeService.updateChangePosition(changePositionEmployee)) {
                response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('调职成功'));" +
                        "window.location.href='manageEmployee?';</script>");
            } else {
                response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('调职失败，请重试'));" +
                        "window.location.href='manageEmployee?';</script>");
            }
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

    @RequestMapping("positionEmployee")
    public String positionEmployee(Position position,HttpSession session){
        List<Employee> positionEmployees = employeeService.getPositionEmployees(position);
        session.setAttribute("positionEmployees",positionEmployees);
        return "positionEmployee";
    }

    @RequestMapping("posEmployee")
    public String posEmployee(Position position,HttpSession session){
        List<Employee> positionEmployees = employeeService.getPositionEmployees(position);
        session.setAttribute("positionEmployees",positionEmployees);
        return "posEmployee";
    }

    @RequestMapping("/departEmployee")
    public String departEmployee(Department department,HttpSession session){
        List<Employee> departEmployees = employeeService.getDepartEmployees(department);
        session.setAttribute("departEmployees",departEmployees);
        return "departEmployees";
    }

    @RequestMapping("/chooseEmpToTrain")
    public String chooseEmpToTrain(Train train, HttpSession session, Model model)throws Exception{
        model.addAttribute(train);
        List<Department> departmentPosition = departmentService.getDepartmentsAndPosition();
        session.setAttribute("departmentPosition",departmentPosition);
        List<Employee> employees = employeeService.getEmployees();
        List<Employee> joinEmployees = employeeService.getJoinTrainEmployees(train);
        List<Employee> empList = new ArrayList<>();
        for (Employee emp :employees) {
            for (Employee joinEmp :joinEmployees) {
                if (emp.getE_id().equals(joinEmp.getE_id())){
                    empList.add(emp);
                }
            }
        }
        employees.removeAll(empList);
        session.setAttribute("TrainEmployees",employees);
        return "chooseEmpToTrain";
    }

    @RequestMapping("/browseEmpJoinTrain")
    public String browseEmpJoinTrain(Train train, HttpSession session, Model model)throws Exception{
        model.addAttribute(train);
        List<Department> departmentPosition = departmentService.getDepartmentsAndPosition();
        session.setAttribute("departmentPosition",departmentPosition);
        List<Employee> joinEmployees = employeeService.getJoinTrainEmployees(train);
        session.setAttribute("joinEmployees",joinEmployees);
        return "browseEmpJoinTrain";
    }
}
