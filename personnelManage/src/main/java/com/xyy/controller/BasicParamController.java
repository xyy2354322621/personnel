package com.xyy.controller;

import com.xyy.biz.BasicParamService;
import com.xyy.model.BasicParam;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by xiyueyang on 2018/4/27 0027.
 */
@Controller
public class BasicParamController {
    @Resource
    private BasicParamService basicParamService;

    @RequestMapping("/manageBasicParam")
    public String manageBasicParam(Model model)throws Exception{
        BasicParam basicParam = basicParamService.getBasicParam();
        if(basicParam==null){
            basicParam = new BasicParam();
            basicParam.setB_attend_time("09:00");
            basicParam.setB_leave_time("17:00");
        }
        model.addAttribute(basicParam);
        return "manageBasicParam";
    }

    @RequestMapping("/alterBasicParam")
    public String addBasicParam(Model model)throws Exception{
        BasicParam basicParam = basicParamService.getBasicParam();
        if(basicParam==null){
            basicParam = new BasicParam();
            basicParam.setB_attend_time("09:00");
            basicParam.setB_leave_time("18:00");
            basicParamService.addBasicParam();
        }
        model.addAttribute(basicParam);
        return "alterBasicParam";
    }

    @RequestMapping("updateBasicParam")
    public void updateBasicParam(BasicParam basicParam, HttpServletRequest request, HttpServletResponse response)throws Exception{
        basicParam.setB_overtime_limit(Integer.parseInt(request.getParameter("overtime")));
        basicParam.setB_attend_time_limit(Integer.parseInt(request.getParameter("attendLimit")));
        basicParam.setB_leave_time_limit(Integer.parseInt(request.getParameter("leaveLimit")));
        basicParam.setB_workdays_month(Double.parseDouble(request.getParameter("workdays")));
        basicParam.setB_social_security_ratio(Double.parseDouble(request.getParameter("social")));
        basicParam.setB_company_pay_social(Double.parseDouble(request.getParameter("companySocial")));
        basicParam.setB_unit_penalty(Integer.parseInt(request.getParameter("unitPenalty")));
        basicParam.setB_overtime_reward_radio(Double.parseDouble(request.getParameter("overtimeReward")));
        basicParam.setPerson_leave_pay_ratio(Double.parseDouble(request.getParameter("personLeave")));
        basicParam.setSick_leave_pay_ratio(Double.parseDouble(request.getParameter("sickLeave")));
        basicParam.setMarriage_leave_pay_ratio(Double.parseDouble(request.getParameter("marriageLeave")));
        basicParam.setMaternity_leave_pay_ratio(Double.parseDouble(request.getParameter("maternityLeave")));
        basicParam.setFuneral_leave_pay_ratio(Double.parseDouble(request.getParameter("funeralLeave")));
        basicParam.setAnnual_leave_pay_ratio(Double.parseDouble(request.getParameter("annualLeave")));
        basicParam.setPublic_leave_pay_ratio(Double.parseDouble(request.getParameter("publicLeave")));
        basicParam.setAbsenteeism_punish_ratio(Double.parseDouble(request.getParameter("absenteeismLeave")));
        basicParam.setB_tax_threshold(Double.parseDouble(request.getParameter("threshold")));
        if(basicParamService.updateBasicParam(basicParam)){
            response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('修改成功'));" +
                    "window.location.href='manageBasicParam';</script>");
        }else {
            response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('修改失败，请重试'));" +
                    "window.location.href='alterBasicParam';</script>");
        }
    }
}
