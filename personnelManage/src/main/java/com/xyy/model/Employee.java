package com.xyy.model;

/**
 * Created by xiyueyang on 2018/4/20 0020.
 */
public class Employee {
    private String e_id;
    private String e_name;
    private String birthday;
    private String gender;
    private String phone;
    private String email;
    private long pos_no;
    private String grade;
    private String entry_time;
    private String dimission_time;
    private String id_no;
    private String education;
    private String dimission_reason;
    private String state;
    private String depart_name;
    private String pos_name;



    public String getE_id() {
        return e_id;
    }

    public void setE_id(String e_id) {
        this.e_id = e_id;
    }

    public String getE_name() {
        return e_name;
    }

    public void setE_name(String e_name) {
        this.e_name = e_name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getPos_no() {
        return pos_no;
    }

    public void setPos_no(long pos_no) {
        this.pos_no = pos_no;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getEntry_time() {
        return entry_time;
    }

    public void setEntry_time(String entry_time) {
        this.entry_time = entry_time;
    }

    public String getDimission_time() {
        return dimission_time;
    }

    public void setDimission_time(String dimission_time) {
        this.dimission_time = dimission_time;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getDimission_reason() {
        return dimission_reason;
    }

    public void setDimission_reason(String dimission_reason) {
        this.dimission_reason = dimission_reason;
    }

    public String getId_no() {
        return id_no;
    }

    public void setId_no(String id_no) {
        this.id_no = id_no;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDepart_name() {
        return depart_name;
    }

    public void setDepart_name(String depart_name) {
        this.depart_name = depart_name;
    }

    public String getPos_name() {
        return pos_name;
    }

    public void setPos_name(String pos_name) {
        this.pos_name = pos_name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "e_id='" + e_id + '\'' +
                ", e_name='" + e_name + '\'' +
                ", birthday='" + birthday + '\'' +
                ", gender='" + gender + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", pos_no=" + pos_no +
                ", grade='" + grade + '\'' +
                ", entry_time='" + entry_time + '\'' +
                ", dimission_time='" + dimission_time + '\'' +
                ", id_no='" + id_no + '\'' +
                ", education='" + education + '\'' +
                ", dimission_reason='" + dimission_reason + '\'' +
                ", state='" + state + '\'' +
                ", depart_name='" + depart_name + '\'' +
                ", pos_name='" + pos_name + '\'' +
                '}';
    }
}
