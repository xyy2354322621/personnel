package com.xyy.controller;

import com.xyy.biz.ApplyService;
import com.xyy.model.Apply;
import com.xyy.model.Resume;
import com.xyy.model.Tourist;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by xiyueyang on 2018/4/21 0021.
 */
@Controller
public class ApplyController {

    @Resource
    private ApplyService applyService;


    @RequestMapping("/applyPosition")
    public void applyPosition(Apply apply, HttpSession session, HttpServletResponse response)throws Exception{
        response.setContentType("text/html;charset=utf-8");
        Tourist tourist = (Tourist) session.getAttribute("tourist");
        if(tourist==null){
            response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('您尚未登录，请先登录后发送'));" +
                    "window.location.href='recruit';</script>");
        }else {
            session.setAttribute("apply",apply);
            response.sendRedirect("chooseResume");
        }
    }

    @RequestMapping("/sendResume")
    public void sendResume(Resume resume,HttpSession session,HttpServletResponse response)throws Exception{
        response.setContentType("text/html;charset=utf-8");
        Apply apply = (Apply) session.getAttribute("apply");
        Tourist tourist = (Tourist) session.getAttribute("tourist");
        apply.setResume_no(resume.getResume_no());
        Apply existApply = applyService.getRepeatApply(apply,tourist);
        if(existApply==null) {
            SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
            apply.setApply_time(format.format(new Date()));
            apply.setExist(1);
            apply.setIsRead("未阅");
            if(applyService.addApply(apply)){
                response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('投递成功'));" +
                        "window.location.href='recruit';</script>");
            }else {
                response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('投递失败，请再次投递'));" +
                        "window.location.href='chooseResume';</script>");
            }
        }else {
            response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('您已申请过该职位，不可重复投递'));" +
                    "window.location.href='recruit';</script>");
        }
    }
}
