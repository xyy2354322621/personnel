package com.xyy.controller;

import com.xyy.biz.*;
import com.xyy.model.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by xiyueyang on 2018/4/27 0027.
 */
@Controller
public class AttendanceController {
    @Resource
    private AttendanceService attendanceService;

    @Resource
    private EmployeeService employeeService;

    @Resource
    private DepartmentService departmentService;

    @Resource
    private BasicParamService basicParamService;

    @Resource
    private PositionService positionService;

    @Resource
    private RewardAanPunishService rewardAanPunishService;

    @RequestMapping("manageAttendance")
    public String manageAttendance( Model model, HttpSession session)throws Exception{
        SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-dd");
        String date = format.format(new Date());
        session.setAttribute("curDate",date);
        List<Attendance> attendances = attendanceService.getTodayAttendance();
        model.addAttribute(attendances);
        List<Department> departmentPosition = departmentService.getDepartmentsAndPosition();
        session.setAttribute("departmentPosition",departmentPosition);
        return "manageAttendance";
    }

    @RequestMapping("/createTodayAttendance")
    public void createTodayAttendance(HttpServletResponse response)throws Exception{
        SimpleDateFormat format= new SimpleDateFormat("YYYY-MM-dd");
        Date date = new Date();
        String today = format.format(date);

        List<Attendance> attendances = attendanceService.getTodayAttendance();
        List<Employee> employees = employeeService.getNormalEmployees();

        List<Employee> attendEmployees = new ArrayList<>();
        for (Attendance ad : attendances) {
            for (Employee emp: employees) {
                System.out.println(emp);
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

    @RequestMapping("createThisMonthAttendance")
    public void createThisMonthAttendance(HttpServletResponse response)throws Exception{
        SimpleDateFormat format= new SimpleDateFormat("YYYY-MM");
        Date date = new Date();
        String moth = format.format(date);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int days = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        String thisDay = null;
        boolean success = false;
        for (int i=1;i<=days;i++){
            if (i<10){
                thisDay = moth+"-0"+i;
            }else {
                thisDay = moth+"-"+i;
            }
            if(createThisDayAttendance(thisDay)) {
                success = true;
            }else {
                success = false;
                break;
            }
        }
        if (success){
            response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('当月考勤生成成功'));" +
                    "window.location.href='manageAttendance';</script>");
        }else {
            response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('部分当月考勤生成失败，请重试'));" +
                    "window.location.href='manageAttendance';</script>");
        }
    }

    private boolean createThisDayAttendance(String date)throws Exception{
        List<Attendance> attendances = attendanceService.getThisDateAttendance(date);
        List<Employee> employees = employeeService.getNormalEmployees();
        List<Employee> attendEmployees = new ArrayList<>();
        for (Attendance ad : attendances) {
            for (Employee emp: employees) {
                System.out.println(emp);
                if (ad.getE_id().equals(emp.getE_id())){
                    attendEmployees.add(emp);
                    break;
                }
            }
        }
        employees.removeAll(attendEmployees);
        if (employees.size()>0){
           return attendanceService.addThisDayAttendance(employees,date);
        }else {
            return true;
        }
    }

    @RequestMapping("createNextMonthAttendance")
    public void createNextMonthAttendance(HttpServletResponse response)throws Exception{
        SimpleDateFormat format= new SimpleDateFormat("YYYY-MM");
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH,1);
        Date date = calendar.getTime();
        String nextMoth = format.format(date);
        int days = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        String thisDay = null;
        boolean success = false;
        for (int i=1;i<=days;i++){
            if (i<10){
                thisDay = nextMoth+"-0"+i;
            }else {
                thisDay = nextMoth+"-"+i;
            }
            if(createThisDayAttendance(thisDay)) {
                success = true;
            }else {
                success = false;
                break;
            }
        }
        if (success){
            response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('下月考勤生成成功'));" +
                    "window.location.href='manageAttendance';</script>");
        }else {
            response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('部分下月考勤生成失败，请重试'));" +
                    "window.location.href='manageAttendance';</script>");
        }
    }

    @RequestMapping("/vacationSet")
    public String vacationSet(Attendance attendance,Model model)throws Exception{
        model.addAttribute(attendance);
        return "vacationSet";
    }

    @RequestMapping("vacationUpdate")
    public void vacationUpdate(Attendance attendance,String vacation,String time,HttpServletResponse response)throws Exception{
        int vacationTime = Integer.parseInt(time);
        if (attendanceService.updateVacation(attendance,vacation,vacationTime)){
            response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('假期设置成功'));" +
                    "window.location.href='manageAttendance';</script>");
        }else {
            response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('假期设置失败，请重试'));" +
                    "window.location.href='manageAttendance';</script>");
        }
    }

    @RequestMapping("/browseThisDateAttendance")
    public String browseThisDateAttendance(String date,Model model,HttpSession session)throws Exception{

        List<Department> departmentPosition = departmentService.getDepartmentsAndPosition();
        session.setAttribute("departmentPosition",departmentPosition);
        if (date==null) {
            List<Attendance> attendances = attendanceService.getTodayAttendance();
            model.addAttribute(attendances);
        }else {
            session.setAttribute("curDate",date);
            List<Attendance> attendances = attendanceService.getThisDateAttendance(date);
            model.addAttribute(attendances);
        }
        return "manageAttendance";
    }

    @RequestMapping("/setPublicVacation")
    public void setPublicVacation(String date,HttpSession session,HttpServletResponse response)throws Exception{
        String curDate = (String) session.getAttribute("curDate");
        if (attendanceService.setPublicVacation(date)){
            response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('法定假日设置成功'));" +
                    "window.location.href='browseThisDateAttendance?date="+curDate+"';</script>");
        }else {
            response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('法定假日设置失败，请重试'));" +
                    "window.location.href='browseThisDateAttendance?date="+curDate+"';</script>");
        }
       /* if(date!=null){
            response.getWriter().write("<script language='javascript'>if( confirm(decodeURIComponent('设为法定假日则其他请假记录将被覆盖\\n是否继续？'))){" +
                    "window.location.href ='confirmSetPublicVacation?date="+date+"';}else {window.location.href ='browseThisDateAttendance?date="+curDate+"';} </script>");


        }else {
            response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('请先选择日期'));" +
                    "window.location.href='browseThisDateAttendance?date="+curDate+"';</script>");
        }*/
    }
    @RequestMapping("/confirmSetPublicVacation")
    public void confirmSetPublicVacation(String date,HttpSession session,HttpServletResponse response)throws Exception {
        String curDate = (String) session.getAttribute("curDate");
        if (attendanceService.setPublicVacation(date)){
            response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('公假日设置成功'));" +
                    "window.location.href='browseThisDateAttendance?date="+curDate+"';</script>");
        }else {
            response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('公假日设置失败，请重试'));" +
                    "window.location.href='browseThisDateAttendance?date="+curDate+"';</script>");
        }
    }

    @RequestMapping("updateCancerPublicVacation")
    public void updateCancerPublicVacation(String date,HttpSession session,HttpServletResponse response)throws Exception{
       response.setContentType("text/html;charset=utf-8");
        String curDate = (String) session.getAttribute("curDate");
        if(date!=null){
            if (attendanceService.updateCancerPublicVacation(date)){
                response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('公假日取消成功'));" +
                        "window.location.href='browseThisDateAttendance?date="+curDate+"';</script>");
            }else {
                response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('公假日取消失败，请重试'));" +
                        "window.location.href='browseThisDateAttendance?date="+curDate+"';</script>");
            }
        }else {
            response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('请先选择日期'));" +
                    "window.location.href='browseThisDateAttendance?date="+curDate+"';</script>");
        }
    }

    @RequestMapping("/clockIn")
    public void clockIn(String date,HttpSession session,HttpServletResponse response)throws Exception{
        response.setContentType("text/html;charset=utf-8");
        Employee employee = (Employee) session.getAttribute("employee");
        Attendance myAttendance = attendanceService.getMyAttendance(employee);
        boolean update = false;
        if (myAttendance==null) {
            if (attendanceService.addClockIn(employee)) {
                update = updateClockIn(session);
            }
        }else {
            update = updateClockIn(session);
        }
        if(update){
            response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('上班打卡成功'));" +
                    "window.location.href='gotoEmployeeHome';</script>");
        }else {
                response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('上班打卡失败，请重试'));" +
                        "window.location.href='gotoEmployeeHome';</script>");
        }
    }

    private boolean updateClockIn(HttpSession session) throws Exception{
        Employee employee = (Employee) session.getAttribute("employee");
        employee = employeeService.getEmployee(employee);
        Attendance myAttendance = attendanceService.getMyAttendance(employee);
        BasicParam basicParam = basicParamService.getBasicParam();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        Date now = new Date();
        myAttendance.setAttend_time(timeFormat.format(now));
        Date attendTime = format.parse(myAttendance.getDate()+" "+basicParam.getB_attend_time());
        int timeGap = (int) ((now.getTime()-attendTime.getTime())/(1000*60));
        myAttendance.setAbsenteeism(0);
        if(timeGap<=0){
            myAttendance.setBe_late(0);
//            myAttendance.setAbsenteeism(0);
            return attendanceService.updateClockIn(myAttendance);
        }else {
            myAttendance.setBe_late(timeGap);
            RewardAanPunish rewardAanPunish = new RewardAanPunish();
            rewardAanPunish.setE_id(employee.getE_id());
            rewardAanPunish.setType("惩罚");
            rewardAanPunish.setTime(format.format(now));
            rewardAanPunish.setReason("上班迟到"+timeGap+"分钟");
            rewardAanPunish.setExist(1);
            double punishMoney = basicParam.getB_unit_penalty()*timeGap;
            Position position = positionService.getEmpPosition(employee);
            double daySalary = position.getBasic_salary()/basicParam.getB_workdays_month();
            if (punishMoney<=daySalary) rewardAanPunish.setMoney(punishMoney);
            else rewardAanPunish.setMoney(daySalary);
            if (Math.abs(timeGap)>basicParam.getB_attend_time_limit()){
//                myAttendance.setAbsenteeism(1);
                rewardAanPunish.setReason("上班迟到"+timeGap+"分钟，超过规定的时长："+basicParam.getB_attend_time_limit()+"分钟");
                rewardAanPunish.setMoney(daySalary);
            }
            if (rewardAanPunishService.addRewardPunish(rewardAanPunish)){
                return attendanceService.updateClockIn(myAttendance);
            }else {
                return false;
            }
        }
    }

    @RequestMapping("clockOut")
    public void clockOut(String date,HttpSession session,HttpServletResponse response)throws Exception{
        response.setContentType("text/html;charset=utf-8");
        Employee employee = (Employee) session.getAttribute("employee");
        Attendance myAttendance = attendanceService.getMyAttendance(employee);
        boolean update = false;
        if (myAttendance==null) {
            if (attendanceService.addMyAttendance(employee)) {
                update = updateClockOut(session);
            }
        }else {
            update = updateClockOut(session);
        }
        if(update){
            response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('下班打卡成功'));" +
                    "window.location.href='gotoEmployeeHome';</script>");
        }else {
            response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('下班打卡失败，请重试'));" +
                    "window.location.href='gotoEmployeeHome';</script>");
        }
    }
    private boolean updateClockOut(HttpSession session) throws Exception{
        Employee employee = (Employee) session.getAttribute("employee");
        employee = employeeService.getEmployee(employee);
        Attendance myAttendance = attendanceService.getMyAttendance(employee);
        BasicParam basicParam = basicParamService.getBasicParam();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        Date now = new Date();
        myAttendance.setLeave_time(timeFormat.format(now));
        Date leaveTime = format.parse(myAttendance.getDate()+" "+basicParam.getB_leave_time());
        int timeGap = (int) ((now.getTime()-leaveTime.getTime())/(1000*60));
        myAttendance.setAbsenteeism(0);
        if(timeGap>=0){
            myAttendance.setLeave_early(0);
            RewardAanPunish todayLeaveEarlyPunish = rewardAanPunishService.getEmpTodayLeaveEarlyPunish(employee);
            if (todayLeaveEarlyPunish!=null){
                if (rewardAanPunishService.deleteRewardPunish(todayLeaveEarlyPunish)){
                    if (timeGap>basicParam.getB_overtime_limit()){
                        myAttendance.setOvertime(timeGap);
                        RewardAanPunish ovrTime = rewardAanPunishService.getEmpTodayOvertime(employee);
                        if (ovrTime==null) {
                            ovrTime = new RewardAanPunish();
                            ovrTime.setE_id(employee.getE_id());
                            ovrTime.setType("加班");
                            ovrTime.setTime(format.format(now));
                            setOvertimeReward(timeGap,ovrTime,session,myAttendance);
                            if (rewardAanPunishService.addRewardPunish(ovrTime)) {
                                return attendanceService.updateClockOut(myAttendance);
                            } else {
                                return false;
                            }
                        }else {
                            ovrTime.setTime(format.format(now));
                            setOvertimeReward(timeGap,ovrTime,session,myAttendance);
                            if(rewardAanPunishService.updateRewardPunish(ovrTime)){
                                return attendanceService.updateClockOut(myAttendance);
                            }else {
                                return false;
                            }
                        }
                    }else {
                        return attendanceService.updateClockOut(myAttendance);
                    }
                }else return false;
            }else {
                if (timeGap>basicParam.getB_overtime_limit()){
                    myAttendance.setOvertime(timeGap);
                    RewardAanPunish ovrTime = rewardAanPunishService.getEmpTodayOvertime(employee);
                    if (ovrTime==null) {
                        ovrTime = new RewardAanPunish();
                        ovrTime.setE_id(employee.getE_id());
                        ovrTime.setType("加班");
                        ovrTime.setTime(format.format(now));
                        setOvertimeReward(timeGap,ovrTime,session,myAttendance);
                        if (rewardAanPunishService.addRewardPunish(ovrTime)) {
                            return attendanceService.updateClockOut(myAttendance);
                        } else {
                            return false;
                        }
                    }else {
                        ovrTime.setTime(format.format(now));
                        setOvertimeReward(timeGap,ovrTime,session,myAttendance);
                        if(rewardAanPunishService.updateRewardPunish(ovrTime)){
                            return attendanceService.updateClockOut(myAttendance);
                        }else {
                            return false;
                        }
                    }
                }else {
                    return attendanceService.updateClockOut(myAttendance);
                }
            }
        }else {
            timeGap = Math.abs(timeGap);
            myAttendance.setLeave_early(timeGap);
            RewardAanPunish todayBeLatePunish = rewardAanPunishService.getEmpTodayBeLatePunish(employee);
            RewardAanPunish todayLeaveEarlyPunish = rewardAanPunishService.getEmpTodayLeaveEarlyPunish(employee);
            if (todayLeaveEarlyPunish==null){
                System.out.println("第一次");
                todayLeaveEarlyPunish = new RewardAanPunish();
                todayLeaveEarlyPunish.setE_id(employee.getE_id());
                todayLeaveEarlyPunish.setType("惩罚");
                todayLeaveEarlyPunish.setTime(format.format(now));
                todayLeaveEarlyPunish.setExist(1);
                setLeaveEarlyPunishMoney(timeGap,session,todayLeaveEarlyPunish, myAttendance);
                if (rewardAanPunishService.addRewardPunish(todayLeaveEarlyPunish)){
                    return attendanceService.updateClockOut(myAttendance);
                }else {
                    return false;
                }
            }else {
                System.out.println("迟到");
                todayLeaveEarlyPunish.setTime(format.format(now));
                todayLeaveEarlyPunish.setExist(1);
                setLeaveEarlyPunishMoney(timeGap,session,todayLeaveEarlyPunish,myAttendance);
                if (rewardAanPunishService.updateRewardPunish(todayLeaveEarlyPunish)){
                    return attendanceService.updateClockOut(myAttendance);
                }else {
                    return false;
                }
            }
        }
    }

    private void setOvertimeReward(int timeGap, RewardAanPunish ovrTime, HttpSession session, Attendance myAttendance) throws ParseException {
        Employee employee = (Employee) session.getAttribute("employee");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        BasicParam basicParam = basicParamService.getBasicParam();
        Date leaveTime = format.parse(myAttendance.getDate()+" "+basicParam.getB_leave_time());
        ovrTime.setReason("当日加班" + timeGap + "分钟");
        ovrTime.setExist(1);
        Date attendTime = format.parse(myAttendance.getDate() + " " + basicParam.getB_attend_time());
        Position position = positionService.getEmpPosition(employee);
        long workMinuter = (leaveTime.getTime() - attendTime.getTime()) / (1000 * 60);
        double daySalary = position.getBasic_salary() / basicParam.getB_workdays_month();
        double minuterSalary = daySalary / workMinuter;
        double overtimeMoney = minuterSalary * timeGap * basicParam.getB_overtime_reward_radio() / 100;
        ovrTime.setMoney(overtimeMoney);
    }

    private void setLeaveEarlyPunishMoney(int timeGap, HttpSession session, RewardAanPunish todayLeaveEarlyPunish, Attendance myAttendance){
        Employee employee = (Employee) session.getAttribute("employee");
        RewardAanPunish todayBeLatePunish = rewardAanPunishService.getEmpTodayBeLatePunish(employee);
        BasicParam basicParam = basicParamService.getBasicParam();
        double punishMoney = timeGap*basicParam.getB_unit_penalty();
        Position position = positionService.getEmpPosition(employee);
        double daySalary = position.getBasic_salary()/basicParam.getB_workdays_month();
        if (todayBeLatePunish==null){
            if (punishMoney<=daySalary) {
                System.out.println("1");
                todayLeaveEarlyPunish.setMoney(punishMoney);
                todayLeaveEarlyPunish.setReason("下班早退"+timeGap+"分钟");

            }else {
                System.out.println("2");

                todayLeaveEarlyPunish.setMoney(daySalary);
                todayLeaveEarlyPunish.setReason("下班早退"+timeGap+"分钟，应罚款金额："+
                        punishMoney+"超过当日工资，所以罚金为当日工资额");
            }
            if (timeGap>basicParam.getB_leave_time_limit()){
                System.out.println("3");

//                myAttendance.setAbsenteeism(1);
                todayLeaveEarlyPunish.setReason("下班早退"+timeGap+"分钟，超过规定的时长："+
                        basicParam.getB_leave_time_limit()+"分钟,罚金为当日工资额");
                todayLeaveEarlyPunish.setMoney(daySalary);
            }
        }else {
            if ((punishMoney+todayBeLatePunish.getMoney())<=daySalary) {
                System.out.println("4");

                todayLeaveEarlyPunish.setMoney(punishMoney);
                todayLeaveEarlyPunish.setReason("下班早退"+timeGap+"分钟");
            }else {
                System.out.println("5");

                todayLeaveEarlyPunish.setMoney(daySalary-todayBeLatePunish.getMoney());
                todayLeaveEarlyPunish.setReason("下班早退"+timeGap+"分钟，应罚金额："+
                        punishMoney+" 加上当日迟到的罚款金额："+todayBeLatePunish.getMoney()+
                        " 超过当日工资，所以罚金为当日工资额减去当日迟到处罚的罚款金额");
            }
            if (timeGap>basicParam.getB_leave_time_limit()){
                System.out.println("6");

//                myAttendance.setAbsenteeism(1);
                todayLeaveEarlyPunish.setReason("下班早退"+timeGap+"分钟，超过规定的时长："+
                        basicParam.getB_leave_time_limit()+"分钟,应罚款金额为当日工资，" +
                        "实际罚款金额为当日工资减去当日迟到处罚的罚款金额");
                todayLeaveEarlyPunish.setMoney(daySalary-todayBeLatePunish.getMoney());
            }
        }
//        return todayLeaveEarlyPunish;
    }

    @RequestMapping("browseMyAttendance")
    public String browseMyAttendance(String month,Model model,HttpSession session,HttpServletResponse response)throws Exception {
        Employee employee = (Employee) session.getAttribute("employee");
        if (month==null){
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
            month = format.format(new Date());
        }
        List<Attendance> myAttendances = attendanceService.getMyThisMonthAttendances(employee,month);
        model.addAttribute("myAttendances",myAttendances);
        session.setAttribute("curMonth",month);
        return "browseMyAttendance";
    }

    @RequestMapping("tidyCurMonthAttendance")
    public void tidyCurMonthAttendance(HttpServletResponse response)throws Exception{
        SimpleDateFormat monthFormat = new SimpleDateFormat("yyyy-MM");
        Date now = new Date();
        String curMonth = monthFormat.format(now);
        if(tidyThisMonthAttendance(curMonth)){
            response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('今日之前的当月考勤整理成功'));" +
                    "window.location.href='manageAttendance';</script>");
        }else {
            response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('部分员工的当月考勤整理失败，请重试'));" +
                    "window.location.href='manageAttendance';</script>");
        }
    }

    private boolean tidyThisMonthAttendance(String month)throws Exception{
        SimpleDateFormat monthFormat = new SimpleDateFormat("yyyy-MM");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date thisMonthFirstDay = monthFormat.parse(month);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(thisMonthFirstDay);
        int thisMonthDays = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        String date = "";
        List<Employee> thisMonthOnPosEmployees = employeeService.getThisMonthOnJobEmployees(month);
        for (Employee employee : thisMonthOnPosEmployees){
            for (int i=1;i<=thisMonthDays;i++){
                if (i<10){
                    date = month+"-0"+i;
                }else {
                    date = month+"-"+i;
                }
                Date now = new Date();
                Date thisDay = dateFormat.parse(date);
                if (now.getTime()>thisDay.getTime()) {
                    Attendance empThisDateAttendance = attendanceService.getEmpThisDateAttendance(employee, date);
                    if (empThisDateAttendance!=null) {
                        if (empThisDateAttendance.getAttend_time() == null || empThisDateAttendance.getLeave_time() == null) {
                            empThisDateAttendance.setAbsenteeism(1);
                            System.out.println(date);
                            if (!attendanceService.updateAttendance(empThisDateAttendance)) return false;
                        }
                    }
                }else {
                    break;
                }
            }
        }
        return true;
    }

    @RequestMapping("tidyPrevMonthAttendance")
    public void tidyPrevMonthAttendance(HttpServletResponse response)throws Exception{
        SimpleDateFormat monthFormat = new SimpleDateFormat("yyyy-MM");
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH,-1);
        Date prevMonthDay = calendar.getTime();
        String prevMonth = monthFormat.format(prevMonthDay);
        if(tidyThisMonthAttendance(prevMonth)){
            response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('上月考勤整理成功'));" +
                    "window.location.href='manageAttendance';</script>");
        }else {
            response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('部分员工的上月考勤整理失败，请重试'));" +
                    "window.location.href='manageAttendance';</script>");
        }
    }

}
