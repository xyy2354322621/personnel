package com.xyy.controller;

import com.xyy.biz.DepartmentService;
import com.xyy.biz.RecruitService;
import com.xyy.model.Department;
import com.xyy.model.Recruit;
import com.xyy.model.Resume;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by xiyueyang on 2018/4/20 0020.
 */
@Controller
public class RecruitController {

    @Resource
    private RecruitService recruitService;

    @Resource
    private DepartmentService departmentService;

    @RequestMapping("/gotoManageRecruit")
    public String gotoManageRecruit() throws Exception {
        return "manageRecruit";
    }

    @RequestMapping("/manageRecruit")
    public String manageRecruit(HttpSession session) throws Exception {
        List<Recruit> recruits = recruitService.getRecruits();
        session.setAttribute("recruits", recruits);
        return "manageRecruit";
    }

    @RequestMapping("/recruit")
    public String recruit(HttpSession session) throws Exception {
        GregorianCalendar ca = new GregorianCalendar();
        int am_pm = ca.get(GregorianCalendar.AM_PM);
        session.setAttribute("am_pm",am_pm);
        List<Recruit> recruits = recruitService.getIssuingRecruits();
        session.setAttribute("issuingRecruit", recruits);
        return "recruit";
    }

    @RequestMapping("/createRecruit")
    public String createRecruit(HttpSession session) throws Exception {
        List<Department> departmentPosition = departmentService.getDepartmentsAndPosition();
        session.setAttribute("departmentPosition",departmentPosition);
        return "createRecruit";
    }

    @RequestMapping(value = "/saveRecruit")
    public void saveRecruit(Recruit recruit, String number, HttpServletResponse response) throws Exception {
        response.setContentType("text/html;charset=utf-8");
        if (recruit.getDescription().length() > 1333) {
            response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('职位描述字数过长'));" +
                    "window.location.href='createRecruit';</script>");
        } else {
            int recruit_number = Integer.parseInt(number);
            recruit.setRecruit_number(recruit_number);
            recruit.setIssue(0);
            SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
            recruit.setIssue_time(format.format(new Date()));
            if (recruitService.addRecruit(recruit)) {
                response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('招聘发布成功'));" +
                        "window.location.href='createRecruit';</script>");
            } else {
                response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('招聘发布失败'));" +
                        "window.location.href='createRecruit';</script>");
            }
        }
    }

    @RequestMapping("/checkRecruit")
    public String checkRecruit(Recruit recruit, HttpSession session) throws Exception {
        List<Recruit> recruits = (List<Recruit>) session.getAttribute("issuingRecruit");
        for (Recruit rec : recruits) {
            if (rec.getRecruit_no() == recruit.getRecruit_no()) {
                recruit = rec;
                break;
            }
        }
        session.setAttribute("checkRecruit", recruit);
        return "checkRecruit";
    }

    @RequestMapping("/checkManageRecruit")
    public String checkManageRecruit(Recruit recruit, HttpSession session) throws Exception {
        List<Recruit> recruits = (List<Recruit>) session.getAttribute("recruits");
        for (Recruit rec : recruits) {
            if (rec.getRecruit_no() == recruit.getRecruit_no()) {
                recruit = rec;
                break;
            }
        }
        session.setAttribute("checkManageRecruit", recruit);
        return "checkManageRecruit";
    }

    @RequestMapping("/pauseIssueRecruit")
    public void pauseIssueRecruit(Recruit recruit, HttpServletResponse response) throws Exception {
        response.setContentType("text/html;charset=utf-8");
        if (recruitService.updatePauseIssueRecruit(recruit)) {
            response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('暂停发布成功'));" +
                    "window.location.href='manageRecruit';</script>");
        } else {
            response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('暂停发布失败，请重试'));" +
                    "window.location.href='manageRecruit';</script>");
        }
    }

    @RequestMapping("/recoverIssueRecruit")
    public void recoverIssueRecruit(Recruit recruit, HttpServletResponse response) throws Exception {
        response.setContentType("text/html;charset=utf-8");
        SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
        recruit.setIssue_time(format.format(new Date()));
        if (recruitService.updateRecoverIssueRecruit(recruit)) {
            response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('恢复发布成功'));" +
                    "window.location.href='manageRecruit';</script>");
        } else {
            response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('恢复发布失败，请重试'));" +
                    "window.location.href='manageRecruit';</script>");
        }
    }

    @RequestMapping("/alterRecruit")
    public String alterRecruit(Recruit recruit, HttpSession session) throws Exception {
        List<Recruit> recruits = (List<Recruit>) session.getAttribute("recruits");
        for (Recruit rec : recruits) {
            if (rec.getRecruit_no() == recruit.getRecruit_no()) {
                recruit = rec;
                break;
            }
        }
        session.setAttribute("alterRecruit", recruit);
        return "alterRecruit";
    }

    @RequestMapping("/updateRecruit")
    public void updateRecruit(Recruit recruit, String number, HttpSession session, HttpServletResponse response) throws Exception {
        response.setContentType("text/html;charset=utf-8");
        Recruit alterRecruit = (Recruit) session.getAttribute("alterRecruit");
        int recruit_number = Integer.parseInt(number);
        recruit.setRecruit_number(recruit_number);
        recruit.setRecruit_no(alterRecruit.getRecruit_no());
        recruit.setPos_no(alterRecruit.getPos_no());
        if (recruitService.updateRecruit(recruit)) {
            response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('招聘信息修改成功'));" +
                    "window.location.href='manageRecruit';</script>");
        } else {
            session.setAttribute("alterRecruit", recruit);
            response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('招聘信息修改失败，请重试'));" +
                    "window.location.href='gotoAlterRecruit';</script>");
        }
    }

    @RequestMapping("/gotoAlterRecruit")
    public String gotoAlterRecruit() throws Exception {
        return "alterRecruit";
    }

    @RequestMapping("/deleteRecruit")
    public void deleteRecruit(Recruit recruit, HttpServletResponse response) throws Exception {
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write("<script language='javascript'>if( confirm(decodeURIComponent('确定要删除吗？'))){" +
                "window.location.href ='confirmDeleteRecruit?recruit_no=" + recruit.getRecruit_no() + "';}else {window.location.href ='manageRecruit';} </script>");
    }

    @RequestMapping("/confirmDeleteRecruit")
    public void confirmDeleteRecruit(Recruit recruit, HttpServletResponse response) throws Exception {
        response.setContentType("text/html;charset=utf-8");
        if (recruitService.deleteRecruit(recruit)) {
            response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('招聘信息删除成功'));" +
                    "window.location.href='manageRecruit';</script>");
        } else {
            response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('招聘信息删除失败，请重试'));" +
                    "window.location.href='manageRecruit';</script>");
        }
    }

}
