package com.xyy.controller;

import com.xyy.biz.ApplyService;
import com.xyy.biz.ResumeService;
import com.xyy.model.Apply;
import com.xyy.model.Recruit;
import com.xyy.model.Resume;
import com.xyy.model.Tourist;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by xiyueyang on 2018/4/21 0021.
 */
@Controller
public class ApplyController {

    @Resource
    private ApplyService applyService;

    @Resource
    private ResumeService resumeService;

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

    @RequestMapping("/browseApplyResume")
    public String browseApplyResume(Recruit recruit,HttpSession session)throws Exception{
        session.setAttribute("curRecruit",recruit);
        List<Apply> applies = applyService.getApplies(recruit);
        session.setAttribute("applies",applies);
        return "browseApplyResume";
    }

    @RequestMapping("/inviteInterview")
    public String inviteInterview(Apply apply,HttpSession session)throws Exception {
        session.setAttribute("inviteApply",apply);
        return "interviewInfo";
    }

    @RequestMapping("/sendInvite")
    public void sendInvite(Apply apply,HttpServletResponse response,HttpSession session)throws Exception {
        response.setContentType("text/html;charset=utf-8");
        Apply inviteApply = (Apply) session.getAttribute("inviteApply");
        apply.setRecruit_no(inviteApply.getRecruit_no());
        apply.setApply_no(inviteApply.getApply_no());
        if (applyService.updateInvite(apply)){
            response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('邀请发送成功'));" +
                    "window.location.href='browseApplyResume?recruit_no="+apply.getRecruit_no()+"';</script>");
        }else {
            response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('邀请发送失败，请重试'));" +
                    "window.location.href='browseApplyResume?recruit_no="+apply.getRecruit_no()+"';</script>");
        }
    }


    @RequestMapping("/cancerInvite")
    public void cancerInvite(Apply apply,HttpServletResponse response)throws Exception {
        response.setContentType("text/html;charset=utf-8");
        if (applyService.updateCancerInvite(apply)){
            response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('取消邀请成功'));" +
                    "window.location.href='browseApplyResume?recruit_no="+apply.getRecruit_no()+"';</script>");
        }else {
            response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('取消邀请失败，请重试'));" +
                    "window.location.href='browseApplyResume?recruit_no="+apply.getRecruit_no()+"';</script>");
        }
    }

    @RequestMapping("/refuseApply")
    public void refuseApply(Apply apply,HttpServletResponse response)throws Exception {
        response.setContentType("text/html;charset=utf-8");
        if (applyService.updateRefuseApply(apply)){
            response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('拒绝申请成功'));" +
                    "window.location.href='browseApplyResume?recruit_no="+apply.getRecruit_no()+"';</script>");
        }else {
            response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('拒绝申请失败，请重试'));" +
                    "window.location.href='browseApplyResume?recruit_no="+apply.getRecruit_no()+"';</script>");
        }
    }

    @RequestMapping("/deleteApply")
    public void deleteApply(Apply apply,HttpServletResponse response)throws Exception {
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write("<script language='javascript'>if( confirm(decodeURIComponent('确定要删除吗？'))){" +
                "window.location.href ='confirmDeleteApply?apply_no="+apply.getApply_no()+"&recruit_no="+apply.getRecruit_no()+
                "';}else {window.location.href ='browseApplyResume?recruit_no="+apply.getRecruit_no()+"';} </script>");

    }

    @RequestMapping("/confirmDeleteApply")
    public void confirmDeleteApply(Apply apply,HttpServletResponse response)throws Exception {
        response.setContentType("text/html;charset=utf-8");
        if (applyService.updateDeleteApply(apply)){
            response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('申请删除成功'));" +
                    "window.location.href='browseApplyResume?recruit_no="+apply.getRecruit_no()+"';</script>");
        }else {
            response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('申请删除失败，请重试'));" +
                    "window.location.href='browseApplyResume?recruit_no="+apply.getRecruit_no()+"';</script>");
        }
    }

    @RequestMapping("/successInterview")
    public void successInterview(Apply apply,HttpServletResponse response)throws Exception {
        response.setContentType("text/html;charset=utf-8");
        if (applyService.updateSuccessInterview(apply)){
            response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('记录变更成功'));" +
                    "window.location.href='browseApplyResume?recruit_no="+apply.getRecruit_no()+"';</script>");
        }else {
            response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('记录变更失败，请重试'));" +
                    "window.location.href='browseApplyResume?recruit_no="+apply.getRecruit_no()+"';</script>");
        }
    }

    @RequestMapping("/failInterview")
    public void failInterview(Apply apply,HttpServletResponse response)throws Exception {
        response.setContentType("text/html;charset=utf-8");
        if (applyService.updateFailInterview(apply)){
            response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('记录变更成功'));" +
                    "window.location.href='browseApplyResume?recruit_no="+apply.getRecruit_no()+"';</script>");
        }else {
            response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('记录变更失败，请重试'));" +
                    "window.location.href='browseApplyResume?recruit_no="+apply.getRecruit_no()+"';</script>");
        }
    }

    @RequestMapping("/manageApply")
    public void manageApply(HttpSession session,HttpServletResponse response)throws Exception{
        response.setContentType("text/html;charset=utf-8");
        Tourist tourist = (Tourist) session.getAttribute("tourist");
        if(tourist==null){
            response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('您尚未登录，不可查看'));" +
                    "window.location.href='recruit';</script>");
        }else {
           List<Apply> myApplies = applyService.getMyApplies(tourist);
           session.setAttribute("myApplies",myApplies);
           response.sendRedirect("myApplies");
        }
    }

    @RequestMapping("/checkApplyResume")
    public String checkApplyResume(Apply apply, HttpSession session)throws Exception{
        applyService.updateSetRead(apply);
        Resume resume = new Resume();
        resume.setResume_no(apply.getResume_no());
        Resume applyResume = resumeService.getResume(resume);
        session.setAttribute("applyResume",applyResume);
        return "checkApplyResume";
    }

    @RequestMapping("/agreeInvite")
    public void agreeInvite(Apply apply,HttpServletResponse response)throws Exception{
        response.setContentType("text/html;charset=utf-8");
        if(applyService.updateAgreeInvite(apply)){
            response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('同意回复发送成功'));" +
                    "window.location.href='manageApply';</script>");
        }else {
            response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('同意回复发送失败，请重试'));" +
                    "window.location.href='manageApply';</script>");
        }
    }

    @RequestMapping("/refuseInvite")
    public void refuseInvite(Apply apply,HttpServletResponse response)throws Exception{
        response.setContentType("text/html;charset=utf-8");
        if(applyService.updateRefuseInvite(apply)){
            response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('拒绝回复发送成功'));" +
                    "window.location.href='manageApply';</script>");
        }else {
            response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('拒绝回复发送失败，请重试'));" +
                    "window.location.href='manageApply';</script>");
        }
    }
}
