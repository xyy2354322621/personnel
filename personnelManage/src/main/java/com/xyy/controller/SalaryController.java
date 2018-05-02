package com.xyy.controller;

import com.xyy.biz.*;
import com.xyy.model.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by xiyueyang on 2018/4/29 0029.
 */
@Controller
public class SalaryController {

    @Resource
    private SalaryService salaryService;

    @Resource
    private DepartmentService departmentService;

    @Resource
    private EmployeeService employeeService;

    @Resource
    private PositionService positionService;

    @Resource
    private BasicParamService basicParamService;

    @Resource
    private RewardAanPunishService rewardAanPunishService;

    @Resource
    private TaxRateService taxRateService;

    @Resource
    private AttendanceService attendanceService;

    @RequestMapping("manageSalary")
    public String manageSalary(String month, Model model, HttpSession session)throws Exception{
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
        if (month==null){
            month = format.format(new Date());
        }
        List<Department> departmentPosition = departmentService.getDepartmentsAndPosition();
        session.setAttribute("departmentPosition",departmentPosition);
        List<Salary> thisMonthSalary = salaryService.getThisMonthSalary(month);
        model.addAttribute(departmentPosition);
        model.addAttribute(thisMonthSalary);
        model.addAttribute("month",month);
        return "manageSalary";
    }

    @RequestMapping("createCurMonthSalary")
    public void createCurMonthSalary(HttpServletResponse response)throws Exception{
        SimpleDateFormat monthFormat = new SimpleDateFormat("yyyy-MM");
        Date now = new Date();
        String curMonth = monthFormat.format(now);
        if (createThisMonthSalary(curMonth)){
            response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('员工的当月薪资生成成功'));" +
                    "window.location.href='manageSalary';</script>");
        }else {
            response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('部分员工的当月薪资生成失败，\n请重试'));" +
                    "window.location.href='manageSalary';</script>");
        }
    }

    private boolean updateEmpThisMonthSalary(Employee employee, String month) throws Exception {
        Salary salary = salaryService.getEmpThisMonthSalary(employee,month);
        BasicParam basicParam = basicParamService.getBasicParam();
        double basicSalary = getEmpThisMonthBasicSalary(employee,month);
        double rewardMoney = getEmpThisMonthExistReward(employee,month);
        double punishMoney = getEmpThisMonthExistPunish(employee,month);
        double overtimePay = getEmpThisMonthOvertimePay(employee,month);
        double performance = salary.getPerformance();
        double salaryAmount= basicSalary + rewardMoney + overtimePay + performance - punishMoney;
        double socialSecurity = salaryAmount * basicParam.getB_social_security_ratio()/100;
        double companyPaySocial = salaryAmount * basicParam.getB_company_pay_social()/100;
        double taxableIncome = salaryAmount - socialSecurity - basicParam.getB_tax_threshold();
        double taxMoney = 0;
        List<TaxRate> taxRates = taxRateService.getTaxRates();
        if (taxRates.size()>0){
            for (TaxRate taxRate : taxRates) {
                if (taxRate.getLow_money()< taxableIncome && taxableIncome <= taxRate.getHigh_money()){
                    taxMoney = taxableIncome * taxRate.getTax_rate()/100 - taxRate.getQuick_deduction();
                    break;
                }
            }
        }
        double netPayroll = salaryAmount - socialSecurity - taxMoney;
        salary.setBasic_salary(basicSalary);
        salary.setReward_money(rewardMoney);
        salary.setPunish_money(punishMoney);
        salary.setIncome_tax(taxMoney);
        salary.setSocial_security(socialSecurity);
        salary.setCompany_social(companyPaySocial);
        salary.setOvertime_pay(overtimePay);
        salary.setNet_payroll(netPayroll);
        return salaryService.updateSalary(salary);
    }

    @RequestMapping("createPrevMonthSalary")
    public void createPrevMonthSalary(HttpServletResponse response)throws Exception{
        SimpleDateFormat monthFormat = new SimpleDateFormat("yyyy-MM");
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH,-1);
        Date prevMonthDay = calendar.getTime();
        String prevMonth = monthFormat.format(prevMonthDay);
        if (createThisMonthSalary(prevMonth)){
            response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('员工的上月薪资生成成功'));" +
                    "window.location.href='manageSalary';</script>");
        }else {
            response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('部分员工的上月薪资生成失败，\n请重试'));" +
                    "window.location.href='manageSalary';</script>");
        }
    }

    private boolean createThisMonthSalary(String month) throws Exception {
        List<Employee> thisMonthOnJobEmployees = employeeService.getThisMonthOnJobEmployees(month);
        SimpleDateFormat monthFormat = new SimpleDateFormat("yyyy-MM");
        Date thisMonth = monthFormat.parse(month);
        boolean update = false;
        for (Employee employee : thisMonthOnJobEmployees) {
            Date entryMonth = monthFormat.parse(employee.getEntry_time().substring(0,7));
            System.out.println(entryMonth);
            System.out.println(thisMonth);
            System.out.println("入职月份");
            if (entryMonth.getTime()<=thisMonth.getTime()) {
                System.out.println("成立");
                Salary salary = salaryService.getEmpThisMonthSalary(employee, month);
                if (salary == null) {
                    salary = new Salary();
                    salary.setE_id(employee.getE_id());
                    salary.setSalary_month(month);
                    salary.setPayoff("未发放");
                    if (salaryService.addSalary(salary)) {
                        update = updateEmpThisMonthSalary(employee, month);
                    } else {
                        return false;
                    }
                } else {
                    update = updateEmpThisMonthSalary(employee, month);
                }
                if (!update) return false;
            }
        }
        return update;
    }


    private double getEmpThisMonthOvertimePay(Employee employee, String month) {
        List<RewardAanPunish> overtime = rewardAanPunishService.getEmpThisMonthOvertime(employee,month);
        double overtimePay = 0;
        if (overtime.size()>0){
            for (RewardAanPunish rap : overtime) {
                overtimePay += rap.getMoney();
            }
        }
        return overtimePay;
    }

    private double getEmpThisMonthExistPunish(Employee employee, String month) {
        List<RewardAanPunish> punishes = rewardAanPunishService.getEmpThisMonthExistPunish(employee,month);
        double punishMoney = 0;
        if (punishes.size()>0){
            for (RewardAanPunish rap : punishes) {
                punishMoney += rap.getMoney();
            }
        }
        return punishMoney;
    }

    private double getEmpThisMonthExistReward(Employee employee, String month) {
        List<RewardAanPunish> rewards = rewardAanPunishService.getEmpThisMonthExistReward(employee,month);
        double rewardMoney = 0;
        if (rewards.size()>0){
            for (RewardAanPunish rap : rewards) {
                rewardMoney += rap.getMoney();
            }
        }
        return rewardMoney;
    }

    private double getEmpThisMonthBasicSalary(Employee employee, String month) throws Exception {
        SimpleDateFormat monthFormat = new SimpleDateFormat("yyyy-MM");
        SimpleDateFormat timeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date curMonthFirstDay = monthFormat.parse(month);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(curMonthFirstDay);
        int thisMonthDays = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        double basicSalary = 0;
        Date entryPosDate = dateFormat.parse(employee.getEntry_time().substring(0,10));
        double thisDateSalary = 0;
        String date = "";
        for (int i=1;i<=thisMonthDays;i++) {
            if (i < 10) {
                date = month + "-0" + i;
            } else {
                date = month + "-" + i;
            }
            Date thisDate = dateFormat.parse(date);
            if (employee.getDimission_time()!=null){
                Date dimissionDate = timeFormat.parse(employee.getDimission_time());
                if (thisDate.getTime()>=entryPosDate.getTime() && thisDate.getTime()<=dimissionDate.getTime()){
                    thisDateSalary = getThisDateBasicSalary(employee,date);
                    basicSalary += thisDateSalary;
                }
            }else {
                if (thisDate.getTime()>entryPosDate.getTime()){
                    thisDateSalary = getThisDateBasicSalary(employee,date);
                    basicSalary += thisDateSalary;
                }
            }
        }
        return basicSalary;
    }

    private double getThisDateBasicSalary(Employee employee, String date) throws Exception{
        SimpleDateFormat monthFormat = new SimpleDateFormat("yyyy-MM");
        SimpleDateFormat timeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String month = date.substring(0,7);
        Date curMonthFirstDay = monthFormat.parse(month);
        Date thisDate = dateFormat.parse(date);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(curMonthFirstDay);
        calendar.add(Calendar.MONTH,1);
        Date nextMonthFirstDay = calendar.getTime();
        double natureDaysThisMonth = (nextMonthFirstDay.getTime()-curMonthFirstDay.getTime())/(1000*60*60*24);
        BasicParam basicParam = basicParamService.getBasicParam();
        Attendance empThisDateAttendance = attendanceService.getEmpThisDateAttendance(employee, date);
        List<ChangePos> changePoses = employeeService.getThisMonthChangePos(employee,month);
        if (changePoses.size()>0){
            Date onPrevPosCurMonthFirstDay = curMonthFirstDay;
            for (ChangePos changePos : changePoses) {
                Position originPosition = new Position();
                originPosition.setPos_no(changePos.getOrigin_pos());
                originPosition = positionService.getPositionByPosNo(originPosition);
                double daySalary = originPosition.getBasic_salary()/natureDaysThisMonth;
                Date changePosDate = timeFormat.parse(changePos.getChange_date());
                if (thisDate.getTime()>=onPrevPosCurMonthFirstDay.getTime() && thisDate.getTime()<changePosDate.getTime()){
                    return  computeThisDateBasicSalary(empThisDateAttendance,basicParam,daySalary);
                }
                onPrevPosCurMonthFirstDay = changePosDate;
            }
        }else {
            Position thisDatePosition = new Position();
            thisDatePosition.setPos_no(employee.getPos_no());
            thisDatePosition = positionService.getPositionByPosNo(thisDatePosition);
            double daySalary = thisDatePosition.getBasic_salary()/natureDaysThisMonth;
            return computeThisDateBasicSalary(empThisDateAttendance,basicParam,daySalary);
        }
        return 0;
    }

    private double computeThisDateBasicSalary(Attendance empThisDateAttendance, BasicParam basicParam, double daySalary) {
        if (empThisDateAttendance.getPublic_leave()==1){
            return daySalary;
        }else if (empThisDateAttendance.getFuneral_leave()==1){
            return daySalary*basicParam.getFuneral_leave_pay_ratio()/100;
        }else if (empThisDateAttendance.getMarriage_leave()==1){
            return daySalary*basicParam.getMarriage_leave_pay_ratio()/100;
        }else if (empThisDateAttendance.getMaternity_leave()==1){
            return daySalary*basicParam.getMaternity_leave_pay_ratio()/100;
        }else if (empThisDateAttendance.getAnnual_leave()==1){
            return daySalary*basicParam.getAnnual_leave_pay_ratio()/100;
        }else if (empThisDateAttendance.getSick_leave()==1){
            return daySalary*basicParam.getSick_leave_pay_ratio()/100;
        }else if (empThisDateAttendance.getPerson_leave()==1){
            return daySalary*basicParam.getPerson_leave_pay_ratio()/100;
        }else if (empThisDateAttendance.getAbsenteeism()==1){
            return daySalary*basicParam.getMaternity_leave_pay_ratio()/100;
        }else {
            return daySalary;
        }
    }

    @RequestMapping("changeEmpSalaryPerformance")
    public void changeEmpSalaryPerformance(Salary salary,String perform,HttpServletResponse response)throws Exception{
        double performance = Double.parseDouble(perform);
        salary = salaryService.getSalary(salary);
        salary.setPerformance(performance);
        if(salaryService.updateSalary(salary)) {
            Employee employee = new Employee();
            employee.setE_id(salary.getE_id());
            employee = employeeService.getEmployee(employee);
            if (updateEmpThisMonthSalary(employee, salary.getSalary_month())) {
                response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('此员工的该月绩效调整成功'));" +
                        "window.location.href='manageSalary?month=" + salary.getSalary_month() + "';</script>");
            } else {
                response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('此员工的该月绩效调整失败，\n请重试'));" +
                        "window.location.href='manageSalary?month=" + salary.getSalary_month() + "';</script>");
            }
        }else {
            response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('此员工的该月绩效调整失败，\n请重试'));" +
                    "window.location.href='manageSalary?month=" + salary.getSalary_month() + "';</script>");
        }
    }

}
