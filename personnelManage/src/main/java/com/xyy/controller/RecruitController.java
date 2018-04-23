package com.xyy.controller;

import com.xyy.biz.DepartmentService;
import com.xyy.biz.RecruitService;
import com.xyy.model.Department;
import com.xyy.model.Recruit;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
public class RecruitController {

    @Resource
    private RecruitService recruitService;

    @Resource
    private DepartmentService departmentService;

    @RequestMapping("/gotoManageRecruit")
    public String gotoManageRecruit()throws Exception{
        return "manageRecruit";
    }

    @RequestMapping("/manageRecruit")
    public String manageRecruit()throws Exception{
        return "manageRecruit";
    }

    @RequestMapping("/recruit")
    public String recruit(HttpSession session)throws Exception{
        List<Recruit> recruits = recruitService.getIssuingRecruits();
        session.setAttribute("issuingRecruit",recruits);
        return "recruit";
    }

    @RequestMapping("/createRecruit")
    public String createRecruit(HttpSession session)throws Exception{
        /*List<Department> departments = departmentService.getDepartments();
        session.setAttribute("departments",departments);*/
        return "createRecruit";
    }

    @RequestMapping(value = "/saveRecruit")
    public void saveRecruit(Recruit recruit, String number, HttpServletResponse response)throws Exception{
        response.setContentType("text/html;charset=utf-8");
        if(recruit.getDescription().length()>1333){
            response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('职位描述字数过长'));" +
                    "window.location.href='createRecruit';</script>");
        }else {
            int recruit_number = Integer.parseInt(number);
            recruit.setRecruit_number(recruit_number);
            recruit.setIssue(1);
            SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
            String time = format.format(new Date());

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
    public String checkRecruit(Recruit recruit,HttpSession session)throws Exception{
        List<Recruit> recruits = (List<Recruit>) session.getAttribute("issuingRecruit");
        for (Recruit rec :recruits) {
            if(rec.getRecruit_no()==recruit.getRecruit_no()){
                recruit=rec;
                break;
            }
        }
        session.setAttribute("checkRecruit",recruit);
        return "checkRecruit";
    }
}
