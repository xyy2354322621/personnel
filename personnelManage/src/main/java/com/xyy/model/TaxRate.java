package com.xyy.model;

/**
 * Created by xiyueyang on 2018/4/30 0030.
 */
public class TaxRate {
    private int tax_no;
    private double low_money;
    private double high_money;
    private double tax_rate;
    private double threshold;
    private double quick_deduction;

    public double getThreshold() {
        return threshold;
    }

    public void setThreshold(double threshold) {
        this.threshold = threshold;
    }

    public double getQuick_deduction() {
        return quick_deduction;
    }

    public void setQuick_deduction(double quick_deduction) {
        this.quick_deduction = quick_deduction;
    }

    public int getTax_no() {
        return tax_no;
    }

    public void setTax_no(int tax_no) {
        this.tax_no = tax_no;
    }

    public double getLow_money() {
        return low_money;
    }

    public void setLow_money(double low_money) {
        this.low_money = low_money;
    }

    public double getHigh_money() {
        return high_money;
    }

    public void setHigh_money(double high_money) {
        this.high_money = high_money;
    }

    public double getTax_rate() {
        return tax_rate;
    }

    public void setTax_rate(double tax_rate) {
        this.tax_rate = tax_rate;
    }
}
