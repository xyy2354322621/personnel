package com.xyy.controller;

import com.xyy.biz.TouristService;
import com.xyy.model.Tourist;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by xiyueyang on 2018/4/20 0020.
 */
@Controller
public class TouristController {
    @Resource
    private TouristService touristService;

    @RequestMapping("/gotoTouristRegister")
    public String gotoTouristRegister()throws Exception{
        return "touristRegister";
    }

    @RequestMapping("/gotoTouristLogin")
    public String gotoTouristLogin()throws Exception{
        return "touristLogin";
    }

    @RequestMapping("/gotoTouristHome")
    public String gotoTouristHome()throws Exception{
        return "touristHome";
    }

    @RequestMapping("/touristRegister")
    public void touristRegister(Tourist tourist, String rePass, HttpSession session, HttpServletResponse response)throws Exception{
        System.out.println(tourist.getTourist_no());
        Tourist existTourist = touristService.getTourist(tourist);
        System.out.println("游客注册");
        response.setContentType("text/html;charset=utf-8");
        System.out.println(existTourist);
        if(existTourist!=null){
            System.out.println("不可注册");
            response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('该手机号已注册'));" +
                    "window.location.href='gotoTouristRegister';</script>");
        }else {
            System.out.println("可注册");
            if("".equals(tourist.getPass()) || !rePass.equals(tourist.getPass())){
                response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('两次输入的密码不一致或为空'));" +
                        "window.location.href='gotoTouristRegister';</script>");
            }else {
                System.out.println("注册");
                if(touristService.addTourist(tourist)){
                    response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('注册成功，前往登录'));" +
                            "window.location.href='gotoTouristLogin';</script>");
                }
            }
        }
    }

    @RequestMapping("/touristLogin")
    public void touristLogin(Tourist tourist,HttpServletResponse response,HttpSession session)throws Exception{
        Tourist existTourist = touristService.getLoginTourist(tourist);
        response.setContentType("text/html;charset=utf-8");
        if(existTourist!=null){
            session.setAttribute("tourist",existTourist);
            response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('登录成功'));" +
                    "window.location.href='recruit';</script>");
        }else {
            response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('账号或密码错误'));" +
                    "window.location.href='gotoTouristLogin';</script>");
        }
    }

    @RequestMapping("/gotoVisit")
    public String gotoVisit()throws Exception{
        System.out.println("直接过来");
        return "/eLogin.jsp";
    }
}
