package com.xyy.controller;

import com.xyy.biz.ReconsiderSalaryService;
import com.xyy.biz.RewardAanPunishService;
import com.xyy.biz.SalaryService;
import com.xyy.model.Employee;
import com.xyy.model.ReconsiderSalary;
import com.xyy.model.RewardAanPunish;
import com.xyy.model.Salary;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by xiyueyang on 2018/5/2 0002.
 */
@Controller
public class ReconsiderSalaryController {

    @Resource
    private ReconsiderSalaryService reconsiderSalaryService;

    @Resource
    private SalaryService salaryService;

    @Resource
    private RewardAanPunishService rewardAanPunishService;

    @RequestMapping("reconsiderSalary")
    public void reconsiderSalary(Salary salary, Model model, HttpServletResponse response) throws Exception {
        ReconsiderSalary myReconsider = reconsiderSalaryService.getThisReconsiderSalary(salary);
        salary = salaryService.getSalary(salary);
        SimpleDateFormat monthFormat = new SimpleDateFormat("yyyy-MM");
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH,-1);
        Date prevMonth = calendar.getTime();
        String preMonthStr = monthFormat.format(prevMonth);
        if (preMonthStr.equals(salary.getSalary_month())) {
            if (myReconsider == null) {
                response.sendRedirect("gotoReconsiderSalary?salary_no=" + salary.getSalary_no());
            } else {
                response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('您已提交过对该月工资的复议，不可再复议'));" +
                        "window.location.href='browseMySalary';</script>");
            }
        }else {
            response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('只能对上月工资进行复议'));" +
                    "window.location.href='browseMySalary';</script>");
        }
    }

    @RequestMapping("gotoReconsiderSalary")
    public String gotoReconsiderSalary(Salary salary, Model model) {
        model.addAttribute(salary);
        return "reconsiderSalary";
    }


    @RequestMapping("saveReconsiderSalary")
    public void saveReconsiderSalary(Salary salary, HttpServletRequest request, HttpServletResponse response) throws Exception {
        salary = salaryService.getSalary(salary);
        ReconsiderSalary reconsiderSalary = new ReconsiderSalary();
        reconsiderSalary.setSalary_no(salary.getSalary_no());
        reconsiderSalary.setSalary_month(salary.getSalary_month());
        reconsiderSalary.setE_id(salary.getE_id());
        reconsiderSalary.setMoney(Double.parseDouble(request.getParameter("money")));
        reconsiderSalary.setReason(request.getParameter("season"));
        reconsiderSalary.setState("未审核");
        if (reconsiderSalaryService.addReconsiderSalary(reconsiderSalary)) {
            response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('复议提交成功'));" +
                    "window.location.href='browseMySalary';</script>");
        } else {
            response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('复议提交失败，请重试'));" +
                    "window.location.href='reconsiderSalary?salary_no=" + salary.getSalary_no() + "';</script>");
        }
    }

    @RequestMapping("browseMyReconsiders")
    public String browseMyReconsiders(Model model, HttpSession session) throws Exception {
        Employee employee = (Employee) session.getAttribute("employee");
        List<ReconsiderSalary> myReconsiderSalary = reconsiderSalaryService.getMyReconsiderSalary(employee);
        model.addAttribute(myReconsiderSalary);
        return "browseMyReconsiders";
    }

    @RequestMapping("alterReconsiderSalary")
    public String alterReconsiderSalary(ReconsiderSalary reconsiderSalary, HttpSession session) throws Exception {
        reconsiderSalary = reconsiderSalaryService.getReconsiderSalary(reconsiderSalary);
        session.setAttribute("alterReconsiderSalary", reconsiderSalary);
        return "alterReconsiderSalary";
    }

    @RequestMapping("updateReconsiderSalary")
    public void updateReconsiderSalary(String money, String reason, HttpSession session, HttpServletResponse response) throws Exception {
        ReconsiderSalary alterReconsiderSalary = (ReconsiderSalary) session.getAttribute("alterReconsiderSalary");
        alterReconsiderSalary.setMoney(Double.parseDouble(money));
        alterReconsiderSalary.setReason(reason);
        if (reconsiderSalaryService.updateReconsiderSalary(alterReconsiderSalary)) {
            response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('薪资复议修改成功'));" +
                    "window.location.href='browseMyReconsiders';</script>");
        } else {
            session.setAttribute("alterReconsiderSalary", alterReconsiderSalary);
            response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('薪资复议修改失败，请重试'));" +
                    "window.location.href='alterReconsiderSalary';</script>");
        }
    }

    @RequestMapping("deleteReconsiderSalary")
    public void deleteReconsiderSalary(ReconsiderSalary reconsiderSalary, HttpServletResponse response) throws Exception {
        if (reconsiderSalaryService.deleteReconsiderSalary(reconsiderSalary)) {
            response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('薪资复议删除成功'));" +
                    "window.location.href='browseMyReconsiders';</script>");
        } else {
            response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('薪资复议删除失败，请重试'));" +
                    "window.location.href='browseMyReconsiders';</script>");
        }
    }

    @RequestMapping("prevMonthSalaryReconsider")
    public String prevMonthSalaryReconsider(Model model,HttpSession session)throws Exception {
        session.setAttribute("month","prevMonth");
        SimpleDateFormat montFormat = new SimpleDateFormat("yyyy-MM");
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, -1);
        Date prevMonth = calendar.getTime();
        String month = montFormat.format(prevMonth);
        List<ReconsiderSalary> reconsiderSalaries = reconsiderSalaryService.getThisMonthReconsider(month);
        model.addAttribute(reconsiderSalaries);
        return "manageReconsiderSalary";
    }

    @RequestMapping("curMonthSalaryReconsider")
    public String curMonthSalaryReconsider(Model model,HttpSession session)throws Exception {
        session.setAttribute("month","curMonth");
        SimpleDateFormat montFormat = new SimpleDateFormat("yyyy-MM");
        Date now = new Date();
        String month = montFormat.format(now);
        List<ReconsiderSalary> reconsiderSalaries = reconsiderSalaryService.getThisMonthReconsider(month);
        model.addAttribute(reconsiderSalaries);
        return "manageReconsiderSalary";
    }

    @RequestMapping("rewardReconsider")
    public void rewardReconsider(ReconsiderSalary reconsider,HttpSession session,HttpServletResponse response)throws Exception {
        reconsider = reconsiderSalaryService.getReconsiderSalary(reconsider);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        reconsider.setState("批准复议");
        String reason = reconsider.getSalary_month()+"月工资复议";
        RewardAanPunish rewardAanPunish = rewardAanPunishService.getThisMonthSalaryReconsider(reason);
        if (rewardAanPunish==null) {
            rewardAanPunish = new RewardAanPunish();
            rewardAanPunish.setMoney(reconsider.getMoney());
            rewardAanPunish.setType("奖励");
            rewardAanPunish.setReason(reconsider.getSalary_month() + "月工资复议奖励");
            rewardAanPunish.setE_id(reconsider.getE_id());
            rewardAanPunish.setExist(1);
            rewardAanPunish.setTime(format.format(new Date()));
            String month = (String) session.getAttribute("month");
            if (rewardAanPunishService.addRewardPunish(rewardAanPunish) && reconsiderSalaryService.updateReconsiderSalary(reconsider)) {
                response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('薪资复议处理成功'));" +
                        "window.location.href='prevMonthSalaryReconsider';</script>");
            } else {
                response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('薪资复议处理失败，请重试'));" +
                        "window.location.href='prevMonthSalaryReconsider';</script>");
            }
        }else {
            rewardAanPunish.setMoney(reconsider.getMoney());
            rewardAanPunish.setType("奖励");
            rewardAanPunish.setReason(reconsider.getSalary_month() + "月工资复议奖励");
            rewardAanPunish.setE_id(reconsider.getE_id());
            rewardAanPunish.setExist(1);
            rewardAanPunish.setTime(format.format(new Date()));
            String month = (String) session.getAttribute("month");
            if (rewardAanPunishService.updateRewardPunish(rewardAanPunish) && reconsiderSalaryService.updateReconsiderSalary(reconsider)) {
                response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('薪资复议处理成功'));" +
                        "window.location.href='prevMonthSalaryReconsider';</script>");
            } else {
                response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('薪资复议处理失败，请重试'));" +
                        "window.location.href='prevMonthSalaryReconsider';</script>");
            }
        }

    }

    @RequestMapping("rewardReconsiderSalary")
    public void rewardReconsiderSalary(ReconsiderSalary reconsider,HttpSession session,HttpServletResponse response)throws Exception {
        String month = (String) session.getAttribute("month");
        response.getWriter().write("<script language='javascript'>if(confirm(decodeURIComponent('点击确定则将在本月工资中补齐,处理不可变更')))" +
                "{window.location.href='rewardReconsider?reconsider_no="+reconsider.getReconsider_no()+
                "';}else{window.location.href='prevMonthSalaryReconsider'}</script>");
    }

    @RequestMapping("punishReconsiderSalary")
    public void punishReconsiderSalary(ReconsiderSalary reconsider,HttpSession session,HttpServletResponse response)throws Exception {
        String month = (String) session.getAttribute("month");
        if (month.equals("prevMonth")){
            response.getWriter().write("<script language='javascript'>if(confirm(decodeURIComponent('点击确定则将在下月工资中扣除,处理不可变更')))" +
                    "{window.location.href='punishReconsider?reconsider_no="+reconsider.getReconsider_no()+
                    "';}else{window.location.href='prevMonthSalaryReconsider'}</script>");
        }else {
            response.getWriter().write("<script language='javascript'>if(confirm(decodeURIComponent('点击确定则将在下月工资中扣除,处理不可变更')))" +
                    "{window.location.href='punishReconsider?reconsider_no="+reconsider.getReconsider_no()+
                    "';}else{window.location.href='curMonthSalaryReconsider'}</script>");
        }
    }

    @RequestMapping("punishReconsider")
    public void agreePunishReconsider(ReconsiderSalary reconsider,HttpSession session,HttpServletResponse response)throws Exception {
        reconsider = reconsiderSalaryService.getReconsiderSalary(reconsider);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        reconsider.setState("批准复议");
        String reason = reconsider.getSalary_month()+"月工资复议";
        RewardAanPunish rewardAanPunish = rewardAanPunishService.getThisMonthSalaryReconsider(reason);
        if (rewardAanPunish==null) {
            rewardAanPunish = new RewardAanPunish();
            rewardAanPunish.setMoney(reconsider.getMoney());
            rewardAanPunish.setType("惩罚");
            rewardAanPunish.setReason(reconsider.getSalary_month() + "月工资复议惩罚");
            rewardAanPunish.setE_id(reconsider.getE_id());
            rewardAanPunish.setExist(1);
            rewardAanPunish.setTime(format.format(new Date()));
            String month = (String) session.getAttribute("month");
            if (rewardAanPunishService.addRewardPunish(rewardAanPunish) && reconsiderSalaryService.updateReconsiderSalary(reconsider)) {
                response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('薪资复议处理成功'));" +
                        "window.location.href='prevMonthSalaryReconsider';</script>");
            } else {
                response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('薪资复议处理失败，请重试'));" +
                        "window.location.href='prevMonthSalaryReconsider';</script>");
            }
        }else {
            rewardAanPunish.setMoney(reconsider.getMoney());
            rewardAanPunish.setType("惩罚");
            rewardAanPunish.setReason(reconsider.getSalary_month() + "月工资复议惩罚");
            rewardAanPunish.setE_id(reconsider.getE_id());
            rewardAanPunish.setExist(1);
            rewardAanPunish.setTime(format.format(new Date()));
            String month = (String) session.getAttribute("month");
            if (rewardAanPunishService.updateRewardPunish(rewardAanPunish) && reconsiderSalaryService.updateReconsiderSalary(reconsider)) {
                response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('薪资复议处理成功'));" +
                        "window.location.href='prevMonthSalaryReconsider';</script>");
            } else {
                response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('薪资复议处理失败，请重试'));" +
                        "window.location.href='prevMonthSalaryReconsider';</script>");
            }
        }

    }

    @RequestMapping("refuseReconsiderSalary")
    public void refuseReconsiderSalary(ReconsiderSalary reconsider,HttpSession session,HttpServletResponse response)throws Exception {
        reconsider = reconsiderSalaryService.getReconsiderSalary(reconsider);
        reconsider.setState("拒绝复议");
        if(reconsiderSalaryService.updateReconsiderSalary(reconsider)){
            response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('薪资复议拒绝成功'));" +
                    "window.location.href='prevMonthSalaryReconsider';</script>");
        } else {
            response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('薪资复议拒绝失败，请重试'));" +
                    "window.location.href='prevMonthSalaryReconsider';</script>");
        }
    }
}