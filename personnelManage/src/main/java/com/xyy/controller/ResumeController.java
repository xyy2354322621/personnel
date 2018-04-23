package com.xyy.controller;

import com.xyy.biz.ResumeService;
import com.xyy.model.Resume;
import com.xyy.model.Tourist;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by xiyueyang on 2018/4/21 0021.
 */
@Controller
public class ResumeController {

    @Resource
    private ResumeService resumeService;

    @RequestMapping("/chooseResume")
    public String chooseResume(HttpSession session)throws Exception{
        Tourist tourist = (Tourist) session.getAttribute("tourist");
        List<Resume> myResumes = resumeService.getMyResume(tourist);
        session.setAttribute("myResumes",myResumes);
        return "chooseResume";
    }

    @RequestMapping("/createResume")
    public String createResume()throws Exception{
        return "createResume";
    }

    @RequestMapping("/manageResume")
    public void manageResume(HttpSession session,HttpServletResponse response)throws Exception{
        response.setContentType("text/html;charset=utf-8");
        Tourist tourist = (Tourist) session.getAttribute("tourist");
        if(tourist==null){
            response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('您尚未登录，请先登录后发送'));" +
                    "window.location.href='recruit';</script>");
        }else {
            List<Resume> myResumes = resumeService.getMyResume(tourist);
            session.setAttribute("myResumes",myResumes);
            response.sendRedirect("manageResume");
        }

    }

    @RequestMapping("/saveResume")
    public void saveResume(Resume resume,HttpSession session, HttpServletResponse response)throws Exception{
        response.setContentType("text/html;charset=utf-8");
        Tourist tourist = (Tourist) session.getAttribute("tourist");
        resume.setTourist_no(tourist.getTourist_no());
        resume.setExist(1);
        if(resumeService.addResume(resume)){
            response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('简历创建成功'));" +
                    "window.location.href='manageResume';</script>");
        }else {
            response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('简历创建失败'));" +
                    "window.location.href='createResume';</script>");
        }
    }

    @RequestMapping("/checkResume")
    public String checkResume(Resume resume,HttpSession session)throws Exception{
        resume = getChosenResume(resume,session);
        session.setAttribute("checkResume",resume);
        return "checkResume";
    }

    @RequestMapping("/scanResume")
    public String scanResume(Resume resume,HttpSession session)throws Exception{
        resume = getChosenResume(resume,session);
        session.setAttribute("scanResume",resume);
        return "scanResume";
    }

    @RequestMapping("/alterResume")
    public String alterResume(Resume resume,HttpSession session)throws Exception{
        resume = getChosenResume(resume,session);
        session.setAttribute("alterResume",resume);
        return "alterResume";
    }

    @RequestMapping("/updateResume")
    public void updateResume(Resume resume,HttpSession session,HttpServletResponse response)throws Exception{
        response.setContentType("text/html;charset=utf-8");
        Resume alterResume = (Resume) session.getAttribute("Resume");
        resume.setResume_no(alterResume.getResume_no());
        resume.setTourist_no(alterResume.getTourist_no());
        if(resumeService.updateResume(resume)){
            response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('简历修改成功'));" +
                    "window.location.href='manageResume';</script>");
        }else {
            response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('简历修改失败,请重新修改'));" +
                    "window.location.href='alterResume?resume_no="+resume.getResume_no()+"';</script>");
        }
    }


    @RequestMapping("/deleteResume")
    public void deleteResume(Resume resume,HttpSession session,HttpServletResponse response)throws Exception{
        response.setContentType("text/html;charset=utf-8");
        Resume isUsingResume = resumeService.getUsingResume(resume);
        if(isUsingResume==null){
            response.getWriter().write("<script language='javascript'>if( confirm(decodeURIComponent('确定要删除吗？'))){" +
                    "window.location.href ='confirmDeleteResume?resume_no="+resume.getResume_no()+"';}else {window.location.href ='manageResume';} </script>");
        }else {
            response.getWriter().write("<script language='javascript'>if( confirm(decodeURIComponent('该简历尚在投递中，确定要删除吗？'))){" +
                    "window.location.href ='virtualDeleteResume?resume_no="+resume.getResume_no()+"';}else {window.location.href ='manageResume';} </script>");
        }
    }

    @RequestMapping("/confirmDeleteResume")
    public void confirmDeleteResume(Resume resume,HttpServletResponse response)throws Exception{
        if(resumeService.deleteResume(resume)){
            response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('简历删除成功'));" +
                    "window.location.href='manageResume';</script>");
        }else {
            response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('简历删除失败'));" +
                    "window.location.href='manageResume';</script>");
        }
    }

    @RequestMapping("/virtualDeleteResume")
    public void virtualDeleteResume(Resume resume,HttpServletResponse response)throws Exception{
        if(resumeService.updateVirtualDeleteResume(resume)){
            response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('简历删除成功'));" +
                    "window.location.href='manageResume';</script>");
        }else {
            response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('简历删除失败'));" +
                    "window.location.href='manageResume';</script>");
        }
    }

    private Resume getChosenResume(Resume resume,HttpSession session){
        List<Resume> resumes = (List<Resume>) session.getAttribute("myResumes");
        for (Resume rsm :resumes) {
            if(rsm.getResume_no()==resume.getResume_no()){
                resume=rsm;
                break;
            }
        }
        return resume;
    }


}
