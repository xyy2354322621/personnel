package com.xyy.controller;

import com.xyy.biz.DepartmentService;
import com.xyy.biz.EmployeeService;
import com.xyy.biz.RewardAanPunishService;
import com.xyy.model.Department;
import com.xyy.model.Employee;
import com.xyy.model.RewardAanPunish;
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
 * Created by xiyueyang on 2018/4/26 0026.
 */
@Controller
public class RewardAanPunishController {

    @Resource
    private RewardAanPunishService rewardAanPunishService;

    @Resource
    private DepartmentService departmentService;

    @Resource
    private EmployeeService employeeService;

    @RequestMapping("/manageRewardAndPunishment")
    public String manageRewardAndPunishment(Model model) throws Exception {
        List<RewardAanPunish> rewardAanPunishes = rewardAanPunishService.getCurMonthRewardAndPunish();
        model.addAttribute(rewardAanPunishes);
        return "manageRewardAndPunishment";
    }

    @RequestMapping("/cancerRewardPunish")
    public void cancerRewardPunish(RewardAanPunish rewardAanPunish, HttpServletResponse response) throws Exception {
        if (rewardAanPunishService.updateCancerRewordPunish(rewardAanPunish)) {
            response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('取消成功'));" +
                    "window.location.href='manageRewardAndPunishment';</script>");
        } else {
            response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('取消失败'));" +
                    "window.location.href='manageRewardAndPunishment';</script>");
        }
    }

    @RequestMapping("/executeRewardPunish")
    public void executeRewardPunish(RewardAanPunish rewardAanPunish, HttpServletResponse response) throws Exception {
        if (rewardAanPunishService.updateExecuteRewordPunish(rewardAanPunish)) {
            response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('执行成功'));" +
                    "window.location.href='manageRewardAndPunishment';</script>");
        } else {
            response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('执行失败'));" +
                    "window.location.href='manageRewardAndPunishment';</script>");
        }
    }

    @RequestMapping("/createRewardPunish")
    public String createRewardPunish(HttpSession session) throws Exception {
        List<Department> departmentPosition = departmentService.getDepartmentsAndPosition();
        session.setAttribute("departmentPosition", departmentPosition);
        List<Employee> employees = employeeService.getEmployees();
        session.setAttribute("employees", employees);
        return "createRewardPunish";
    }

    @RequestMapping("/saveRewardPunish")
    public void saveRewardPunish(RewardAanPunish rewardAanPunish, String money, HttpServletResponse response) throws Exception {
        rewardAanPunish.setMoney(Double.parseDouble(money));
        SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-dd");
        rewardAanPunish.setTime(format.format(new Date()));
        if (rewardAanPunishService.addRewardPunish(rewardAanPunish)) {
            response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('新增成功'));" +
                    "window.location.href='createRewardPunish';</script>");
        } else {
            response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('新增失败'));" +
                    "window.location.href='createRewardPunish';</script>");

        }
    }

    @RequestMapping("/alterRewardPunish")
    public String alterRewardPunish(RewardAanPunish rewardAanPunish, Model model) throws Exception {
        rewardAanPunish = rewardAanPunishService.getRewardPunish(rewardAanPunish);
        model.addAttribute(rewardAanPunish);
        return "alterRewardPunish";
    }

    @RequestMapping("/updateRewardPunish")
    public void updateRewardPunish(RewardAanPunish rewardAanPunish, String money, HttpServletResponse response) throws Exception {
        rewardAanPunish.setMoney(Double.parseDouble(money));
        if (rewardAanPunishService.updateRewardPunish(rewardAanPunish)) {
            response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('修改成功'));" +
                    "window.location.href='manageRewardAndPunishment';</script>");
        } else {
            response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('修改失败'));" +
                    "window.location.href='alterRewardPunish?r_and_p_no=" + rewardAanPunish.getR_and_p_no() + "';</script>");

        }
    }

    @RequestMapping("/deleteRewardPunish")
    public void deleteRewardPunish(RewardAanPunish rewardAanPunish, HttpServletResponse response) throws Exception {
        response.getWriter().write("<script language='javascript'>if( confirm(decodeURIComponent('确定要删除吗？'))){" +
                "window.location.href ='confirmDeleteRewardPunish?r_and_p_no=" + rewardAanPunish.getR_and_p_no() +
                "';}else {window.location.href ='manageRewardAndPunishment';} </script>");

    }

    @RequestMapping("/confirmDeleteRewardPunish")
    public void confirmDeleteRewardPunish(RewardAanPunish rewardAanPunish, HttpServletResponse response) throws Exception {
        if (rewardAanPunishService.deleteRewardPunish(rewardAanPunish)) {
            response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('删除成功'));" +
                    "window.location.href='manageRewardAndPunishment';</script>");
        } else {
            response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('删除失败'));" +
                    "window.location.href='manageRewardAndPunishment';</script>");

        }
    }

    @RequestMapping("/chooseMonthForRP")
    public String chooseMonthForRP(String month, Model model) throws Exception {
        List<RewardAanPunish> rewardAanPunishes = rewardAanPunishService.getThisMonthRewardAndPunish(month);
        model.addAttribute(rewardAanPunishes);
        return "manageRewardAndPunishment";
    }

}