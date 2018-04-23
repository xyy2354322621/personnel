package com.xyy.model;

/**
 * Created by xiyueyang on 2018/4/20 0020.
 */
public class Recruit {
    private long recruit_no;
    private String position;
    private String description;
//    private Department department;
    private String position_type;
    private int issue;
    private int recruit_number;
    private String salary;
    private String issue_time;

    public long getRecruit_no() {
        return recruit_no;
    }

    public void setRecruit_no(long recruit_no) {
        this.recruit_no = recruit_no;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

   /* public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }*/

    public String getPosition_type() {
        return position_type;
    }

    public void setPosition_type(String position_type) {
        this.position_type = position_type;
    }

    public int getIssue() {
        return issue;
    }

    public void setIssue(int issue) {
        this.issue = issue;
    }

    public int getRecruit_number() {
        return recruit_number;
    }

    public void setRecruit_number(int recruit_number) {
        this.recruit_number = recruit_number;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getIssue_time() {
        return issue_time;
    }

    public void setIssue_time(String issue_time) {
        this.issue_time = issue_time;
    }

    @Override
    public String toString() {
        return "Recruit{" +
                "recruit_no=" + recruit_no +
                ", position='" + position + '\'' +
                ", description='" + description + '\'' +
                ", position_type='" + position_type + '\'' +
                ", issue=" + issue +
                ", recruit_number=" + recruit_number +
                ", salary='" + salary + '\'' +
                ", issue_time='" + issue_time + '\'' +
                '}';
    }
}
