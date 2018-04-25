package com.xyy.model;

/**
 * Created by xiyueyang on 2018/4/20 0020.
 */
public class Recruit {
    private long recruit_no;
    private long pos_no;
    private String pos_name;
    private String description;
    private Department depart_name;
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

    public long getPos_no() {
        return pos_no;
    }

    public void setPos_no(long pos_no) {
        this.pos_no = pos_no;
    }



    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPos_name() {
        return pos_name;
    }

    public void setPos_name(String pos_name) {
        this.pos_name = pos_name;
    }

    public Department getDepart_name() {
        return depart_name;
    }

    public void setDepart_name(Department depart_name) {
        this.depart_name = depart_name;
    }

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
                ", pos_no=" + pos_no +
                ", pos_name='" + pos_name + '\'' +
                ", description='" + description + '\'' +
                ", depart_name=" + depart_name +
                ", position_type='" + position_type + '\'' +
                ", issue=" + issue +
                ", recruit_number=" + recruit_number +
                ", salary='" + salary + '\'' +
                ", issue_time='" + issue_time + '\'' +
                '}';
    }
}
