package com.xyy.controller;

import com.xyy.biz.AttendApplyService;
import com.xyy.biz.AttendanceService;
import com.xyy.biz.BasicParamService;
import com.xyy.model.AttendApply;
import com.xyy.model.Attendance;
import com.xyy.model.BasicParam;
import com.xyy.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by xiyueyang on 2018/4/28 0028.
 */
@Controller
public class AttendApplyController {

    @Resource
    private AttendApplyService attendApplyService;

    @Resource
    private AttendanceService attendanceService;

    @Resource
    private BasicParamService basicParamService;

    @RequestMapping("forgetClockIn")
    public void forgetClockIn(Attendance attendance, HttpSession session, HttpServletResponse response)throws Exception{
        attendance = attendanceService.getAttendance(attendance);
        String month = (String) session.getAttribute("curMonth");
        SimpleDateFormat timeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        BasicParam basicParam = basicParamService.getBasicParam();
        Date now = new Date();
        Date attendanceDate = timeFormat.parse(attendance.getDate()+" "+basicParam.getB_attend_time());
        if (now.getTime()-attendanceDate.getTime()>0) {
            AttendApply myAttendApply = attendApplyService.getMyAttendApply(attendance);
            System.out.println(month);
            if (myAttendApply == null) {
                myAttendApply = new AttendApply();
                myAttendApply.setAttend_no(attendance.getAttend_no());
                myAttendApply.setForget_clock_in("上班忘打卡");
//            myAttendApply.setApprove("未审批");
                if (attendApplyService.addAttendApply(myAttendApply)) {
                    response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('上班忘打卡申请成功，等待审批'));" +
                            "window.location.href='browseMyAttendance?month=" + month + "';</script>");
                } else {
                    response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('上班忘打卡申请失败，请重试'));" +
                            "window.location.href='browseMyAttendance?month=" + month + "';</script>");
                }
            } else {
                if (!"上班忘打卡".equals(myAttendApply.getForget_clock_in())) {
                    myAttendApply.setForget_clock_in("上班忘打卡");
                    if (attendApplyService.updateAttendApply(myAttendApply)) {
                        response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('上班忘打卡申请成功，等待审批'));" +
                                "window.location.href='browseMyAttendance?month=" + month + "';</script>");
                    } else {
                        response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('上班忘打卡申请失败，请重试'));" +
                                "window.location.href='browseMyAttendance?month=" + month + "';</script>");
                    }
                } else {
                    response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('您已提交过申请，无需重复申请'));" +
                            "window.location.href='browseMyAttendance?month=" + month + "';</script>");
                }
            }
        }else {
            response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('尚未到该日期的上班时间，不可申请'));" +
                    "window.location.href='browseMyAttendance?month=" + month + "';</script>");

        }
    }

    @RequestMapping("forgetClockOut")
    public void forgetClockOut(Attendance attendance, HttpSession session, HttpServletResponse response)throws Exception{
        AttendApply myAttendApply = attendApplyService.getMyAttendApply(attendance);
        String month = (String) session.getAttribute("curMonth");
        attendance = attendanceService.getAttendance(attendance);
        SimpleDateFormat timeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        BasicParam basicParam = basicParamService.getBasicParam();
        Date now = new Date();
        Date attendanceDate = timeFormat.parse(attendance.getDate()+" "+basicParam.getB_leave_time());
        if (now.getTime()-attendanceDate.getTime()>0) {
            if (myAttendApply == null) {
                myAttendApply = new AttendApply();
                myAttendApply.setAttend_no(attendance.getAttend_no());
                myAttendApply.setForget_clock_out("下班忘打卡");
                if (attendApplyService.addAttendApply(myAttendApply)) {
                    response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('下班忘打卡申请成功，等待审批'));" +
                            "window.location.href='browseMyAttendance?month=" + month + "';</script>");
                } else {
                    response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('下班忘打卡申请失败，请重试'));" +
                            "window.location.href='browseMyAttendance?month=" + month + "';</script>");
                }
            } else {
                if (!"下班忘打卡".equals(myAttendApply.getForget_clock_in())) {
                    myAttendApply.setForget_clock_out("下班忘打卡");
                    if (attendApplyService.updateAttendApply(myAttendApply)) {
                        response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('下班忘打卡申请成功，等待审批'));" +
                                "window.location.href='browseMyAttendance?month=" + month + "';</script>");
                    } else {
                        response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('下班忘打卡申请失败，请重试'));" +
                                "window.location.href='browseMyAttendance?month=" + month + "';</script>");
                    }
                } else {
                    response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('您已提交过申请，无需重复申请'));" +
                            "window.location.href='browseMyAttendance?month=" + month + "';</script>");
                }
            }
        }else {
            response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('尚未到该日期的下班时间，不可申请'));" +
                    "window.location.href='browseMyAttendance?month=" + month + "';</script>");

        }
    }

    @RequestMapping("applyLeave")
    public String applyLeave(Attendance attendance,Model model)throws Exception{
        model.addAttribute(attendance);
        return "applyLeave";
    }

    @RequestMapping("attendApplyLeave")
    public void attendApplyLeave(Attendance attendance,String vacation,String time,HttpSession session,HttpServletResponse response)throws Exception{
        int timeLong = Integer.parseInt(time);
        String month = (String) session.getAttribute("curMonth");
        AttendApply myAttendApply = attendApplyService.getMyAttendApply(attendance);
        if (myAttendApply==null){
            myAttendApply = new AttendApply();
            myAttendApply.setAttend_no(attendance.getAttend_no());
            myAttendApply.setApprove("未审批");
            if(attendApplyService.addAttendApply(myAttendApply)){
                myAttendApply= attendApplyService.getMyAttendApply(attendance);
                updateApplyLeave(myAttendApply,vacation,timeLong,session,response);
            }else {
                response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('请假申请失败，请重试'));" +
                        "window.location.href='browseMyAttendance?month="+month+"';</script>");
            }
        }else {
            myAttendApply.setApprove("未审批");
            updateApplyLeave(myAttendApply,vacation,timeLong,session,response);
        }

    }

    private void updateApplyLeave(AttendApply attendApply,String vacation,int timeLong,HttpSession session,HttpServletResponse response)throws Exception{
        String month = (String) session.getAttribute("curMonth");
        if(attendApplyService.updateApplyLeave(attendApply,vacation,timeLong)){
            response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('此次请假申请成功！\\n当日若有其他请假申请，则已被取消'));" +
                    "window.location.href='browseMyAttendance?month="+month+"';</script>");
        }else {
            response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('请假申请失败，请重试'));" +
                    "window.location.href='browseMyAttendance?month="+month+"';</script>");
        }
    }

    @RequestMapping("browseMyAttendApplies")
    public String myAttendApply(Model model,String month,HttpSession session)throws Exception{
        Employee employee = (Employee) session.getAttribute("employee");
        if (month==null){
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
            month = format.format(new Date());
        }
        List<Attendance> myAttendances = attendanceService.getMyThisMonthAttendances(employee,month);
        List<AttendApply> myAttendApplies = attendApplyService.getMyThisMonthAttendApplies(myAttendances);
        model.addAttribute("myAttendApplies",myAttendApplies);
        session.setAttribute("curMonth",month);
        return "browseMyAttendApplies";
    }

    @RequestMapping("browseAttendApplies")
    public String browseAttendApplies(Model model,String month,HttpSession session)throws Exception{
        if (month==null){
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
            month = format.format(new Date());
        }
        List<AttendApply> attendApplies = attendApplyService.getThisMonthAttendApplies(month);
        model.addAttribute("attendApplies",attendApplies);
        session.setAttribute("curMonth",month);
        return "browseAttendApplies";
    }

    @RequestMapping("approveAttendApply")
    public void approveAttendApply(Attendance attendance,HttpSession session,HttpServletResponse response)throws Exception{
        attendance = attendanceService.getAttendance(attendance);
        AttendApply attendApply = attendApplyService.getMyAttendApply(attendance);
        BasicParam basicParam = basicParamService.getBasicParam();
        if ("上班忘打卡".equals(attendApply.getForget_clock_in())){
            attendance.setAttend_time(basicParam.getB_attend_time());
            attendance.setBe_late(0);
            attendApply.setForget_clock_in("已同意");
        }
        if ("下班忘打卡".equals(attendApply.getForget_clock_out())){
            attendance.setLeave_time(basicParam.getB_leave_time());
            attendance.setLeave_early(0);
            attendApply.setForget_clock_out("已同意");
        }
        if(attendApply.getPerson_leave()!=0){
            attendance.setPerson_leave(attendApply.getPerson_leave());
            attendance.setSick_leave(0);
            attendance.setAnnual_leave(0);
            attendance.setMaternity_leave(0);
            attendance.setMarriage_leave(0);
            attendance.setFuneral_leave(0);
            attendance.setAbsenteeism(0);
        }else if (attendApply.getSick_leave()!=0){
            attendance.setPerson_leave(0);
            attendance.setSick_leave(attendApply.getSick_leave());
            attendance.setAnnual_leave(0);
            attendance.setMaternity_leave(0);
            attendance.setMarriage_leave(0);
            attendance.setFuneral_leave(0);
            attendance.setAbsenteeism(0);
        }else if (attendApply.getAnnual_leave()==1){
            attendance.setPerson_leave(0);
            attendance.setSick_leave(0);
            attendance.setAnnual_leave(1);
            attendance.setMaternity_leave(0);
            attendance.setMarriage_leave(0);
            attendance.setFuneral_leave(0);
            attendance.setAbsenteeism(0);
        }else if (attendApply.getMaternity_leave()==1){
            attendance.setPerson_leave(0);
            attendance.setSick_leave(0);
            attendance.setAnnual_leave(0);
            attendance.setMaternity_leave(1);
            attendance.setMarriage_leave(0);
            attendance.setFuneral_leave(0);
            attendance.setAbsenteeism(0);
        }else if (attendApply.getMarriage_leave()==1){
            attendance.setPerson_leave(0);
            attendance.setSick_leave(0);
            attendance.setAnnual_leave(0);
            attendance.setMaternity_leave(0);
            attendance.setMarriage_leave(1);
            attendance.setFuneral_leave(0);
            attendance.setAbsenteeism(0);
        }else if (attendApply.getFuneral_leave()==1){
            attendance.setPerson_leave(0);
            attendance.setSick_leave(0);
            attendance.setAnnual_leave(0);
            attendance.setMaternity_leave(0);
            attendance.setMarriage_leave(0);
            attendance.setFuneral_leave(1);
            attendance.setAbsenteeism(0);
        }
        String month = (String) session.getAttribute("curMonth");
        if (attendanceService.updateAttendance(attendance)){
            attendApply.setApprove("批准请假");
            if (attendApplyService.updateAttendApply(attendApply)){
                response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('审批成功'));" +
                        "window.location.href='browseAttendApplies?month="+month+"';</script>");
            }else {
                response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('审批失败，请重试'));" +
                        "window.location.href='browseAttendApplies?month="+month+"';</script>");
            }
        }else {
            response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('审批失败，请重试'));" +
                    "window.location.href='browseAttendApplies?month="+month+"';</script>");
        }
    }

    @RequestMapping("notApproveAttendApply")
    public void notApproveAttendApply(Attendance attendance,HttpSession session,HttpServletResponse response)throws Exception{
        AttendApply attendApply = attendApplyService.getMyAttendApply(attendance);
        attendApply.setApprove("拒绝请假");
        String month = (String) session.getAttribute("curMonth");
        if (attendApplyService.updateAttendApply(attendApply)){
            response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('拒绝成功'));" +
                    "window.location.href='browseAttendApplies?month="+month+"';</script>");
        }else {
            response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('拒绝失败，请重试'));" +
                    "window.location.href='browseAttendApplies?month="+month+"';</script>");
        }
    }

    @RequestMapping("approveForgetClockIn")
    public void approveForgetClockIn(Attendance attendance,HttpSession session,HttpServletResponse response)throws Exception {
        attendance = attendanceService.getAttendance(attendance);
        AttendApply attendApply = attendApplyService.getMyAttendApply(attendance);
        BasicParam basicParam = basicParamService.getBasicParam();
        attendance.setAttend_time(basicParam.getB_attend_time());
        attendance.setBe_late(0);
        String month = (String) session.getAttribute("curMonth");
        if (attendanceService.updateAttendance(attendance)) {
            attendApply.setForget_clock_in("已同意");
            if (attendApplyService.updateAttendApply(attendApply)){
                response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('同意补卡成功'));" +
                        "window.location.href='browseAttendApplies?month="+month+"';</script>");
            }else {
                response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('同意补卡失败，请重试'));" +
                        "window.location.href='browseAttendApplies?month="+month+"';</script>");
            }
        } else {
            response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('同意补卡失败，请重试'));" +
                    "window.location.href='browseAttendApplies?month=" + month + "';</script>");
        }
    }

    @RequestMapping("approveForgetClockOut")
    public void approveForgetClockOut(Attendance attendance,HttpSession session,HttpServletResponse response)throws Exception {
        attendance = attendanceService.getAttendance(attendance);
        AttendApply attendApply = attendApplyService.getMyAttendApply(attendance);
        BasicParam basicParam = basicParamService.getBasicParam();
        attendance.setLeave_time(basicParam.getB_leave_time());
        attendance.setLeave_early(0);
        String month = (String) session.getAttribute("curMonth");
        if (attendanceService.updateAttendance(attendance)) {
            attendApply.setForget_clock_out("已同意");
            if (attendApplyService.updateAttendApply(attendApply)){
                response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('同意补卡成功'));" +
                        "window.location.href='browseAttendApplies?month="+month+"';</script>");
            }else {
                response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('同意补卡失败，请重试'));" +
                        "window.location.href='browseAttendApplies?month="+month+"';</script>");
            }
        } else {
            response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('同意补卡失败，请重试'));" +
                    "window.location.href='browseAttendApplies?month=" + month + "';</script>");
        }
    }
}
