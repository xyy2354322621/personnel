package com.xyy.model;

/**
 * Created by xiyueyang on 2018/4/27 0027.
 */
public class BasicParam {
    private String b_attend_time;
    private String b_leave_time;
    private int b_overtime_limit;
    private int b_attend_time_limit;
    private int b_leave_time_limit;
    private double b_social_security_ratio;
    private double b_company_pay_social;
    private int b_unit_penalty;
    private double b_overtime_reward_radio;
    private double b_workdays_month;
    private double b_tax_threshold;
    private double person_leave_pay_ratio;
    private double sick_leave_pay_ratio;
    private double annual_leave_pay_ratio;
    private double marriage_leave_pay_ratio;
    private double maternity_leave_pay_ratio;
    private double funeral_leave_pay_ratio;
    private double public_leave_pay_ratio;
    private double absenteeism_punish_ratio;

    public double getPerson_leave_pay_ratio() {
        return person_leave_pay_ratio;
    }

    public void setPerson_leave_pay_ratio(double person_leave_pay_ratio) {
        this.person_leave_pay_ratio = person_leave_pay_ratio;
    }

    public double getSick_leave_pay_ratio() {
        return sick_leave_pay_ratio;
    }

    public void setSick_leave_pay_ratio(double sick_leave_pay_ratio) {
        this.sick_leave_pay_ratio = sick_leave_pay_ratio;
    }

    public double getAnnual_leave_pay_ratio() {
        return annual_leave_pay_ratio;
    }

    public void setAnnual_leave_pay_ratio(double annual_leave_pay_ratio) {
        this.annual_leave_pay_ratio = annual_leave_pay_ratio;
    }

    public double getMarriage_leave_pay_ratio() {
        return marriage_leave_pay_ratio;
    }

    public void setMarriage_leave_pay_ratio(double marriage_leave_pay_ratio) {
        this.marriage_leave_pay_ratio = marriage_leave_pay_ratio;
    }

    public double getMaternity_leave_pay_ratio() {
        return maternity_leave_pay_ratio;
    }

    public void setMaternity_leave_pay_ratio(double maternity_leave_pay_ratio) {
        this.maternity_leave_pay_ratio = maternity_leave_pay_ratio;
    }

    public double getFuneral_leave_pay_ratio() {
        return funeral_leave_pay_ratio;
    }

    public void setFuneral_leave_pay_ratio(double funeral_leave_pay_ratio) {
        this.funeral_leave_pay_ratio = funeral_leave_pay_ratio;
    }

    public double getPublic_leave_pay_ratio() {
        return public_leave_pay_ratio;
    }

    public void setPublic_leave_pay_ratio(double public_leave_pay_ratio) {
        this.public_leave_pay_ratio = public_leave_pay_ratio;
    }

    public double getAbsenteeism_punish_ratio() {
        return absenteeism_punish_ratio;
    }

    public void setAbsenteeism_punish_ratio(double absenteeism_punish_ratio) {
        this.absenteeism_punish_ratio = absenteeism_punish_ratio;
    }

    public double getB_tax_threshold() {
        return b_tax_threshold;
    }

    public void setB_tax_threshold(double b_tax_threshold) {
        this.b_tax_threshold = b_tax_threshold;
    }

    public double getB_workdays_month() {
        return b_workdays_month;
    }

    public void setB_workdays_month(double b_workdays_month) {
        this.b_workdays_month = b_workdays_month;
    }

    public String getB_attend_time() {
        return b_attend_time;
    }

    public void setB_attend_time(String b_attend_time) {
        this.b_attend_time = b_attend_time;
    }

    public String getB_leave_time() {
        return b_leave_time;
    }

    public void setB_leave_time(String b_leave_time) {
        this.b_leave_time = b_leave_time;
    }

    public int getB_overtime_limit() {
        return b_overtime_limit;
    }

    public void setB_overtime_limit(int b_overtime_limit) {
        this.b_overtime_limit = b_overtime_limit;
    }

    public int getB_attend_time_limit() {
        return b_attend_time_limit;
    }

    public void setB_attend_time_limit(int b_attend_time_limit) {
        this.b_attend_time_limit = b_attend_time_limit;
    }

    public int getB_leave_time_limit() {
        return b_leave_time_limit;
    }

    public void setB_leave_time_limit(int b_leave_time_limit) {
        this.b_leave_time_limit = b_leave_time_limit;
    }

    public double getB_social_security_ratio() {
        return b_social_security_ratio;
    }

    public void setB_social_security_ratio(double b_social_security_ratio) {
        this.b_social_security_ratio = b_social_security_ratio;
    }

    public double getB_company_pay_social() {
        return b_company_pay_social;
    }

    public void setB_company_pay_social(double b_company_pay_social) {
        this.b_company_pay_social = b_company_pay_social;
    }

    public int getB_unit_penalty() {
        return b_unit_penalty;
    }

    public void setB_unit_penalty(int b_unit_penalty) {
        this.b_unit_penalty = b_unit_penalty;
    }

    public double getB_overtime_reward_radio() {
        return b_overtime_reward_radio;
    }

    public void setB_overtime_reward_radio(double b_overtime_reward_radio) {
        this.b_overtime_reward_radio = b_overtime_reward_radio;
    }

    @Override
    public String toString() {
        return "BasicParam{" +
                "b_attend_time='" + b_attend_time + '\'' +
                ", b_leave_time='" + b_leave_time + '\'' +
                ", b_overtime_limit=" + b_overtime_limit +
                ", b_attend_time_limit=" + b_attend_time_limit +
                ", b_leave_time_limit=" + b_leave_time_limit +
                ", b_social_security_ratio=" + b_social_security_ratio +
                ", b_company_pay_social=" + b_company_pay_social +
                ", b_unit_penalty=" + b_unit_penalty +
                ", b_overtime_reward_radio=" + b_overtime_reward_radio +
                ", b_workdays_month=" + b_workdays_month +
                '}';
    }
}
