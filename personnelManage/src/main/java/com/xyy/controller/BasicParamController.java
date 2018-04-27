package com.xyy.controller;

import com.xyy.biz.BasicParamService;
import com.xyy.model.BasicParam;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.jnlp.BasicService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

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
            basicParam.setB_leave_time("17:00");
            basicParamService.addBasicParam();
        }
        model.addAttribute(basicParam);
        return "alterBasicParam";
    }

    @RequestMapping("/updateBasicParam")
    public void updateBasicParam(BasicParam basicParam, HttpServletRequest request, HttpServletResponse response)throws Exception{
        basicParam.setB_overtime_limit(Integer.parseInt(request.getParameter("overtime")));
        basicParam.setB_attend_time_limit(Integer.parseInt(request.getParameter("attendLimit")));
        basicParam.setB_leave_time_limit(Integer.parseInt(request.getParameter("leaveLimit")));
        basicParam.setB_social_security_ratio(Double.parseDouble(request.getParameter("social")));
        basicParam.setB_housing_fund_ratio(Double.parseDouble(request.getParameter("houseFund")));
        basicParam.setB_unit_penalty(Integer.parseInt(request.getParameter("unitPenalty")));
        basicParam.setB_overtime_reward_radio(Double.parseDouble(request.getParameter("overtimeReward")));
        if(basicParamService.updateBasicParam(basicParam)){
            response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('修改成功'));" +
                    "window.location.href='manageBasicParam';</script>");
        }else {
            response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('修改失败，请重试'));" +
                    "window.location.href='alterBasicParam';</script>");
        }
    }
}
