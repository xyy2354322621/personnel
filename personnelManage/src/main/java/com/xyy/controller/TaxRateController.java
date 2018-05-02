package com.xyy.controller;

import com.xyy.biz.TaxRateService;
import com.xyy.model.TaxRate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by xiyueyang on 2018/4/30 0030.
 */
@Controller
public class TaxRateController {

    @Resource
    private TaxRateService taxRateService;

    @RequestMapping("manageTaxRate")
    public String manageTaxRate(Model model)throws Exception{
        List<TaxRate> taxRates = taxRateService.getTaxRates();
        model.addAttribute(taxRates);
        return "manageTaxRate";
    }

    @RequestMapping("addTaxRate")
    public String addTaxRate()throws Exception{
        return "addTaxRate";
    }

    @RequestMapping("saveTaxRate")
    public void saveTaxRate(HttpServletRequest request, HttpServletResponse response)throws Exception{
        TaxRate taxRate = new TaxRate();
//        taxRate.setThreshold(Double.parseDouble(request.getParameter("start")));
        taxRate.setLow_money(Double.parseDouble(request.getParameter("low")));
        taxRate.setHigh_money(Double.parseDouble(request.getParameter("high")));
        taxRate.setTax_rate(Double.parseDouble(request.getParameter("rate")));
        taxRate.setQuick_deduction(Double.parseDouble(request.getParameter("deduction")));
        if (taxRateService.addTaxRate(taxRate)){
            response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('新增成功'));" +
                    "window.location.href='manageTaxRate';</script>");
        }else {
            response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('新增失败，请重试'));" +
                    "window.location.href='manageTaxRate';</script>");
        }
    }

    @RequestMapping("alterTaxRate")
    public String alterTaxRate(TaxRate taxRate,Model model)throws Exception{
        taxRate = taxRateService.getThisTaxRate(taxRate);
        model.addAttribute(taxRate);
        return "alterTaxRate";
    }

    @RequestMapping("updateTaxRate")
    public void updateTaxRate(HttpServletRequest request, HttpServletResponse response)throws Exception{
        TaxRate taxRate = new TaxRate();
        taxRate.setTax_no(Integer.parseInt(request.getParameter("tax_no")));
//        taxRate.setThreshold(Double.parseDouble(request.getParameter("start")));
        taxRate.setLow_money(Double.parseDouble(request.getParameter("low")));
        taxRate.setHigh_money(Double.parseDouble(request.getParameter("high")));
        taxRate.setTax_rate(Double.parseDouble(request.getParameter("rate")));
        taxRate.setQuick_deduction(Double.parseDouble(request.getParameter("deduction")));
        if (taxRateService.updateTaxRate(taxRate)){
            response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('修改成功'));" +
                    "window.location.href='manageTaxRate';</script>");
        }else {
            response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('修改失败，请重试'));" +
                    "window.location.href='manageTaxRate';</script>");
        }
    }

    @RequestMapping("deleteTaxRate")
    public void deleteTaxRate(TaxRate taxRate,HttpServletResponse response)throws Exception{
        if (taxRateService.deleteTaxRate(taxRate)){
            response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('删除成功'));" +
                    "window.location.href='manageTaxRate';</script>");
        }else {
            response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('删除失败，请重试'));" +
                    "window.location.href='manageTaxRate';</script>");
        }
    }

}
