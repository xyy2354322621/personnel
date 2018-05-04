package com.xyy.model;

/**
 * Created by xiyueyang on 2018/5/2 0002.
 */
public class ReconsiderSalary {
    private long salary_no;
    private long reconsider_no;
    private String e_id;
    private String salary_month;
    private double money;
    private String reason;
    private String state;

    public long getSalary_no() {
        return salary_no;
    }

    public void setSalary_no(long salary_no) {
        this.salary_no = salary_no;
    }

    public long getReconsider_no() {
        return reconsider_no;
    }

    public void setReconsider_no(long reconsider_no) {
        this.reconsider_no = reconsider_no;
    }

    public String getE_id() {
        return e_id;
    }

    public void setE_id(String e_id) {
        this.e_id = e_id;
    }

    public String getSalary_month() {
        return salary_month;
    }

    public void setSalary_month(String salary_month) {
        this.salary_month = salary_month;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "ReconsiderSalary{" +
                "salary_no=" + salary_no +
                ", reconsider_no=" + reconsider_no +
                ", e_id='" + e_id + '\'' +
                ", salary_month='" + salary_month + '\'' +
                ", money=" + money +
                ", reason='" + reason + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
